package com.testngproject.demo2;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class C3 {

	@Test
	void pqr()
	{
		System.out.println("This is pqr from C3..");
	}
	@BeforeSuite
	void bs()
	{
		System.out.println("This is Before suite..");
	}
	@AfterSuite
	void as()
	{
		System.out.println("This is After Suite..");
	}
}
