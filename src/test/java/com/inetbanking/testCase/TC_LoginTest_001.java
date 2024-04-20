package com.inetbanking.testCase;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetBankingV1.PageObjects.LoginPage;

public class TC_LoginTest_001 extends BaseClass{
	
	

	@Test
	public void logintest() throws IOException 
	{
		
		LoginPage lp = new LoginPage(driver); 
		
		lp.setusername(username);
		log.info("entered username");
		
		lp.setpassword(password);
		log.info("entered password");
		
		lp.clickonloginbtn();
		log.info("click on login btn");
		
		
		
		String title = driver.getTitle();
		System.out.println(title);

		if(title.equals(title))
		{
			Assert.assertTrue(true);
			log.info("login test passed");
		}
		else
		{
			CaptureScreenshot(driver,"logintest");
			Assert.assertTrue(false);
			log.info("login test case failed...");
		}

	}



}
