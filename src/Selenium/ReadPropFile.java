package Selenium;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class ReadPropFile {

	static WebDriver driver;
	public static void main(String[] args) throws IOException {
		Properties prop=new Properties();
		FileInputStream ip=new FileInputStream("E:\\automation\\workspace\\Selenium\\src\\Selenium\\config.properties");
		prop.load(ip);
		String url=prop.getProperty("url");
		String browserName=prop.getProperty("browser");
		if(browserName.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "E:\\Automation sources\\chromedriver.exe");
			driver=new ChromeDriver();
		}
		else if(browserName.equals("FF"))
		{
			System.setProperty("webdriver.gecko.driver", "E:\\Automation sources\\geckodriver.exe");
			DesiredCapabilities compabit=DesiredCapabilities.firefox();
			compabit.setCapability("marionette", true);
			driver=new FirefoxDriver();
		}
		else if(browserName.equals("IE"))
		{
			System.setProperty("webdriver.ie.driver", "E:\\Automation sources\\IEDriverServer.exe");
			driver=new InternetExplorerDriver();
		}
		driver.get(url);
		driver.findElement(By.id(prop.getProperty("firstName_id"))).sendKeys(prop.getProperty("firstName"));
		driver.findElement(By.id(prop.getProperty("lastName_id"))).sendKeys(prop.getProperty("lastName"));
		driver.findElement(By.id(prop.getProperty("password_id"))).sendKeys(prop.getProperty("password"));
		

	}

}
