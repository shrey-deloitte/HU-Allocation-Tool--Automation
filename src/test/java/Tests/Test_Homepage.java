package Tests;

import Pages.HomePage.HomePage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class Test_Homepage {

    WebDriver driver;
    String title_to_check = "HU ALLOCATION TOOL";
    String url = "https://automatedhuallocation-ui-urtjok3rza-wl.a.run.app/";

    //Initializing web driver
    @BeforeTest
    public void setup() throws InterruptedException {
        driver = HomePage.open_page();
        Thread.sleep(1000);
    }

    //Verifying Title
    @Test(priority = 1)
    public void Check_Title() throws InterruptedException {
        Thread.sleep(2000);
        try {
            Thread.sleep(2000);
            String title = HomePage.title(driver);
            Assert.assertEquals(title,title_to_check);
            System.out.println("Title is matched, title is "+title);
        }
        catch (Exception e){
            System.out.println("Title is not matched");
        }
//        Assert.assertEquals(HomePage.title(driver),title_to_check);
    }

    //Verifying Carousel
    @Test(priority = 2)
    void Carousel() throws InterruptedException {
        HomePage.carousel(driver);
        Thread.sleep(1000);
    }

    //Verifying Get Started Button
    @Test(priority = 3)
    void GetStarted_Btn() throws InterruptedException {
        HomePage.GetStarted_btn(driver);
        Thread.sleep(2000);
    }

    //Verfying the Login icon Button
    @Test(priority = 4)
    void Login_icon_button() throws InterruptedException {
        HomePage.Login_icon(driver);
        Thread.sleep(2000);
    }
    //Verifying the team members
    @Test(priority = 5)
    void Check_members() throws InterruptedException{
        HomePage.Check_members(driver);
        Thread.sleep(2000);
    }

    //Clicking on the website Logo to return Homepage
    @Test(priority = 6)
    void Click_logo() throws InterruptedException {
        HomePage.Website_Logo(driver);
        Thread.sleep(4000);
    }

    //Closing the browser
    @AfterTest
    void Close_Browser() {
        driver.close();
    }
}