package com.testngproject.demo;

import org.testng.annotations.Test;

/*
 * 1) Open application
 * 2) Login
 * 3) Logout
 */
public class FirstTestCase {

	@Test(priority = 1)
	void openApp()
	{
		System.out.println("Open application...");
	}
	
	@Test(priority = 2)
	void login()
	{
		System.out.println("Login in the application...");
	}
	
	@Test(priority = 3)
	void logout()
	{
		System.out.println("Logout from the application...");
	}
}
