package Pages.LoginAsLinker;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class LinkersLogin {
    static WebDriver driver;
    static ReadingExcel readingExcel= new ReadingExcel();

    public LinkersLogin(WebDriver driver) throws IOException {
        this.driver = driver;
        readingExcel.readCells();
    }
    static String UsernamePath = "//*[@id=\"basic_username\"]";
    static String PasswordPath = "//*[@id=\"basic_password\"]";
    static String Submit = "//*[@id=\"basic\"]/div[3]/div/div/div/button";
    public static void Login() throws InterruptedException{
        String username = ReadingExcel.getUsername();
      driver.findElement(By.xpath(UsernamePath)).sendKeys(username);
       String password = ReadingExcel.getPassword();
        driver.findElement(By.xpath(PasswordPath)).sendKeys(password);
        driver.findElement(By.xpath(Submit)).click();
    }
    }
