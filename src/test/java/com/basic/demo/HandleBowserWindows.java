package com.basic.demo;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleBowserWindows {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.navigate().to("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		
		driver.findElement(By.linkText("OrangeHRM, Inc")).click();
		
		Set<String> windowIds = driver.getWindowHandles();
		// Approach 1 using for loop
		/*
		for(String winId:windowIds)
		{
			String title = driver.switchTo().window(winId).getTitle();
			
			if(title.equals("OrangeHRM"))
			{
				System.out.println(driver.getCurrentUrl());
			}
		}*/
		
		// Approach 2 using converting set to list
		
		List<String> winids = new ArrayList(windowIds);
		
		String parentid = winids.get(0);
		String childid = winids.get(1);
		
		driver.switchTo().window(childid);
		System.out.println(driver.getCurrentUrl());
		
		driver.switchTo().window(parentid);
		System.out.println(driver.getCurrentUrl());
		
	}

}
