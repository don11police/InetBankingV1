package com.inetbanking.testCase;

import java.io.IOException;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.inetBankingV1.PageObjects.LoginPage;
import com.inetbanking.Utilities.XLutils;

import junit.framework.Assert;

public class TC_LoginDDT_002 extends BaseClass {
	
	@Test(dataProvider = "LoginData")
	public void loginDDT(String user , String pwd) throws InterruptedException, IOException
	{
		LoginPage lp = new LoginPage(driver);
		
		lp.setusername(user);
		log.info("username provided");
		lp.setpassword(pwd);
		log.info("password provided");
		lp.clickonloginbtn();
		log.info("click on login button");
		
		Thread.sleep(3000);
		
		if(isalertpresent()==true)
		{
			CaptureScreenshot(driver,"loginDDT");
			Assert.assertTrue(false);
			log.warn("login failed");
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			
		}
		else
		{
			Assert.assertTrue(true);
			log.info("login pass");
			lp.clickonlogout();
			Thread.sleep(3000);
			driver.switchTo().alert().accept(); //close to logout alert
			driver.switchTo().defaultContent();
			
		}
		
		
		
	}
	
	public boolean isalertpresent() //user defined method created if alert is present or not
	{
		try
		{
			driver.switchTo().alert();
			return true;
		}
		catch(NoAlertPresentException e)
		{
			return false;
		}
		
	}
	@DataProvider(name="LoginData")
	String[][] getData() throws IOException
	{
		String path = "/home/lenovo/Desktop/inetBankingV1/src/test/java/com/inetbanking/TestData/LoginData.xlsx";
		
		int rownum = XLutils.getRowCount(path, "sheet1");
		int colcount = XLutils.getCellCount(path, "sheet1", 1);
		
		String logindata[][] = new String [rownum][colcount];
		
		for(int i=1; i<=rownum; i++)
		{
			for(int j=0; j<colcount; j++)
			{
				logindata[i-1][j]= XLutils.getCellData(path, "sheet1", i, j);
			}
		}
		
		return logindata;
		
	}

}
