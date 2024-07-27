package com.basic.demo;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class OpenLinkinNewTab {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();

		driver.get("https://demo.nopcommerce.com/");
		driver.manage().window().maximize();

		WebElement regLink = driver.findElement(By.xpath("//a[normalize-space()='Register']"));

		Actions act = new Actions(driver);

		act.keyDown(Keys.CONTROL).click(regLink).keyUp(Keys.CONTROL).perform();
		
		// switch to registration page
		
		List<String> ids = new ArrayList<String>(driver.getWindowHandles());
		
		driver.switchTo().window(ids.get(1));  // switch to register page
		
		driver.findElement(By.xpath("//input[@id='FirstName']")).sendKeys("sagar");
		
		// back to home page
		
		driver.switchTo().window(ids.get(0));
		
		driver.findElement(By.xpath("//input[@id='small-searchterms']")).sendKeys("tshirts");
		
		

	}

}
