package com.testngproject.demo;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

/*
 * 1) Open application
 * 2) Test Logo Presence
 * 3) Login
 * 4) Close
 */

public class OrangeHrmTest {
 
	WebDriver driver;
	
	@Test(priority = 1)
	void openApp()
	{
	    driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
	}
	
	@Test(priority = 2)
	void testlogoPresence()
	{
		boolean status =driver.findElement(By.xpath("//div[@class='orangehrm-login-branding']")).isDisplayed();
		System.out.println("Logo displayed.."+status);
	}
	
	@Test(priority = 3)
	void login()
	{
		driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("Admin");
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
	}
	
	@Test(priority = 4)
	void close()
	{
		driver.quit();
	}
}
