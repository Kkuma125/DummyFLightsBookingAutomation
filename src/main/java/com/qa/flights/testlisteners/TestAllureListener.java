package com.qa.flights.testlisteners;

import com.qa.flights.factory.DriverFactory;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;


public class TestAllureListener extends DriverFactory implements ITestListener {

    private static String getTestMethodName(ITestResult iTestResult) {
        return iTestResult.getMethod().getConstructorOrMethod().getName();
    }

    // Text attachments for Allure
    @Attachment(value = "Page screenshot", type = "image/png")
    public void saveScreenshotPNG(WebDriver driver) {
        ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
    }

    // Text attachments for Allure
    @Attachment(value = "{0}", type = "text/plain")
    public static void saveTextLog(String message) {
    }

    // HTML attachments for Allure
    @Attachment(value = "{0}", type = "text/html")
    public static String attachHtml(String html) {
        return html;
    }

    @Override
    public void onStart(ITestContext iTestContext) {
        System.out.println("I am in onStart method "+iTestContext.getName());
        //iTestContext.setAttribute("WebDriver", BasePage.getDriver());
    }

    @Override
    public void onFinish(ITestContext iTestContext) {
        System.out.println("I am in onFinish method "+iTestContext.getName());
    }

    @Override
    public void onTestStart(ITestResult iTestResult) {
        System.out.println("I am in onTestStart method "+getTestMethodName(iTestResult)+" start");
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        System.out.println("I am in onTestSuccess method "+getTestMethodName(iTestResult)+" succeed");
        Object testClass = iTestResult.getInstance();
        //WebDriver driver = BasePage.getDriver();
        // Allure ScreenShotRobot and SaveTestLog
        if (getDriver() instanceof WebDriver) {
            System.out.println("Screenshot captured for test case:"+getTestMethodName(iTestResult));
            saveScreenshotPNG(getDriver());
        }
        // Save a log on allure.
        saveTextLog(getTestMethodName(iTestResult)+" succeed and screenshot taken!");
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        System.out.println("I am in onTestFailure method "+getTestMethodName(iTestResult)+" failed");
        Object testClass = iTestResult.getInstance();
        //WebDriver driver = BasePage.getDriver();
        // Allure ScreenShotRobot and SaveTestLog
        if (getDriver() instanceof WebDriver) {
            System.out.println("Screenshot captured for test case:"+getTestMethodName(iTestResult));
            saveScreenshotPNG(getDriver());
        }
        // Save a log on allure.
        saveTextLog(getTestMethodName(iTestResult)+" failed and screenshot taken!");
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        System.out.println("I am in onTestSkipped method "+getTestMethodName(iTestResult)+" skipped");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
        System.out.println("Test failed but it is in defined success ratio "+getTestMethodName(iTestResult));
    }
}
