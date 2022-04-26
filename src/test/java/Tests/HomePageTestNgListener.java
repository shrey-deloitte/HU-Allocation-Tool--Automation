package Tests;

import Pages.HomePage.LogSetup;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.apache.logging.log4j.Logger;
import org.testng.ITestResult;

public class HomePageTestNgListener extends Test_Homepage implements ITestListener {
    Logger log = LogSetup.log;

    @Override
    public void onTestStart(ITestResult result){
        log.info(result.getMethod().getMethodName() +" start");
        takeScreenshot();
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