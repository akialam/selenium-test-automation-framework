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
import com.ui.tests.LogInTestIListener;
import com.utility.LoggerUtility;

public class TestListener1 implements ITestListener {
	
	Logger logger=LoggerUtility.getLogger(this.getClass());
	
	ExtentSparkReporter extentSparkReporter;
	ExtentReports extentReporter;
	ExtentTest extentText;
	 public void onTestStart(ITestResult result) {
		 logger.info(result.getMethod().getMethodName());
		 logger.info(result.getMethod().getDescription()); 
		 logger.info(Arrays.toString(result.getMethod().getGroups()));
		 extentText=extentReporter.createTest(result.getMethod().getMethodName());
		 
		  
		  }
	public void onTestSuccess(ITestResult result) {
		 logger.info(result.getMethod().getMethodName()+" "+"PASSED");
		 extentText.log(Status.PASS, result.getMethod().getMethodName()+" "+"PASSED");
		
	}
	public void onTestFailure(ITestResult result) {
		 logger.info(result.getMethod().getMethodName()+" "+"FAILED");
		 logger.info(result.getThrowable().getMessage());
		 extentText.log(Status.FAIL, result.getMethod().getMethodName()+" "+"FAILED");
	  }
	public void onTestSkipped(ITestResult result) {
		logger.warn(result.getMethod().getMethodName()+" "+"SKIPPED");
		extentText.log(Status.SKIP, result.getMethod().getMethodName()+" "+"SKIPPED");
	}
	public void onStart(ITestContext context) {
	    logger.info("Test Suite Started");
	    extentSparkReporter=new ExtentSparkReporter(System.getProperty("user.dir")+"\\report.html");
	    extentReporter=new ExtentReports();
	    extentReporter.attachReporter(extentSparkReporter);
	    
	  }
	public  void onFinish(ITestContext context) {
		  logger.info("Test Suite Completed");
		  extentReporter.flush();
	  }
}

