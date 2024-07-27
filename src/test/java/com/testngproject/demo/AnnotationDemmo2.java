package com.testngproject.demo;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/*
 * 1) login
 * 2) search
 * 3) advance search
 * 4) logout
 */
public class AnnotationDemmo2 {

	@BeforeClass
	void login()
	{
		System.out.println("login..");
	}
	
	@AfterClass
	void logout()
	{
		System.out.println("logout..");
	}
	
	@Test(priority = 1)
	void search()
	{
		System.out.println("search..");
	}
	
	@Test(priority = 2)
	void advanceSearch()
	{
		System.out.println("advance search...");
	}
}
