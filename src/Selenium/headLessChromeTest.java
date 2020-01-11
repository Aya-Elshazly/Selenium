package Selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class headLessChromeTest {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "E:\\Automation sources\\chromedriver.exe");
		ChromeOptions options=new ChromeOptions();
		options.addArguments("window-size=1400,800");
		options.addArguments("headless");
		WebDriver driver=new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		//dynamic wait
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("http://www.freecrm.com");
		System.out.println("Login page title="+driver.getTitle());
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[@href='https://ui.freecrm.com']")).click();
		driver.findElement(By.name("email")).sendKeys("aya.elshazly3@gmail.com");
		driver.findElement(By.name("password")).sendKeys("P@$$w0rd123");
		driver.findElement(By.xpath("//div[contains(text(),'Login')]")).click();
		System.out.println("Homepage page title="+driver.getTitle());

	}

}
