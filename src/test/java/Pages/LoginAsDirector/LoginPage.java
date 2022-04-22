package Pages.LoginAsDirector;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class LoginPage {

    static WebDriver driver;
    //xpaths of login function
    By LoginAvatarIcon= By.xpath("//div[@class='loginicon bellicon']");

    //variables
    String loginUsername;
    String loginPassword;

    //constructor
    public LoginPage(WebDriver driver){
        this.driver=driver;
    }

    public void ClickOnLoginIcon(){
        WebElement LoginIconElement= driver.findElement(LoginAvatarIcon);
        LoginIconElement.click();

    }
    public void readLoginDetails() throws IOException {
        System.out.println("inside readLoginDetails function");
        String excelFilePath="C:\\Users\\shubhamkumar32\\Desktop\\Product_week_LoginDetails.xlsx";
        FileInputStream fis=new FileInputStream(excelFilePath);
        XSSFWorkbook workbook=new XSSFWorkbook(fis);
        XSSFSheet sheet =workbook.getSheetAt(0);
        XSSFRow row =null;
        XSSFCell cell =null;

        //iterating over the row and column
        for(int i=1;i<sheet.getLastRowNum();i++){
            System.out.println("inside readLoginDetails function for loop");
            row = sheet.getRow(i);
            for( int j=0;j<row.getLastCellNum();j++){
                cell =row.getCell(j);

                if(j==0){
                    loginUsername=cell.getStringCellValue();
                }
                if(j==1){
                    loginPassword=cell.getStringCellValue();
                }


            }
        }

        System.out.println("usernamw is "+loginUsername);
        System.out.println("password is "+loginPassword);

    }
}
