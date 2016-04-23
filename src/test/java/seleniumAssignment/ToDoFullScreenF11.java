package seleniumAssignment;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.testng.annotations.Test;

import com.Practice.Base.Lib.BaseLib;
import com.relevantcodes.extentreports.LogStatus;

import atu.testng.reports.ATUReports;
import atu.testng.reports.logging.LogAs;
import atu.testng.reports.utils.Utils;
import atu.testng.selenium.reports.CaptureScreen;
import atu.testng.selenium.reports.CaptureScreen.ScreenshotOf;

public class ToDoFullScreenF11 extends BaseLib{
	
	private void setAuthorInfoForReports() {
		ATUReports.setAuthorInfo("Ashish Srivastava", Utils.getCurrentTime(),"1.0");
	}

	@Test
	public void fullScreenUsingRobotClass() throws AWTException, InterruptedException{
		
		setAuthorInfoForReports();
		
		logger = report.startTest("fullScreenUsingRobotClass");
		
		driver.get("http://google.com");
		logger.log(LogStatus.INFO, "Google application is launched.");
		ATUReports.add("Google application is launched.", LogAs.INFO, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_F11);
		robot.keyRelease(KeyEvent.VK_F11);
		logger.log(LogStatus.INFO, "Key F11 is pressed using Robot class to go to Full screen.");
		ATUReports.add("Key F11 is pressed using Robot class to go to Full screen.", LogAs.INFO, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		Thread.sleep(3000);
		robot.keyPress(KeyEvent.VK_F11);
		robot.keyRelease(KeyEvent.VK_F11);
		logger.log(LogStatus.INFO, "Key F11 is pressed using Robot class to go to normal screen.");
		ATUReports.add("Key F11 is pressed using Robot class to go to normal screen.", LogAs.INFO, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		
	} 
}
