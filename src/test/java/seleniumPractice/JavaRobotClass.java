package seleniumPractice;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import org.openqa.selenium.By;
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
public class JavaRobotClass extends BaseLib{
	
	private void setAuthorInfoForReports() {
		ATUReports.setAuthorInfo("Ashish Srivastava", Utils.getCurrentTime(),"1.0");
	}
	
	@Test(priority=1, enabled=true)
	public void useKeyboard() throws AWTException, InterruptedException{
		
		setAuthorInfoForReports();
		
		logger = report.startTest("useKeyboard");
		driver.get("http://gmail.com");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//input[@placeholder='Enter your email']")).click();
		Thread.sleep(2000);
		System.out.println("Enter Email Id");
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_A);
		robot.keyRelease(KeyEvent.VK_A);
		robot.keyPress(KeyEvent.VK_S);
		robot.keyRelease(KeyEvent.VK_S);
		robot.keyPress(KeyEvent.VK_H);
		robot.keyRelease(KeyEvent.VK_H);
		robot.keyPress(KeyEvent.VK_I);
		robot.keyRelease(KeyEvent.VK_I);
		robot.keyPress(KeyEvent.VK_DECIMAL);
		robot.keyRelease(KeyEvent.VK_DECIMAL);
		robot.keyPress(KeyEvent.VK_S);
		robot.keyRelease(KeyEvent.VK_S);
		robot.keyPress(KeyEvent.VK_R);
		robot.keyRelease(KeyEvent.VK_R);
		robot.keyPress(KeyEvent.VK_I);
		robot.keyRelease(KeyEvent.VK_I);
		robot.keyPress(KeyEvent.VK_DECIMAL);
		robot.keyRelease(KeyEvent.VK_DECIMAL);
		robot.keyPress(KeyEvent.VK_1);
		robot.keyRelease(KeyEvent.VK_1);
		robot.keyPress(KeyEvent.VK_8);
		robot.keyRelease(KeyEvent.VK_8);
		Thread.sleep(1000);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(1000);
		System.out.println("Enter Password");
		driver.findElement(By.xpath("//span[contains(text(),'Stay signed in')]")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("Passwd")).sendKeys("");
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(2000);
		logger.log(LogStatus.PASS, "useKeyboard method is Pass." );
		ATUReports.add("useKeyboard method is Pass.", LogAs.PASSED, new CaptureScreen(ScreenshotOf.DESKTOP));
		
	}
	
	@Test(priority=2,enabled=true)
	public void useMouse() throws AWTException, InterruptedException {
		System.out.println("Hi");
		Robot robot = new Robot();
		robot.mouseMove(125, 30);
		robot.mousePress(InputEvent.BUTTON1_MASK);
		robot.mouseRelease(InputEvent.BUTTON1_MASK);
		robot.delay(500);
		Thread.sleep(2000);
		System.out.println("Bye");
	}
	
	
	@Test(priority=3,enabled=false)
	public void downloadFile(){
		
	}
	
	
}
