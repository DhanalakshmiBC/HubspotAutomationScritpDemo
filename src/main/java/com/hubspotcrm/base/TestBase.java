package com.hubspotcrm.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.hubspotcrm.util.TestUtil;

public class TestBase {
	
	public static Properties prop;
	public static WebDriver driver;
	
	public TestBase()
	{
		try
		{
			prop=new Properties();
			FileInputStream fs=new FileInputStream("../HubspotAutomationScritpDemo/src/main/java/com/hubspotcrm/config/config.properties");
			
			//HubspotAutomationScritpDemo/src/main/java/com/hubspotcrm/config/config.properties
		    prop.load(fs);
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
	
	public void initialization()
	{
		if(prop.getProperty("browser").equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", prop.getProperty("chromedriverpath"));
			driver=new ChromeDriver();
		}
		else if(prop.getProperty("browser").equals("ff"))
		{
			System.setProperty("webdriver.gecko.driver", prop.getProperty("firefoxdriverpath"));
			driver=new FirefoxDriver();
		}
		
		driver.manage().deleteAllCookies();
		//driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_TIMEOUT, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
		
	}
	

}
