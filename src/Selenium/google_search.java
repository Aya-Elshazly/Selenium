package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class google_search {
	public void search_firefox(WebDriver driver)
	{
	// find search text box
		driver.get("https://www.google.com");
	WebElement search_box=driver.findElement(By.id("lst-ib"));
	search_box.sendKeys("ArabTester on YouTube");
	
	// click on google search
	WebElement search_buttom=driver.findElement(By.name("btnK"));
	search_buttom.click();
	}
	
	public void search_other(WebDriver driver)
	{
		// find search text box
		driver.get("https://www.google.com/");
		WebElement search_box=driver.findElement(By.id("lst-ib"));
		search_box.sendKeys("ArabTester on YouTube");
		
		// click search buttom
		WebElement search_icon=driver.findElement(By.name("btnK"));
		search_icon.click();
		
	}

}
