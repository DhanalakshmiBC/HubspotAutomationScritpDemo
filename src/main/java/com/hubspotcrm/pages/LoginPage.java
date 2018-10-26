package com.hubspotcrm.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.hubspotcrm.base.TestBase;

public class LoginPage extends TestBase{
	
	WebDriverWait wait;
	Actions action;
	
	@FindBy(id="username")
	WebElement usernametab;
	
	@FindBy(id="password")
	WebElement passwordtab;
	
	@FindBy(id="loginBtn")
	WebElement loginbutton;
	
	@FindBy(xpath="//i18n-string[text()='Forgot my password']")
	WebElement forgotPasswordLink;
	
	@FindBy(xpath="//span[text()='Show Password']")
	WebElement showpasswordLink;
	
	@FindBy(xpath="//i18n-string[text()='Sign up']")
	WebElement signupLink;
	
	@FindBy(xpath="//i18n-string[text()='Privacy Policy']")
	WebElement privacyPolicy;
	
	@FindBy(xpath="//input[@class='sr-only private-checkbox__input']")
	WebElement checkbox;
	
	@FindBy(xpath="//h2[@class='private-heading-5 private-alert__title']")
	WebElement errorMessage;
	
	public LoginPage()
	{
		PageFactory.initElements(driver, this);
		wait=new WebDriverWait(driver,30);
		action=new Actions(driver);
		
	}
	
	public HomePage login(String un,String pw)
	{
		action.moveToElement(usernametab).click().sendKeys(un).build().perform();
		action.moveToElement(passwordtab).click().sendKeys(pw).build().perform();
		action.moveToElement(loginbutton).click().build().perform();
		//usernametab.sendKeys(un);
		//passwordtab.sendKeys(pw);
		//loginbutton.click();
		return new HomePage();
	}
	
	/*public String verifyHomePageTitle()
	{
		wait.until(ExpectedConditions.titleContains("Reports dashboard"));
		return driver.getTitle();
	}*/
	
	public String verifyLoginPageTitle()
	{
		return driver.getTitle();
	}
	
	public boolean verifyForgotPasswordLink()
	{
		return forgotPasswordLink.isDisplayed();
	}
	public boolean verifyshowpasswordLink()
	{
		return showpasswordLink.isDisplayed();
	}
	
	public void clickShowpassword(String un,String pw)
	{
		action.moveToElement(usernametab).click().sendKeys(un).build().perform();
		action.moveToElement(passwordtab).click().sendKeys(pw).build().perform();
		showpasswordLink.click();
		System.out.println("password is:"+passwordtab.getAttribute("value"));
	}
	
	public boolean verifysignupLink()
	{
		return signupLink.isDisplayed();
	}
	
	public boolean verifyprivacyPolicy()
	{
		return privacyPolicy.isDisplayed();
	}
	public boolean verifycheckBox()
	{
		return checkbox.isSelected();
	}
	
	public void verifyErrorMessage(String un,String pw)
	{
		action.moveToElement(usernametab).click().sendKeys(un).build().perform();
		action.moveToElement(passwordtab).click().sendKeys(pw).build().perform();
		action.moveToElement(loginbutton).click().build().perform();
		errorMessage.isDisplayed();
		
		System.out.println("error message is displayed:"+errorMessage.isDisplayed());
		
	}
	
	
	

}
