package com.basic.demo;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SumCalc {

	public static void main(String[] args) throws IOException, InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://planetcalc.com/8183/");
		driver.manage().window().maximize();
		
		
		String filepath = System.getProperty("user.dir")+"\\testData\\SumCal.xlsx";

		int rows = ExcelUtils.getRowCount(filepath,"Sheet1");

		for(int i=0;i<=rows;i++)
		{
			// read value from excel
			
			String val = ExcelUtils.getCellData(filepath, "Sheet1", i, 0);
			String exp_result = ExcelUtils.getCellData(filepath, "Sheet1", i, 1);
			
			// pass above data to application
			
			WebElement txtarea =driver.findElement(By.xpath("//textarea[@id='dialogv6411c55e0cc72_numbers']"));
			
			txtarea.clear();
			txtarea.sendKeys(val);
			
			// validation
			
			String result = driver.findElement(By.xpath("//div[@id='dialogv6411c55e0cc72_sum']")).getText();
			System.out.println(result);
			
			if(Double.parseDouble(exp_result)==Double.parseDouble(result))
			{
				System.out.println("Test Passed!");
				ExcelUtils.setCellData(filepath, "Sheet1", i, 2, "Passed");
			//	ExcelUtils.fillGreenColor(filepath, "Sheet1", i, 2);

			}
			else
			{
				System.out.println("Test Failed!");
				ExcelUtils.setCellData(filepath, "Sheet1", i, 2, "Failed");
				//ExcelUtils.fillRedColor(filepath, "Sheet1", i, 2);
			}
			
			Thread.sleep(3000);

		
		}
			
	driver.quit();
		
		
	
	}

}
