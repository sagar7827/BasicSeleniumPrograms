package com.listeners.demo;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class MyListener implements ITestListener {

	
	 public void onStart(ITestContext context) {
		 
		 System.out.println("Test Execution is started...");
	 }
	 
	public void onTestStart(ITestResult result) {
		
		System.out.println("Test is start...");
	}
	  
	public void onTestSuccess(ITestResult result) {
		
		System.out.println("Test is successful...");
	}
	
	 public void onTestFailure(ITestResult result) {
		
		 System.out.println("Test is Fail...");
		 
		  }

	 public void onTestSkipped(ITestResult result) {
		 
		 System.out.println("Test is skipped...");
	 }
	 
	 
	  
	  public void onFinish(ITestContext context) {
		  
		  System.out.println("Test Execution is finished...");
	  }

}
