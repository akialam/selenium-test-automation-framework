package com.utility;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.constant.Browser;

public class BrowserUtility1 {
	
	private WebDriver driver;
	//private static ThreadLocal<WebDriver> driver=new ThreadLocal<WebDriver>();//For thread safety and parallel testing.
	
	
	Logger logger=LoggerUtility.getLogger(this.getClass());//We can use this logger in any classes and we can get the logger for the particular methods and blocks.

	public WebDriver getDriver() {
		return driver;
	}

	public BrowserUtility1(WebDriver driver) {
		super();
		this.driver=driver;//intialize the instance variable driver
		
		
	}
	
	/*public BrowserUtility(String browserName)//
	{
		if(browserName.equalsIgnoreCase("Chrome"))
		{
			driver=new ChromeDriver();
		}
		else if(browserName.equalsIgnoreCase("Edge"))
		{
			driver=new EdgeDriver();
		}
		else
		{
			System.err.println("Invalide browser");
		}
	}
	*/
	public BrowserUtility1(Browser browserName)//using enum
	{
		logger.info("Trying to Launching the Browser "+browserName);
		if(browserName==Browser.CHROME)
		{
			driver=new ChromeDriver();
		}
		else if(browserName==Browser.EDGE)
		{
			driver=new EdgeDriver();
		}
		else if(browserName==Browser.FIREFOX)
		{
			driver=new FirefoxDriver();
		}
		else
		{
			System.err.println("Invalide browser");
		}
	}
	
	public void goToWebsite(String url)
	{
		logger.info("Trying to Launching the Website "+url);
		driver.get(url);
	}
	public void maximizeWindow()
	{
		logger.info("Maximize the Window screen for this Application");
		driver.manage().window().maximize();
		
		
	}
	public void clickOn(By locator)
	{
		
		WebElement signLinkWebElement=driver.findElement(locator);
		signLinkWebElement.click();
		
	}
	
	public void enterText(By locator,String textToEnter)
	{
		WebElement passwordTextBoxWebElement=driver.findElement(locator);
		passwordTextBoxWebElement.sendKeys(textToEnter);
	}
	public String getVisibleText(By locator)
	{
		WebElement visibleText=driver.findElement(locator);
		return visibleText.getText();
	}
	public void closedBrowser()
	{
		driver.quit();
	}
	
	public String takeScreenshots(String name)
	{
		TakesScreenshot screenshots=(TakesScreenshot) driver;
		File screenShotData=screenshots.getScreenshotAs(OutputType.FILE);
		String path=System.getProperty("user.dir")+"//screenshots"+name;
		File screenShotFile=new File(path);
		try {
			FileUtils.copyFile(screenShotData, screenShotFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return path;
		
	}

}
