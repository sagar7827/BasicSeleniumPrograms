package com.basic.demo;

import java.io.File;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CaptureScreenShots {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://demo.nopcommerce.com/");
		driver.manage().window().maximize();

		// 1) Full page screenshot

		/*
		TakesScreenshot ts = (TakesScreenshot) driver;
		File sourcefile = ts.getScreenshotAs(OutputType.FILE);

		File targetFile = new File(System.getProperty("user.dir") + "\\ScreenShots\\Fullpage.png");
		sourcefile.renameTo(targetFile);

		 */
		// 2) block screenshot
/*
		WebElement featureProducts = driver
				.findElement(By.xpath("//div[@class='product-grid home-page-product-grid']"));

		File sourcefile = featureProducts.getScreenshotAs(OutputType.FILE);
		File targetFile = new File(System.getProperty("user.dir") + "\\ScreenShots\\Blockpage.png");
		sourcefile.renameTo(targetFile);
*/		
		
		// 3) single element screenshot
		
		WebElement logo = driver.findElement(By.xpath("//img[@alt='nopCommerce demo store']"));
		
		File sourcefile = logo.getScreenshotAs(OutputType.FILE);
		File targetFile = new File(System.getProperty("user.dir") + "\\ScreenShots\\logo.png");
		sourcefile.renameTo(targetFile);
	
		
	}

}
