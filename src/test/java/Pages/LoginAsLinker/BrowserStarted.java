package Pages.LoginAsLinker;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import java.time.Duration;
public class BrowserStarted {
    String appURL = "https://automatedhuallocation-ui-urtjok3rza-wl.a.run.app/";
    String GetStarted = "//*[@id=\"root\"]/div/div[3]/div[1]/div[2]/button";
    String Username = "//*[@id=\"basic_username\"]";
    String Password = "//*[@id=\"basic_password\"]";
    String Submit = "//*[@id=\"basic\"]/div[3]/div/div/div/button";
    String Notification = "//*[@id=\"root\"]/div/div[1]/div[3]/div[1]";
    public WebDriver driver;

    @Test(priority = 1)
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "Driver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().window().maximize();
        driver.get(appURL);}
    @Test(priority = 2)
    public void linkerLogin() {
        WebElement element = driver.findElement(By.xpath(GetStarted));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", element);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
        driver.findElement(By.xpath(Username)).sendKeys("gheavens2");
        driver.findElement(By.xpath(Password)).sendKeys("password");
        driver.findElement(By.xpath(Submit)).click();
    }
    @Test(priority = 3)
    public void getNotify() throws InterruptedException {
        driver.findElement(By.xpath(Notification)).click();
        driver.findElement(By.xpath(Notification)).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20);
    }
    @Test(priority = 4)
    public void preferenceButton(){
        driver.findElement(By.xpath("//*[contains(text(),'Preference Form')]")).click();

    }
}
//    }
//    public void Login(WebDriver driver) {
//        this.driver = driver;
//    }
//    @Test
//    public void login(){
//        ReadingExcel readingExcel = new ReadingExcel();
//     //   driver.findElement(By.xpath(Username)).sendKeys(readingExcel.Username);
//        System.out.println(readingExcel.Username);
//     //   driver.findElement(By.xpath(Password)).sendKeys(readingExcel.Password);
//        System.out.println(readingExcel.Password);
      //  driver.findElement(By.xpath(Submit)).click();

//
//    @AfterTest
//   public void AppQuit(){
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
//       driver.close();
//}

