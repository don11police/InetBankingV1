package com.inetbanking.Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class ReadConfig {
	
	
	Properties pro;
	
	public ReadConfig()
	{
		File file = new File("./Configuration/Config.properties");
		
		try 
		{
			FileInputStream fis = new FileInputStream(file);
			
			pro = new Properties();
			
			pro.load(fis);
		}
		catch(Exception e)
		{
			System.out.println("Exception is " + e.getMessage());
		}
		
		}
	
	public String Readapplicationurl()
	{
		String url = pro.getProperty("URL");
		return url;
		
	}
	
	public String Readusername() 
	{
		String uname = pro.getProperty("Username");
		return uname;
	}
	
	public String Readpassword()
	{
		String pass = pro.getProperty("Password");
		return pass;
	}

}
