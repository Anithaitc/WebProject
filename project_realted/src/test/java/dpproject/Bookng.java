package dpproject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.openqa.selenium.WebElement;
/*import org.testng.annotations.AfterMethod;

import com.google.common.base.Function;
import dpproject.uticodedataprovider;*/

public class Bookng {
	private WebDriver driver;
	private uticodedataprovider utility;

	@DataProvider
	public Object[][] getTestData() throws Exception {
		utility = new uticodedataprovider();

		int totalRows = utility.getRowCount("D:\\WebProject-main\\WebProject-main\\files\\excel_proj\\bkng.xlsx",
				"Bookng");
		int totalColumns = utility.getColumnCount("D:\\WebProject-main\\WebProject-main\\files\\excel_proj\\bkng.xlsx",
				"Bookng");
		System.out.println("=> Total rows and columns is/are (" + totalRows + ", " + totalColumns + ")");

		Object[][] data = new Object[totalRows][totalColumns];
		for (int i = 0; i < totalRows; i++) {
			for (int j = 0; j < totalColumns; j++) {
				data[i][j] = new uticodedataprovider()
						.getData("D:\\WebProject-main\\WebProject-main\\files\\excel_proj\\bkng.xlsx", "Bookng", i, j);
			}
		}
		return data;
	}

	@BeforeMethod()
	public void setup() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver_win32\\chromedriver.exe");
		this.driver = new ChromeDriver();

		driver.get("file:///D:/WebProject-main/WebProject-main/project/booking.html");
		Thread.sleep(2000);

	}

	@Test(dataProvider = "getTestData")
	public void test(String FirstName, String LastName, String Address, String Email, String PhNum,String dob, String Minm,
			String Maxm) throws InterruptedException {
		driver.findElement(By.id("Fname")).sendKeys(FirstName);
		Thread.sleep(1000);
		driver.findElement(By.id("Lname")).sendKeys(LastName);
		Thread.sleep(1000);
		driver.findElement(By.id("Address")).sendKeys(Address);
		Thread.sleep(1000);
		driver.findElement(By.id("mail")).sendKeys(Email);
		Thread.sleep(1000);
		driver.findElement(By.id("Phno")).sendKeys(PhNum);
		Thread.sleep(1000);
		driver.findElement(By.id("DOB")).sendKeys(dob);
		Thread.sleep(1000);
		
		/*WebElement DOB = driver.findElement(By.xpath("//input[@id=\"DOB\"]"));
		DOB.sendKeys("17082001");
		Thread.sleep(1000);*/
		Select se = new Select(driver.findElement(By.xpath("//*[@id='option']")));
		se.selectByIndex(2);
		Thread.sleep(2000);
		WebElement checkboxSelect = driver.findElement(By.id("V1"));
		Boolean isSelect = checkboxSelect.isSelected();
		if (isSelect == false) {
			checkboxSelect.click();
		}
		driver.findElement(By.id("Min")).sendKeys(Minm);
		Thread.sleep(1000);
		driver.findElement(By.id("Max")).sendKeys(Maxm);
		Thread.sleep(1000);
		driver.findElement(By.id("submit")).click();
		Thread.sleep(1000);
		//driver.findElement(By.id("alert")).click();
		driver.switchTo().alert().accept();
		Thread.sleep(1000);
		//driver.close();
	}
	@AfterMethod()
	public void booki() {
		driver.quit();
	}

}
