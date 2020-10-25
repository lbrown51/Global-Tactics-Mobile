const functions = require("firebase-functions");

const admin = require("firebase-admin");
admin.initializeApp();

const nodemailer = require("nodemailer");
let transporter = nodemailer.createTransport({
  service: "gmail",
  auth: {
  },
});

exports.sendContactInformation = functions.firestore
  .document("/requests/{requestId}")
  .onCreate((snap, context) => {
    const formDetails = snap.data();

    const from = `From: ${formDetails.email} \n`;
    const name = `Name: ${formDetails.firstName} ${formDetails.lastName} \n`;
    const topic = `Topic: ${formDetails.topic} \n`;
    const message = `Message: ${formDetails.message} \n`;

    const mailOptions = {
      from: "gtcontactform@gmail.com",
      to: "lenny.casey.brown@gmail.com",
      subject: "GT Contact Form",
      text: '' + from + name + topic + message,
    };

    return transporter.sendMail(mailOptions, (err, info) => {
      if (err) {
        return { err: err.toString() };
      }
      console.log(info);
      return { info: "SENT REQUEST FORM" };
    });
  });
