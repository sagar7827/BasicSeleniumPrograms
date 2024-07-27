package com.pageobjectmodel.demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

// constructor
// locators
// action methods



public class LoginPage {

	WebDriver driver;
	
	// constructor
	LoginPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	// locators
	
	By txt_username_loc = By.xpath("//input[@placeholder='Username']");
	By txt_password_loc = By.xpath("//input[@placeholder='Password']");
	By btn_login_loc = By.xpath("//button[normalize-space()='Login']");
	
	// action methods
	
	public void setUsername(String user)
	{
		driver.findElement(txt_username_loc).sendKeys(user);
	}
	
	public void setPassword(String pass)
	{
		driver.findElement(txt_password_loc).sendKeys(pass);
	}
	
	public void clicLogin()
	{
		driver.findElement(btn_login_loc).click();
	}
}
