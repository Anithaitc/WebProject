package testng_excel;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;

public class bokngtestexc {
	WebDriver driver;
	WebDriverWait wait;
	HSSFWorkbook workbook;
	HSSFSheet sheet;
	XSSFCell cell;

	@Test
	public void contact() throws Exception {
		File src = new File("D:\\WebProject-main\\WebProject-main\\files\\excel_proj\\bkng.xlsx");
		FileInputStream fis = new FileInputStream(src);
		@SuppressWarnings("resource")
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet1 = wb.getSheetAt(0);
		System.out.println("login to Bike gallery");
		XSSFCell cell = sheet1.getRow(1).getCell(0);
		driver.findElement(By.id("Fname")).sendKeys(cell.getStringCellValue());
		Thread.sleep(1000);
		XSSFCell cell1 = sheet1.getRow(1).getCell(1);
		driver.findElement(By.id("Lname")).sendKeys(cell1.getStringCellValue());
		Thread.sleep(1000);
		XSSFCell cell2 = sheet1.getRow(1).getCell(2);
		driver.findElement(By.id("Address")).sendKeys(cell2.getStringCellValue());
		Thread.sleep(1000);
		XSSFCell cell3 = sheet1.getRow(1).getCell(3);
		driver.findElement(By.id("mail")).sendKeys(String.valueOf(cell3));
		Thread.sleep(1000);
		XSSFCell cell4 = sheet1.getRow(1).getCell(4);
		driver.findElement(By.id("Phno")).sendKeys(String.valueOf(cell4));
		Thread.sleep(1000);

		WebElement DOB = driver.findElement(By.xpath("//input[@id=\'DOB\']"));
		DOB.sendKeys("17082001");
		Select se = new Select(driver.findElement(By.xpath("//*[@id='option']")));
		se.selectByIndex(2);
		Thread.sleep(2000);
		WebElement checkboxSelect = driver.findElement(By.id("V1"));
		Boolean isSelect = checkboxSelect.isSelected();
		if (isSelect == false) {
			checkboxSelect.click();
		}
		XSSFCell cell5 = sheet1.getRow(1).getCell(5);
		driver.findElement(By.id("Min")).sendKeys(String.valueOf(cell5));
		Thread.sleep(1000);
		XSSFCell cell6 = sheet1.getRow(1).getCell(6);
		driver.findElement(By.id("Max")).sendKeys(String.valueOf(cell6));
		Thread.sleep(1000);
		driver.findElement(By.id("submit")).click();
		Thread.sleep(2000);
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}

	@BeforeMethod
	public void beforeMethod() throws Exception {
		String path1 = "D:\\chromedriver_win32\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", path1);
		driver = new ChromeDriver();
		driver.get("file:///D:/WebProject-main/WebProject-main/project/booking.html");

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
