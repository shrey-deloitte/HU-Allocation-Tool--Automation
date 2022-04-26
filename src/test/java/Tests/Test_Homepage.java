package Tests;

import Pages.HomePage.HomePage;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.Assert;
import org.testng.annotations.*;
import java.io.File;
import java.io.IOException;

public class Test_Homepage {

    static WebDriver driver;
    static int i = 1;
    String title_to_check = "HU ALLOCATION TOOL";

    //Initializing web driver
    @BeforeSuite
    public void setup() throws InterruptedException {
        driver = HomePage.open_page();
    }

    //Verifying Title
    @Test(priority = 1)
    public void Check_Title() throws InterruptedException {
        try {
            String title = HomePage.title(driver);
            Assert.assertEquals(title,title_to_check);
            System.out.println("Title is matched, title is "+title);
        }
        catch (Exception e){
            System.out.println("Title is not matched");
        }
        //Assert.assertEquals(HomePage.title(driver),title_to_check);
    }

    //Verifying Carousel
    @Test(priority = 2)
    void Carousel() throws InterruptedException {
        HomePage.carousel(driver);
    }

    //Verifying Get Started Button
    @Test(priority = 3)
    void GetStarted_Btn() throws InterruptedException {
        HomePage.GetStarted_btn(driver);
        takeScreenshot();
        Thread.sleep(1000);
        HomePage.Cancel_button(driver);
    }

    //Verifying the Login icon Button
    @Test(priority = 4)
    void Login_icon_button() throws InterruptedException {
        HomePage.Login_icon(driver);
        takeScreenshot();
        Thread.sleep(1000);
        HomePage.Cancel_button(driver);
    }

    //Verifying the team members
    @Test(priority = 5)
    void Check_members() throws InterruptedException{
        HomePage.Check_members(driver);
        takeScreenshot();
    }

    //Clicking on the website Logo to return Homepage
    @Test(priority = 6)
    void Click_logo() throws InterruptedException {
        HomePage.Website_Logo(driver);
        Thread.sleep(2000);
    }

    //Taking Screenshot
    public static void takeScreenshot() {
        try {
            File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileHandler.copy(scrFile, new File(System.getProperty("user.dir") + "/src/HomePage_screenshots/" + "screenshot " + i + ".png"));
            i++;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //Closing the browser
    @AfterSuite
    void Close_Browser() {
        driver.close();
    }
}