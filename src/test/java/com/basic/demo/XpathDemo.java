package com.basic.demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class XpathDemo {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.opencart.com/");
		driver.manage().window().maximize(); // maximize window

		// xpath with single attribute

		// driver.findElement(By.xpath("//input[@placeholder='Search']")).sendKeys("T-shirts");

		// xpath with multiple attributes

		// driver.findElement(By.xpath("//input[@placeholder='Search'][@name='search']")).sendKeys("T-shirts");

		// xpath with 'and' 'or' operators

		// driver.findElement(By.xpath("//input[@placeholder='Search'and
		// @name='search']")).sendKeys("T-shirts");
		// driver.findElement(By.xpath("//input[@placeholder='Search'or
		// @name='search']")).sendKeys("T-shirts");

		// xpath with inner text

		// boolean status
		// =driver.findElement(By.xpath("//h3[text()='Featured']")).isDisplayed();
		// System.out.println(status);

		// xpath with contains method
		// driver.findElement(By.xpath("//input[contains(@placeholder,'Sea')]")).sendKeys("T-shirts");

		// xpath with start-with method
		
		driver.findElement(By.xpath("//input[starts-with(@placeholder,'Sea')]")).sendKeys("T-shirts");

		
	}

}
