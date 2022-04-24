package Pages.HomePage;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class HomePage {

    //Declaration of Xpaths used
    static By GetStarted = By.xpath("//button[@class='btnstart btn btn-primary btn-lg']");
    static By cancel = By.xpath("//button[@class='ant-btn ant-btn-default']");
    static By left = By.xpath("//span[@class=\"carousel-control-prev-icon\"]");
    static By right = By.xpath("//span[@class=\"carousel-control-next-icon\"]");
    static String url = "https://automatedhuallocation-ui-urtjok3rza-wl.a.run.app/";
    static By member_1 = By.xpath("//*[@id=\"team\"]/div/div[2]/div[1]/div/div/img");
    static By member_2 = By.xpath("//*[@id=\"team\"]/div/div[2]/div[2]/div/div/img");
    static By member_3 = By.xpath("//*[@id=\"team\"]/div/div[2]/div[3]/div/div/img");
    static By member_4 = By.xpath("//*[@id=\"team\"]/div/div[2]/div[4]/div/div/img");

    //Open Page
    public static WebDriver open_page() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\suhasm\\Downloads\\selenium\\selenium 4.1.2\\chromedriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get(url);
        driver.manage().window().maximize();
        Thread.sleep(2000);
        return driver;
    }

    //Title of the webpage
    public static String title(WebDriver driver) {
        return driver.getTitle();
    }

    //Carousel
    public static void carousel(WebDriver driver) throws InterruptedException {
        driver.findElement(left).click();
        Thread.sleep(2000);

        driver.findElement(right).click();
        Thread.sleep(2000);
    }

    //Get Started Button
    public static void GetStarted_btn(WebDriver driver) throws InterruptedException {
        WebElement Get_started_btn = driver.findElement(GetStarted);
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollBy(0,1000)");
        Thread.sleep(2000);
        Get_started_btn.click();
        Thread.sleep(2000);
        driver.findElement(cancel).click();
        Thread.sleep(2000);
    }

    //Team Members
    public static void Check_members(WebDriver driver) throws InterruptedException {
        WebElement member1 = driver.findElement(member_1);
        WebElement member2 = driver.findElement(member_2);
        WebElement member3 = driver.findElement(member_3);
        WebElement member4 = driver.findElement(member_4);

        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollBy(0,1500)");
        Thread.sleep(2000);

        Actions act = new Actions(driver);
        act.moveToElement(member1).perform();
        Thread.sleep(2000);
        act.moveToElement(member2).perform();
        Thread.sleep(2000);
        act.moveToElement(member3).perform();
        Thread.sleep(2000);
        act.moveToElement(member4).perform();
        Thread.sleep(2000);
    }
}