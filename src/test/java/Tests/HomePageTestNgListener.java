package Tests;

import Pages.HomePage.LogSetup;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.apache.logging.log4j.Logger;
import org.testng.ITestResult;

import static Tests.extentReport.extent;

public class HomePageTestNgListener  implements ITestListener {
    Logger log = LogSetup.log;
    ExtentTest test = extentReport.test;

    @Override
    public void onTestStart(ITestResult result){
        log.info(result.getMethod().getMethodName() +" start");
        System.out.println(result.getMethod().getMethodName()+"start");
        test = extent.createTest(result.getMethod().getMethodName(), "Test Description");
        test.log(Status.INFO, result.getMethod().getMethodName() + " start");
       // takeScreenshot();
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        log.info(result.getMethod().getMethodName() + " success");
        System.out.println(result.getMethod().getMethodName()+"success");
        test = extent.createTest(result.getMethod().getMethodName(), "Test Description");
        test.log(Status.PASS, result.getMethod().getMethodName() + " success");
       // takeScreenshot();
    }

    @Override
    public void onTestFailure(ITestResult result) {
        log.info(result.getMethod().getMethodName() + " Failed");
        System.out.println(result.getMethod().getMethodName()+"failed");
        test = extent.createTest(result.getMethod().getMethodName(), "Test Description");
        test.fail(result.getMethod().getMethodName() + " test Fail");
       // takeScreenshot();
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
        System.out.println(result.getName()+"finished");
        extent.flush();
        extentReport.log.traceExit();
        //takeScreenshot();

    }
}