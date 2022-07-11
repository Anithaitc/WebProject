package dataprovider;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;

public class loginexc {
	WebDriver driver;
	@BeforeMethod
	public void beforeMethod() {
		String path1="D:\\chromedriver_win32\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", path1);
		driver=new ChromeDriver();
		driver.get("D:\\WebProject-main\\WebProject-main\\project\\login.html");
		}
	@Test(dataProvider="getData1")
	public void test(String username, String password) {
		System.out.println("Automating for Login");
		driver.findElement(By.id("name")).sendKeys(username);
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.id("login")).click();
		}
@AfterMethod
public void afterMethod() {
	driver.quit();
	}
@DataProvider
public String[][] getData1() throws Exception{
	File src=new File("‪D:\\WebProject-main\\WebProject-main\\files\\excel_proj\\login.xlsx");
	FileInputStream fis=new FileInputStream(src);
	XSSFWorkbook wb=new XSSFWorkbook(fis);
	XSSFSheet sheet=wb.getSheet("login");
	int Rows=sheet.getPhysicalNumberOfRows();
	int cols=sheet.getRow(0).getLastCellNum();
	String[][] data=new String[Rows-1][cols];
	for(int i=0;i<Rows-1;i++)
	{
		for(int j=0;j<cols;j++){
			DataFormatter df=new DataFormatter();
			data[i][j]= df.formatCellValue(sheet.getRow(i+1).getCell(j));
			}
		System.out.println();
		}
	wb.close();
	fis.close();
	return data;
}

}
