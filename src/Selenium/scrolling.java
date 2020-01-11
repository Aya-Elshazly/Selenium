package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class scrolling {
	public WebDriver driver ; 
	@BeforeClass
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "E:\\Automation sources\\chromedriver.exe");
		driver = new ChromeDriver(); 
		driver.manage().window().maximize();
		driver.navigate().to("http://www.amazon.com");

	}
	@Test
	public void scroll(){
		JavaScriptExecutor js=(JavaScriptExecutor) driver;
		js.executeScript("scrollBy(0,3000)");
		WebElement element=driver.findElement(By.cssSelector("div.nav-logo-base nav-sprite"));
		js.executeScript("arguments[0].scrollIntoView();",element);
	}
	@AfterClass
	public void tearDown(){
		driver.quit();
	}

}
