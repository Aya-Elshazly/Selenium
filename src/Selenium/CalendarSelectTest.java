package Selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class CalendarSelectTest {

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
	    //button to open calendar
		driver.findElement(By.xpath("//a[@href='/calendar']")).click();
		//button to move next in calendar
	    WebElement nextLink = driver.findElement(By.xpath("//*[@id='ui']/div/div[2]/div[2]/div/div[2]/div/div[2]/div/div[1]/span[1]/button[3]"));
		nextLink.click();
		
		
		/*String date="19-September-2019";
		String dateArr[]=date.split("-");
		String day=dateArr[0];
		String month=dateArr[1];
		String year=dateArr[2];
		Select select=new Select(driver.findElement(By.name("")));
		select.selectByVisibleText(year);
		
		//*[@id='ui']/div/div[2]/div[2]/div/div[2]/div/div[2]/div/div[2]/div[2]/div[1]/div[1]
		//*[@id='ui']/div/div[2]/div[2]/div/div[2]/div/div[2]/div/div[2]/div[2]/div[1]/div[2]
		//*[@id='ui']/div/div[2]/div[2]/div/div[2]/div/div[2]/div/div[2]/div[2]/div[1]/div[4]
		String beforeXpath="//*[@id='ui']/div/div[2]/div[2]/div/div[2]/div/div[2]/div/div[2]/div[";
		String afterXpath="]/div[1]/div[";
		final int totalWeekDays=7;
		boolean flag=false;
		for(int rowNum=2;rowNum<=7;rowNum++)
		{
			for(int colNum=1;colNum<=totalWeekDays;colNum++)
			{
				String dayVal=driver.findElement(By.xpath(beforeXpath+rowNum+afterXpath+colNum+"]")).getText();
				System.out.println(dayVal);
				if(dayVal.equals(day))
				{
					driver.findElement(By.xpath(beforeXpath+rowNum+afterXpath+colNum+"]")).click();
					flag=true;
					break;
				}
			}
			if(flag){
				break;
			}
		}

	}*/
	}	

}
