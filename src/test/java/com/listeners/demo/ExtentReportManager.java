package com.listeners.demo;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportManager implements ITestListener
{
	public ExtentSparkReporter sparkreporter; // UI of the report
	public ExtentReports extent; // populate common info on report
	public ExtentTest test; // creating test case entries in the report amd update status of the test methods
	

 public void onStart(ITestContext context) {
		 
		sparkreporter = new ExtentSparkReporter(System.getProperty("user.dir")+"/reports/myReport.html");
		sparkreporter.config().setDocumentTitle("Automation Report"); // title of report
		sparkreporter.config().setReportName("Functional Testing"); // name of report
		sparkreporter.config().setTheme(Theme.DARK);
		
		extent = new ExtentReports();
		extent.attachReporter(sparkreporter);
		
		extent.setSystemInfo("Computer Name","localhost");
		extent.setSystemInfo("Environment","QA");
		extent.setSystemInfo("Tester Name","sagar");
		extent.setSystemInfo("os","windows 10");
		extent.setSystemInfo("Browser Name","chrome");
	 }
	 
	public void onTestStart(ITestResult result) {
		
		System.out.println("Test is start...");
	}
	  
	public void onTestSuccess(ITestResult result) {
		
		test = extent.createTest(result.getName()); // create new entry in report
		test.log(Status.PASS, "Test case passed is :"+result.getName()); // update the status 
	}
	
	 public void onTestFailure(ITestResult result) {
		
		 test = extent.createTest(result.getName());
		 test.log(Status.FAIL,"Test case Failed is :"+result.getName());
		 test.log(Status.FAIL, "Test case failed cause is :"+result.getThrowable());
		 
		  }

	 public void onTestSkipped(ITestResult result) {
		 
		 test = extent.createTest(result.getName());
		 test.log(Status.SKIP,"Test case skipped is :"+result.getName());
	 }
	 
	 
	  
	  public void onFinish(ITestContext context) {
		  
		 extent.flush();
	  }

}
