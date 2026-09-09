package com.ui.listeners;

import java.util.Arrays;

import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.utility.BaseTest;
import com.utility.BaseTestLambdaTestNGParameters;
import com.utility.BrowserUtility;
import com.utility.ExtentReportUtility;
import com.utility.LoggerUtility;

public class TestListener implements ITestListener {
	
	Logger logger=LoggerUtility.getLogger(this.getClass());
	
	ExtentSparkReporter extentSparkReporter;
	ExtentReports extentReporter;
	ExtentTest extentText;
	 public void onTestStart(ITestResult result) {
		 logger.info(result.getMethod().getMethodName());
		 logger.info(result.getMethod().getDescription()); 
		 logger.info(Arrays.toString(result.getMethod().getGroups()));
		 ExtentReportUtility.createExtentTest(result.getMethod().getMethodName());
		 
		  
		  }
	public void onTestSuccess(ITestResult result) {//onTestStart() = an individual @Test method starts
		 logger.info(result.getMethod().getMethodName()+" PASSED");
		 ExtentReportUtility.getTest().log(Status.PASS, result.getMethod().getMethodName()+" PASSED");
		
	}
	public void onTestFailure(ITestResult result) {
		 logger.info("Capturing the screenshot for the failed test case.");
		 logger.info(result.getThrowable().getMessage());
		 ExtentReportUtility.getTest().log(Status.FAIL, result.getMethod().getMethodName()+" FAILED");
		 
		Object testclass= result.getInstance();
		BrowserUtility broweserUniltity=((BaseTestLambdaTestNGParameters) testclass).getInstance();
		logger.info(result.getMethod().getMethodName() + " FAILED");
		String screenShotPath=broweserUniltity.takeScreenshots(result.getMethod().getMethodName());
		ExtentReportUtility.getTest().addScreenCaptureFromPath(screenShotPath);
		logger.info("Storing the Screenshot to the html report.");
	  }
	
	
	public void onTestSkipped(ITestResult result) {
		logger.warn(result.getMethod().getMethodName()+" SKIPPED");
		ExtentReportUtility.getTest().log(Status.SKIP, result.getMethod().getMethodName()+" SKIPPED");
	}
	public void onStart(ITestContext context) { //onStart() = TestNG test context/suite starts
	    logger.info("Test Suite Started");
	    ExtentReportUtility.setupSpartReporter("report.html");
	    
	  }
	public  void onFinish(ITestContext context) {
		  logger.info("Test Suite Completed");
		  ExtentReportUtility.flushReport();
	  }
}

