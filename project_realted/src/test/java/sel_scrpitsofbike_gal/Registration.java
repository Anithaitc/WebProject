package sel_scrpitsofbike_gal;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class Registration {
	public static void main(String[] args) throws InterruptedException {
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
}
