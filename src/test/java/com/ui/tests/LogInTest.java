package com.ui.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.utility.BrowserUtility;

public class LogInTest {

	public static void main(String[] args) {
		
		WebDriver driver=new ChromeDriver();
		BrowserUtility bu=new BrowserUtility(driver);
		bu.goToWebsite("https://automationpractice.techwithjatin.com/");
		bu.maximizeWindow();
		
		//driver.findElement(By.xpath("//a[contains(text(),'Sign in')]")).click();
		By	signInLinkLocator=By.xpath("//a[contains(text(),'Sign in')]");
		bu.clickOn(signInLinkLocator);
		
		By emailTextBoxLocator=By.id("email");
		bu.enterText(emailTextBoxLocator, "nimepej424@koboywin.com");
		 
		By passwordTextBoxLocator=By.id("passwd");
		bu.enterText(passwordTextBoxLocator, "Password");
		
		By submitLocator=By.id("SubmitLogin");
		bu.clickOn(submitLocator);
		
		 

	}

}
