package com.test;

import org.testng.annotations.Test;

public class testingFeatures {
	@Test
	public void loginTest(){
		System.out.println("login test");
	}
	@Test(dependsOnMethods="loginTest")
	public void HomePageTest(){
		System.out.println("home page test");
	}

}
