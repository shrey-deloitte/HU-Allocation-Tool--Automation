package Pages.LoginAsLinker;
import Tests.extentReport;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import com.aventstack.extentreports.ExtentReports;
import org.apache.logging.log4j.Logger;

import java.time.Duration;
//@Listeners(Listener.class)
public class linkersTestcases extends extentReport {
    Logger log = extentReport.log;
    ExtentReports extent = extentReport.extent;
    static int number =1;
    LinkersLogin linkersLogin;
    static WebDriver driver;
    String appURL = "https://automatedhuallocation-ui-urtjok3rza-wl.a.run.app/";
    String GetStarted = "//*[@id=\"root\"]/div/div[3]/div[1]/div[2]/button";
    String Notification = "//*[@id=\"root\"]/div/div[1]/div[3]/div[1]";

    //@Test(priority = 1)
    @BeforeClass
    public void setup() throws Exception {
       System.setProperty("webdriver.chrome.driver", "C:\\Users\\shubhamkumar32\\Downloads\\chromedriver.exe");
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

    @Test(priority = 4)
    public void getNotify()  {
        driver.findElement(By.xpath(Notification)).click();
        driver.findElement(By.xpath(Notification)).click();
       driver.manage().timeouts().implicitlyWait(Duration.ofMinutes(1));
    }

    @Test(priority = 5)
    public void preferenceButton()  {
        driver.findElement(By.xpath("//*[contains(text(),'Preference Form')]")).click();
        driver.findElement(By.xpath("//*[@id=\"vertical-tabpanel-0\"]/div/p/button")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofMinutes(1));
        driver.findElement(By.xpath("//*[contains(text(),'Data Engineering')]")).click();
    }

    @Test(priority = 6)
    public void Submit() {
        driver.findElement(By.xpath("//*[@id=\"vertical-tabpanel-0\"]/div/p/div[2]/button")).click();
        boolean status =  driver.findElement(By.xpath("//*[@id=\"vertical-tabpanel-0\"]/div/p/div[2]/button")).isDisplayed();
        if(status){
            System.out.println("logging failed");
        }
       // System.out.println("Submit is clicked but not working");

    }

    @AfterClass
    public void AppQuit() {
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.close();
    }
}

