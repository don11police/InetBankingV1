package com.inetBankingV1.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver ldriver;
	
	public LoginPage(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(name="uid") WebElement username;
	@FindBy(name="password") WebElement pass;
	@FindBy(name="btnLogin") WebElement btn;
	@FindBy(xpath="//a[normalize-space()='Log out']") WebElement logoutlnk;
	
	
	public void setusername(String uname)
	{
		username.sendKeys(uname);
	}
	
	public void setpassword(String password)
	{
		pass.sendKeys(password);
	}
	
	public void clickonloginbtn()
	{
		btn.click();
	}
	
	public void clickonlogout()
	{
		logoutlnk.click();
	}
	
	

}
