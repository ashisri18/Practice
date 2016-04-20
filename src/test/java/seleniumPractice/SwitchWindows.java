package seleniumPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import com.Practice.Base.Lib.BaseLib;

import atu.testng.reports.ATUReports;
import atu.testng.reports.utils.Utils;

public class SwitchWindows extends BaseLib{
	public void setAuthorInfoReport(){
		ATUReports.setAuthorInfo("Ashish Srivastava", Utils.getCurrentTime(), "1.0");
	}
	
	@Test(priority=1,enabled=true)
	public void switchWindows() throws InterruptedException{
		setAuthorInfoReport();
		logger = report.startTest("switchWindows");
		
		driver.get("http://flipkart.com");
		driver.manage().window().maximize();
		
// Scroll to the image and open product in new Tab:-   (Open any two Product)
		String xpathImg1 = "//div[div[h2[text()='Discounts for You']]]/following-sibling::div//div[text()='Wrist Watches']/preceding-sibling::div[2]//div/img";
		WebElement elementImg1 = driver.findElement(By.xpath(xpathImg1));
		Actions act = new Actions(driver);
		act.moveToElement(elementImg1).perform();		// We can remove this line, because in contextClick() we are giving WebElement.
		Thread.sleep(1000);
		act.contextClick(elementImg1).perform();
		Thread.sleep(1000);
		act.sendKeys("T").perform();
		Thread.sleep(2000);
		
		
		driver.findElement(By.name("pincode")).sendKeys("560075");
		driver.findElement(By.xpath("//input[@type='submit' and @value='OK']")).click();
		
		String xpathImg2 = "//div[div[h2[text()='Footwear for Men & Women']]]/following-sibling::div//div[text()='Casual shoes']/preceding-sibling::div[2]//div/img";
		WebElement elementImg2 = driver.findElement(By.xpath(xpathImg2));
		if(elementImg2.isDisplayed()){
			act.moveToElement(elementImg2).perform();	
			Thread.sleep(1000);
			System.out.println("Product found on first page");
			act.contextClick(elementImg2).perform();
			Thread.sleep(1000);
			act.sendKeys("T").perform();
			Thread.sleep(2000);
		}else{
			WebElement elementText = driver.findElement(By.xpath("//h2[text()='Footwear for Men & Women']"));
			act.moveToElement(elementText).perform();
			Thread.sleep(1000);
			driver.findElement(By.xpath("//div[div[div[h2[text()='Footwear for Men & Women']]]]//div[text()='›']")).click();
		//	act.moveToElement(elementImg2).perform();	
			Thread.sleep(1000);
			System.out.println("Product found on second page");
			act.contextClick(elementImg2).perform();
			Thread.sleep(1000);
			act.sendKeys("T").perform();
			Thread.sleep(2000);
		}
		/*String jcode = "document.getElementById('Email').value='ashi.sri.18@gmail.com'";
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript(jcode);
		String jCode1 = "document.getElementById('next').click()";
		jse.executeScript(jCode1);
		Thread.sleep(3000);
		String jCode2 = "document.getElementById('PersistentCookie').click()";
		jse.executeScript(jCode2);
		Thread.sleep(2000);*/
	}
	
	@AfterMethod
	public void tearDown(){
		report.endTest(logger);
		report.flush();
	//	driver.close();
	}

}
