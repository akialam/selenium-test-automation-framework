package com.ui.tests;

import static com.constant.Browser.CHROME;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ui.pages.HomePage;
import com.ui.pojo.User;

public class LogInTest3 {

	/*public static void main(String[] args) {
		
		//WebDriver driver=new ChromeDriver();
		//HomePage homepage=new HomePage("Chrome");
		//HomePage homepage=new HomePage(Browser.CHROME);//import com.constant.Browser;
		HomePage homepage=new HomePage(CHROME);//import static com.constant.Browser.*;
		String userName=homepage.goToLoginPage().doLoginWith("nimepej424@koboywin.com", "Password").getUserName();
		System.out.println(userName);
		}
*/
//With TESTNG
	
	HomePage homepage;
	@BeforeMethod(description = "Load the homepage of the website")
	public void setup()
	{
	homepage=new HomePage(CHROME);//import static com.constant.Browser.*;
	
	}
	
	@Test(description ="Varifies that the valid user is able to access into the application",groups= {"e2e","sanity"},dataProviderClass = com.ui.dataproviders.LoginDataProvider.class,dataProvider = "LoginExcelTestDataProvider")
	public void loginTest(User user)
	{
		
		String userName=homepage.goToLoginPage().doLoginWith(user.getEmailAddress(), user.getPassword()).getUserName();
		
		Assert.assertEquals(userName, "Aaquib Alam");
		homepage.closedBrowser();
		
	}
	
	
	
}
