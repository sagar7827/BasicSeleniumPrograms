package com.dataprovider.demo;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class DataProvider {

	WebDriver driver;
	
	@BeforeClass
	void setup()
	{
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
	}
	
	@Test(dataProvider = "dp")
	void testLogin(String email,String pass) throws InterruptedException
	{
		driver.get("https://tutorialsninja.com/demo/index.php?route=account/login");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys(email);
		driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys(pass);
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		Thread.sleep(2000);
		boolean status = driver.findElement(By.xpath("//h2[normalize-space()='My Account']")).isDisplayed();
		if(status==true)
		{
			driver.findElement(By.xpath("//a[@class='list-group-item'][normalize-space()='Logout']")).click();
			Assert.assertTrue(true);
		}
		else
		{
			Assert.fail();
		}
		
		
	}
	
	@AfterClass
	void tearDown()
	{
		driver.close();
	}
	
	@org.testng.annotations.DataProvider(name = "dp",indices = {0,1})
	Object[][] loginData()
	{
		Object data[][]= {
							{"abc@gmail.com","test@123"},
							{"xyz@gmail.com","test012"},
							{"pqr@gmail.com","test23"},
							{"pavanol123@gmail.com","test@123"},
							{"lmn@gmail.com","lopw23"},
					
							};
		return data;
	}
}
