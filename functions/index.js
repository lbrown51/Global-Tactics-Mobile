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
      to: "aaron.rose@globaltactics.co",
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
const { contains } = require("cheerio");

// https://crontab.guru/every-week was helpful in getting 0 0 * * 0
exports.fetchAndParseOurExpertsHTML = functions.pubsub
  .schedule("0 0 * * 0")
  .onRun((context) => {
    const expertsPath = "experts";

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

              const expertCardTextHolder = $(expertDiv).find(
                "div.cardItemTextHolder"
              );
              expertCardTextHolder.children().remove("div");
              expert.description = expertCardTextHolder.text();

              const linkedin = $(expertDiv)
                .find("div.cardItemLinkHolder > a")
                .attr("href");

              expert.linkedin = linkedin === undefined ? "" : linkedin;

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
  });

exports.fetchAndParseOurSuccessesHTML = functions.pubsub
  .schedule("0 0 * * 6")
  .onRun((context) => {
    const successesPath = "successes";

    deleteCollection(db, successesPath, 20)
      .then(() => {
        // Grab the text parameter.
        const successesBatchAdd = db.batch();
        const successesURL =
          "https://www.globaltactics.co/who-we-are/our-successes.html";

        got(successesURL)
          .then((response) => {
            const $ = cheerio.load(response.body);

            const topLevelSections = $("main#content-all")
              .children()
              .filter(function (e, el) {
                const containsSuccessCards =
                  $(el).find("div.cardItemHolder").length > 0;
                return containsSuccessCards;
              });

            topLevelSections.each((i, successSection) => {
              const successType =
                i === 0 ? "corporate" : i === 1 ? "government" : "nonprofit";

              const successCards = $(successSection).find("div.cardItemHolder");

              successCards.each((i, successCard) => {
                const success = {};

                success.parent = successType;

                success.title = $(successCard)
                  .find("div.cardItemNameHolder")
                  .text();

                success.description = $(successCard)
                  .find("div.cardItemTextHolder")
                  .text();

                success.imageUrl =
                  "https://www.globaltactics.co/" +
                  $(successCard)
                    .find("div.cardItemImageHolder > img")
                    .attr("src");

                const successesNewRef = db.collection(successesPath).doc();
                successesBatchAdd.set(successesNewRef, success);
              });
            });

            successesBatchAdd
              .commit()
              .then(() => {
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
  });


exports.fetchAndParseEventsJSON = functions.pubsub
.schedule("0 0 * * *")
.onRun((context) => {
    const eventsPath = "events";
    const numDaysInAdvance = 180;

    deleteCollection(db, eventsPath, 20)
      .then(() => {
        const eventsBatchAdd = db.batch();

        const [startDate, endDate] = getStartAndEndDate(numDaysInAdvance);

        const eventsURL =
          `https://www.globaltactics.co/_bloq_calendars/json/6536?start=${startDate}&end=${endDate}&_=1605675092353`;

        got(eventsURL)
          .then((response) => {
            const events = JSON.parse(response.body);

            events.forEach((evnt) => {
              const newEvent = {
                description: evnt.title,
                from: new Date(evnt.start),
                to: new Date(evnt.end),
                host: evnt.contact_url,
              };

              const evntNewRef = db.collection(eventsPath).doc();
              eventsBatchAdd.set(evntNewRef, newEvent);
            });

            eventsBatchAdd
              .commit()
              .then(() => {
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

function getStartAndEndDate(numDaysInAdvance=180) {
  let start = new Date(),
      sMonth = '' + (start.getMonth() + 1),
      sDay = '' + start.getDate(),
      sYear = start.getFullYear();
  
  let end = new Date();
  end.setDate(end.getDate() + numDaysInAdvance);

  let eMonth = '' + (end.getMonth() + 1),
    eDay = '' + end.getDate(),
    eYear = end.getFullYear();
    
  if (sMonth.length < 2) sMonth = '0' + sMonth;
  if (eMonth.length < 2)  eMonth = '0' + eMonth;
  
  if (sDay.length < 2) sDay = '0' + sDay;
  if (eDay.length < 2)  eDay = '0' + eDay;

  return [
    [sYear, sMonth, sDay].join('-'),
    [eYear, eMonth, eDay].join('-'),
  ];
}
