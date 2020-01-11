package Selenium;

import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class fluentWait {
	public static WebDriver driver;
	@BeforeTest
	public void setUP(){
		System.setProperty("webdriver.chrome.driver", "E:\\Automation sources\\chromedriver.exe");	
		driver = new ChromeDriver(); 
		driver.get("http://cookbook.seleniumacademy.com/AjaxDemo.html");
	}
	@Test
	public void testFluentWait() {
		driver.findElement(By.linkText("Page 4")).click();	
		Wait<WebDriver> wait=new FluentWait<WebDriver>(driver)
				.withTimeout(10,TimeUnit.SECONDS)
				.pollingEvery(2, TimeUnit.SECONDS)
				.ignoring(NoSuchElementException.class);
				WebElement message=wait
						.until(new Function<WebDriver, WebElement>() {
							public WebElement apply(WebDriver d){
								return d.findElement(By.id("page4"));
							}
						});
				assertTrue(message.getText().contains("Nunc nibh tortor"));
	}
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}

}
