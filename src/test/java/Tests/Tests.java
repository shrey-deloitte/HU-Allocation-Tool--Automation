package Tests;

import Pages.LoginAsDirector.AllProductsList;
import Pages.LoginAsDirector.LoginPage;
import Pages.LoginAsDirector.ProductTrackMainPage;
import net.bytebuddy.build.Plugin;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import java.io.File;
import java.io.IOException;
import java.io.PushbackInputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;


public class Tests {
    WebDriver driver;
    File folder;
    String HomeUrl="https://automatedhuallocation-ui-urtjok3rza-wl.a.run.app/";
    LoginPage loginPage;
    ProductTrackMainPage productTrackMainPage;
    AllProductsList allProductsList;

    @BeforeSuite
    public void fileSetup(){

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\shubhamkumar32\\Downloads\\chromedriver.exe");




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

    @AfterSuite
    public void tearDown(){

    //driver.quit();

    }
}
