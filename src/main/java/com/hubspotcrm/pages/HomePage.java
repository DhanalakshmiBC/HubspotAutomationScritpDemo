package com.hubspotcrm.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hubspotcrm.base.TestBase;

public class HomePage extends TestBase  {
	
	Actions action;
	
	@FindBy(xpath="//div[@class='desktop-nav-left-container']")
	WebElement levtnavcontainer;
	
	@FindBy(xpath="//div[@class='navtools']")
	WebElement rightnavcontainer;
	
	@FindBy(xpath="//a[@id='nav-primary-home']")
	WebElement leftLogoClick;
	
	@FindBy(xpath="//a[@id='nav-primary-contacts-branch']")
	WebElement leftContactclick;
	
	@FindBy(xpath="//a[@id='nav-secondary-contacts']")
	WebElement subcontactclick;
	
	@FindBy(xpath="//a[@id='nav-secondary-companies']")
	WebElement subcompaniesclick;
	
	@FindBy(xpath="//a[@id='nav-secondary-activity']")
	WebElement subactivityclick;
	
	@FindBy(xpath="//img[@class=' nav-avatar ']")
	WebElement profileicon;
	
	@FindBy(xpath="//div[@class='user-info-name']")
	WebElement loggedusername;
	
	
	
	public HomePage()
	{
		PageFactory.initElements(driver, this);
		action=new Actions(driver);
	}
	
	public boolean leftnavVerify()
	{
		return levtnavcontainer.isDisplayed();
	}
	public boolean rightnavVerify()
	{
		return rightnavcontainer.isDisplayed();
	}
	
	public String logoVerify()
	{
		
		 leftLogoClick.click();
		 return driver.getCurrentUrl();
	}
	
	public String contactverify()
	{
		action.moveToElement(leftContactclick).click().build().perform();
		action.moveToElement(subcontactclick).click().build().perform();
		
		return driver.getCurrentUrl();
	}
	public String companiesurlverify()
	{
		action.moveToElement(leftContactclick).click().build().perform();
		action.moveToElement(subcompaniesclick).click().build().perform();
		
		return driver.getCurrentUrl();
	}
	
	public String activityurlverify()
	{
		action.moveToElement(leftContactclick).click().build().perform();
		action.moveToElement(subactivityclick).click().build().perform();
		
		return driver.getCurrentUrl();
	}
	
	public String verifyloggedusername()
	{
		profileicon.click();
		return loggedusername.getText();
	}
	
	
	
	
	

}
