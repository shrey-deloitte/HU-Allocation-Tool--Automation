package Tests;

import Pages.PreferenceTrack.Listener;
import Pages.PreferenceTrack.extentController;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static Pages.PreferenceTrack.Method_container.*;

@Listeners(Listener.class)
public class TestPreferenceTrack
    {
        Logger log = extentController.log;
        ExtentReports extent = extentController.extent;
        
        @Test(priority = 1)
        public void A_openTheWebsite() throws Exception {
            ExtentTest Test = extent.createTest("T1");
            initialSetup(Test,log);
        }
        @Test(priority = 2)
        public void login() throws Exception
        {
            ExtentTest Test = extent.createTest("T2");
            assert (loggingin(Test,log)==true);
        }
        @Test(priority = 3)
        public void check_performance_graphs() throws Exception
        {
            ExtentTest Test = extent.createTest("T3");
            checkthebutton(Test,log);
        }
        @Test(priority = 5)
        public void set_preferencesTrack() throws Exception
        {
            ExtentTest Test = extent.createTest("T4");
            assert (settingthepreferenceTrack(Test,log)==true);
        }
        @Test(priority = 6)
        public void set_preferencesMonth() throws Exception
        {
            ExtentTest Test = extent.createTest("T5");
            assert (settingthepreferenceMonth(Test,log)==true);
        }
       // @AfterClass
        public void close()
        {
            ExtentTest Test = extent.createTest("T6");
            closing(Test,log);
        }


    }

