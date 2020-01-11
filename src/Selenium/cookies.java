package Selenium;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class cookies {
	public static WebDriver driver;
	@BeforeTest
	public void setUP(){
		System.setProperty("webdriver.chrome.driver", "E:\\Automation sources\\chromedriver.exe");	
		driver = new ChromeDriver(); 
		driver.get("http://magento-demo.lexiconn.com/");
	}
	@Test
	public void testCookies(){
		WebElement lanSelect=driver.findElement(By.id("select-language"));
		Select select=new Select(lanSelect);
		Assert.assertEquals("English", select.getFirstSelectedOption().getText());
		Cookie storeCookie=driver.manage().getCookieNamed("store");
		Assert.assertEquals(null, storeCookie);
		select.selectByVisibleText("German");
		storeCookie=driver.manage().getCookieNamed("store");
		Assert.assertEquals("german", storeCookie.getValue());
		System.out.println(storeCookie.getValue());
		Set<Cookie> cookies=driver.manage().getCookies();
		System.out.println("Number of Cookies: "+cookies.size());
		Iterator<Cookie> itr=cookies.iterator();
		while(itr.hasNext()){
			Cookie cookie=itr.next();
			System.out.println(cookie.getDomain());
			System.out.println(cookie.getName());
			System.out.println(cookie.getPath());
			System.out.println(cookie.getValue());
		}
		
	}
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}

}
