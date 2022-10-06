package listeners;

import base.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import utilities.DriverManager;
import utilities.Logs;

public class TestListeners implements ITestListener {

    private final Logs logs = new Logs();

    @Override
    public void onTestStart(ITestResult result) {
        logs.startTest(result.getName());
    }

    private WebDriver getDriverFromResult(ITestResult result) {
        var currentClass = result.getInstance();
        return ((BaseTest) currentClass).getDriver();
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        logs.endTest("Success");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        logs.endTest("Fail");
        var driverManager = new DriverManager();
        var driver = getDriverFromResult(result);
        driverManager.getScreenshot(driver, result.getName());
        driverManager.attachAllureScreenShot(driver);
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        logs.endTest("Skipped");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
        ITestListener.super.onTestFailedWithTimeout(result);
    }

    @Override
    public void onStart(ITestContext context) {
        ITestListener.super.onStart(context);
    }

    @Override
    public void onFinish(ITestContext context) {
        ITestListener.super.onFinish(context);
    }
}