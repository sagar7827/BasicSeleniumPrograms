package com.basic.demo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/*
 * Test case :
 * 1) Launch chrome browser
 * 2) Open url https://demo.opencart.com/
 * 3) validate title should be "Your Store"
 * 4) close browser
 */


public class FirstTestProgram {

	public static void main(String[] args) {

		// 1) Launch chrome browser
		//ChromeDriver driver = new ChromeDriver();
		WebDriver driver = new ChromeDriver();
		
		// 2) Open url https://demo.opencart.com/
		driver.get("https://demo.opencart.com/");
		
		// 3) validate title should be "Your Store"
		String act_title = driver.getTitle();
		
		if(act_title.equals("Your Store"))
		{
			System.out.println("Test Pass!");
		}else
		{
			System.out.println("Test Failed!");
		}
		
		// 4) close browser
		driver.close();
		
	}

}
