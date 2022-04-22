package Tests;

import Pages.LoginAsDirector.LoginPage;
import net.bytebuddy.build.Plugin;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.io.IOException;

public class Tests {
    WebDriver driver;
    String HomeUrl="https://automatedhuallocation-ui-urtjok3rza-wl.a.run.app/";
    LoginPage loginPage;

    @BeforeSuite
    public void setup() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\shubhamkumar32\\Downloads\\chromedriver.exe");
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

}
