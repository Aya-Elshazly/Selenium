package Selenium;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class explicitWait {
	public static WebDriver driver;
	@BeforeTest
	public void setUP(){
		System.setProperty("webdriver.chrome.driver", "E:\\Automation sources\\chromedriver.exe");	
		driver = new ChromeDriver(); 
		driver.get("https://www.google.com/");
	}
	@Test
	public void testExplicitWait(){
		WebElement ele=driver.findElement(By.name("q"));
		ele.sendKeys("selenium webdriver");
		ele.submit();
		WebDriverWait wait=new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.titleContains("selenium"));
		assertTrue(driver.getTitle().toLowerCase().startsWith("selenium"));
	}
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}

}
