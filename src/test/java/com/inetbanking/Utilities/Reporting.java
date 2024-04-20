package com.inetbanking.Utilities;

//listener class user to generate Extent report

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Reporting extends TestListenerAdapter{
	public WebDriver driver;
	public ExtentReports extent;
	public ExtentTest logger;
	public ExtentHtmlReporter htmlReporter ;
	
	
	public void onStart(ITestContext testContect)
	{
		String timestamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date()); //times tamp
		String repName = "Test-Report-"+timestamp+".html";
		
		
		htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir")+"/test-output/"+repName); //specify location
		htmlReporter.loadXMLConfig(System.getProperty("user.dir")+"/extent-config.xml");
		
		extent = new ExtentReports(); //create a object of extentreports
		
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("Host name", "localhost");
		extent.setSystemInfo("Environment", "QA");
		extent.setSystemInfo("user name", "Mahendra");
		
		htmlReporter.config().setDocumentTitle("Inetbanking Test Project");
		htmlReporter.config().setReportName("Functional Test Report");
		htmlReporter.config().setTheme(Theme.STANDARD);
	}
	
	public void onTestSuccess(ITestResult tr) 
	{
		logger = extent.createTest(tr.getName()); //create a new entry into report
		logger.log(Status.PASS, MarkupHelper.createLabel(tr.getName(), ExtentColor.GREEN)); //send the passed information
		
	}
	
	public void onTestFailure(ITestResult tr )
	{
		logger = extent.createTest(tr.getName()); //create a new entry into report
		logger.log(Status.FAIL, MarkupHelper.createLabel(tr.getName(), ExtentColor.RED)); //send the passed information
		
		String screenshotpath = System.getProperty("user.dir")+"/Screenshots/"+tr.getName()+".png";
		
		File f = new File (screenshotpath);
		
		if(f.exists())
		{
			try
			{
		      logger.fail("Screenshot is below:" + logger.addScreenCaptureFromPath(screenshotpath));
			}
			catch(IOException e)
			{
				e.printStackTrace();
			}
		}
	}
	
	public void onTestSkipped(ITestResult result) 
	{
	  logger = extent.createTest(result.getName());
	  logger.log(Status.SKIP, MarkupHelper.createLabel(result.getName(), ExtentColor.ORANGE));
		
	}
	
	
	public void onTestFinish()
	{
		extent.flush();
		
	}

}
