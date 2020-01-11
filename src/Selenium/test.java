package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class test {
	public WebDriver driver ; 


	@BeforeClass
	public void setUp() 
	{
		System.setProperty("webdriver.chrome.driver", 
				System.getProperty("user.dir")+"\\Sources\\chromedriver.exe");
		driver = new ChromeDriver(); 
		driver.navigate().to("https://demo.nopcommerce.com/register?returnUrl=%2F");
		driver.manage().window().maximize();
	}
	@Test
	public void testFileUpload() throws InterruptedException {
		driver.findElement(By.id("FirstName")).sendKeys("aya");
		Thread.sleep(3000);
		
		
	}
	@AfterClass
	public void tearDown() 
	{
		driver.quit();
	}

}
