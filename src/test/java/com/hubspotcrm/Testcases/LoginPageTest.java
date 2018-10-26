package com.hubspotcrm.Testcases;

import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.hubspotcrm.base.TestBase;
import com.hubspotcrm.pages.LoginPage;

public class LoginPageTest extends TestBase{
	
	LoginPage loginpage;
	
	public LoginPageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setup()
	{
		initialization();
		loginpage=new LoginPage();
	}
	
	@Test
	public void loginverifyTest()
	{
		loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		Assert.assertEquals(loginpage.verifyLoginPageTitle(), "HubSpot Login");
	}
	
	@Test(priority=2)
	public void verifyPasswordTest()
	{
		loginpage.clickShowpassword("deepsy@gmail.com", "123456");
	}
	@Test(priority=3)
	public void verifyLinksTest()
	{
		loginpage.verifyForgotPasswordLink();
		System.out.println("Forgot Password Link is displayed:"+loginpage.verifyForgotPasswordLink());
		loginpage.verifyLoginPageTitle();
		System.out.println("LoginPage title is displayed:"+loginpage.verifyLoginPageTitle());
		loginpage.verifysignupLink();
		System.out.println("Signup link is displayed:"+loginpage.verifysignupLink());
		loginpage.verifyshowpasswordLink();
		System.out.println("show password link:"+loginpage.verifyshowpasswordLink());
		loginpage.verifycheckBox();
		System.out.println("check box is selected:"+loginpage.verifycheckBox());
	}
	
	@Test(priority=4)
	public void verifyErrormessageTest()
	{
		loginpage.verifyErrorMessage("deepsy@gmail.com", "123456");
		
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			FileHandler.copy(src, new File("/Users/deepika/Desktop/My_Project/Hubspot_Demo/screenshot/eroormsg.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@AfterMethod()
	public void teardown()
	{
		driver.quit();
	}

}
