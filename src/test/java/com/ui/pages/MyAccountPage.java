package com.ui.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.utility.BrowserUtility;

public class MyAccountPage extends BrowserUtility {
	
	private static final By USER_NAME_LOCATOR=By.xpath("//a[@title='View my customer account']");

	public MyAccountPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	public String getUserName()
	{
		//return getVisibleText(USER_NAME_LOCATOR);
		
		 WebDriverWait wait =
		            new WebDriverWait(getDriver(), Duration.ofSeconds(10));

		    return wait.until(
		            ExpectedConditions.visibilityOfElementLocated(USER_NAME_LOCATOR)
		    ).getText();
		
	}
	

}
