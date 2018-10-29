package com.hubspotcrm.Testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.hubspotcrm.base.TestBase;
import com.hubspotcrm.pages.HomePage;
import com.hubspotcrm.pages.LoginPage;

public class HomePageTest extends TestBase{
	
	HomePage homepage;
	LoginPage loginpage;
	
	
	public HomePageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setup()
	{
		initialization();
		loginpage=new LoginPage();
		homepage=new HomePage();
		homepage=loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		
	}
	
	@Test
	public void verifylogourlTest()
	{	
		Assert.assertEquals(homepage.logoVerify(), "https://app.hubspot.com/reports-dashboard/5068902");
	}
	@Test
	public void verifycontacturlTest()
	{
		Assert.assertEquals(homepage.contactverify(), "https://app.hubspot.com/contacts/5068902/contacts/list/view/all/?");
	}
	@Test
	public void verifycompaniesurlTest()
	{
		Assert.assertEquals(homepage.companiesurlverify(), "https://app.hubspot.com/contacts/5068902/companies");
	}
	@Test
	public void verifyactivityurlTest()
	{
		Assert.assertEquals(homepage.activityurlverify(), "https://app.hubspot.com/activity-feed/5068902/view");
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	

}
