package Selenium;

import java.awt.JobAttributes;

import javax.swing.JOptionPane;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class first {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver=new FirefoxDriver();
		driver.get("http://www.seleniumframework.com/practiceform/");
		
		//String page_title = driver.getTitle();
		//JOptionPane.showMessageDialog(null, page_title);
		
		//String page_source=driver.getPageSource();
		//System.out.print(page_source);
		
		//JOptionPane.showMessageDialog(null, driver.getCurrentUrl().toString());
		
		//driver.close();
		
		//driver.navigate().to("http://www.google.com");
		//driver.navigate().back();
		//driver.navigate().forward();
		//driver.quit();
		
		/*WebElement page_text=driver.findElement(By.xpath(".//*[@id='presscore-contact-form-widget-3']/form/div/span[4]/input"));
		if(page_text.isDisplayed())
		{
			JOptionPane.showMessageDialog(null, "text area is enabled");
		}
		
		JOptionPane.showMessageDialog(null,page_text.getText());
		
		JOptionPane.showMessageDialog(null,page_text.getAttribute("name"));
		*/
		
		driver.manage().window().maximize();
		JOptionPane.showMessageDialog(null, "window max");
		
		

	}

}
