const functions = require("firebase-functions");
const admin = require("firebase-admin");
admin.initializeApp();

exports.sendContactInformation = functions.firestore
  .document("/requests/{requestId}")
  .onCreate((snap, context) => {
    const original = snap.data();
    console.log(original);
  });

// // Create and Deploy Your First Cloud Functions
// // https://firebase.google.com/docs/functions/write-firebase-functions
//
// exports.helloWorld = functions.https.onRequest((request, response) => {
//   functions.logger.info("Hello logs!", {structuredData: true});
//   response.send("Hello from Firebase!");
// });
