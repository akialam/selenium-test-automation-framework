package com.utility;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.latest.page.model.Screenshot;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import com.constant.Browser;
import com.ui.tests.LogInTestIListener;

public class BrowserUtility extends BaseTestLambdaTestNGParameters{
	
	//private WebDriver driver;
	private static ThreadLocal<WebDriver> driver=new ThreadLocal<WebDriver>();//For thread safety and parallel testing.
	
	
	Logger logger=LoggerUtility.getLogger(this.getClass());//We can use this logger in any classes and we can get the logger for the particular methods and blocks.

	public WebDriver getDriver() {
		return driver.get();
	}

	public BrowserUtility(WebDriver driver) {
		super();
		this.driver.set(driver);//initialize the instance variable driver
		
		
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
	public BrowserUtility(Browser browserName)//using enum
	{
		logger.info("Trying to Launching the Browser "+browserName);
		if(browserName==Browser.CHROME)
		{
			driver.set(new ChromeDriver());
		}
		else if(browserName==Browser.EDGE)
		{
			driver.set(new EdgeDriver());
		}
		else if(browserName==Browser.FIREFOX)
		{
			driver.set(new FirefoxDriver());
		}
		else
		{
			System.err.println("Invalide browser");
		}
	}
	public BrowserUtility(Browser browserName,boolean headless)//using enum
	{
		logger.info("Trying to Launching the Browser "+browserName);
		if(browserName==Browser.CHROME)
		{
			ChromeOptions options=new ChromeOptions();
			if( headless)
			{
			options.addArguments("--headless=old");//Headless
			}
			options.addArguments("--window-size=1920,1080");
			driver.set(new ChromeDriver(options));
		}
		else if(browserName==Browser.EDGE && headless)
		{
			EdgeOptions options=new EdgeOptions();
			options.addArguments("--headless=old");//Headless
			options.addArguments("--window-size=1920,1080");
			driver.set(new EdgeDriver(options));
		}
		else if(browserName==Browser.FIREFOX && headless)
		{
			FirefoxOptions options=new FirefoxOptions();
			options.addArguments("--headless=old");//Headless
			options.addArguments("--window-size=1920,1080");
			driver.set(new FirefoxDriver(options));
		}
		else
		{
			System.err.println("Invalide browser");
		}
	}
	
	public void goToWebsite(String url)
	{
		logger.info("Trying to Launching the Website "+url);
		driver.get().get(url);
	}
	public void maximizeWindow()
	{
		logger.info("Maximize the Window screen for this Application");
		driver.get().manage().window().maximize();
		
		
	}
	public void clickOn(By locator)
	{
		
		WebElement signLinkWebElement=driver.get().findElement(locator);
		signLinkWebElement.click();
		
	}
	
	public void enterText(By locator,String textToEnter)
	{
		WebElement passwordTextBoxWebElement=driver.get().findElement(locator);
		passwordTextBoxWebElement.sendKeys(textToEnter);
	}
	public String getVisibleText(By locator)
	{
		WebElement visibleText=driver.get().findElement(locator);
		return visibleText.getText();
	}
	public void closedBrowser()
	{
		driver.get().quit();
	}
	
	public String takeScreenshots(String name)
	{
		TakesScreenshot screenshots=(TakesScreenshot) driver.get();
		File screenShotData=screenshots.getScreenshotAs(OutputType.FILE);
		Date date=new Date();
		SimpleDateFormat datefomate=new SimpleDateFormat("HH-mm-ss");
		String timeStamp=datefomate.format(date);
		//String path=System.getProperty("user.dir")+"//screenshots"+name+"-"+timeStamp+".png";
		String path = System.getProperty("user.dir") + "//screenshots//" + name +"-"+timeStamp+ ".png";
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
