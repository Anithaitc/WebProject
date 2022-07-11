package dpproject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.openqa.selenium.WebElement;
/*import org.testng.annotations.AfterMethod;

import com.google.common.base.Function;
import dpproject.uticodedataprovider;*/

public class Regis {
	private WebDriver driver;
	private uticodedataprovider utility;

	@DataProvider
	public Object[][] getTestData() throws Exception {
		utility = new uticodedataprovider();

		int totalRows = utility.getRowCount("D:\\WebProject-main\\WebProject-main\\files\\excel_proj\\reg.xlsx",
				"regs");
		int totalColumns = utility.getColumnCount("D:\\WebProject-main\\WebProject-main\\files\\excel_proj\\reg.xlsx",
				"regs");
		System.out.println("=> Total rows and columns is/are (" + totalRows + ", " + totalColumns + ")");

		Object[][] data = new Object[totalRows][totalColumns];
		for (int i = 0; i < totalRows; i++) {
			for (int j = 0; j < totalColumns; j++) {
				data[i][j] = new uticodedataprovider()
						.getData("D:\\WebProject-main\\WebProject-main\\files\\excel_proj\\reg.xlsx", "regs", i, j);
			}
		}
		return data;
	}

	@BeforeMethod()
	public void setup() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver_win32\\chromedriver.exe");
		this.driver = new ChromeDriver();

		driver.get("file:///D:/WebProject-main/WebProject-main/project/register.html");
		Thread.sleep(2000);

	}

	@Test(dataProvider = "getTestData")
	public void test(String FullName, String Username, String Email, String PhoneNum, String Paswrd, String ConPass)
			throws InterruptedException {
		driver.findElement(By.id("name")).sendKeys(FullName);
		Thread.sleep(1000);
		driver.findElement(By.id("username")).sendKeys(Username);
		Thread.sleep(1000);
		driver.findElement(By.id("mail")).sendKeys(Email);
		Thread.sleep(1000);
		driver.findElement(By.id("phone")).sendKeys(PhoneNum);
		Thread.sleep(1000);
		driver.findElement(By.id("pass")).sendKeys(Paswrd);
		Thread.sleep(1000);
		driver.findElement(By.id("conpass")).sendKeys(ConPass);
		Thread.sleep(1000);
		WebElement radioboxSelect = driver.findElement(By.id("girl"));
		Boolean isSelect = radioboxSelect.isSelected();
		if (isSelect == false) {
			radioboxSelect.click();
		}
		driver.findElement(By.id("sub")).click();
		Thread.sleep(2000);
		driver.switchTo().alert().accept();
		//driver.close();
	}
	@AfterMethod()
	public void regist() {
		driver.quit();
	}
}
