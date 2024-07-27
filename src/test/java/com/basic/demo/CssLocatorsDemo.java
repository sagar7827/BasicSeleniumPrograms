package com.basic.demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CssLocatorsDemo {

	/* CSS -- Cascading style sheets
	 * 
	 * tag id					tag#id
	 * tag class				tag.className
	 * tag attribute			tag[attribute="value"]
	 * tag class attribute		tag.className[attribute="value"]
	 * 
	 */
	
	
	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.nopcommerce.com/");
		driver.manage().window().maximize();
		
		// 1) tag#id
		
		//driver.findElement(By.cssSelector("input#small-searchterms")).sendKeys("T-shirts");
		
		// 2) tag.className
		
		//driver.findElement(By.cssSelector("input.search-box-text")).sendKeys("T-shirts");
		
		// 3) tag[attribute="value"]
		
		//driver.findElement(By.cssSelector("input[placeholder='Search store']")).sendKeys("T-shirts");
		
		// 4) tag.className[attribute="value"]
		
		driver.findElement(By.cssSelector("input.search-box-text[name='q']")).sendKeys("T-Shirts");
	}

}
