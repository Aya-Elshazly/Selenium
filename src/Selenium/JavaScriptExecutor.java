package Selenium;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavaScriptExecutor {

	public static void main(String[] args) throws InterruptedException, IOException   {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "E:\\Automation sources\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		//dynamic wait
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("http://www.freecrm.com");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[@href='https://ui.freecrm.com']")).click();
		driver.findElement(By.name("email")).sendKeys("aya.elshazly3@gmail.com");
		driver.findElement(By.name("password")).sendKeys("P@$$w0rd123");
		WebElement loginBtn=driver.findElement(By.xpath("//div[contains(text(),'Login')]"));
		flash(loginBtn,driver);
		drawBorder(loginBtn, driver);
		File src= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("/automation/workspace/Selenium/src/Selenium/drawBorder.png"));
		//generateAlert(driver,"there is an issue with login buttom on login page");
		clickElementByJS(loginBtn, driver);
		//refresh browser by selenium
		driver.navigate().refresh();
		//refresh browser by JS
		refreshBrowserByJS(driver);
		//get title of the page by JS
		System.out.println(getTitleByJS(driver));
		//get page text
		System.out.println(getPageInnerText(driver));
		//scroll page down
		//scrollPageDown(driver);
		
		WebElement forgotPassword=driver.findElement(By.xpath("//a[contains(text(),'Forgot your password')]"));
		scrollIntoView(forgotPassword, driver);
		
	}
	
		public static void flash(WebElement element,WebDriver driver)
		{
			JavascriptExecutor js=((JavascriptExecutor)driver);
			String bgcolor=element.getCssValue("backgroundColor");
			for(int i=0;i<10;i++)
			{
				changeColor("rgb(0,200,0)",element,driver);
				changeColor(bgcolor,element,driver);
				
			}
		}
		public static void changeColor(String color, WebElement element,WebDriver driver) 
		{
			JavascriptExecutor js=((JavascriptExecutor)driver);
			js.executeScript("arguments[0].style.backgroundColor= '"+color+"'",element);
			try{
				Thread.sleep(20);
			}catch(InterruptedException e){
				
			}
			
		}
		public static void drawBorder(WebElement element,WebDriver driver)
		{
			JavascriptExecutor js=((JavascriptExecutor)driver);
			js.executeScript("arguments[0].style.border='3px solid red'", element);
		}
	
		public static void generateAlert(WebDriver driver,String message)
		{
			JavascriptExecutor js=((JavascriptExecutor)driver);
			js.executeScript("alert('"+message+"')");
		}
		public static void clickElementByJS(WebElement element,WebDriver driver)
		{
			JavascriptExecutor js=((JavascriptExecutor)driver);
			js.executeScript("arguments[0].click();",element);
		}
		public static void refreshBrowserByJS(WebDriver driver)
		{
			JavascriptExecutor js=((JavascriptExecutor)driver);
			js.executeScript("history.go(0)");
		}
		public static String getTitleByJS(WebDriver driver)
		{
			JavascriptExecutor js=((JavascriptExecutor)driver);
			String title=js.executeScript("return document.title;").toString();
			return title;
		}
		public static String getPageInnerText(WebDriver driver)
		{
			JavascriptExecutor js=((JavascriptExecutor)driver);
			String pageText=js.executeScript("return document.documentElement.innerText;").toString();
			return pageText;
			
		}
		public static void scrollPageDown(WebDriver driver)
		{
			JavascriptExecutor js=((JavascriptExecutor)driver);
			js.executeScript("window.scrollTo(0,document.body.scrollHeight)");

		}
		public static void scrollIntoView(WebElement element,WebDriver driver)
		{
			JavascriptExecutor js=((JavascriptExecutor)driver);
			js.executeScript("arguments[0].scrollIntoView(true)",element);

		}

		
	


	

}
