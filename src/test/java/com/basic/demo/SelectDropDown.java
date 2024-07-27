package com.basic.demo;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SelectDropDown {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		
		WebElement drpcountryEl = driver.findElement(By.xpath("//select[@id='country']"));
		
		Select drpcountry = new Select(drpcountryEl);
		
		// select option from dropdown
		
		//drpcountry.selectByVisibleText("France");
		
		//drpcountry.selectByValue("japan");
		
		drpcountry.selectByIndex(2);
		
		List<WebElement> options=drpcountry.getOptions();
		System.out.println(options.size());
		
		for (WebElement op : options) 
		{
		
			System.out.println(op.getText());
		}

	}

}
