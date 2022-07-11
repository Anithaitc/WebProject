package dpproject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
/*import org.testng.annotations.AfterMethod;
import org.openqa.selenium.WebElement;
import com.google.common.base.Function;
import dpproject.uticodedataprovider;*/

public class Contact {
	private WebDriver driver;
	private uticodedataprovider utility;

	@DataProvider
	public Object[][] getTestData() throws Exception {
		utility = new uticodedataprovider();

		int totalRows = utility.getRowCount("D:\\WebProject-main\\WebProject-main\\files\\excel_proj\\cont.xlsx",
				"cont");
		int totalColumns = utility.getColumnCount("D:\\WebProject-main\\WebProject-main\\files\\excel_proj\\cont.xlsx",
				"cont");
		System.out.println("=> Total rows and columns is/are (" + totalRows + ", " + totalColumns + ")");

		Object[][] data = new Object[totalRows][totalColumns];
		for (int i = 0; i < totalRows; i++) {
			for (int j = 0; j < totalColumns; j++) {
				data[i][j] = new uticodedataprovider()
						.getData("D:\\WebProject-main\\WebProject-main\\files\\excel_proj\\cont.xlsx", "cont", i, j);
			}
		}
		return data;
	}

	@BeforeMethod()
	public void setup() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver_win32\\chromedriver.exe");
		this.driver = new ChromeDriver();

		driver.get("file:///D:/WebProject-main/WebProject-main/project/contact.html");
		Thread.sleep(2000);

	}

	@Test(dataProvider = "getTestData")
	public void test(String FirstName, String LastName, String Email,String Phno, String Message)
			throws InterruptedException {
		driver.findElement(By.id("fname")).sendKeys(FirstName);
		driver.findElement(By.id("lname")).sendKeys(LastName);
		Thread.sleep(1000);
		driver.findElement(By.id("email")).sendKeys(Email);
		driver.findElement(By.id("mobile")).sendKeys(Phno);
		Thread.sleep(1000);
		driver.findElement(By.id("meg")).sendKeys(Message);
		Thread.sleep(1000);
		driver.findElement(By.id("sub")).click();
		Thread.sleep(2000);
		//driver.switchTo().alert().accept();
		//driver.close();
	}
	@AfterMethod()
	public void contaus() {
		driver.quit();
	}
}
