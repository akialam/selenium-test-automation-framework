package com.utility;

import static com.constant.Browser.CHROME;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.ui.pages.HomePage;
import com.ui.tests.LogInTestSuite;

public class BaseTestLambda {

	Logger logger=LoggerUtility.getLogger(LogInTestSuite.class);
	protected HomePage homepage;//protected allows child classes such as LogInTestSuite to access it.
	private boolean isLambdaTest=true;
	private boolean isHeadLess=true;
	
	
	
	@BeforeMethod(description = "Load the homepage of the website")
	public void setup(ITestResult result)
	{
		WebDriver lambdaDriver;
		if(isLambdaTest)
		{
			lambdaDriver=LambdaTestUtility.initilizeLabmdaTestSession(result.getMethod().getMethodName(),"Chrome");
			homepage=new HomePage(lambdaDriver);
		}
		
	homepage=new HomePage(CHROME,isHeadLess);//import static com.constant.Browser.*;
	
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
