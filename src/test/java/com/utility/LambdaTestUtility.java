package com.utility;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class LambdaTestUtility {

	private static final String HUB_URL = "https://hub.lambdatest.com/wd/hub";
	private static ThreadLocal<WebDriver> driverLocal=new ThreadLocal<WebDriver>();
	private static ThreadLocal<DesiredCapabilities> capabilitiesLocal=new ThreadLocal<DesiredCapabilities>();
	
	public static WebDriver initilizeLabmdaTestSession(String testName,String BrowserName)
	{

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("browserName", BrowserName);
        capabilities.setCapability("browserVersion", "152");
        Map<String, Object> ltOptions = new HashMap();
        ltOptions.put("user","akimohd81");
        ltOptions.put("accessKey", "LT_dNADxRJJshUOIshTL8so2tr1dixAmHtvBIUeRn2M9OriZ33");
        ltOptions.put("build", "Selenium 4");
        ltOptions.put("name", testName);
        ltOptions.put("platformName", "Windows 10");
        ltOptions.put("seCdp", true);
        ltOptions.put("selenium_version", "latest");
        capabilities.setCapability("LT:Options", ltOptions);
        capabilitiesLocal.set(capabilities);
        WebDriver driver = null;
		try {
			driver = new RemoteWebDriver(new URL(HUB_URL), capabilitiesLocal.get());
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        driverLocal.set(driver);
        return driverLocal.get();
	}
	public static void quitSession()
	{
		if(driverLocal.get()!=null)
		{
			driverLocal.get().quit();
		}
	}
	
}
