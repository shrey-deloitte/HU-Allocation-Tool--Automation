package Pages.LoginAsLinker;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.Duration;

public class BrowserStarted {
    LinkersLogin linkersLogin;
    static WebDriver driver;
    String appURL = "https://automatedhuallocation-ui-urtjok3rza-wl.a.run.app/";
    String GetStarted = "//*[@id=\"root\"]/div/div[3]/div[1]/div[2]/button";
    String Notification = "//*[@id=\"root\"]/div/div[1]/div[3]/div[1]";

    @Test(priority = 1)
    public void setup() throws IOException {
        System.setProperty("webdriver.chrome.driver", "Driver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().window().maximize();
        driver.get(appURL);
        linkersLogin = new LinkersLogin(driver);
    }

    @Test(priority = 2)
    public void linkerLogin() {
        WebElement element = driver.findElement(By.xpath(GetStarted));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", element);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
    }

    @Test(priority = 3)
    public void Login() throws InterruptedException {
        linkersLogin.Login();
    }

    @Test(priority = 5)
    public void getNotify() throws InterruptedException {
        driver.findElement(By.xpath(Notification)).click();
        driver.findElement(By.xpath(Notification)).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }

    @Test(priority = 6)
    public void preferenceButton() throws InterruptedException {
        driver.findElement(By.xpath("//*[contains(text(),'Preference Form')]")).click();
        driver.findElement(By.xpath("//*[@id=\"vertical-tabpanel-0\"]/div/p/button")).click();
        //driver.findElement(By.name("Fill Your Preference")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//*[contains(text(),'Data Engineering')]")).click();
    }

    @Test(priority = 7)
    public void Submit() {
        driver.findElement(By.xpath("//*[@id=\"vertical-tabpanel-0\"]/div/p/div[2]/button")).click();
        System.out.println("Submit is clicked but not working");

    }

    @AfterTest
    public void AppQuit() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.close();
    }
}

