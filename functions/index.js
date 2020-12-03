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

exports.fetchAndParseOurExpertsHTML = functions.https.onRequest(
  async (req, res) => {
    const expertsPath = "experts2";

    deleteCollection(db, expertsPath, 20)
      .then(() => {
        // Grab the text parameter.
        const expertsBatchAdd = db.batch();
        const experts = {};
        const expertsURL =
          "https://www.globaltactics.co/our-experts-cards.html";

        got(expertsURL)
          .then((response) => {
            const $ = cheerio.load(response.body);
            const expertCards = $("div.cardItemHolder");

            let expertCount = 0;
            expertCards.each((i, expertDiv) => {
              const expert = {};
              expert.id = expertCount++;

              expert.name = $(expertDiv)
                .find("div.cardItemNameHolder")
                .text()
                .trim();
              expert.title = $(expertDiv).find("div.GTPosition").text();
              expert.location = $(expertDiv).find("div.GTLocation").text();
              expert.specialties = $(expertDiv).find("div.GTSpecialty").text();

              const expertCardTextHolder = $(expertDiv).find("div.cardItemTextHolder");
              expertCardTextHolder.children().remove("div");
              expert.description = expertCardTextHolder.text()
              
              const linkedin = $(expertDiv)
                .find("div.cardItemLinkHolder > a")
                .attr("href");
              
              expert.linkedin = linkedin === undefined ? "" : linkedin

              expert.imageUrl =
                "https://www.globaltactics.co" +
                $(expertDiv).find("div.cardItemImageHolder > img").attr("src");


              if (!(expert.name in experts)) {
                experts[expert.name] = expert;
                const expertsNewRef = db
                  .collection(expertsPath)
                  .doc(expert.id.toString());
                expertsBatchAdd.set(expertsNewRef, expert);
              }
            });

            expertsBatchAdd
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

        return null;
      })
      .catch((err) => {
        console.log(err);
      });
  }
);


exports.fetchAndParseOurSuccessesHTML = functions.https.onRequest(
  async (req, res) => {
    const successesPath = "successes2";

    deleteCollection(db, successesPath, 20)
      .then(() => {
        // Grab the text parameter.
        const successesBatchAdd = db.batch();
        const successesURL =
          "https://www.globaltactics.co/who-we-are/our-successes.html";

        got(successesURL)
          .then((response) => {
            const $ = cheerio.load(response.body);
            const successCards = $("div.cardItemHolder");

            successCards.each((i, successCard) => {
              const success = {};

              success.title = $(successCard)
                .find("div.cardItemNameHolder")
                .text();

              success.description = $(successCard)
                .find("div.cardItemTextHolder")
                .text();

              success.imageUrl =
                "https://www.globaltactics.co/" +
                $(successCard).find("div.cardItemImageHolder > img").attr("src");


              const successesNewRef = db
                .collection(successesPath)
                .doc();
              successesBatchAdd.set(successesNewRef, success);
            });

            successesBatchAdd
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

        return null;
      })
      .catch((err) => {
        console.log(err);
      });
  }
);

exports.fetchAndParseEventsJSON = functions.https.onRequest(
  async (req, res) => {
    const eventsPath = "events2";

    deleteCollection(db, eventsPath, 50)
      .then(() => {
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

        return null;
      })
      .catch((err) => {
        console.log(err);
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
