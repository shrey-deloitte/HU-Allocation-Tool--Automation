package Tests;

import Pages.LoginAsDirector.ExtentReportsSetUp;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import java.io.IOException;
public class TestNGListener extends Tests implements ITestListener {
    Logger log = ExtentReportsSetUp.log;


    @Override
    public void onTestStart(ITestResult result) {
        log.info(result.getMethod().getMethodName() + " start");
        takeScreenshot();
        //ITestListener.super.onTestStart(result);

    }

    @Override
    public void onTestSuccess(ITestResult result) {
        log.info(result.getMethod().getMethodName() + " success");
        takeScreenshot();

    }

    @Override
    public void onTestFailure(ITestResult result) {
        log.info(result.getMethod().getMethodName() + " Failed");
        takeScreenshot();

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
    public void onFinish(ITestContext result) {
        log.info(result.getName() + " finished");
        takeScreenshot();

    }

}
