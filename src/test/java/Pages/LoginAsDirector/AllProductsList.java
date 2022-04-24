package Pages.LoginAsDirector;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

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
        Assert.assertEquals(productsListElement.size(),86);
    }
    public void verifyProductLeadBtn() throws InterruptedException {
        WebElement productLeadBtnElement = driver.findElement(editProductLeadBtn);
        productLeadBtnElement.click();
        Thread.sleep(3000);
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
    }
    public void verifyPieChart(){

    }
}
