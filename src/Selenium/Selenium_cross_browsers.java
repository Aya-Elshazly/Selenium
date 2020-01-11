package Selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Selenium_cross_browsers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// firefox setup
		System.setProperty("webdriver.gecko.driver", "E:\\Automation sources\\geckodriver.exe");
		DesiredCapabilities compabit=DesiredCapabilities.firefox();
		compabit.setCapability("marionette", true);
		WebDriver driver_FF=new FirefoxDriver();
		google_search search_class=new google_search();
		search_class.search_firefox(driver_FF);
		
		// chrome setup
		System.setProperty("webdriver.chrome.driver", "E:\\Automation sources\\chromedriver.exe");
		WebDriver chrome_driver=new ChromeDriver();
		search_class.search_other(chrome_driver);
		
		// Internet Explorer
		System.setProperty("webdriver.ie.driver", "E:\\Automation sources\\IEDriverServer.exe");
		WebDriver IE_Driver=new InternetExplorerDriver();
		search_class.search_other(IE_Driver);
		
		

	}

}
