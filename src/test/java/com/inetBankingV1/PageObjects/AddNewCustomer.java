package com.inetBankingV1.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddNewCustomer {

WebDriver ldriver;
	
	public AddNewCustomer(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(xpath="//a[contains(text(),'New Customer')]") WebElement link;
	@FindBy(xpath="//Input[@name='name']") WebElement name;
	@FindBy(xpath="//input[@value='m']") WebElement radiobtn;
	@FindBy(xpath="//input[@id='dob']") WebElement dob;
	@FindBy(xpath="//textarea[@name='addr']") WebElement address;
	@FindBy(xpath="//input[@name='city']") WebElement city;
	@FindBy(xpath="//input[@name='state']") WebElement state;
	@FindBy(xpath="//input[@name='pinno']") WebElement pincode;
	@FindBy(xpath="//input[@name='telephoneno']") WebElement telephone;
	@FindBy(xpath="//input[@name='emailid']") WebElement emailid;
	@FindBy(xpath="//input[@name='password']") WebElement password;
	@FindBy(xpath="//input[@name='sub']") WebElement subbtn;

	
	public void clickOnAddNewCustomerLink()
	{
		link.click();
	}
	
	public void EnterName(String CustomerName)
	{
		name.sendKeys(CustomerName);
	}
	
	public void SelectGender()
	{
		radiobtn.click();
	}
	
	public void SelectDOB(String dd,String mm, String yy)
	{
		dob.sendKeys(dd);
		dob.sendKeys(mm);
		dob.sendKeys(yy);
	}
	
	public void EnterAddress(String addre)
	{
		address.sendKeys(addre);
	}
	
	public void EnterCity(String cityname)
	{
		city.sendKeys(cityname);
	}
	
	public void EnterState(String statename)
	{
		state.sendKeys(statename);
	}
	
	public void EnterPincode(String pin)
	{
		pincode.sendKeys(String.valueOf(pin));
	}
	
	public void EnterMobileNumber(String mobile) {
		
		telephone.sendKeys(mobile);
	}
	
	public void EnterEmailID(String email)
	{
		emailid.sendKeys(email);
	}
	
	public void EnterPassword(String pwd)
	{
		password.sendKeys(pwd);
	}
	
	public void clickonSubmitbtn() {
		
		subbtn.click();
	}
	
}
