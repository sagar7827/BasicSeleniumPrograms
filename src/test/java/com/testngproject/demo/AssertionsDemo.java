package com.testngproject.demo;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AssertionsDemo {

	@Test
	void testTitle()
	{
		String act_title = "OpenCart";
		String exp_title = "OpenShop";
		
		if(act_title.equals(exp_title))
		{
			System.out.println("Test Passed..!!");
			Assert.assertTrue(true); 
		}
		else
		{
			System.out.println("Test Failed..!!");
			Assert.assertTrue(false);
		}
	}
}
