package com.tf.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.*;
import org.testng.xml.XmlClass;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class WebDriverListener implements IInvokedMethodListener, ITestListener, IRetryAnalyzer {

    ExtentReports report;
    private static AtomicInteger atomicIndex = new AtomicInteger(0);
    private int count = 0;
    private int maxCount = Integer.parseInt("1");
    static HashMap<String, ExtentTest> extentMap = new HashMap();
    PropertyReader propertyReader;
    public static String filePath = System.getProperty("user.dir") + "/target/SmavaAutomationReport.html";

    public WebDriverListener () {
        propertyReader = PropertyReader.getInstance();
    }

    @Override
    public void beforeInvocation ( IInvokedMethod iInvokedMethod, ITestResult iTestResult ) {
        if (iInvokedMethod.isTestMethod()) {
            String browserName = iInvokedMethod.getTestMethod().getXmlTest().getLocalParameters().get("browserName");
            WebDriver driver = DriverFactory.createInstance(browserName);
            DriverManager.setDriver(driver);
        }
        Thread.currentThread().setName(String.valueOf(atomicIndex.getAndIncrement()));
    }

    @Override
    public void afterInvocation ( IInvokedMethod iInvokedMethod, ITestResult iTestResult ) {

        if (iTestResult.getStatus() == ITestResult.SUCCESS) {
            ExtentTest child = extentMap.get(iInvokedMethod.getTestMethod().getRealClass().getSimpleName())
                    .createNode(iTestResult.getMethod().getMethodName())
                    .assignCategory(iInvokedMethod.getTestMethod().getRealClass().getSimpleName());
            ExtentTestFactory.setExtentTest(child);
            ExtentTestFactory.getExtentTest().pass("Test passed");
        }
        if (DriverManager.getDriver() != null) {
            DriverManager.getDriver().quit();
        }
    }

    @Override
    public void onStart ( ITestContext iTestContext ) {
        report = new ExtentReports();
        report.attachReporter(getHtmlReporter());
        report.setSystemInfo("Selenium Java Version", "3.0");
        String environment = System.getenv("EnvironmentName");
        if (environment == null) {
            environment = propertyReader.readProperty("environment");
        }
        report.setSystemInfo("Environment", environment);
        List<XmlClass> classnames = iTestContext.getCurrentXmlTest().getClasses();
        for (XmlClass classname : classnames) {
            String name = classname.getName().toString();
            String[] names = name.split("\\.");
            extentMap.put(names[names.length - 1], report.createTest(names[names.length - 1]));
        }
    }

    @Override
    public void onFinish ( ITestContext iTestContext ) {
        report.flush();
    }

    public void captureScreenShot ( String className, String methodName ) throws IOException, InterruptedException {
        try {
            File scrFile = ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.FILE);
            String screenShotNameWithTimeStamp = currentDateAndTime();
            String failedScreen =
                    System.getProperty("user.dir") + "/target/screenshot/" + className + "/" + methodName + "/"
                            + screenShotNameWithTimeStamp + "_" + methodName + "_failed" + ".png";
            FileUtils.copyFile(scrFile, new File(failedScreen));
            ExtentTestFactory.getExtentTest()
                    .log(Status.INFO,
                            "Snapshot below: " + ExtentTestFactory.getExtentTest().addScreenCaptureFromPath(
                                    "screenshot/" + className + "/" + methodName + "/"
                                            + screenShotNameWithTimeStamp + "_" + methodName + "_failed" + ".png"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String currentDateAndTime () {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("ddMMyyyyHHmmss");
        return now.format(dtf);
    }

    private static ExtentHtmlReporter getHtmlReporter () {
        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(filePath);
        htmlReporter.config().setChartVisibilityOnOpen(true);
        htmlReporter.config().setDocumentTitle("Responsive Smava Automation");
        htmlReporter.config().setReportName("Smava Execution Report");
        htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
        htmlReporter.config().setTheme(Theme.STANDARD);
        return htmlReporter;
    }

    @Override
    public boolean retry ( ITestResult result ) {
        if (count < maxCount && !result.isSuccess()) {
            System.out.println("Retrying test case: " + result.getMethod() + " [" + result.getParameters()[0] + "]" + ", " + count + " out of " + maxCount);
            count++;
            return true;
        }
        Object[] obj = result.getParameters();
        if (result.getStatus() == ITestResult.FAILURE && count == maxCount) {
            ExtentTest child = extentMap.get(result.getMethod().getRealClass().getSimpleName())
                    .createNode(result.getMethod().getMethodName() + " [" + obj[0] + "]")
                    .assignCategory(result.getMethod().getRealClass().getSimpleName());
            ExtentTestFactory.setExtentTest(child);
            ExtentTestFactory.getExtentTest().log(Status.FAIL, "<pre>" + result.getThrowable() + "</pre>");
            try {
                captureScreenShot(result.getMethod().getRealClass().getSimpleName(), result.getMethod().getMethodName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                WebDriver driver = DriverManager.getDriver();
                if (driver != null) {
                    driver.quit();
                }
            }
        }
        return false;
    }

    @Override
    public void onTestStart ( ITestResult iTestResult ) {

    }

    @Override
    public void onTestSuccess ( ITestResult iTestResult ) {
        printTestResults(iTestResult);
    }

    @Override
    public void onTestFailure ( ITestResult iTestResult ) {
        printTestResults(iTestResult);
    }

    @Override
    public void onTestSkipped ( ITestResult iTestResult ) {

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage ( ITestResult iTestResult ) {

    }

    private void printTestResults ( ITestResult iTestResult ) {

        Reporter.log("Test Method is under Test Class: " + iTestResult.getTestClass().getName(), true);

        if (iTestResult.getParameters().length != 0) {

            String params = ": ";

            for (Object parameter : iTestResult.getParameters()) {

                params += parameter.toString() + ",";

            }

            Reporter.log("Test Method was executed on following parameters " + params, true);
        }

        String status = null;

        switch (iTestResult.getStatus()) {

            case ITestResult.SUCCESS:

                status = "Pass";

                break;

            case ITestResult.FAILURE:

                status = "Failed";

                break;

            case ITestResult.SKIP:

                status = "Skipped";

        }

        Reporter.log("Test Status: " + status, true);
    }
}
