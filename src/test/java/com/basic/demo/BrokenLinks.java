package com.basic.demo;

import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/*
 * 1) Link href = "https://xyz.com"
 * 2) https://xyz.com ---> server ---> status code
 * 3) status code >= 400 broken link
 * 	   status code < 400 not a broken link
 */

public class BrokenLinks {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("http://www.deadlinkcity.com/");
		driver.manage().window().maximize();

		List<WebElement> links = driver.findElements(By.tagName("a"));

		System.out.println("Total No of Links :" + links.size());
		int brokenlinks=0;

		for (WebElement linkelement : links) {
			String hrefattvalue = linkelement.getAttribute("href");

			if (hrefattvalue == null || hrefattvalue.isEmpty()) 
			{
				System.out.println("href attribute value is empty so not posssible to check !!");
				continue;
			}

			// hit url to server

			try {
				URL linkurl = new URL(hrefattvalue);

				HttpURLConnection conn = (HttpURLConnection) linkurl.openConnection(); // open connection to server

				conn.connect(); // connect to the server and send request

				if (conn.getResponseCode() >= 400)
				{
					System.out.println(hrefattvalue+"======> Broken links");
					brokenlinks++;
				} else 
				{
					System.out.println(hrefattvalue+"========> Not a Broken Links");
				}
			} catch (Exception e)
			{

			}

		}
		
		System.out.println("No of Broken Links :"+brokenlinks);
	}

}
