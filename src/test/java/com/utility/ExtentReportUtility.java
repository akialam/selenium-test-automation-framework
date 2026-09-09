package com.utility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportUtility {
	
	private static ExtentReports extentReporter; //Dumpping all the info at once. no need to dump multiple times.
	private static ThreadLocal<ExtentTest> extentTest=new ThreadLocal<ExtentTest>();
	

	public static void setupSpartReporter(String reportName)
	{
		ExtentSparkReporter extentSparkReporter=new ExtentSparkReporter(System.getProperty("user.dir")+"\\"+reportName);
		    extentReporter=new ExtentReports();
		    extentReporter.attachReporter(extentSparkReporter);
		    
	}
	public static void createExtentTest(String testName)
	{
		ExtentTest test =extentReporter.createTest(testName);
		extentTest.set(test);
	}
	public static ExtentTest getTest()
	{
		return extentTest.get();
	}
	
	public static void flushReport()
	{
		extentReporter.flush();
	}

}
