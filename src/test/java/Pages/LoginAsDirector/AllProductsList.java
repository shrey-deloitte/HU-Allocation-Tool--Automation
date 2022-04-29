package Pages.LoginAsDirector;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

import static java.lang.Thread.sleep;

public class AllProductsList {

    static WebDriver driver;

    //Xpaths
    By searchBox = By.xpath("//input[@type='text']");
    By prodctsList = By.xpath("//button[@class='accordion-button collapsed']");
    By editProductLeadBtn = By.xpath("//div[@class='header-div']/child::button[1]");
    By EditProductTeamBtn = By.xpath("//button[@class='btnstart performbtn1 btn btn-primary btn-lg'][2]");
    String EditProductTeamBtnString ="//button[@class='btnstart performbtn1 btn btn-primary btn-lg'][2]";
    By leftDropBtn = By.xpath("//*[@id=\"root\"]/div/div[2]/div[1]/div[1]/div/div/div/button[2]");
   By leftdropDownDiv = By.xpath("//div[@role='presentation']");
   String leftdropDownDivString = "//div[@role='presentation']";
   By rightDropBtn = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[1]/div/div/div/button[2]");
   By pieChart= By.xpath("//div[@class='bar-div']/child::canvas");
   String pieChartString = "//div[@class='bar-div']/child::canvas";
   By addNotifBtn= By.xpath("//div[@class='right']/button");
   By addNotifDialogBox=By.xpath("//div[@class='ant-modal-content']");
   String addNotifDialogBoxString ="//div[@class='ant-modal-content']";
   By message= By.xpath("//textarea[@id='outlined-multiline-static']");
   By radioBoxes = By.xpath("//input[@type='radio' ][@class='ant-radio-input']");
   By receiver= By.xpath("//input[@id='validate_other_receiver']");
   By linkersList =By.xpath("//div[@class='ant-select-item ant-select-item-option']");

   By sendBtn =By.xpath("//button[@type='submit']");

    public AllProductsList(WebDriver driver) {
        this.driver=driver;
    }


    public void verifySearchBox(){
        WebElement searchBoxElement = driver.findElement(searchBox);
        searchBoxElement.click();
        searchBoxElement.sendKeys("dwd");
    }

    public void countOfAllProducts() throws InterruptedException {
        //Thread.sleep(3000);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='accordion-button collapsed']")));
        List<WebElement> productsListElement = driver.findElements(prodctsList);
       // Assert.assertEquals(productsListElement.size(),67);
    }
    public void verifyProductLeadBtn() throws InterruptedException {
        WebElement productLeadBtnElement = driver.findElement(editProductLeadBtn);
        productLeadBtnElement.click();
        sleep(3000);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='maincontent']")));
        Actions builder = new Actions(driver);
        WebElement leftdrag= driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div[1]/div[2]/div/div/div[1]/div[2]/div"));
        WebElement dest= driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[2]/div/div/div[1]/div[2]/div"));
//Building a drag and drop action
        builder.dragAndDrop(leftdrag,dest).build().perform();

        driver.switchTo().defaultContent();

        driver.navigate().back();
    }
    public void verifyEditProductTeam() throws InterruptedException {
        WebElement edtProductTeamBtnElement = driver.findElement(EditProductTeamBtn);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(EditProductTeamBtnString)));
        edtProductTeamBtnElement.click();
        WebElement leftbtnElement = driver.findElement(leftDropBtn);
        leftbtnElement.click();

        WebElement div = driver.findElement(leftdropDownDiv);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(leftdropDownDivString)));
        Assert.assertEquals(div.isDisplayed(),true);

        WebElement rightBtnElement = driver.findElement(rightDropBtn);
        rightBtnElement.click();

        driver.navigate().back();
        new WebDriverWait(driver, Duration.ofSeconds(20)).until(
                webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
    }
    public void verifyPieChart() throws InterruptedException {

       WebElement chartElement = driver.findElement(pieChart);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(pieChartString)));
        //sleep(40000);
        //Creating object of an Actions class
        Actions action = new Actions(driver);

//Performing the mouse hover action on the target element.
        action.moveToElement(chartElement).perform();
        String title = chartElement.getAttribute("Title");
        System.out.println(title);

    }
    public void verifyAddNotif(){
        WebElement addNotifBtnElement = driver.findElement(addNotifBtn);
        addNotifBtnElement.click();
        WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(addNotifDialogBoxString)));

        WebElement messageElement= driver.findElement(message);
        Boolean messagestatus = messageElement.isDisplayed() && messageElement.isEnabled();
        messageElement.sendKeys("Hello");

        List<WebElement> radios = driver.findElements(radioBoxes);

        for(WebElement ele:radios){
            ele.click();

            Assert.assertEquals(ele.isSelected(),true);
        }
        WebElement receiverElement = driver.findElement(receiver);
        Assert.assertEquals(receiverElement.isDisplayed(),true);
        receiverElement.click();

        WebElement linkersListElement = driver.findElement(linkersList);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ant-select-item ant-select-item-option']")));
        Assert.assertEquals(linkersListElement.isDisplayed(),true);

      //driver.findElement(By.xpath("//div[@title='dfirpog']")).click();


       WebElement sendBtnElement = driver.findElement(sendBtn);
       //wait.until(ExpectedConditions.elementToBeClickable(sendBtnElement));
        sendBtnElement.submit();

        driver.findElement(By.xpath("//span[@class='ant-modal-close-x']")).click();

    }
}
