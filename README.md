![alt text](https://github.com/lbrown51/Global-Tactics-Mobile/blob/master/app/src/main/res/drawable/gt1.png?raw=true)
# Description
This repo contains the code for the mobile version of the global tactics app.

# Developer's Help
## Install
- you need to have android studio installed on your device.
- open the terminal/cmd and navigate to the folder that you'd like to install the project.
- run this command in the terminal/cmd to clone the project:
-- `git clone https://github.com/lbrown51/Global-Tactics-Mobile.git`
- get the **google-services.json** file form the Global Tactics' firebase project, and place the file in the app folder in the project directory.
- open the project in the Android Studio.

## firebase functions
we are using firebase to manage the data flow of the application.

### firebase collections
- requests
- events
- experts
- successes

## firebase functions
-**sendContactInformation**
-- triggers each time a user use the contact form.

-**fetchAndParseOurExpertsHTML**
-- triggers each time on app start.

-**fetchAndParseEvents**
-- triggers each time on app start.

[![CircleCI](https://circleci.com/gh/lbrown51/Global-Tactics-Mobile.svg?style=svg&circle-token=d2d1a99ff7fe84dace19e7958db247c2aee682d0)](https://circleci.com/gh/lbrown51/Global-Tactics-Mobile)

[![codecov](https://codecov.io/gh/lbrown51/global-tactics-mobile/branch/master/graph/badge.svg?token=33YHKYYRCU)](https://codecov.io/gh/lbrown51/global-tactics-mobile)
