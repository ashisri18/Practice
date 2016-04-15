package seleniumPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.Practice.Base.Lib.BaseLib;
import com.relevantcodes.extentreports.LogStatus;

import atu.testng.reports.ATUReports;
import atu.testng.reports.logging.LogAs;
import atu.testng.reports.utils.Utils;
import atu.testng.selenium.reports.CaptureScreen;
import atu.testng.selenium.reports.CaptureScreen.ScreenshotOf;
@Listeners (com.Practice.Base.Lib.TestNGListener.class)
public class AutoIT extends BaseLib{
	
	private void setAuthorInfoForReports() {
		   ATUReports.setAuthorInfo("Ashish Srivastava", Utils.getCurrentTime(),"1.0");
		}
	
	@Test(priority=1,enabled=true)
	public void uploadFile() throws Exception{
		setAuthorInfoForReports();
		logger = report.startTest("AutoIT");
		driver.get("http://gmail.com");
		driver.manage().window().maximize();
		logger.log(LogStatus.INFO, "Gmail application launch.");
		Thread.sleep(2000);
		System.out.println("Enter Email Id");
		driver.findElement(By.xpath("//input[@placeholder='Enter your email']")).sendKeys("ashish12psitsrivastava");
		driver.findElement(By.id("next")).click();
		logger.log(LogStatus.INFO, "Email Id entered.");
		Thread.sleep(2000);
		System.out.println("Enter Password");
		driver.findElement(By.xpath("//span[contains(text(),'Stay signed in')]")).click();
		logger.log(LogStatus.INFO, "Check box unchecked.");
		Thread.sleep(2000);
		driver.findElement(By.id("Passwd")).sendKeys("jai$sri$ram");
		driver.findElement(By.id("signIn")).click();
		logger.log(LogStatus.INFO, "Password entered.");
		Thread.sleep(5000);
		WebElement element= driver.findElement(By.xpath("//div/div[contains(text(),'COMPOSE')]"));
		element.click();
		logger.log(LogStatus.INFO, "Clicked on COMPOSE.");
		ATUReports.add("Warning Step", LogAs.WARNING,new CaptureScreen(element));
		driver.findElement(By.name("to")).sendKeys("ashi.sri.18@gmail.com");
		driver.findElement(By.name("subjectbox")).sendKeys("File Upload using AutoIt");
		logger.log(LogStatus.INFO, "mail id and subject entered.");
		driver.findElement(By.xpath("//div[@data-tooltip='Attach files']")).click();
		Thread.sleep(2000);
		Runtime.getRuntime().exec("D:\\CBT_Automation\\Ashish\\AutoIt Script\\AutoIt Script to FileUpload.exe");
		Thread.sleep(3000);
		logger.log(LogStatus.INFO, "File uploaded using AutoIt.");
	//	driver.findElement(By.xpath("//div[contains(text(),'Send')]")).click();
		
		driver.findElement(By.xpath("//a[@title='Google Account: Ashish Srivastava   (ashi.sri.18@gmail.com)']")).click();
		driver.findElement(By.xpath("//a[text()='Sign out']")).click();
		logger.log(LogStatus.INFO, "Logout Successfully.");
		Thread.sleep(2000);
		logger.log(LogStatus.PASS, "Upload file method is Pass." );
		ATUReports.add("Fail step", LogAs.FAILED, new CaptureScreen(ScreenshotOf.DESKTOP));
	}
	
	
}
