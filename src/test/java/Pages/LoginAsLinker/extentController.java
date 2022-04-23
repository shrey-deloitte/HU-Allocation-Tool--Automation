package Pages.LoginAsLinker;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class extentController {
    public static Logger log;
    public static ExtentReports extent;
    public static ExtentTest test;
    static {
        log = LogManager.getLogger(extentController.class.getName());
        extent = new ExtentReports();
        extent.attachReporter(new ExtentSparkReporter("extent.html"));
        test = extent.createTest("Main Assignment", "Test Description");
    }
}