package com.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Selenium.hashMap;

public class hashMapTest {
    
	public WebDriver driver;
	public String credentials;
	public String credentialsInfo[];
	@BeforeMethod
	public void setUp(){
		
		System.setProperty("webdriver.chrome.driver","E:\\Automation sources\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("http://www.freecrm.com");
		

	}
	@Test
	public void calendarSelect(){
		driver.findElement(By.xpath("//a[@href='https://ui.freecrm.com']")).click();
		driver.findElement(By.name("email")).sendKeys("aya.elshazly3@gmail.com");
		driver.findElement(By.name("password")).sendKeys("P@$$w0rd123");
		//button to open calendar
        WebElement selectDate = driver.findElement(By.xpath("//*[@id='main-nav']/a[3]/span"));
        selectDate.click();
	}
	/*@Test(priority=1)
	public void loginAdminTest(){
		credentials=hashMap.getUserLoginInfo().get("admin");
		credentialsInfo=credentials.split("_");
		driver.findElement(By.xpath("//a[@href='https://ui.freecrm.com']")).click();
		driver.findElement(By.name("email")).sendKeys(credentialsInfo[0]);
		driver.findElement(By.name("password")).sendKeys(credentialsInfo[1]);
		driver.findElement(By.xpath("//div[contains(text(),'Login')]")).click();
	    //button to open calendar
        WebElement selectDate = driver.findElement(By.xpath("//*[@id='main-nav']/a[3]/span"));
        selectDate.click();
		
	}*/
	/*@Test(priority=2)
	public void loginCustomerTest(){
		credentials=hashMap.getUserLoginInfo().get("customer");
		credentialsInfo=credentials.split("_");
		driver.findElement(By.xpath("//a[@href='https://ui.freecrm.com']")).click();
		driver.findElement(By.name("email")).sendKeys(credentialsInfo[0]);
		driver.findElement(By.name("password")).sendKeys(credentialsInfo[1]);
		driver.findElement(By.xpath("//div[contains(text(),'Login')]")).click();
		
	}*/
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}

}
