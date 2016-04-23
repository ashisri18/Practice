package com.Practice.Base.Lib;

import java.io.File;
import java.io.FileInputStream;
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
import atu.testng.reports.ATUReports;

public class BaseLib { 
	public static ExtentReports report;
	public static ExtentTest logger;
	public static WebDriver driver;
	public static Properties prop ;
	
	@BeforeTest
	public void driverInitialization() throws IOException{
		
		File file = new File("../Practice/config.properties");
		FileInputStream fis = null;
		fis = new FileInputStream(file);
		prop = new Properties();
		prop.load(fis);
		if(prop.getProperty("Browser").equalsIgnoreCase("Firefox")){
			driver = new FirefoxDriver();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}else if (prop.getProperty("Browser").equalsIgnoreCase("Chrome")) {
			System.setProperty("webdriver.chrome.driver", "../Practice/src/test/resources/chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}else if (prop.getProperty("Browser").equalsIgnoreCase("ie")){
			System.setProperty("webdriver.ie.driver", "../Practice/src/test/resources/IEDriverServer.exe");
			driver = new InternetExplorerDriver();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}
	// create object for ExtentReports class.	
		report = new ExtentReports("../Practice/Report/Practice_ExtentReport/Sample_ExtentReport.html", false);

		
	//Set Property for ATU Reporter Configuration
		{
	    	System.setProperty("atu.reporter.config", "../Practice/src/test/java/atu.properties");

	    }
		ATUReports.setWebDriver(driver);
        setIndexPageDescription();
        
	}
	
	private void setIndexPageDescription() {
        ATUReports.indexPageDescription = "Selenium Practice Project";
 }
	
	@AfterTest
	public void tearDown(){
		driver.quit();
	
	
		driver.get("../Practice/Report/Practice_ExtentReport/Sample_ExtentReport.html");
	}
}
