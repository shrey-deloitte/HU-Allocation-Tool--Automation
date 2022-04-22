//package Pages.LoginAsLinker;
//import org.apache.poi.xssf.usermodel.XSSFRow;
//import org.apache.poi.xssf.usermodel.XSSFSheet;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//import org.testng.annotations.Test;
//
//import java.io.FileInputStream;
//import java.io.IOException;
//
//
//
//public class ReadingExcel {
//    public String Username;
//    public String Password;
//
//    @Test
//    public void readCells() throws IOException {
//        String excelFilePath = "src\\test\\resources\\LinkersLogin.xlsx";
//        FileInputStream input = new FileInputStream(excelFilePath);
//        XSSFWorkbook wb = new XSSFWorkbook(input);
//        XSSFSheet sheet = wb.getSheetAt(0);
//        int rows = sheet.getLastRowNum();
//        int cols = sheet.getRow(1).getLastCellNum();
//        for (int i = 1; i <= rows; i++) {
//            XSSFRow row = sheet.getRow(i);
//            for (int j = 0; j < cols; j++) {
//                XSSFRow cell = sheet.getRow(j);
//                if (j == 0) {
//                    Username = row.getCell(0).getStringCellValue();
//                }
//                if (j == 1) {
//                    Password = String.valueOf(cell.getCell(j));
//                }
//            }
//        }
//        System.out.println(Username + " " + Password);
//    }
//}

//    public void User(String name, String email, String password, int age) {
//        this.Username = name;
//        this.Password = password;
//    }
//}
