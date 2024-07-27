package com.testngproject.demo;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/*
 * 1) login
 * 2) search
 * 3) logout
 * 4) login
 * 5) Advance search
 * 6) logout
 */




public class AnnotationDemo1 {

	@BeforeMethod
	void login()
	{
		System.out.println("login...");
	}
	
	@Test(priority = 1)
	void search()
	{
		System.out.println("search..");
	}
	
	@Test(priority = 2)
	void advanceSearch()
	{
		System.out.println("advance search..");
	}
	
	@AfterMethod
	void logout()
	{
		System.out.println("logout..");
	}
}
