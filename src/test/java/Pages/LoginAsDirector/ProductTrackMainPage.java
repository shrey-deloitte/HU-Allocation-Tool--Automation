package Pages.LoginAsDirector;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class ProductTrackMainPage {

    static WebDriver driver;
    //Xpaths
    By productTrack =By.xpath("//div[@id='rc-tabs-0-tab-2']");
    String productTrackString="//div[@id='rc-tabs-0-tab-2']";
    By upoloadTypes = By.xpath("//div[contains(@class, 'uploader')]");
    By downloadSampleLink= By.xpath("//div[contains(@class, 'uploader')]/child::div[1]");

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
    public void verifyDownloadSampleLink(){
        List<WebElement> sampleLinks= driver.findElements(downloadSampleLink);
        System.out.println(sampleLinks.size());
    }
}
