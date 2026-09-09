package com.utility;

import static com.constant.Browser.CHROME;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.constant.Browser;
import com.ui.pages.HomePage;
import com.ui.tests.LogInTestSuite;

public class BaseTestLambdaTestNGParameters {

	Logger logger=LoggerUtility.getLogger(LogInTestSuite.class);
	protected HomePage homepage;//protected allows child classes such as LogInTestSuite to access it.
	private boolean isLambdaTest;
	@Parameters({"browser","isLambdaTest","isHeadLess"})
	@BeforeMethod(description = "Load the homepage of the website")
	public void setup(
			
			@Optional("chrome") String browser,
			@Optional("false") boolean isLambdaTest,
			@Optional("false") Boolean isHeadLess, ITestResult result)
	{	
		
		
		this.isLambdaTest=isLambdaTest;
		WebDriver lambdaDriver;
		System.out.println(browser+" "+isLambdaTest+" "+isHeadLess);
		if(isLambdaTest)
		{
			lambdaDriver=LambdaTestUtility.initilizeLabmdaTestSession(result.getMethod().getMethodName(),browser);
			homepage=new HomePage(lambdaDriver);
		}
		else
		{
			homepage=new HomePage(Browser.valueOf(browser.toUpperCase()),isHeadLess);//import static com.constant.Browser.*;
		}
	
	
	}
	public BrowserUtility getInstance()
	{
		return homepage;
	}
	@AfterMethod(description = "Tear Down the Browser")
	public void tearDown()
	{
		if(isLambdaTest)
		{
			LambdaTestUtility.quitSession();
		}
		else
		{
			homepage.closedBrowser();
		}
	}
}
