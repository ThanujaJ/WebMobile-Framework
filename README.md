
Sample test framework to demonstrate execution of WEB and M-WEB application automated tests         .

1. Tools Used: Selenium for Web, Appium for M-Web

2. Build tool: Maven

3. Language: JAVA

4. IDE: Eclipse

5: Design Pattern: POM [Page object model]

Before execution, below are pre-requisites that you have to setup in your machine

## [Prerequisites to run web tests]

OS: Linux (Mac)

•  Install chrome browser (latest)
•  Install Intellij


## Steps to Execute Web Tests

	To Execute to Appium tests, execute below command

•	mvn clean test.


## [Prerequisites to run m-web tests]


OS: Linux (Mac)

•	Install Xcode or Upgrade to 9.X

•	Install Homebrew

•	Install Carthage

•	Install Java

•	Install Node

•	Install Android Studio

•	Install Appium (npm install -g appium@beta)

•	Install Maven and setup maven environment variables

•	Verify Appium installation using below command and make sure all dependencies are installed using following commands

	   - npm install -g appium-doctor

       - appium-doctor --android

•	Setup environment variables

       - export ANDROID_HOME=/Users/YourUser/Library/Android/sdk

       -  export JAVA_HOME=/Library/Java/JavaVirtualMachines/jdk1.8.0_111.jdk/Contents/Home

        - Add the Android sdk paths to your existing PATH=$PATH variable. e.g. :/Users/YourUser/Library/Android/sdk/tools:/Users/YourUser/Library/Android/sdk/platform-tools:/Users/YourUser/Library/Android/sdk/build-tools

•	Open terminal and clone the project and import all dependencies.

•	Connect an android and ios device

•	Open terminal and enter adb devices and press Trust button on android device

•	Open terminal and enter idevicepair pair and press Trust button on ios device

•	Open XCode, and navigate to Appium (usr/local/lib/node_modules/appium/node_modules/appium-xcuitest-driver) folder and open WebDriverAgent.xcodeproj

•	Build the project (make sure developer signing certificate is installed)

•	Navigate to Product -> Test	(This would install webdriver agent in iOS device, click on stop once webdriver agent opens and closed on the device.)


## Steps to Execute M-Web Tests

	To Execute to Appium tests, execute below command

•	Platform=android mvn install -Dtest=Runner test (Only Android)

•	Platform=ios mvn install -Dtest=Runner test (Only Ios)

•	Platform=both mvn install -Dtest=Runner test (Both Andorid and Ios)

## Reports

Framework has been integrated with Extent Reports, we can find under target folder

•  	Mobile Execution Report: ExternReports.html

•	Web Execution Report: SmavaAutomationReport.html


