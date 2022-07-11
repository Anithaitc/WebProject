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
import dpproject.uticodedataprovider;
import org.openqa.selenium.NoSuchSessionException;*/

public class Login {
	private WebDriver driver;
	private uticodedataprovider utility;

	@DataProvider
	public Object[][] getTestData() throws Exception {
		utility = new uticodedataprovider();

		int totalRows = utility.getRowCount("D:\\WebProject-main\\WebProject-main\\files\\excel_proj\\login.xlsx",
				"login");
		int totalColumns = utility.getColumnCount("D:\\WebProject-main\\WebProject-main\\files\\excel_proj\\login.xlsx",
				"login");
		System.out.println("=> Total rows and columns is/are (" + totalRows + ", " + totalColumns + ")");

		Object[][] data = new Object[totalRows][totalColumns];
		for (int i = 0; i < totalRows; i++) {
			for (int j = 0; j < totalColumns; j++) {
				data[i][j] = new uticodedataprovider().getData("D:\\WebProject-main\\WebProject-main\\files\\excel_proj\\login.xlsx", "login", i, j);
			}
		}
		return data;
	}

	@BeforeMethod()
	public void setup() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver_win32\\chromedriver.exe");
		this.driver = new ChromeDriver();

		driver.get("file:///D:/WebProject-main/WebProject-main/project/login.html");
		Thread.sleep(2000);

	}

	@Test(dataProvider = "getTestData")
	public void test(String userName, String password) throws InterruptedException {
		driver.findElement(By.id("username")).sendKeys(userName);
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.id("sub")).click();
		Thread.sleep(2000);
		driver.switchTo().alert().accept();
		Thread.sleep(2000);
	}
	@AfterMethod()
	public void login() {
		driver.quit();
	}
}
