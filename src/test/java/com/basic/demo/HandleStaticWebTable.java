package com.basic.demo;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleStaticWebTable {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		
		// 1) find total no of rows in a table
		
		List<WebElement> rows=driver.findElements(By.xpath("//table[@name='BookTable']//tr"));
		System.out.println("No of rows :"+rows.size());
		
		// 2) find total no of columns in a table
		
		int columns = driver.findElements(By.xpath("//table[@name='BookTable']//th")).size();
		System.out.println("No of columns :"+columns);
		
		// 3) read data from specific row and column(ex : 5th row n 1st col)
		
		String data = driver.findElement(By.xpath("//table[@name='BookTable']//tr[5]//td[1]")).getText();
		System.out.println("specific data is :"+data);
		
		// 4) read data from all rows and columns
		
		for (int r = 2; r <= rows.size(); r++) {
			
			for(int c=1;c<=columns;c++)
			{
				String value = driver.findElement(By.xpath("//table[@name='BookTable']//tr["+r+"]//td["+c+"]")).getText();
				System.out.print(value+"\t");
			}
			System.out.println();
		}
		
		System.out.println("*******************************************************");
		
		// 5) print bookname whose author is mukesh
		
		for(int r=2;4<=rows.size();r++)
		{
			String authorname = driver.findElement(By.xpath("//table[@name='BookTable']//tr["+r+"]//td[2]")).getText();
			
			if(authorname.equals("Mukesh"))
			{
				String bookname = driver.findElement(By.xpath("//table[@name='BookTable']//tr["+r+"]//td[1]")).getText();
				System.out.println(bookname+"\t"+authorname);
			}
			
		}
	}

}
