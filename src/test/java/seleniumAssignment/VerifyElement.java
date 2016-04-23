package seleniumAssignment;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
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
		
//  Open link in New Tab.	(Using Ctrl+click)			
		Actions act = new Actions(driver);
		WebElement wb = driver.findElement(By.xpath("//h3/a[text()='Flipkart']"));
		act.sendKeys(wb, Keys.CONTROL).perform();
		wb.click();
		Thread.sleep(2000);
		System.out.println("Link opened in new tab using ctrl+click");
		
	//		********   OR     *****  	
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
		Thread.sleep(2000);*/
		
// Open Link in new tab using Right click and click on open link in new Tab(or pass "T").
		act.contextClick(wb).perform();
		Thread.sleep(1000);
		act.sendKeys("T").perform();
		
// Open Link in new tab using Right click, click on right arrow and press Enter.
		act.contextClick(wb).perform();
		Thread.sleep(1000);
		act.sendKeys(Keys.ARROW_RIGHT).sendKeys(Keys.ENTER).build().perform();		// We can remove build() function.
		
// Open Link in new tab using middle button(scroll button) of mouse.		(Not Working)
		act.sendKeys(wb, Keys.SHIFT).perform();
	//	wb.click();
		Thread.sleep(2000);
		System.out.println("Link opened in new tab by clicking on scroll button of mouse.");

// open a link in new browser using (shift+click)
		act.sendKeys(wb, Keys.SHIFT).perform();
//		wb.click();
		Thread.sleep(2000);
		System.out.println("Link opened in new browser using shift+click");
//  Minimize and Maximize windows using shortcut (windows+d) and Robot class.	
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
		
//  Open a blank new browser. (ctrl+n)		
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_N);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_N);
		Thread.sleep(2000);
		driver.get("http://gmail.com");
		
		
	}
	
	 
}
