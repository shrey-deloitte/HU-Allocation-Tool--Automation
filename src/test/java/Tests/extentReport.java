package Tests;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class extentReport {
    public static Logger log;
    public static ExtentReports extent;
    public static ExtentTest test;
    static {
        log = LogManager.getLogger(extentReport.class.getName());
        extent = new ExtentReports();
        extent.attachReporter(new ExtentHtmlReporter("Newextent.html"));
        //test = extent.createTest("Main Assignment", "Test Description");
    }
}