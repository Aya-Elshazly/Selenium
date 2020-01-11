package Selenium;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrokenLinkTest {

	public static void main(String[] args) throws InterruptedException, MalformedURLException, IOException {
		System.setProperty("webdriver.chrome.driver", "E:\\Automation sources\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		//dynamic wait
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://freecrm.com/");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[@href='https://ui.freecrm.com']")).click();
		driver.findElement(By.name("email")).sendKeys("aya.elshazly3@gmail.com");
		driver.findElement(By.name("password")).sendKeys("P@$$w0rd123");
		driver.findElement(By.xpath("//div[contains(text(),'Login')]")).click();
		Thread.sleep(3000);
		List<WebElement> LinksList=driver.findElements(By.tagName("a"));
		LinksList.addAll(driver.findElements(By.tagName("img")));
		System.out.println("number of all links and images----"+LinksList.size());
		List<WebElement> ActiveLinks=new ArrayList<WebElement>();
		for(int i=0;i<LinksList.size();i++){
			if(LinksList.get(i).getAttribute("href")!=null 
					&&(!LinksList.get(i).getAttribute("href").contains("javascript"))){
				ActiveLinks.add(LinksList.get(i));
			}
		}
		System.out.println("number of active links and images----"+ActiveLinks.size());
		//check the href URL with httpconnection
		//200 --- ok
		//404 --- not found
		//500 --- internal error
		//400 --- bad request
		for(int j=0;j<ActiveLinks.size();j++){
			HttpURLConnection connection=(HttpURLConnection)new URL
					(ActiveLinks.get(j).getAttribute("href")).openConnection();
			connection.connect();
			String response=connection.getResponseMessage();
			connection.disconnect();
			System.out.println(ActiveLinks.get(j).getAttribute("href")+"--->"+response);
			
		}

	}

}
