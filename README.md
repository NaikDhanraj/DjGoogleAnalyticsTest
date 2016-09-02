# DjGoogleAnalyticsTest
Google Analytics Example


Google analytics is a powerful service which comes with great features like real time user count,
event tracking, geo tracking, error & crash reporting and lot more and yet it is completely free.

Essential Modules/Features Of Google Analytics Necessary For Every Android App :
-Tracking screens(Activity/Fragment)
-Tracking Events/any kind of user interaction with app(eg.Downloading song)
-Tracking all known exceptions using try and catch
-Tracking App Crashes


1>>>Creating Google Analytics Property
Google Analytics tracking ID identifies the analytics property for which mobile tracking is enabled.

STEPS:
1. Sign in to your Google Analytics account.
https://analytics.google.com/analytics/web/#home/
2. Select the Admin tab.
3. In the ACCOUNT dropdown, click on Create new account. (Or select the property if you created one already)
4. Select Mobile App in the new property form.
5. Enter the App Name.
6. Select Industry Category & Report Time Zone and click on Get Tracking ID.
7. In the next screen you will be shown your property Tracking ID.
The tracking ID should look like UA-XXXXXXXX-X.

2>>>CREATE ANDROID PROJECT
1. add google analytics dependency
compile 'com.google.android.gms:play-services-analytics:9.0.0'
2.manifest permissions
    <uses-permission android:name="android.permission.INTERNET"/>
    <uses-permission android:name="android.permission.ACCESS_NETWORK_STATE"/>
    
3.Add google-services.json
4. Add support for non google play devices in manifest
5. Create a folder named xml under res. Inside xml folder, create an xml file named app_tracker.xml
Add Analytics configurations here
replace the ga_trackingId with your tracking ID
6 . Under app package, create a class named AnalyticsTrackers.java

7. Create a class named MyApplication.java under app package.
