package Pages.HomePage;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {

    //Initializing web driver
    static WebDriver driver;
    WebElement ele = driver.findElement(By.xpath("//button[@class='btnstart performbtn btn btn-primary btn-lg']"));
    By Get_started_btn = By.xpath("//*[@id=\"root\"]/div/div[3]/div[1]/div[2]/button");
    By cancel = By.xpath("/html/body/div/div/div[1]/button[1]");
    By left = By.xpath("//span[@class=\"carousel-control-prev-icon\"]");
    By right = By.xpath("//span[@class=\"carousel-control-next-icon\"]");
    String url = "https://automatedhuallocation-ui-urtjok3rza-wl.a.run.app/";


    //Home Page
    public HomePage(WebDriver driver){
        this.driver = driver;
    }

    //Open Page
    public void open_page() throws InterruptedException {
        driver.manage().window().maximize();
        driver.get(url);
        Thread.sleep(1000);
    }

    public String title() throws InterruptedException{
       return driver.getTitle();
    }
    public void carousel() throws InterruptedException {
        driver.findElement(left).click();
        Thread.sleep(2000);

        driver.findElement(right).click();
        Thread.sleep(2000);
    }

    public void GetStarted_btn() throws InterruptedException {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].click()", ele);
        driver.findElement(cancel).click();
        Thread.sleep(2000);
    }

    public void Team_members_info(){

    }
}
