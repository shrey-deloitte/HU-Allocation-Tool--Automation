package Tests;

import Pages.LoginAsDirector.AllProductsList;
import Pages.LoginAsDirector.LoginPage;
import Pages.LoginAsDirector.ProductTrackMainPage;
import net.bytebuddy.build.Plugin;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import org.openqa.selenium.io.FileHandler;
import org.testng.Assert;
import org.testng.annotations.*;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import java.io.File;
import java.io.IOException;
import java.io.PushbackInputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;


public class Tests {
   static WebDriver driver;
    static int i = 1;
    File folder;
    String HomeUrl="https://automatedhuallocation-ui-urtjok3rza-wl.a.run.app/";
    LoginPage loginPage;
    ProductTrackMainPage productTrackMainPage;
    AllProductsList allProductsList;

    @BeforeClass
    public void fileSetup(){

        System.setProperty("webdriver.chrome.driver",baseClass.chromePath);




        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(HomeUrl);



    }

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

       @Test(priority = 6)
    public void uploadFiles() throws InterruptedException {
        productTrackMainPage=new ProductTrackMainPage(driver);

        productTrackMainPage.uploadFiles();
    }
    @Test(priority = 7)
    public void verifyShowUploadBtns() throws InterruptedException {
        productTrackMainPage=new ProductTrackMainPage(driver);
        productTrackMainPage.verifyShowUploadBtn();
    }
    @Test(priority = 8)
    public void verifyAddNewProjectBtn() throws InterruptedException {
        productTrackMainPage=new ProductTrackMainPage(driver);
        productTrackMainPage.verifyAddNewProjectBtn();
    }

    @Test(priority = 9)
    public void verifyPerformAnalysisBtn() throws InterruptedException {
        productTrackMainPage=new ProductTrackMainPage(driver);
        productTrackMainPage.verifyPerformAnalysisBtn();
    }

    public void verifySearchBox(){
        allProductsList=new AllProductsList(driver);
        allProductsList.verifySearchBox();
    }
    @Test(priority = 10)
    public void countOfAllProducts() throws InterruptedException {

        allProductsList=new AllProductsList(driver);
        allProductsList.countOfAllProducts();
    }
    @Test(priority = 11)
    public void verifyProductLeadBtn() throws InterruptedException {
        allProductsList=new AllProductsList(driver);
        allProductsList.verifyProductLeadBtn();
    }
    @Test(priority = 12)
    public void verifyEditProductTeam() throws InterruptedException {
        allProductsList=new AllProductsList(driver);
        allProductsList.verifyEditProductTeam();
    }
    @Test(priority = 12)
    public void verifyPieChart() throws InterruptedException {
        allProductsList=new AllProductsList(driver);
        allProductsList.verifyPieChart();
    }
    @Test(priority = 14)
    public void verifyAddNotif(){
        allProductsList=new AllProductsList(driver);
        allProductsList.verifyAddNotif();
    }

    @AfterClass
    public void tearDown(){

    driver.quit();


    }
    public static void takeScreenshot() {

        try {
            File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            //The below method will save the screen shot in destination directory
            FileHandler.copy(scrFile, new File(System.getProperty("user.dir") + "/src/Screenshots/" + "sample" + i + ".png"));
            i++;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
