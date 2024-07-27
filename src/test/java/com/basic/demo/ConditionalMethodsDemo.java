package com.basic.demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ConditionalMethodsDemo {

	
	// ConditionalMethods --> we can access this commands through webelement.
	// returns true/false
	
	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		
		driver.get("https://demo.nopcommerce.com/register");
		driver.manage().window().maximize();
		
		// isDisplayed()
		
		WebElement img=driver.findElement(By.xpath("//img[@alt='nopCommerce demo store']"));
		
		System.out.println(img.isDisplayed());
	
		// isEnabled()
		
		boolean chk = driver.findElement(By.xpath("//input[@id='gender-male']")).isEnabled();
		System.out.println(chk);
		
		// isSelected()
		
		boolean chk2 = driver.findElement(By.xpath("//input[@id='gender-male']")).isSelected();
		System.out.println(chk2);
		
		
		
		
	}

}
