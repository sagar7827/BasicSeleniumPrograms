package com.basic.demo;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DataDrivenFDCalculator {
	

	//input[@id='principal']
	//input[@id='interest']
	//input[@id='tenure']

	public static void main(String[] args) throws IOException, InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.moneycontrol.com/fixed-income/calculator/hsbc/fixed-deposit-calculator-ZZZ-BHS001.html?classic=true");
		driver.manage().window().maximize();
		
	//	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
		
		
		String filepath = System.getProperty("user.dir")+"\\testData\\Simple Interest.xlsx";
		
		int rows = ExcelUtils.getRowCount(filepath,"Sheet1");
		
		for(int i=1;i<=rows;i++)
		{
			// 1) read data from excel
			
			String principle = ExcelUtils.getCellData(filepath, "Sheet1", i, 0);
			String rateOfinterest = ExcelUtils.getCellData(filepath, "Sheet1", i, 1);
			String period1 = ExcelUtils.getCellData(filepath, "Sheet1", i, 2);
			String period2 = ExcelUtils.getCellData(filepath, "Sheet1", i, 3);
			String frequency = ExcelUtils.getCellData(filepath, "Sheet1", i, 4);
			String exp_maturityvalue = ExcelUtils.getCellData(filepath, "Sheet1", i, 5);
			
			// 2) pass above data to the application
			
			
			
			driver.findElement(By.xpath("input[@id='principal']")).sendKeys(principle);
			//wait.until(ExpectedConditions.elementToBeClickable(By.xpath("input[@id='principal']"))).sendKeys(principle);
			driver.findElement(By.xpath("input[@id='interest']")).sendKeys(rateOfinterest);
			driver.findElement(By.xpath("input[@id='tenure']")).sendKeys(period1);
			
			Select perddrp = new Select(driver.findElement(By.xpath("//select[@id='tenurePeriod']")));
			perddrp.selectByVisibleText(period2);
			
			Select fredrp = new Select(driver.findElement(By.xpath("//select[@id='frequency']")));
			fredrp.selectByVisibleText(frequency);
			
			driver.findElement(By.xpath("//div[@class='CTR PT15']//a[1]")).click(); // click on calculate
			
			// 3) validation
			
			String act_mval = driver.findElement(By.xpath("//span[@id='resp_matval']//strong")).getText();
			
			if(Double.parseDouble(exp_maturityvalue)==Double.parseDouble(act_mval))
			{
				System.out.println("Test Passed!");
				ExcelUtils.setCellData(filepath, "Sheet1", i, 7, "Passed");
				ExcelUtils.fillGreenColor(filepath, "Sheet1", i, 7);
			}
			else
			{
				System.out.println("Test Failed!");
				ExcelUtils.setCellData(filepath, "Sheet1", i, 7, "Failed");
				ExcelUtils.fillRedColor(filepath, "Sheet1", i, 7);
			}
			
			Thread.sleep(3000);
			driver.findElement(By.xpath("//img[@class='PL5']")).click(); // click on clear button
		}
		
		driver.quit();
	}

}
