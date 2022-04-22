package Pages.LoginAsDirector;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.Duration;
import java.util.List;


import static java.lang.Thread.sleep;

public class ParallelTrack {
    static WebDriver driver;


    @BeforeTest
    public  void launch() throws IOException, InterruptedException {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\shredeshpande\\Downloads\\chromedriver.exe");
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
    }

    @Test(priority = 1)
    public void OpenParallelTrack() throws InterruptedException {
        driver.findElement(By.xpath("//div[contains(text(),'Parallel Track')]")).click();
        sleep(3000);
    }

    @Test(priority = 2)
    public void downloadSample(){
        driver.findElement(By.xpath("//a[@download='linkerdata.csv']")).click();
    }

    @Test(priority = 3)
    public  void  chooseFile(){

        List<WebElement> elementList = driver.findElements(By.xpath("//input[@type='file']"));

        for (int i = 0;i<elementList.size();i++){
            WebElement element = elementList.get(i);

            if(i==0){
                element.sendKeys("C:\\Users\\shredeshpande\\Documents\\HU_ProductWeek\\linkerdata.csv");
            }
            if(i==1){
                element.sendKeys("C:\\Users\\shredeshpande\\Documents\\HU_ProductWeek\\trackresults.csv");
            }
            if(i==2){
                element.sendKeys("C:\\Users\\shredeshpande\\Documents\\HU_ProductWeek\\paralleltrack.csv");
            }
            if(i==3){
                element.sendKeys("C:\\Users\\shredeshpande\\Documents\\HU_ProductWeek\\sectionlead.csv");
            }
            if(i==4){
                element.sendKeys("C:\\Users\\shredeshpande\\Documents\\HU_ProductWeek\\parallelpref.csv");
            }
        }
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
            element.click();
            sleep(3000);

        }
    }

    @Test(priority = 5)
    public void dropdownFunctionality(){
        Select dropdown = new Select(driver.findElement(By.xpath("//span[contains(text(),'Rows per page:')]")));
        dropdown.selectByVisibleText("15");

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
    }

    @Test(priority = 7)
    public void search() throws InterruptedException {
        sleep(2000);
     //   driver.findElement(By.xpath("//input[@placeholder='Search..']")).sendKeys("Data");
     //   sleep(1000);
        driver.findElement(By.className("accordion-item")).click();
        sleep(1000);
        driver.findElement(By.xpath("//a[contains(text(),'dgeroldik')]")).click();
        sleep(3000);
        driver.navigate().back();
    }

    @Test(priority = 8)
    public void editTeamTrack(){
        WebElement ele = driver.findElement(By.xpath("//button[@class='btnstart performbtn1 btn btn-primary btn-lg']"));
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].click()", ele);

    }

}
