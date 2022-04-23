package Pages.LoginAsDirector;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import java.time.Duration;
import java.io.File;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
public class ProductTrackMainPage {

    static WebDriver driver;

    //Xpaths
    By productTrack =By.xpath("//div[@id='rc-tabs-0-tab-2']");
    String productTrackString="//div[@id='rc-tabs-0-tab-2']";
    By upoloadTypes = By.xpath("//div[contains(@class, 'uploader')]");
    By downloadSampleLink= By.xpath("//div[@class='head']/child::a");
    By chooseFile=By.xpath("//div[@class='uploader']/child::div[2]/child::input");
    By showUploadBtn= By.xpath("//div[@class='uploader']/child::div[2]/child::button[1]");

    //constructor
    public ProductTrackMainPage(WebDriver driver) {
        this.driver = driver;
    }

    public void verifyNumberOfUploadTypes(){
        WebElement productTrackELement = driver.findElement(productTrack);
        productTrackELement.click();
        List<WebElement> numberOfUploadTypes =driver.findElements(upoloadTypes);
        Assert.assertEquals(numberOfUploadTypes.size(),5);
    }
    public void verifyFilesDownloadedOrNot() throws InterruptedException {
        List<WebElement> sampleLinks = driver.findElements(downloadSampleLink);
        ArrayList<String> targets=new ArrayList<String>();

        for(WebElement link:sampleLinks){
            targets.add(link.getAttribute("href"));
        }
        for(String target:targets){
            driver.navigate().to(target);
            Thread.sleep(500);
        }
        ArrayList<String> filenames= new ArrayList<>();
        filenames.add("linkerdata (1).csv");
        filenames.add("trackresults (2).csv");
        filenames.add("productdetail (1).csv");
        filenames.add("sectionlead (1).csv");
        filenames.add("productpref (1).csv");

        File location = new File("C:\\Users\\shubhamkumar32\\Downloads");
        File [] totalFiles = location.listFiles();

        for(File file:totalFiles){
            if(filenames.contains(file.getName())){
                Assert.assertTrue(true);
            }
        }
        Thread.sleep(2000);
    }

    public void uploadFiles() throws InterruptedException {
        List<WebElement> uploadFields = driver.findElements(chooseFile);

        for(WebElement ele:uploadFields){
            boolean status =ele.isDisplayed() && ele.isEnabled();
            Assert.assertEquals(status,true);
            ele.sendKeys("C:\\Users\\shubhamkumar32\\Downloads\\linkerdata (1).csv");

            Thread.sleep(500);
        }
    }

    public void verifyShowUploadBtn(){
        List<WebElement> showUploadBtns = driver.findElements(showUploadBtn);

        for(WebElement ele:showUploadBtns){
            boolean status= ele.isDisplayed() && ele.isEnabled();
            ele.click();
        }
    }


}
