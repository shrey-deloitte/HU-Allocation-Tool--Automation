package Pages.LoginAsDirector;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
public class ExtentReportsSetUp {

    public static Logger log;
   public static ExtentHtmlReporter htmlReporter;
   public static ExtentReports extent;
    static {
        log = LogManager.getLogger(ExtentReportsSetUp.class.getName());

    }
}