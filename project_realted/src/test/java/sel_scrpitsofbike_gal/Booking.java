package sel_scrpitsofbike_gal;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Booking {
	public static void main(String[] args) throws InterruptedException {
		String path1 = "D:\\\\chromedriver_win32\\\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", path1);
		WebDriver driver = new ChromeDriver();
		driver.get("D:/WebProject-main/WebProject-main/project/booking.html");

		driver.findElement(By.id("Fname")).sendKeys("Anitha");
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
		Thread.sleep(2000);
		driver.findElement(By.id("alert")).click();
		driver.switchTo().alert().accept();
		Thread.sleep(1000);
	}
}
