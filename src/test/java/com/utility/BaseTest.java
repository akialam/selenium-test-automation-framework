package com.utility;

import static com.constant.Browser.CHROME;

import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeMethod;

import com.ui.pages.HomePage;
import com.ui.tests.LogInTestSuite;

public class BaseTest {

	Logger logger=LoggerUtility.getLogger(LogInTestSuite.class);
	protected HomePage homepage;//protected allows child classes such as LogInTestSuite to access it.
	@BeforeMethod(description = "Load the homepage of the website")
	public void setup()
	{
	homepage=new HomePage(CHROME,true);//import static com.constant.Browser.*;
	
	}
	public BrowserUtility getInstance()
	{
		return homepage;
	}
}
