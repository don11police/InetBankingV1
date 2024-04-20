package com.inetbanking.testCase;

import java.io.IOException;
import org.testng.annotations.Test;

import com.inetBankingV1.PageObjects.AddNewCustomer;
import com.inetBankingV1.PageObjects.LoginPage;

import junit.framework.Assert;

public class TC_AddNewCustomer_003 extends BaseClass{
	
	
	@Test
	public void AddCustomer() throws InterruptedException, IOException
	{
		LoginPage lp = new LoginPage(driver);
		lp.setusername(username);
		lp.setpassword(password);
		lp.clickonloginbtn();
		
		Thread.sleep(3000);
		
	AddNewCustomer ac = new AddNewCustomer(driver);
		
		ac.clickOnAddNewCustomerLink();
		ac.EnterName("Akshat Gupta");
		ac.SelectGender();
		ac.SelectDOB("10", "02", "1992");
		Thread.sleep(3000);
		ac.EnterAddress("India");
		ac.EnterCity("Gurgaon");
		ac.EnterState("Haryana");
		ac.EnterPincode("444311");
		ac.EnterMobileNumber("3333344487");
		
		String randomemail = Randomstring()+"@gmail.com";
		ac.EnterEmailID(randomemail);
		
		ac.EnterPassword("pass@123");
		ac.clickonSubmitbtn();
		
		Thread.sleep(3000);
		
		log.info("Add new customer page validation is started....");
		
		boolean result = driver.getPageSource().contains("Customer Registered Successfully!!!");
		
		if(result==true)
		{
			Assert.assertTrue(true);
			log.info("Add new customer test case is passed....");
		}
		else
		{
			
			CaptureScreenshot(driver, "AddCustomer");
			Assert.assertTrue(false);
			log.info("Add new customer test case is failed....");
			
		}
		
	}
	
	

}
