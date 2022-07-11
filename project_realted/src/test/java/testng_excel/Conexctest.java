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
import org.testng.annotations.AfterClass;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
/*import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.hssf.usermodel.HSSFCell;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellValue;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;*/

public class Conexctest {
	WebDriver driver;
	WebDriverWait wait;
	HSSFWorkbook workbook;
	HSSFSheet sheet;
	XSSFCell cell;

	@Test
	public void contact() throws Exception {
		File src = new File("D:\\WebProject-main\\WebProject-main\\files\\excel_proj\\cont.xlsx");
		FileInputStream fis = new FileInputStream(src);
		@SuppressWarnings("resource")
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet1 = wb.getSheetAt(0);
		System.out.println("login to Bike gallery");
		XSSFCell cell = sheet1.getRow(1).getCell(0);
		driver.findElement(By.id("fname")).sendKeys(cell.getStringCellValue());
		XSSFCell cell1 = sheet1.getRow(1).getCell(1);
		Thread.sleep(1000);
		driver.findElement(By.id("lname")).sendKeys(cell1.getStringCellValue());
		XSSFCell cell2 = sheet1.getRow(1).getCell(2);
		Thread.sleep(1000);
		driver.findElement(By.id("email")).sendKeys(cell2.getStringCellValue());
		XSSFCell cell3 = sheet1.getRow(1).getCell(3);
		Thread.sleep(1000);
		driver.findElement(By.id("mobile")).sendKeys(String.valueOf(cell3));
		XSSFCell cell4 = sheet1.getRow(1).getCell(4);
		Thread.sleep(1000);
		driver.findElement(By.id("meg")).sendKeys(cell4.getStringCellValue());
		driver.findElement(By.id("sub")).click();
		Thread.sleep(2000);
		Alert alert = driver.switchTo().alert();
		Thread.sleep(1000);
		alert.accept();
	}

	@BeforeMethod
	public void beforeMethod() throws Exception {
		String path1 = "D:\\chromedriver_win32\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", path1);
		driver = new ChromeDriver();
		driver.get("file:///D:/WebProject-main/WebProject-main/project/contact.html");

	}

	@AfterMethod
	public void afterMethod() {
		// driver.close();
	}

	@BeforeClass
	public void beforeClass() {
		System.out.println("Before Class");
	}

	@AfterClass
	public void afterClass() {
		System.out.println("After Class");
	}

}
