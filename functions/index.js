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

    const email = `From: ${formDetails.email} \n`;
    const name = `Name: ${formDetails.firstName} ${formDetails.lastName} \n`;
    const topic = `Topic: ${formDetails.topic} \n`;
    const message = `Message: ${formDetails.message} \n`;

    const mailOptions = {
      from: "gtcontactform@gmail.com",
      to: "lenny.casey.brown@gmail.com",
      subject: "GT Contact Form",
      text: '' + String(email) + name + topic + message,
    };

    return transporter.sendMail(mailOptions, (err, info) => {
      if (err) {
        return { err: err.toString() };
      }
      console.log(info);
      return { info: "SENT REQUEST FORM" };
    });
  });

const cheerio = require('cheerio');
const got = require('got');

exports.fetchAndParseOurExpertsHTML = functions.https.onRequest(async (req, res) => {
  // Grab the text parameter.
  const ourExpertsBatchAdd = db.batch();
  const ourExperts = {};
  const ourExpertsURL = "https://www.globaltactics.co/who-we-are/our-experts.html";

  got(ourExpertsURL).then(response => {
    const $ = cheerio.load(response.body);
    const ourExpertSections = $("section");
    
    let expertCount = 0;
    ourExpertSections.each((i, section) => {
      const ourExpertInnerAreas = $(section).find("div.area_inner");

      ourExpertInnerAreas.each((i, innerArea) => {
        const ourExpertName = $(innerArea).find("h2").text();
        const ourExpertTitle = $(innerArea).find("h4").text();

        if(ourExpertName !== "" && ourExpertTitle !== "") {
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
            linkedin: ourExpertLinkedIn
          };

          if (!(ourExpert.name in ourExperts)) {
            ourExperts[ourExpert.name] = ourExpert;
            const ourExpertsNewRef = db.collection("experts").doc(ourExpert.id.toString());
            ourExpertsBatchAdd.set(ourExpertsNewRef, ourExpert);
          }
        }
      });
    });

    ourExpertsBatchAdd.commit()
      .then(() => {
        res.json({result: `it worked!`});
        return null;
      })
      .catch((err) => {
        console.log(err);
      });

    return null;
  }).catch(err => {
    console.log(err);
  });
});
