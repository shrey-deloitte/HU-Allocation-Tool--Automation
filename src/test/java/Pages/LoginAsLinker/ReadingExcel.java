package Pages.LoginAsLinker;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;
import java.io.FileInputStream;
import java.io.IOException;
public class ReadingExcel {
    public static String Username;
    public static String Password;

    public  void readCells() throws IOException {
        String excelFilePath = "src\\test\\resources\\LinkersLogin.xlsx";
        FileInputStream input = new FileInputStream(excelFilePath);
        XSSFWorkbook wb = new XSSFWorkbook(input);
        XSSFSheet sheet = wb.getSheetAt(0);
        int rows = sheet.getLastRowNum();
        int cols = sheet.getRow(1).getLastCellNum();
        for (int i = 1; i <= rows; i++) {
            XSSFRow row = sheet.getRow(i);
            for (int j = 0; j < cols; j++) {
                XSSFCell cell = row.getCell(j);
                if (j == 0) {
                    Username = cell.getStringCellValue();
                }
                if (j == 1) {
                    Password = cell.getStringCellValue();
                }
            }
        }
        System.out.println(Username + " " + Password);
    }
    public static String getUsername(){
        return Username;
    }
    public static String getPassword(){
        return Password;
    }
}
