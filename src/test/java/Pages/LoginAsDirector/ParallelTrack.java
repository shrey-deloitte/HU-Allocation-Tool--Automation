package Pages.LoginAsDirector;

import Tests.baseClass;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;


import static java.lang.Thread.sleep;

public class ParallelTrack {
    static WebDriver driver;
    static int i=1;
    private static Class<Pages.LoginAsDirector.ParallelTrack> ParallelTrack;
    static Logger logger= LogManager.getLogger(ParallelTrack);

    //before test
    @BeforeClass
    public  void launch() throws IOException, InterruptedException {
        System.setProperty("webdriver.chrome.driver", baseClass.chromePath);
        driver=new ChromeDriver();
        driver.get("https://automatedhuallocation-ui-urtjok3rza-wl.a.run.app/");
        driver.manage().window().maximize();
        sleep(3000);

    }

    @Test(priority = 0)
    public void login() throws InterruptedException {
        driver.findElement(By.xpath("//span[@role='img']")).click();
        driver.findElement(By.xpath("//input[@id='basic_username']")).sendKeys("HUDIRECTOR");
        driver.findElement(By.xpath("//input[@id='basic_password']")).sendKeys("HUDIRECTOR");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        sleep(3000);
        logger.info("logged in successfully");
    }

    @Test(priority = 1)
    public void OpenParallelTrack() throws InterruptedException {
        driver.findElement(By.xpath("//div[contains(text(),'Parallel Track')]")).click();
        sleep(3000);
        logger.info("Parallel track opened");
    }

   @Test(priority = 2)
    public void downloadSample() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;

        driver.findElement(By.xpath("//a[@download='linkerdata.csv']")).click();
        sleep(1000);
        driver.findElement(By.xpath("//a[@download='trackresults.csv']")).click();

        sleep(1000);
        js.executeScript("window.scrollBy(0,300)");

       // driver.findElement(By.xpath("//a[@download='paralleltrack.csv']")).click();

     //  sleep(1000);

      // js.executeScript("window.scrollBy(0,300)");

      // driver.findElement(By.xpath("//a[@download='sectionlead.csv']")).click();
       sleep(800);

       // js.executeScript("window.scrollBy(0,200)");

       //driver.findElement(By.xpath("//a[@download='parallelpref.csv']")).click();

       logger.info("Downloaded all sample links");

    }

    @Test(priority = 3)
    public  void  chooseFile(){

        List<WebElement> elementList = driver.findElements(By.xpath("//input[@type='file']"));

        for (int i = 0;i<elementList.size();i++){
            WebElement element = elementList.get(i);

            if(i==0){
                element.sendKeys(baseClass.linkersDataFilePath);
            }
            if(i==1){
                element.sendKeys(baseClass.linkersDataFilePath);
            }
            if(i==2){
                element.sendKeys(baseClass.linkersDataFilePath);
            }
            if(i==3){
                element.sendKeys(baseClass.linkersDataFilePath);
            }
            if(i==4){
                element.sendKeys(baseClass.linkersDataFilePath);
            }
        }
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,-1200)");
        logger.info("Uploaded all sample data");
    }

    @Test(priority = 4)
    public void showUploadedFile() throws InterruptedException {
        List<WebElement> elementList = driver.findElements(By.xpath("//button[contains(@class,'showfile btn btn-primary')]"));
        for(int i=0;i<elementList.size();i++){
            sleep(2000);
            WebElement element = elementList.get(i);
            while (!element.isDisplayed()){
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
            }
            JavascriptExecutor js = (JavascriptExecutor) driver;
            if(i==0){
                js.executeScript("arguments[0].scrollIntoView();", element);
              //  js.executeScript("window.scrollBy(0,-2800)");
            }

            js.executeScript("arguments[0].scrollIntoView();", element);
            element.click();
            js.executeScript("window.scrollBy(0,700)");

            sleep(1000);


        }
        logger.info("Show data buttons clicked");
    }


    @Test(priority = 6)
    public void performAnalysisButton() throws InterruptedException {
        WebElement ele = driver.findElement(By.xpath("//button[@class='btnstart performbtn btn btn-primary btn-lg']"));
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].click()", ele);

        sleep(2000);

        driver.findElement(By.xpath("//input[@value='1']")).click();
        driver.findElement(By.xpath("//input[@value='2']")).click();
        driver.findElement(By.xpath("//a[@href='/analysis']")).click();
        logger.info("perform analysis button clicked ");
    }

    @Test(priority = 7)
    public void search() throws InterruptedException {
        sleep(2000);
     //   driver.findElement(By.xpath("//input[@placeholder='Search..']")).sendKeys("Data");
     //   sleep(1000);
        driver.findElement(By.className("accordion-item")).click();
        sleep(1000);
//        driver.findElement(By.xpath("//strong[contains(text(),'Data Engineering')]")).click();
//        driver.findElement(By.xpath("//a[contains(text(),'lchinnery7')]")).click();

        sleep(3000);
        driver.navigate().back();
        logger.info("dropdowns checked");

    }

   @Test(priority = 8)
    public void editTeamTrack() throws InterruptedException {
        sleep(3000);
       WebElement ele = driver.findElement(By.xpath("//button[@class='btnstart performbtn1 btn btn-primary btn-lg']"));
       JavascriptExecutor jse = (JavascriptExecutor) driver;
       jse.executeScript("arguments[0].click()", ele);

    }

    @Test(priority = 9)
    public void drag_and_drop() throws InterruptedException {
        List<WebElement> linkersList = driver.findElements(By.className("myname"));
        for (int i = 0; i < linkersList.size()-46; i++) {
            sleep(2000);
            WebElement drag = linkersList.get(i);
            WebElement drop=linkersList.get(i+29);

            Actions action=new Actions(driver);
            sleep(4000);
            action.dragAndDrop(drag,drop);


        }
        logger.info("drag and dropped");
    }

    public static void takeScreenshot() {

        try {
            File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            //The below method will save the screen shot in destination directory
            FileHandler.copy(scrFile, new File(System.getProperty("user.dir") + "/src/Screenshots/" + "sample" + i + ".png"));
            i++;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @AfterClass
    public void tearDown(){
        driver.quit();
    }

}
