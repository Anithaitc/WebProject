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
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
/*import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.Test;*/

public class regtest {
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
	public void reg() throws InterruptedException {
		String path1 = "D:\\chromedriver_win32\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", path1);
		WebDriver driver = new ChromeDriver();
		driver.get("D:/WebProject-main/WebProject-main/project/register.html");
		Thread.sleep(2000);
		driver.findElement(By.id("name")).sendKeys("Anitha Poluru");
		Thread.sleep(1000);
		driver.findElement(By.id("username")).sendKeys("anithaITC");
		Thread.sleep(1000);
		driver.findElement(By.id("mail")).sendKeys("anitha@gmail.com");
		Thread.sleep(1000);
		driver.findElement(By.id("phone")).sendKeys("9876543210");
		Thread.sleep(1000);
		driver.findElement(By.id("pass")).sendKeys("Ani@123");
		Thread.sleep(1000);
		driver.findElement(By.id("conpass")).sendKeys("Ani@123");
		Thread.sleep(1000);
		WebElement radioboxSelect = driver.findElement(By.id("girl"));
		Boolean isSelect = radioboxSelect.isSelected();
		if (isSelect == false) {
			radioboxSelect.click();
		}
		driver.findElement(By.id("sub")).click();
		Thread.sleep(2000);
		driver.switchTo().alert().accept();
		// driver.close();
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
