package sel_scrpitsofbike_gal;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class Login {
	public static void main(String[] args) throws InterruptedException {
		String path1 = "D:\\chromedriver_win32\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", path1);
		WebDriver driver = new ChromeDriver();
		driver.get("D:\\WebProject-main\\WebProject-main\\project\\login.html");
		Thread.sleep(2000);
		driver.findElement(By.id("username")).sendKeys("Anitha");
		Thread.sleep(1000);
		driver.findElement(By.id("password")).sendKeys("A@1234");
		Thread.sleep(1000);
		driver.findElement(By.id("sub")).click();
		Thread.sleep(2000);
		driver.switchTo().alert().accept();
		// driver.close();
	}
}
