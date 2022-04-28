package Pages.PreferenceTrack;

import Tests.baseClass;
import com.aventstack.extentreports.ExtentTest;

import com.aventstack.extentreports.Status;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.testng.annotations.Listeners;

import java.time.Duration;

@Listeners(Listener.class)
public class Method_container {
    static WebDriver driver;
    static int number=1;

    public static void initialSetup(ExtentTest test,Logger log) throws Exception
    {
        //Loading CSV
        System.out.println("Q:A :- Open Website");
        test.log(Status.INFO,"Starting of test cases Q:A :- Open Website");
        log.info("Q:A :- Open Website");
        System.setProperty("webdriver.chrome.driver", baseClass.chromePath);
        test.pass("Web driver is initialized successfully");
        driver = new ChromeDriver();
        driver.get("https://automatedhuallocation-ui-urtjok3rza-wl.a.run.app");
        Thread.sleep(1000);
        driver.manage().window().maximize();
        log.info("Website is opened and window is Maximized");
        test.pass("Web pages is opened and maximized");

    }
    public static boolean loggingin(ExtentTest test,Logger log) throws Exception{
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        test.info("login_using username and password");
        System.out.println("Q:B :- get the login username and password");
        log.info("Q:B :- get the login username and password");
        //Clicked "bank manager login"
        Thread.sleep(2000);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[1]/div/div[1]/div[3]/div[2]"))).click();

        Thread.sleep(2000);
        WebElement email = driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div/div/div[2]/form/div[1]/div[2]/div/div/input"));
        email.sendKeys("gheavens2");
        WebElement pass = driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div/div/div[2]/form/div[2]/div[2]/div/div/span/input"));
        pass.sendKeys("password");
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[2]/div/div[2]/div/div/div[2]/form/div[3]/div/div/div/button"))).click();
        Thread.sleep(2000);
        boolean Status = driver.findElement(By.xpath("//div[@class='myimg']")).isDisplayed();
        if (Status==false){
            test.pass("logging failed");
            log.info("logging failed");
            System.out.println("logging failed");
            return false;
        }
        test.pass("logging in");
        log.info("Successfully logged in");
        System.out.println("Successfully logged it");
        return true;

    }
    public static void checkthebutton(ExtentTest test,Logger log) throws Exception{
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        test.info("login_using username and password");
        System.out.println("Q:B :- get the login username and password");
        log.info("Q:B :- get the login username and password");
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(text(),'Section Lead Insights')]"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(text(),'Marks Alloted')]"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(text(),'Grades Achieved')]"))).click();

        JavascriptExecutor jse = (JavascriptExecutor)driver;
        Thread.sleep(2000);
        jse.executeScript("window.scrollBy(300,0)");

    }
    public  static boolean settingthepreferenceMonth(ExtentTest test,Logger log) throws Exception{
        // Click "Home
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        test.info("Q:D :- clicking on preference button" );
        System.out.println("Q:D :- clicking on preference button");
        log.info("Q:D :- clicking on preference button");
        //wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(text(),'Preference Form')]"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(text(),'Product Month Preference')]"))).click();
        // Choice 2
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"vertical-tabpanel-1\"]/div/p/div/div[1]/button[2]"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(text(),'Covid')]"))).click();

        // Choice 1
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"vertical-tabpanel-1\"]/div/p/div/div[1]/button[1]"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(text(),'SWIPE')]"))).click();


        // Choice 3
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"vertical-tabpanel-1\"]/div/p/div/div[1]/button[3]"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(text(),'Hashedin')]"))).click();

        //submit
        //wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='btn btn-success btn-lg']"))).click();
        boolean Status = driver.findElement(By.xpath("//button[@class='btn btn-success btn-lg']")).isDisplayed();
        if (Status==false){
            test.pass("setting failed");
            log.info("setting failed");
            System.out.println("setting failed");
            return false;
        }
        //Loggedin as new User
        test.pass("setting set");
        log.debug("setting set");
        System.out.println("setting set");
        return true;

    }
    public  static boolean settingthepreferenceTrack(ExtentTest test,Logger log) throws Exception{
        // Click "Home
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        test.info("Q:D :- clicking on preference button" );
        System.out.println("Q:D :- clicking on preference button");
        log.info("Q:D :- clicking on preference button");
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(text(),'Preference Form')]"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(text(),'Parallel Track Preference')]"))).click();
        // Choice 2
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"vertical-tabpanel-0\"]/div/p/button"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(text(),'IOT')]"))).click();

        //submit
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='btn btn-success btn-lg']"))).click();
        boolean Status = driver.findElement(By.xpath("//button[@class='btn btn-success btn-lg']")).isDisplayed();
        if (Status==false){
            test.pass("setting failed");
            log.info("setting failed");
            System.out.println("setting failed");
            return false;
        }
        //Loggedin as new User
        test.pass("setting set");
        log.debug("setting set");
        System.out.println("setting set");
        return true;

    }


    public static WebDriver closing(ExtentTest test,Logger log)
    {
        test.info("Browser is closed");
        log.info("Browser is getting closed");
        driver.close();
        extentController.extent.flush();
        return null;
    }

}
