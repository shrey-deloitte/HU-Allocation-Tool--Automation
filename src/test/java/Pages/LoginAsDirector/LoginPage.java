package Pages.LoginAsDirector;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class LoginPage {

    static WebDriver driver;

    //xpaths of login function
    By LoginAvatarIcon = By.xpath("//div[@class='loginicon bellicon']");
    By usernameLoginField = By.xpath("//input[@id='basic_username']");
    By passwordLoginField = By.xpath("//input[@id='basic_password']");
    String LoginAvatarIconString = "//div[@class='loginicon bellicon']";
    String usernameLoginFieldString = "//input[@id='basic_username']";
    String passwordLoginFieldString = "//input[@id='basic_password']";

    //variables
    String loginUsername;
    String loginPassword;

    //constructor
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void ClickOnLoginIcon() {
        WebElement LoginIconElement = driver.findElement(LoginAvatarIcon);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(LoginAvatarIconString)));
        LoginIconElement.click();

    }

    public void readLoginDetails() throws IOException {
        System.out.println("inside readLoginDetails function");
        String excelFilePath = "C:\\Users\\shubhamkumar32\\Desktop\\Product_week_LoginDetails.xlsx";
        FileInputStream fis = new FileInputStream(excelFilePath);
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet sheet = workbook.getSheetAt(0);
        XSSFRow row = null;
        XSSFCell cell = null;

        //iterating over the row and column
        for (int i = 1; i < sheet.getLastRowNum(); i++) {
            System.out.println("inside readLoginDetails function for loop");
            row = sheet.getRow(i);
            for (int j = 0; j < row.getLastCellNum(); j++) {
                cell = row.getCell(j);

                if (j == 0) {
                    loginUsername = cell.getStringCellValue();
                }
                if (j == 1) {
                    loginPassword = cell.getStringCellValue();
                }


            }
        }

        System.out.println("usernamw is " + loginUsername);
        System.out.println("password is " + loginPassword);

    }

    public void inputFieldIsEnabledAndDisplayed() {
        WebElement usernameField = driver.findElement(usernameLoginField);
        WebElement passwordField = driver.findElement(passwordLoginField);
        boolean usernameFieldStatus = usernameField.isEnabled() && usernameField.isDisplayed();
        boolean passwordFieldStatus = passwordField.isEnabled() && passwordField.isDisplayed();
        Assert.assertEquals(usernameFieldStatus, true);
        Assert.assertEquals(passwordFieldStatus, true);

    }

    public void addLoginDetails() {

        inputFieldIsEnabledAndDisplayed();

        //webelements of login input field
        WebElement usernameInputFieldElement = driver.findElement(usernameLoginField);
        WebElement passwordInputFieldElement = driver.findElement(passwordLoginField);
        //entering details
        usernameInputFieldElement.sendKeys(loginUsername);
        passwordInputFieldElement.sendKeys(loginPassword);
    }

}
