package com.ui.listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import com.constant.Env;
import com.utility.JSONUtility;

public class MyRetryAnalyzer implements IRetryAnalyzer{

	//private static final int MAX_NUMBER_OF_ATTEMPTS=Integer.parseInt(PropertiesUtil.readProperty(Env.QA, "MAX_NUMBER_OF_ATTEMPTS"));	//Read from properties
	private static final int MAX_NUMBER_OF_ATTEMPTS=JSONUtility.readJSON(Env.DEV).getMAX_NUMBER_OF_ATTEMPTS();
	
	private static int current_attempts=1;
	@Override
	public boolean retry(ITestResult result) {
		if(current_attempts<=MAX_NUMBER_OF_ATTEMPTS)
		{
			current_attempts++;
			return true;
		}
		return false;
	}

}
