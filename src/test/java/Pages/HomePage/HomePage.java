package Pages.HomePage;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class HomePage {

    //Declaration of xpath and URL
    static String url = "https://automatedhuallocation-ui-urtjok3rza-wl.a.run.app/";
    static By GetStarted = By.xpath("//button[@class='btnstart btn btn-primary btn-lg']");
    static By LoginIcon = By.xpath("//span[@class='ant-avatar ant-avatar-circle ant-avatar-icon']");
    static By cancel = By.xpath("//button[@class='ant-btn ant-btn-default']");
    static By left = By.xpath("//span[@class=\"carousel-control-prev-icon\"]");
    static By right = By.xpath("//span[@class=\"carousel-control-next-icon\"]");
    static By member_1 = By.xpath("//*[@id=\"team\"]/div/div[2]/div[1]/div/div/img");
    static By member_2 = By.xpath("//*[@id=\"team\"]/div/div[2]/div[2]/div/div/img");
    static By member_3 = By.xpath("//*[@id=\"team\"]/div/div[2]/div[3]/div/div/img");
    static By member_4 = By.xpath("//*[@id=\"team\"]/div/div[2]/div[4]/div/div/img");
    static By Logo = By.xpath("//a[@href='/']");

    //Open Page
    public static WebDriver open_page() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\suhasm\\Downloads\\selenium\\selenium 4.1.2\\chromedriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get(url);
        driver.manage().window().maximize();
        return driver;
    }

    //Title of the webpage
    public static String title(WebDriver driver) {
        return driver.getTitle();
    }

    //Carousel
    public static void carousel(WebDriver driver) throws InterruptedException {
        driver.findElement(left).click();
        Thread.sleep(1000);

        driver.findElement(right).click();
    }

    //Get Started Button
    public static void GetStarted_btn(WebDriver driver) throws InterruptedException {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollBy(0,1000)");
        Thread.sleep(2000);

        driver.findElement(GetStarted).click();
        Thread.sleep(1000);
    }

    //Cancel Button
    public static void Cancel_button(WebDriver driver) {
        driver.findElement(cancel).click();
    }

    //Login icon button
    public static void Login_icon(WebDriver driver) throws InterruptedException {
        driver.findElement(LoginIcon).click();
        Thread.sleep(1000);
    }

    //Team Members
    public static void Check_members(WebDriver driver) throws InterruptedException {

        WebElement member1 = driver.findElement(member_1);
        WebElement member2 = driver.findElement(member_2);
        WebElement member3 = driver.findElement(member_3);
        WebElement member4 = driver.findElement(member_4);

        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollBy(0,500)");
        Thread.sleep(500);

        Actions act = new Actions(driver);
        act.moveToElement(member1).perform();
        Thread.sleep(2000);
        act.moveToElement(member2).perform();
        Thread.sleep(2000);
        act.moveToElement(member3).perform();
        Thread.sleep(2000);
        act.moveToElement(member4).perform();
        Thread.sleep(2000);

        jse.executeScript("window.scrollBy(0,2000)");
    }

    //Clicking Website Logo to return HomePage
    public static void Website_Logo(WebDriver driver) {
        driver.findElement(Logo).click();
    }

}