package listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import utilities.Logs;

public class TestListeners implements ITestListener {

    private final Logs logs = new Logs();

    @Override
    public void onTestStart(ITestResult result) {
        logs.startTest(result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        logs.endTest("Success");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        logs.endTest("Fail");
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