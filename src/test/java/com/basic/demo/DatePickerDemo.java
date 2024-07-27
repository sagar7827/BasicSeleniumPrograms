package com.basic.demo;

import java.time.Duration;
import java.time.Month;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DatePickerDemo {
	
	// user define method convert string to month
	
	static Month convertMonth(String month)
	{
		
		HashMap<String, Month> monthmap = new HashMap<String, Month>();
		
		monthmap.put("January", Month.JANUARY);
		monthmap.put("February",Month.FEBRUARY);
		monthmap.put("March", Month.MARCH);
		monthmap.put("April", Month.APRIL);
		monthmap.put("May",Month.MAY);
		monthmap.put("June",Month.JUNE);
		monthmap.put("July",Month.JULY);
		monthmap.put("August", Month.AUGUST);
		monthmap.put("September",Month.SEPTEMBER);
		monthmap.put("October",Month.OCTOBER);
		monthmap.put("November",Month.NOVEMBER);
		monthmap.put("December",Month.DECEMBER);
		
		Month vmonth = monthmap.get(month);
		
		if(vmonth==null)
		{
			
			System.out.println("invalid month...");
		}
		
			return vmonth;
		
	}
	
	

	static void futureDate(WebDriver driver, String date, String month, String year) {
	
		while (true) {

			String actualmonth = driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
			String actualyear = driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();

			if (actualmonth.equals(month) && actualyear.equals(year)) 
			{
				break;
			}

			driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")).click(); // next btn
		}
		
		// select the date
		List<WebElement> alldates = driver
				.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//tbody//tr//td//a"));

		for (WebElement dt : alldates) {

			if (dt.getText().equals(date)) 
			{
				dt.click();
				break;
			}
		}
	}

	
	
	static void pastDate(WebDriver driver, String date, String month, String year) {
		
		while (true) {

			String actualmonth = driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
			String actualyear = driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();

			if (actualmonth.equals(month) && actualyear.equals(year)) 
			{
				break;
			}

			driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-w']")).click(); // next btn
		}
		
		// select the date
		List<WebElement> alldates = driver
				.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//tbody//tr//td//a"));

		for (WebElement dt : alldates) {

			if (dt.getText().equals(date)) 
			{
				dt.click();
				break;
			}
		}
	}

	
	
	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://jqueryui.com/datepicker/");
		driver.manage().window().maximize();

		// switch to frame

		driver.switchTo().frame(0);

		// method 1 : using sendkeys()

		// driver.findElement(By.xpath("//input[@id='datepicker']")).sendKeys("05/02/2024");

		// Method2 : using DatePicker

		String year = "2022";
		String month = "January";
		String date = "22";

		driver.findElement(By.xpath("//input[@id='datepicker']")).click(); // opens date picker

		//futureDate(driver, date, month, year);
		
		pastDate(driver, date, month, year);

	}

}
