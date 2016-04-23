package seleniumPractice;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.Practice.Base.Lib.BaseLib;
import com.relevantcodes.extentreports.LogStatus;

import atu.testng.reports.ATUReports;
import atu.testng.reports.utils.Utils;
//@Listeners (com.Practice.Base.Lib.TestNGListener.class)
public class SwitchWindows extends BaseLib{
	public void setAuthorInfoReport(){
		ATUReports.setAuthorInfo("Ashish Srivastava", Utils.getCurrentTime(), "1.0");
	}
	
	@BeforeMethod
	public void reportSetup(){
		setAuthorInfoReport();
		logger = report.startTest("Switch Windows");
	}
	
	@Test(priority=1,enabled=true)
	public void switchWindows() throws InterruptedException{
		
	//	setAuthorInfoReport();
	//	logger = report.startTest("switchWindows");
		
		driver.get("http://flipkart.com");
		driver.manage().window().maximize();
		driver.navigate().refresh();
		Thread.sleep(3000);
		
// Scroll to the image and open product in new Window:-   (Open any two Product)
	// Open First Product:-	
		String xpathImg1 = "//div[div[h2[text()='Discounts for You']]]/following-sibling::div//div[text()='Wrist Watches']/preceding-sibling::div[2]//div/img";
		WebElement elementImg1 = driver.findElement(By.xpath(xpathImg1));
		Actions act = new Actions(driver);
		act.moveToElement(elementImg1).perform();		// We can remove this line, because in contextClick() we are giving WebElement.
		logger.log(LogStatus.INFO, "Scroll the screen to the first product.");
		Thread.sleep(1000);
		act.contextClick(elementImg1).perform();
		logger.log(LogStatus.INFO, "Right click on the first product.");
		Thread.sleep(1000);
		act.sendKeys("W").perform();
		logger.log(LogStatus.INFO, "Open link in new wondow.");
		Thread.sleep(5000);
	// Open Second Product:-
		String xpathText = "//h2[text()='Clothing for Women']";
		WebElement elementText = driver.findElement(By.xpath(xpathText));
		act.moveToElement(elementText).perform();
		logger.log(LogStatus.INFO, "Scroll the screen to the category of second product.");
		Thread.sleep(2000);
		String xpathImg2 = "//div[div[h2[text()='Clothing for Women']]]/following-sibling::div//div[text()='Ethnic Wear']/preceding-sibling::div[1]//div/img";
		if(driver.findElement(By.xpath(xpathImg2)).isDisplayed()){	
			logger.log(LogStatus.INFO, "Second Product found on main page");
			act.contextClick(driver.findElement(By.xpath(xpathImg2))).perform();
			logger.log(LogStatus.INFO, "Right click on the second product.");
			Thread.sleep(1000);
			act.sendKeys("W").perform();
			logger.log(LogStatus.INFO, "Open link in new wondow.");
			Thread.sleep(2000);
		}else{
			driver.findElement(By.xpath("//div[div[div[h2[text()='Clothing for Women']]]]//div[text()='›']")).click();
			logger.log(LogStatus.INFO, "Product not found on main page, so clicked on Arrow button.");
			Thread.sleep(1000);
			logger.log(LogStatus.INFO, "Product found on after clicking on Arrow button.");
			act.contextClick(driver.findElement(By.xpath(xpathImg2))).perform();
			logger.log(LogStatus.INFO, "Right click on the second product.");
			Thread.sleep(1000);
			act.sendKeys("W").perform();
			logger.log(LogStatus.INFO, "Open link in new wondow.");
			Thread.sleep(2000);
		}
		
// Capture Id's of all the Windows:-	
		Set<String> set = driver.getWindowHandles();
		Iterator<String> it = set.iterator();
		String parentId = it.next();
		String childId_1 = it.next();
		String childId_2 = it.next();
		logger.log(LogStatus.INFO, "Captured Window-Id for all the open windows.");
	// Switch to First Child Window:-	
		driver.switchTo().window(childId_1);
		logger.log(LogStatus.INFO, "Switched to First Child Window");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.name("pincode")).click();
		driver.findElement(By.name("pincode")).sendKeys("560075");
		driver.findElement(By.xpath("//input[@type='submit' and @value='OK']")).click();
		logger.log(LogStatus.INFO, "Entered Pincode and clicked on OK button on first Child window.");
		Thread.sleep(2000);
	// Switch to second child Window:-	
		driver.switchTo().window(childId_2);
		logger.log(LogStatus.INFO, "Switched to Second Child Window");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.name("pincode")).click();
		driver.findElement(By.name("pincode")).sendKeys("560075");
		driver.findElement(By.xpath("//input[@type='submit' and @value='OK']")).click();
		logger.log(LogStatus.INFO, "Entered Pincode and clicked on OK button on second Child window.");
		Thread.sleep(2000);
	// Switch to parent window:-	
		driver.switchTo().window(parentId);
		logger.log(LogStatus.INFO, "Switched to Parent Window");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//input[@placeholder='So, what are you wishing for today?']")).sendKeys("Byke");
		logger.log(LogStatus.INFO, "Entered some text on Parent window.");
	//	driver.findElement(By.xpath("//input[@type='submit' and @value='Search']")).click();
		Thread.sleep(2000);
		logger.log(LogStatus.PASS, "SwitchWindows method is pass.");
	//	report.endTest(logger);
	//	report.flush();
	}
	
	@AfterMethod
	public void tearDown(){
		report.endTest(logger);
		report.flush();
	//	driver.close();
	}

}
