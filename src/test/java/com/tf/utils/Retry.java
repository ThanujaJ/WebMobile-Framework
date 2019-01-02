package com.tf.utils;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.Augmenter;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

public class Retry implements IRetryAnalyzer {

    PropertyReader maxCountReader = new PropertyReader();
    int maxCount = Integer.parseInt(maxCountReader.readProperty("MAX_RETRY_COUNT"));
    Map<String, Integer> retryCounts = new HashMap<String, Integer>();

    @Override
    public boolean retry ( ITestResult result ) {
        int counter = 0;
        int retryCountForTest = 0;
        String methodName = result.getMethod().getMethodName();
        Object[] obj = result.getParameters();

        while (obj.length != counter) {
            methodName = methodName + "_" + obj[counter];
            counter++;
        }

        if (retryCounts.containsKey(methodName)) {
            retryCountForTest = retryCounts.get(methodName);
            retryCountForTest++;
        }

        if (!result.isSuccess() && retryCountForTest < maxCount) {
            System.out.println(methodName + " execution failed in count: " + retryCountForTest + "\n");
            retryCounts.put(methodName, retryCountForTest);
            return true;
        }

        if (!result.isSuccess() && retryCountForTest == maxCount) {
            retryCounts.remove(methodName);
            System.out.println(methodName + " execution failed in count: " + maxCount + "\n");
            ExtentTest child = WebDriverListener.extentMap.get(result.getMethod().getRealClass().getSimpleName())
                    .createNode(result.getMethod().getMethodName() + "[" + obj[0] + "]")
                    .assignCategory(result.getMethod().getRealClass().getSimpleName());
            ExtentTestFactory.setExtentTest(child);
            ExtentTestFactory.getExtentTest().info(obj[0].toString());
            ExtentTestFactory.getExtentTest().log(Status.FAIL, "<pre>" + result.getThrowable() + "</pre>");
            try {
                System.out.println("Trying to capture screenshot: ");
                captureScreenShot(result.getMethod().getRealClass().getSimpleName(), result.getMethod().getMethodName());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    public void captureScreenShot ( String className, String methodName ) throws IOException {
        System.out.println("Page title is: " + DriverManager.getDriver().getTitle());
        WebDriver driver = new Augmenter().augment(DriverManager.getDriver());
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
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
    }

    public String currentDateAndTime () {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("ddMMyyyyHHmmss");
        return now.format(dtf);
    }
}

