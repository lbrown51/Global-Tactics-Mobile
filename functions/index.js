const functions = require("firebase-functions");

const admin = require("firebase-admin");
admin.initializeApp();
const db = admin.firestore();

const nodemailer = require("nodemailer");
let transporter = nodemailer.createTransport({
  service: "gmail",
});

exports.sendContactInformation = functions.firestore
  .document("/requests/{requestId}")
  .onCreate((snap, context) => {
    const formDetails = snap.data();

    const email = formDetails.email;
    const name = `${formDetails.firstName} ${formDetails.lastName}`;
    const topic = formDetails.topic;
    const message = formDetails.message;

    const html = `
      <div>
        <h1>Contact Request</h1>
        <h2>From ${name}</h2>
        <h3>Topic: ${topic}</h3>
        <p>${message}</p>
        <p>Reply to: <a href="mailto:${email}">${email}</a></p>
      </div>`;

    const mailOptions = {
      from: "gtcontactform@gmail.com",
      to: "lenny.casey.brown@gmail.com",
      subject: "GT Contact Form",
      html: html,
    };

    return transporter.sendMail(mailOptions, (err, info) => {
      if (err) {
        return { err: err.toString() };
      }
      console.log(info);
      return { info: "SENT REQUEST FORM" };
    });
  });

const cheerio = require("cheerio");
const got = require("got");
const { response } = require("express");

exports.fetchAndParseOurExpertsHTML = functions.https.onRequest(
  async (req, res) => {
    const ourExpertsPath = "experts2";

    deleteCollection(db, ourExpertsPath, 20).then(() => {
      // Grab the text parameter.
      const ourExpertsBatchAdd = db.batch();
      const ourExperts = {};
      const ourExpertsURL =
        "https://www.globaltactics.co/who-we-are/our-experts.html";

      got(ourExpertsURL)
        .then((response) => {
          const $ = cheerio.load(response.body);
          const ourExpertSections = $("section");

          let expertCount = 0;
          ourExpertSections.each((i, section) => {
            const ourExpertInnerAreas = $(section).find("div.area_inner");

            ourExpertInnerAreas.each((i, innerArea) => {
              const ourExpertName = $(innerArea).find("h2").text();
              const ourExpertTitle = $(innerArea).find("h4").text();

              if (ourExpertName !== "" && ourExpertTitle !== "") {
                const ourExpertSpecialties = $(innerArea).find("small").text();
                let ourExpertLinkedIn = $(innerArea).find("a").attr("href");
                if (ourExpertLinkedIn === undefined) {
                  ourExpertLinkedIn = "";
                }

                $(innerArea).find("small").remove();
                $(innerArea).find("a").remove();
                const ourExpertDescription = $(innerArea).find("p").text();

                $(innerArea).find("p").remove();
                $(innerArea).find("h2").remove();
                $(innerArea).find("h4").remove();
                const ourExpertLocation = $(innerArea).text().trim();

                const ourExpert = {
                  id: expertCount++,
                  name: ourExpertName,
                  title: ourExpertTitle,
                  location: ourExpertLocation,
                  specialties: ourExpertSpecialties,
                  description: ourExpertDescription,
                  linkedin: ourExpertLinkedIn,
                };

                if (!(ourExpert.name in ourExperts)) {
                  ourExperts[ourExpert.name] = ourExpert;
                  const ourExpertsNewRef = db
                    .collection(ourExpertsPath)
                    .doc(ourExpert.id.toString());
                  ourExpertsBatchAdd.set(ourExpertsNewRef, ourExpert);
                }
              }
            });
          });

          ourExpertsBatchAdd
            .commit()
            .then(() => {
              res.json({ result: `it worked!` });
              return null;
            })
            .catch((err) => {
              console.log(err);
            });

          return null;
        })
        .catch((err) => {
          console.log(err);
        });
    });
  }
);

exports.fetchAndParseEventsJSON = functions.https.onRequest(
  async (req, res) => {
    const eventsPath = "events2";

    deleteCollection(db, eventsPath, 50).then(() => {
      const eventsBatchAdd = db.batch();
      const eventsURL =
        "https://www.globaltactics.co/_bloq_calendars/json/6536?start=2020-11-29&end=2021-01-10&_=1605675092353";

      got(eventsURL)
        .then((response) => {
          const events = JSON.parse(response.body);

          events.forEach((evnt) => {
            const newEvent = {
              description: evnt.title,
              from: new Date(evnt.start),
              to: new Date(evnt.end),
              host: "https://greenwicheconomicforum.com/",
            };

            const evntNewRef = db.collection(eventsPath).doc();
            eventsBatchAdd.set(evntNewRef, newEvent);
          });

          eventsBatchAdd
            .commit()
            .then(() => {
              res.json({ result: `it worked!` });
              return null;
            })
            .catch((err) => {
              console.log(err);
            });

          return null;
        })
        .catch((err) => {
          console.log(err);
        });
    });
  }
);

const deleteCollection = async (db, collectionPath, batchSize) => {
  const collectionRef = db.collection(collectionPath);
  const query = collectionRef.orderBy("__name__").limit(batchSize);

  return new Promise((resolve, reject) => {
    deleteQueryBatch(db, query, resolve).catch(reject);
  });
};

const deleteQueryBatch = async (db, query, resolve) => {
  const snapshot = await query.get();

  const batchSize = snapshot.size;
  if (batchSize === 0) {
    // When there are no documents left, we are done
    resolve();
    return;
  }

  // Delete documents in a batch
  const batch = db.batch();
  snapshot.docs.forEach((doc) => {
    batch.delete(doc.ref);
  });
  await batch.commit();

  // Recurse on the next process tick, to avoid
  // exploding the stack.
  process.nextTick(() => {
    deleteQueryBatch(db, query, resolve);
  });
};
