package Tests;
import Pages.HomePage.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Test_Homepage {

    WebDriver driver;
    HomePage home;
    String title_to_check = "HU ALLOCATION TOOL";
    String url = "https://automatedhuallocation-ui-urtjok3rza-wl.a.run.app/";

    //Initializing web driver
    @BeforeTest
    public void setup() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\suhasm\\Downloads\\selenium\\selenium 4.1.2\\chromedriver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(url);
        driver.manage().window().maximize();
        Thread.sleep(1000);
    }

    //Checking Title
    @Test(priority = 1)
    public void Check_Title() throws InterruptedException {
        home = new HomePage(this.driver);
        String Title = home.title();
        Thread.sleep(2000);
        if (Title == title_to_check) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }
    }

    //Checking Carousel
    @Test(priority = 2)
    public void Carousel() throws InterruptedException {
        home = new HomePage(driver);
        home.carousel();
        Thread.sleep(1000);
    }

    //Checking 'Get Started Button
    @Test(priority = 3)
    public void GetStarted_Btn() throws InterruptedException {
        home = new HomePage(driver);
        home.GetStarted_btn();
        Thread.sleep(2000);
    }

    //


    @AfterTest
    public void Close_Browser() {
        driver.close();
    }


}


        /*@Test
        public void main() throws InterruptedException {

    System.setProperty("webdriver.chrome.driver","C:\\Users\\suhasm\\Downloads\\selenium\\selenium 4.1.2\\chromedriver\\chromedriver.exe");
    WebDriver driver = new ChromeDriver();
    driver.get("https://automatedhuallocation-ui-urtjok3rza-wl.a.run.app/");
    driver.manage().window().maximize();

    Thread.sleep(2000);
    driver.findElement(By.xpath("//span[@class=\"carousel-control-prev-icon\"]")).click();
    Thread.sleep(2000);
    driver.findElement(By.xpath("//span[@class=\"carousel-control-next-icon\"]")).click();
    Thread.sleep(2000);
    driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[3]/div[1]/div[2]/button")).click();
 // driver.findElement(By.xpath("//button[@class='btnstart btn btn-primary btn-lg']")).click();
    Thread.sleep(2000);
    driver.findElement(By.xpath("//button[@class=\"ant-btn ant-btn-default\"]")).click();
    Thread.sleep(2000);*/

            //driver.close();
