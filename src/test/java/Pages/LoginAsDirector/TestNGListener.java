package Pages.LoginAsDirector;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import java.io.IOException;
public class TestNGListener implements ITestListener {
    Logger log = ExtentReportsSetUp.log;
    ExtentTest test = ExtentReportsSetUp.test;

    @Override
    public void onTestStart(ITestResult result) {
        log.info(result.getMethod().getMethodName() + " start");
        test.log(Status.INFO, result.getMethod().getMethodName() + " start");
        //ITestListener.super.onTestStart(result);

    }

    @Override
    public void onTestSuccess(ITestResult result) {
        log.info(result.getMethod().getMethodName() + " success");
        test.log(Status.PASS, result.getMethod().getMethodName() + " success");

    }

    @Override
    public void onTestFailure(ITestResult result) {
        test.fail(result.getMethod().getMethodName() + " test Fail");

    }

    @Override
    public void onTestSkipped(ITestResult result) {

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

    @Override
    public void onStart(ITestContext context) {

    }

    @Override
    public void onFinish(ITestContext context) {
        ExtentReportsSetUp.extent.flush();
        ExtentReportsSetUp.log.traceExit();

    }

}
