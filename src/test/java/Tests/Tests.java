package Tests;

import Pages.LoginAsDirector.LoginPage;
import Pages.LoginAsDirector.ProductTrackMainPage;
import net.bytebuddy.build.Plugin;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;

public class Tests {
    WebDriver driver;
    File folder;
    String HomeUrl="https://automatedhuallocation-ui-urtjok3rza-wl.a.run.app/";
    LoginPage loginPage;
    ProductTrackMainPage productTrackMainPage;

    @BeforeSuite
    public void fileSetup(){
        folder = new File(UUID.randomUUID().toString());
        folder.mkdir();
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\shubhamkumar32\\Downloads\\chromedriver.exe");

//        ChromeOptions options= new ChromeOptions();
//        Map<String,Object> prefs= new HashMap<String, Object>();
//        prefs.put("profile.default_content_settings.popups",0);
//        prefs.put("download.default_directory",folder.getAbsolutePath());
//
//        options.setExperimentalOption("prefs",prefs);
//        DesiredCapabilities caps = DesiredCapabilities.chrome();
//        caps.setCapability(ChromeOptions.CAPABILITY,options);
//        options.addArguments("--start-maximized");
//        options.merge(caps);


        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(HomeUrl);



    }
//    @BeforeSuite
//    public void setup() throws InterruptedException {
//
//
//
//
//    }
    @Test(priority = 1)
    public void loginAvatarClick() throws InterruptedException {
       loginPage =new LoginPage(driver);
       loginPage.ClickOnLoginIcon();

    }
    @Test(priority = 2)
    public void Login() throws IOException {
        loginPage=new LoginPage(driver);
        loginPage.readLoginDetails();
        loginPage.addLoginDetails();
    }
    @Test(priority = 3)
    public void clickOnSubmitBtn() throws InterruptedException {
        loginPage=new LoginPage(driver);
        loginPage.clickOnSubmitBtn();
    }
    @Test(priority = 4)
    public void verifyNumberOfUploadTypes(){
        productTrackMainPage=new ProductTrackMainPage(driver);
        productTrackMainPage.verifyNumberOfUploadTypes();
    }
//    @Test(priority = 5)
//    public void verifyDownloadSampleLink(){
//        productTrackMainPage=new ProductTrackMainPage(driver);
//        productTrackMainPage.verifyDownloadSampleLink();
//    }
    @Test(priority = 5)
    public void download() throws InterruptedException {

        productTrackMainPage=new ProductTrackMainPage(driver);
        productTrackMainPage.verifyFilesDownloadedOrNot();

    }

    @AfterSuite
    public void tearDown(){
        driver.quit();

        for(File file:folder.listFiles()){
            file.delete();
        }
        folder.delete();
    }
}
