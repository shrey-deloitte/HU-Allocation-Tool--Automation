package Pages.HomePage;

import org.checkerframework.checker.units.qual.A;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class HomePage {

    //Initializing web driver
   static By ele = By.xpath("//button[@class='btnstart performbtn btn btn-primary btn-lg']");
   static By cancel = By.xpath("/html/body/div/div/div[1]/button[1]");
   static By left = By.xpath("//span[@class=\"carousel-control-prev-icon\"]");
   static By right = By.xpath("//span[@class=\"carousel-control-next-icon\"]");
   static String url = "https://automatedhuallocation-ui-urtjok3rza-wl.a.run.app/";


    //Open Page
    public static WebDriver open_page() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\suhasm\\Downloads\\selenium\\selenium 4.1.2\\chromedriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get(url);
        driver.manage().window().maximize();
        Thread.sleep(2000);
        return driver;
    }

    public static String title(WebDriver driver){
       return driver.getTitle();
    }
    public static void carousel(WebDriver driver) throws InterruptedException {
        driver.findElement(left).click();
        Thread.sleep(2000);

        driver.findElement(right).click();
        Thread.sleep(2000);
    }

    public static void GetStarted_btn(WebDriver driver) throws InterruptedException {
        WebElement Get_started_btn = driver.findElement(ele);
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].click()", Get_started_btn);
//        Get_started_btn.click();
        Thread.sleep(2000);
        driver.findElement(cancel).click();
        Thread.sleep(2000);
    }
    public static void Check_members(WebDriver driver) throws InterruptedException {
        WebElement member = driver.findElement(By.xpath("//*[@id=\"team\"]/div/div[2]/div[1]/div/div/div"));
//        Actions act = new Actions(driver);
//        act.moveToElement(member).perform();
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        //jse.executeScript("arguments[0].click()", member);
        jse.executeScript("window.scrollBy(0,1000)");
        Thread.sleep(2000);
//        WebDriver webdriver = new ChromeDriver();
//        System.setProperty("webdriver.chrome.driver", "C:\\Users\\suhasm\\Downloads\\selenium\\selenium 4.1.2\\chromedriver\\chromedriver.exe");
//        JavascriptExecutor js = (JavascriptExecutor) webdriver;
//        webdriver.get(url);
//        webdriver.manage().window().maximize();
//        js.executeScript("window.scrollBy(0,1000)");
    }
}