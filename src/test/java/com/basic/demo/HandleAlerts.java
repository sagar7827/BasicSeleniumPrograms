package com.basic.demo;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleAlerts {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		
		driver.get("https://the-internet.herokuapp.com/javascript_alerts");
		driver.manage().window().maximize();
		
		// Normal Alert with Ok Button
	/*	
		driver.findElement(By.xpath("//button[@onclick='jsAlert()']")).click();
		Thread.sleep(5000);
		
		Alert myalert =driver.switchTo().alert();
		String msg = myalert.getText();
		System.out.println(msg);
		myalert.accept();*/
		
		// 2) Confirmation Alert --> ok & cancel button
		
	/*	driver.findElement(By.xpath("//button[@onclick='jsConfirm()']")).click();
		Thread.sleep(5000);
		
		Alert myalert = driver.switchTo().alert();
		System.out.println(myalert.getText());
		//myalert.accept();
		myalert.dismiss();*/
		
		// 3) prompt window alert
		
		driver.findElement(By.xpath("//button[@onclick='jsPrompt()']")).click();
		Thread.sleep(5000);
		
		Alert myalert = driver.switchTo().alert();
		myalert.sendKeys("Welcome");
		myalert.accept();
		
	}

}
