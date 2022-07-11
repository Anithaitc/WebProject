package testng_codesofbike_gal;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
/*import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.Test;*/

public class bkngtest {
	@BeforeClass
	public void beforeClass() {
		System.out.println("Execution starts");
	}

	WebDriver driver;

	@BeforeMethod
	public void beforeMethod() {
		String path1 = "D:\\chromedriver_win32\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", path1);
	}

	@Test
	public void booking() throws InterruptedException {
		String path1 = "D:\\chromedriver_win32\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", path1);
		WebDriver driver = new ChromeDriver();
		driver.get("D:/WebProject-main/WebProject-main/project/booking.html");
		driver.findElement(By.id("Fname")).sendKeys("Anitha");
		Thread.sleep(1000);
		driver.findElement(By.id("Lname")).sendKeys("Poluru");
		Thread.sleep(1000);
		driver.findElement(By.id("Address")).sendKeys("Srikakulam");
		Thread.sleep(1000);
		driver.findElement(By.id("mail")).sendKeys("anitha@gmail.com");
		Thread.sleep(1000);
		driver.findElement(By.id("Phno")).sendKeys("9876543210");
		Thread.sleep(1000);
		WebElement DOB = driver.findElement(By.xpath("//input[@id=\"DOB\"]"));
		DOB.sendKeys("17082001");
		Thread.sleep(1000);
		Select se = new Select(driver.findElement(By.xpath("//*[@id='option']")));
		se.selectByIndex(2);
		Thread.sleep(2000);
		WebElement checkboxSelect = driver.findElement(By.id("V1"));
		Boolean isSelect = checkboxSelect.isSelected();
		if (isSelect == false) {
			checkboxSelect.click();
		}
		driver.findElement(By.id("Min")).sendKeys("100000");
		Thread.sleep(1000);
		driver.findElement(By.id("Max")).sendKeys("500000");
		Thread.sleep(1000);
		driver.findElement(By.id("submit")).click();
		driver.findElement(By.id("alert")).click();
		driver.switchTo().alert().accept();
		Thread.sleep(1000);
	}

	@AfterMethod
	public void afterMethod() {
		// driver.close();
	}

	@AfterClass
	public void afterClass() {
		System.out.println("Execution completed");
	}

	@DataProvider
	public Object[][] dp() {
		return new Object[][] { new Object[] { 1, "a" }, new Object[] { 2, "b" }, };
	}

	@BeforeTest
	public void beforeTest() {
		System.out.println("Test with valid data");
	}

	@AfterTest
	public void afterTest() {
		System.out.println("After test");
	}

	@BeforeSuite
	public void beforeSuite() {
		System.out.println("Before suite");
	}

	@AfterSuite
	public void afterSuite() {
		System.out.println("After suite");
	}
}
