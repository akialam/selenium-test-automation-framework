package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.constant.Browser;
import com.constant.Env;
import com.utility.BrowserUtility;
import com.utility.JSONUtility;

public final class HomePage extends BrowserUtility {
	
	/*public HomePage(String browserName) {
		super(browserName);//To call the Parent Class constructor from the child class constructor 
		// TODO Auto-generated constructor stub
		goToWebsite("https://automationpractice.techwithjatin.com/");//Java effectively treats it as:this.goToWebsite(url);Here, this refers to the current HomePage object.
	}
*/

	public HomePage(WebDriver driver) {
		super(driver);//To call the Parent Class constructor from the child class constructor 
		
		//goToWebsite(PropertiesUtil.readProperty(Env.QA, "URL"));//Properties file
		goToWebsite(JSONUtility.readJSON(Env.UAT).getUrl());//Json file
	}
	public HomePage(Browser browserName,boolean headless) {
		super(browserName,headless);//To call the Parent Class constructor from the child class constructor 
		
		//goToWebsite(PropertiesUtil.readProperty(Env.QA, "URL"));//Properties file
		goToWebsite(JSONUtility.readJSON(Env.UAT).getUrl());//Json file
	}
	private static final  By SIGN_IN_LINK_LOCATOR=By.xpath("//a[contains(text(),'Sign in')]");
	
	public LoginPage goToLoginPage()
	{	maximizeWindow();
		clickOn(SIGN_IN_LINK_LOCATOR);
		LoginPage loginPage=new LoginPage(getDriver());
		return loginPage;
	}
}
