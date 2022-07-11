package sel_scrpitsofbike_gal;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class Home {
	public static void main(String[] args) throws InterruptedException {
		String path1 = "D:\\chromedriver_win32\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", path1);
		WebDriver driver = new ChromeDriver();
		driver.get("D:\\WebProject-main\\WebProject-main\\project\\home.html");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='About']"));
		driver.findElement(By.xpath("//*[@id='Product']"));
		driver.findElement(By.xpath("//*[@id='Booking']"));
		driver.findElement(By.xpath("//*[@id='Contact us']"));
		driver.findElement(By.xpath("//*[@id='Team']"));
		// driver.close();
	}
}
