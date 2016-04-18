package com.Practice.Base.Lib;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import atu.testng.reports.ATUReports;

public class BaseLib { 
	public static ExtentReports report;
	public static ExtentTest logger;
	public static WebDriver driver;
	
	@BeforeTest
	public void driverInitialization() throws IOException{
		
		/*File file = new File("../Practice/config.properties");
		FileInputStream fis = null;
		fis = new FileInputStream(file);
		Properties prop = new Properties();
		prop.load(fis);
		if(prop.getProperty("Browser")== "Firefox"){
			driver = new FirefoxDriver();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}else if (prop.getProperty("Browser")=="Chrome") {
			System.setProperty("webdriver.chrome.driver", "../Practice/src/test/resources/chromedriver.exe");
			driver = new ChromeDriver();
			
		}else if (prop.getProperty("Browser")=="IE") {
			System.setProperty("webdriver.ie.driver", "../Practice/src/test/resources/IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}*/
		
		report = new ExtentReports("D:\\CBT_Automation\\Workspace\\Practice\\Report\\Practice_ExtentReport\\Sample_ExtentReport.html", false);
//		logger = report.startTest("Practice Extent Report");
		
		System.setProperty("webdriver.chrome.driver", "../Practice/src/test/resources/chromedriver.exe");
		driver = new ChromeDriver();
		
//		logger.log(LogStatus.INFO, "Browser started ");
		
	//Set Property for ATU Reporter Configuration
		{
	    	System.setProperty("atu.reporter.config", "../Practice/src/test/java/atu.properties");

	    }
		ATUReports.setWebDriver(driver);
        setIndexPageDescription();
        
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	private void setIndexPageDescription() {
        ATUReports.indexPageDescription = "My Project Description";
 }
	
	@AfterTest
	public void tearDown(){
		BaseLib.report.endTest(BaseLib.logger);
		BaseLib.report.flush();
	//	driver.get("D:\\CBT_Automation\\Workspace\\Practice\\Report\\Practice_ExtentReport\\Sample_ExtentReport.html");
	}
}
