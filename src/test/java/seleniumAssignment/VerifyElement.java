package seleniumAssignment;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.Practice.Base.Lib.BaseLib;

public class VerifyElement extends BaseLib{
	
	@Test
	public void UsingFindElementMethod() throws InterruptedException, AWTException{
		driver.get("http://google.com");
		driver.manage().window().maximize();
		driver.findElement(By.id("lst-ib")).click();
		driver.findElement(By.id("lst-ib")).sendKeys("flipkart",Keys.ENTER);
		Thread.sleep(2000);
		Actions act = new Actions(driver);
		WebElement wb = driver.findElement(By.xpath("//h3/a[text()='Flipkart']"));
		
//  Open link in New Tab.		
		/*act.sendKeys(Keys.TAB).perform();
		Thread.sleep(500);
		act.sendKeys(Keys.TAB).perform();
		Thread.sleep(500);
		act.sendKeys(Keys.TAB).perform();
		Thread.sleep(500);
		act.sendKeys(Keys.TAB).perform();
		Thread.sleep(500);
		act.sendKeys(Keys.CONTROL).perform();
		act.sendKeys(Keys.ENTER).perform();
		Thread.sleep(2000);
	//	********   OR     *****  */
		
		act.sendKeys(Keys.CONTROL).perform();
		wb.click();
		Thread.sleep(2000);
		
//  Minimize and Maximize windows using Robot class.	
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_WINDOWS);
		robot.keyPress(KeyEvent.VK_D);
		robot.keyRelease(KeyEvent.VK_D);
		robot.keyRelease(KeyEvent.VK_WINDOWS);
		Thread.sleep(2000);
		robot.keyPress(KeyEvent.VK_WINDOWS);
		robot.keyPress(KeyEvent.VK_D);
		robot.keyRelease(KeyEvent.VK_D);
		robot.keyRelease(KeyEvent.VK_WINDOWS);
		Thread.sleep(2000);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_N);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_N);
		Thread.sleep(2000);
		driver.get("http://gmail.com");
		
		
	}
	
	 
}
