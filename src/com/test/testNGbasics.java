package com.test;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class testNGbasics {
	@BeforeSuite
	public void setUp(){
		System.out.println("setup system property for chrome");
	}
	@BeforeTest
	public void launchBrowser(){
		System.out.println("launch chrome browser");
	}
	@BeforeClass
	public void login(){
		System.out.println("login to app");
		
	}
	@BeforeMethod
	public void enterURL(){
		System.out.println("enter URL");
	}
	@Test
	public void googleTitleTest(){
		System.out.println("google title test");
	}
	@Test
	public void searchTest(){
		System.out.println("search test");
	}
	@AfterMethod
	public void logout(){
		System.out.println("logout from app");
	}
	@AfterTest
	public void deleteAllCookies(){
		System.out.println("delete All Cookies");
	}
	@AfterClass
	public void closeBrowser(){
		System.out.println("Close Browser");
	}
	@AfterSuite
	public void generateTestReport(){
		System.out.println("generate Test Report");
	}
	
	

}
