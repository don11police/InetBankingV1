package com.inetbanking.testCase;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.inetbanking.Utilities.ReadConfig;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.managers.ChromeDriverManager;


public class BaseClass {
	
	ReadConfig rc = new ReadConfig();
	public String baseurl = rc.Readapplicationurl();
	public String username = rc.Readusername();
	public String password = rc.Readpassword();
	
	public static WebDriver driver;
	public static Logger log ;
	
	
	@Parameters("browser")
	@BeforeMethod
	public void setup(String br)
	{
		
		
		if(br.equals("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		else if(br.equals("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			
		}
		else if(br.equals("ie"))
		{
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
			
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(1000,TimeUnit.SECONDS);
		driver.get(baseurl);
		
		log = Logger.getLogger("ebanking");
		PropertyConfigurator.configure("log4j.properties");
		
		
	    
		
	}
	
	@AfterClass
	public void teardown()
	{
		driver.quit();
	}
	
	public void CaptureScreenshot(WebDriver driver, String tname) throws IOException
	{
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir") + "/Screenshots/" +tname+ ".png");
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot taken");
	}
	
	public String Randomstring()
	{
		String gereratedstring = RandomStringUtils.randomAlphabetic(8);
		return gereratedstring;
	}
	
	public String randomeNum()
	{
		String generatenum = RandomStringUtils.randomNumeric(4);
		return generatenum;
	}

}
