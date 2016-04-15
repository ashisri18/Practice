package seleniumPractice;

import org.openqa.selenium.JavascriptExecutor;
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
public class JScriptExecutor extends BaseLib{
	
	private void setAuthorInfoForReports() {
		ATUReports.setAuthorInfo("Ashish Srivastava", Utils.getCurrentTime(),"1.0");
	}
	
	@Test
	public void jScriptExecutorTest() throws InterruptedException{
		
		setAuthorInfoForReports();
		
		logger = report.startTest("jScriptExecutorTest");
		logger.log(LogStatus.INFO, "Practice to use jScriptExecutor.");
		driver.get("http://gmail.com");
		driver.manage().window().maximize();
		logger.log(LogStatus.INFO, "Gamil Application launched.");
		ATUReports.add("INfo Step", LogAs.INFO, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		String jcode = "document.getElementById('Email').value='ashi.sri.18@gmail.com'";
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript(jcode);
		logger.log(LogStatus.INFO, "Email id entered using JavascriptExecutor.");;
		String jCode1 = "document.getElementById('next').click()";
		jse.executeScript(jCode1);
		logger.log(LogStatus.INFO, "Clicked on NEXT button using JavascriptExecutor.");
		Thread.sleep(2000);
		String jCode2 = "document.getElementById('PersistentCookie').click()";
		jse.executeScript(jCode2);
		logger.log(LogStatus.INFO, "Unchecked check-box using JavascriptExecutor.");
	
		
		
		 //Creating the Javascriptexecutor interface object by Type casting
		   JavascriptExecutor js = (JavascriptExecutor)driver;
		  //Fetching the Domain Name 
		  String sDomain = js.executeScript("return document.domain;").toString();
		  System.out.println("Domain = "+sDomain);
		  //Fetching the URL 
		  String sURL = js.executeScript("return document.URL;").toString();
		  System.out.println("URL = "+sURL);
		  //Fetching the Title
		  String sTitle = js.executeScript("return document.title;").toString();
		  System.out.println("Title = "+sTitle);
		  //Vertical scroll - down by 200  pixels
		  js.executeScript("window.scrollBy(0,200)");
		  System.out.println("Successfully did the vertical scroll by 200px");
		  logger.log(LogStatus.PASS, "useKeyboard method is Pass." );
	}
	
	
}
