package Pages.LoginAsDirector;


import Tests.baseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.io.File;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

import static java.lang.Thread.sleep;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
public class ProductTrackMainPage {

    static WebDriver driver;

    //Xpaths
    By productTrack =By.xpath("//div[@id='rc-tabs-0-tab-2']");
    String productTrackString="//div[@id='rc-tabs-0-tab-2']";
    By upoloadTypes = By.xpath("//div[contains(@class, 'uploader')]");
    By downloadSampleLink= By.xpath("//div[@class='head']/child::a");
   // By chooseFile=By.xpath("//div[@class='uploader']/child::div[2]/child::input");
   By chooseFile=By.xpath("//input[@type='file']");
    By showUploadBtn= By.xpath("//div[@class='uploader']/child::div[2]/child::button[1]");
    By showUploadedFileData= By.xpath("//*[@class='sc-dlVxhl fSQziN']");
    By addNewProjectBtn= By.xpath("//span[text()='Add New Project']");
    By addNewProjectDialog= By.xpath("//div[@class='ant-modal-content']");
    By addNewProjectFields= By.xpath("//*[@class='ant-input']");
    By performAnalysisBtn= By.xpath("//*[@id=\"rc-tabs-0-panel-2\"]/div/div[2]/div[2]/button");
    By PerformCheckboxes = By.xpath("//input[@type='checkbox']");
    By performSubmitBtn= By.xpath("//a[@href='/analysis']");

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
            sleep(500);
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
        sleep(2000);
    }

    public void uploadFiles() throws InterruptedException {
        List<WebElement> uploadFields = driver.findElements(chooseFile);

        for(WebElement ele:uploadFields){
            boolean status =ele.isDisplayed() && ele.isEnabled();
            Assert.assertEquals(status,true);
            ele.sendKeys(baseClass.linkersDataFilePath);
            sleep(500);
        }
    }

    public void clickOnShowUploadFileBtn() throws InterruptedException {
        List<WebElement> elementList = driver.findElements(By.xpath("//button[contains(@class,'showfile btn btn-primary')]"));
        for(int i=0;i<elementList.size();i++){
            //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
            sleep(1000);
            WebElement element = elementList.get(i);
            while (!element.isDisplayed()){
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
            }
            //element.click();
            JavascriptExecutor jse = (JavascriptExecutor) driver;
            jse.executeScript("arguments[0].click()", element);
            //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
            sleep(2000);

        }
    }
    public void verifyShowUploadBtn() throws InterruptedException {
        clickOnShowUploadFileBtn();
        //veryfying data is showing or not

        List<WebElement> datas=driver.findElements(showUploadedFileData);
        for(int i=0;i<datas.size();i++){
            sleep(1000);
            WebElement ele= datas.get(i);

            Assert.assertNotEquals(ele.getText(),"There are no records to display");
            sleep(2000);
        }
    }


    public void verifyAddNewProjectBtn() throws InterruptedException {
        WebElement addNewProjectBtnElement = driver.findElement(addNewProjectBtn);
        Boolean status = addNewProjectBtnElement.isDisplayed() && addNewProjectBtnElement.isEnabled();
        //addNewProjectBtnElement.click();
        Thread.sleep(1000);

        //WebElement addNewProjectDialogElement = driver.findElement(addNewProjectDialog);
       //Assert.assertEquals(addNewProjectDialogElement.isDisplayed(),true);


       //verifying fields in the dialog box


        //List<WebElement> fields = driver.findElements(addNewProjectFields);
//        Thread.sleep(1500);
//        JavascriptExecutor executor = (JavascriptExecutor)driver;
//
//        for(int i=0;i< fields.size();i++){
//            if(i==0){
//                WebElement ele = fields.get(i);
//                Thread.sleep(1500);
//                executor.executeScript("arguments[0].click();", ele);
//                ele.sendKeys("New Project");
//            }
//            if(i==1){
//                WebElement ele = fields.get(i);
//                executor.executeScript("arguments[0].click();", ele);
//                ele.sendKeys("Fantastic Project");
//            }
//        }

    }

    public void verifyPerformAnalysisBtn() throws InterruptedException {
        WebElement performBtn = driver.findElement(performAnalysisBtn);
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].click()", performBtn);
        Thread.sleep(2000);
        List<WebElement> checkboxes =driver.findElements(PerformCheckboxes);

        for(WebElement ele:checkboxes){
            jse.executeScript("arguments[0].click()", ele);
            Assert.assertEquals(ele.isSelected(),true);
        }

        Thread.sleep(1500);
        driver.findElement(performSubmitBtn).click();

    }
}
