package Selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class dynamicWebTable {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "E:\\Automation sources\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("http://www.freecrm.com");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[@href='https://ui.freecrm.com']")).click();
		driver.findElement(By.name("email")).sendKeys("aya.elshazly3@gmail.com");
		driver.findElement(By.name("password")).sendKeys("P@$$w0rd123");
		driver.findElement(By.xpath("//div[contains(text(),'Login')]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@href='/contacts']")).click();
		
		//method 1
		/*String beforeXpath="//*[@id='ui']/div/div[2]/div[2]/div/div[2]/table/tbody/tr[";
		String afterXpath="]/td[2]";
		for(int i=1;i<=3;i++)
		{
			String name=driver.findElement(By.xpath(beforeXpath+i+afterXpath)).getText();
			System.out.println(name);
			if(name.contains("test2 test2"))
			{
				driver.findElement(By.xpath("//*[@id='ui']/div/div[2]/div[2]/div/div[2]/table/tbody/tr["+i+"]/td[2]")).click();
			}
		}*/
		
		//method 2
		String name="test2 test2";
		driver.findElement(By.xpath("//td[text()='"+name+"']")).click();
		//driver.findElement(By.xpath("//td[text()='"+name+"']//parent::td//div[@class='datalistrow']"
		//+ "//preceding-sibling::td[@class='datalistrow']//input[@name='contact_id']")).click();

	}

}
