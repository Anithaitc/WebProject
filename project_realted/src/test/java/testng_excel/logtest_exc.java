package testng_excel;

import java.io.File;
import java.io.FileInputStream;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
/*import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellValue;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;*/

public class logtest_exc {
	WebDriver driver;
	WebDriverWait wait;
	HSSFWorkbook workbook;
	HSSFSheet sheet;
	XSSFCell cell;

	@BeforeClass
	public void beforeClass() {
		System.out.println("Before Class");
	}

	@BeforeMethod
	public void beforeMethod() throws Exception {
		String path1 = "D:\\chromedriver_win32\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", path1);
		driver = new ChromeDriver();
		driver.get("file:///D:/WebProject-main/WebProject-main/project/login.html");
	}

	@Test
	public void login() throws Exception {
		File src = new File("D:\\WebProject-main\\WebProject-main\\files\\excel_proj\\login.xlsx");
		FileInputStream fis = new FileInputStream(src);
		@SuppressWarnings("resource")
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet1 = wb.getSheetAt(0);
		System.out.println("login to Bike gallery");
		Thread.sleep(2000);
		XSSFCell cell = sheet1.getRow(1).getCell(0);
		driver.findElement(By.id("username")).sendKeys(cell.getStringCellValue());
		Thread.sleep(1000);
		XSSFCell cell1 = sheet1.getRow(1).getCell(1);
		driver.findElement(By.id("password")).sendKeys(cell1.getStringCellValue());
		Thread.sleep(1000);
		driver.findElement(By.id("sub")).click();
		Thread.sleep(2000);
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}

	@AfterMethod
	public void afterMethod() {
		// driver.close();
	}

	@AfterClass
	public void afterClass() {
		System.out.println("After Class");
	}
}
