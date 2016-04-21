package seleniumPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.Practice.Base.Lib.BaseLib;

import atu.testng.reports.ATUReports;
import atu.testng.reports.utils.Utils;

public class PageScroll extends BaseLib{
	
	public void setAuthorInfoReport(){
		ATUReports.setAuthorInfo("Ashish Srivastava", Utils.getCurrentTime(), "1.0");
	}
	
	@BeforeMethod
	public void openBrowser() throws InterruptedException{
	//	setAuthorInfoReport();				// Report's Author info.
		
		driver.get("http://flipkart.com");
		driver.manage().window().maximize();
		Thread.sleep(1500);
	}
	
	@Test(priority=1, enabled= true)
	public void scrollingToBottomofAPage() throws InterruptedException{
		setAuthorInfoReport();
		logger = report.startTest("Scroll to Bottom");
// Page Scrolling using JavascriptExecutor:-			(Working)
		JavascriptExecutor jse = ((JavascriptExecutor)driver);
		jse.executeScript("window.scroll(0,document.body.scrollHeight)");
		Thread.sleep(2000);
// page Scrolling up using Actions class:-				(Working)	
		Actions act = new Actions(driver);
		act.moveByOffset(0, 1000).click().perform();		// To move cursor from address bar to anywhere on main screen.
		act.keyDown(Keys.CONTROL).sendKeys(Keys.HOME).perform();
		Thread.sleep(2000);
// page scrolling down using actions class:-			(Working)
		act.keyDown(Keys.CONTROL).sendKeys(Keys.END).perform();
		Thread.sleep(2000);
		
		act.keyDown(Keys.LEFT_ALT).sendKeys(Keys.chord(Keys.SPACE, "n")).build().perform();
	}
	
	@Test(priority=2, enabled=false)
	public void scrollingToElementofAPage() throws InterruptedException{
		setAuthorInfoReport();
		logger = report.startTest("Scroll to Element");
// Page Scrolling using JavascriptExecutor:-
// Scroll till text:-								(Working)
		String xpathText = "//div[div[h2[text()='Discounts for You']]]/following-sibling::div//div[text()='Wrist Watches']";
		WebElement elementText = driver.findElement(By.xpath(xpathText));
		JavascriptExecutor jse = ((JavascriptExecutor)driver);
		jse.executeScript("arguments[0].scrollIntoView();", elementText);
		System.out.println( elementText.isDisplayed());
		Thread.sleep(2000);
// Scroll till image:-								(Working)
		String xpathImg = "//div[div[h2[text()='Discounts for You']]]/following-sibling::div//div[text()='Wrist Watches']/preceding-sibling::div[2]//div/img";
		WebElement elementImg = driver.findElement(By.xpath(xpathImg));
		jse.executeScript("arguments[0].scrollIntoView();", elementImg);
		System.out.println( elementText.isDisplayed());
		Thread.sleep(2000);
		
// Page scrolling using action class:-				(Working)
		Actions act = new Actions(driver);
		act.moveToElement(elementText).perform();
		Thread.sleep(2000);
		act.moveToElement(elementImg).perform();
		Thread.sleep(2000);
	}
	
	@Test(priority=3, enabled=false)
	public void scrollingByCoordinatesofAPage() throws InterruptedException{
		setAuthorInfoReport();
		logger = report.startTest("Scroll by coordinate");
// Page scrolling using JavascriptExecutor:-		(Working)
		JavascriptExecutor jse = ((JavascriptExecutor)driver);
		jse.executeScript("scrollBy(0,1000)");
		Thread.sleep(1000);
		jse.executeScript("scroll(0,2000)");
		Thread.sleep(1000);
		jse.executeScript("scroll(0,3000)");
		Thread.sleep(1000);
		jse.executeScript("scroll(0,-2000)");
		Thread.sleep(1000);
		jse.executeScript("scroll(-1000,0)");
	}
	
	@AfterMethod
	public void tearDown(){
		report.endTest(logger);
		report.flush();
		driver.close();
	}
	
	

}
