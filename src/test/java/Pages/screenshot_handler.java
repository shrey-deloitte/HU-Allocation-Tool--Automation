package Pages;

import Pages.Method_container;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;

public class screenshot_handler extends Method_container {
    public static void getScreenShotPass() throws IOException
    {
        String filename="PassScreenshot"+""+number+".jpg";
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File src = takesScreenshot.getScreenshotAs(OutputType.FILE);
        File des = new File(System.getProperty("user.dir")+"/PassedScreenshot/"+filename);
        FileUtils.copyFile(src,des);
        System.out.println("Screenshot action is performed for pass condition");
        number+=1;
    }
    public static void getScreenShotFail() throws IOException
    {
        String filename="FailedScreenshot"+""+number+".jpg";
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File src = takesScreenshot.getScreenshotAs(OutputType.FILE);
        File des = new File(System.getProperty("user.dir")+"/FailedScreenshot/"+filename);
        FileUtils.copyFile(src,des);
        System.out.println("Screenshot option is performed for fail condition");
        number+=1;
    }

}
