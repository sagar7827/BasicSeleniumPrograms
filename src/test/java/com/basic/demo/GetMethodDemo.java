package com.basic.demo;

import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetMethodDemo {

	// Get Methods --> we can access this methods through webdriver instance.
	
	
	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		
		// 1) get() command to open url in browser
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		
		driver.manage().window().maximize();
		
		// 2) getTitle() returns title of the page
		
		System.out.println(driver.getTitle());
		
		// 3) getCurrentUrl() returns url of the current webpage
		
		System.out.println(driver.getCurrentUrl());
		
		// 4) getPagesource() returns source code of page
		
		System.out.println(driver.getPageSource());
		
		// 5) getWindowHandle() returns id of single browser window
		
		System.out.println(driver.getWindowHandle());
		
		// 6) getWindowHandles() returns id of multiple browser windows
		
		//Set<String>ids=driver.getWindowHandles();
		
		//System.out.println(ids);
	}

}
