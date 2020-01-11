package Selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CustomizePath {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "E:\\Automation sources\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("http://www.half.ebay.com");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		//dynamic wait
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//input[@class='gh-tb ui-autocomplete-input']")).sendKeys("java");;
		//driver.findElement(By.xpath("//input[@name='_nkw']")).sendKeys("java");
		//driver.findElement(By.xpath("//input[contains(class,'gh-tb ui-autocomplete-input')]")).sendKeys("java");
		//driver.findElement(By.xpath("//input[starts with(@id='gh-ac')]")).sendKeys("java");
		//click on My eBay
		driver.findElement(By.xpath("//a[contains(text(),'My eBay')]")).click();
		

	}

}
