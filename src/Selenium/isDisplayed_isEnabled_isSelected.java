package Selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class isDisplayed_isEnabled_isSelected {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "E:\\Automation sources\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		//dynamic wait
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.get("https://api.cogmento.com/register/");
		//isDisplayed method -- for all elements
		boolean b1=driver.findElement(By.name("action")).isDisplayed();
		System.out.println(b1); //true
		boolean b2=driver.findElement(By.name("action")).isEnabled();
		System.out.println(b2);
		//isSelected meyhod -- checkbox,dropdown,radiobuttom
		boolean b3=driver.findElement(By.id("terms")).isSelected();
		System.out.println(b3);

	}

}
