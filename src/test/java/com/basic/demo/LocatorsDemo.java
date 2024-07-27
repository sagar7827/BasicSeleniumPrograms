package com.basic.demo;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocatorsDemo {
	
	/* findElement() vs findElements()
	 * 
	 * scenario 1: locator matching with single WebElement
	 * findElement()  ---> Single WebElement  return type WebElement
	 * findElements() ---> Single WebElement  return type List<WebElement>
	 * 
	 * scenario 2: locator matching with multiple WebElement
	 * findElement()  ---> Single WebElement  return type WebElement
	 * findElements() ---> Multiple WebElements  return type List<WebElement>
	 * 
	 * scenario 3: locator is not matching with any element.
	 * findElement()  ---> No such Element Exception
	 * findElements() ---> returns 0
	 * 
	 */

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.opencart.com/");
		driver.manage().window().maximize();  // maximize window
		
		// 1) name locator
		
		//driver.findElement(By.name("search")).sendKeys("mac");
		
		// 2) id locator
		
		//boolean logoDisplaystatus = driver.findElement(By.id("logo")).isDisplayed();
		//System.out.println(logoDisplaystatus);
		
		// 3) linkText locator
		
		//driver.findElement(By.linkText("Tablets")).click();
		
		// 4) partialLinktext locator
		
		//driver.findElement(By.partialLinkText("Table")).click();
		
		// for multiple elements
		
		// 5) className locator
		
		 List<WebElement> headerLinks=driver.findElements(By.className("list-inline-item"));
		 System.out.println("No of headrers :"+headerLinks.size());
		 
		 // 6) TagName locator
		 
		 List<WebElement> links=driver.findElements(By.tagName("a"));
		 System.out.println("No of Links :"+links.size());
		 
		 List<WebElement> images=driver.findElements(By.tagName("img"));
		 System.out.println("No of Images :"+images.size());
		 
	}

}
