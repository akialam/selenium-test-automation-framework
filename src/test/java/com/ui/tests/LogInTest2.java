package com.ui.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.ui.pages.HomePage;
import com.ui.pages.LoginPage;
import com.utility.BrowserUtility;

public class LogInTest2 {

	public static void main(String[] args) {
		
		WebDriver driver=new ChromeDriver();
		//HomePage homepage=new HomePage(driver);
		HomePage homepage=new HomePage("chrome");
		LoginPage loginpage= homepage.goToLoginPage();
		loginpage.doLoginWith("nimepej424@koboywin.com", "Password");
		
		
		
		 

	}

}
