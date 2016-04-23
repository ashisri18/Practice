package appiumPractice;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;

public class AppiumPractice {
	AndroidDriver<WebElement> driver;
	@BeforeTest
	public void setup() throws MalformedURLException{
	
		DesiredCapabilities capabilities = new DesiredCapabilities();
		
		capabilities.setCapability("appPackage", "com.google.android.gm");
		capabilities.setCapability("appActivity", ".ConversationListActivityGmail");
		capabilities.setCapability("deviceName", "Redmi-2");
	//	capabilities.setCapability("browserName", "Chrome");
		capabilities.setCapability("noReset", true);
		capabilities.setCapability("fullReset","false");
		capabilities.setCapability("newCommandTimeout", "30");
		capabilities.setCapability("log-level", "warn");
	//	capabilities.setCapability("deviceReadyTimeout", "30");
		driver = new AndroidDriver<WebElement>(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	@Test(priority=0, enabled= false)
	public void testplayMusic(){
		driver.findElementByXPath("//android.view.View[contains(@content-desc,'Downloaded')]").click();
	//	String xpath = "//android.widget.ListView[@resource-id='com.miui.player:id/list']/android.widget.RelativeLayout/android.widget.RelativeLayout/android.widget.TableLayout/android.widget.TableRow/android.widget.TextView[resource-id='com.miui.player:id/title']";
	//	String xpath = "//android.widget.TableRow/android.widget.TextView[com.miui.player:id/title]";
		String xpath = "//android.widget.TableRow/android.widget.TextView[@resource-id='com.miui.player:id/title']";
		List<WebElement> xpathList = driver.findElementsByXPath(xpath);
		for(WebElement xpaths: xpathList){
			System.out.println(xpaths.getText());
		}
		System.out.println(xpathList.size());
		Random random = new Random();
		int index = random.nextInt(7);
		System.out.println("Now song "+ xpathList.get(index).getText()+" is going to play." );
		xpathList.get(index).click();
		TouchAction tAction = new TouchAction(driver);
	//	tAction.moveTo(xpathList.get(index)).tap(xpathList.get(index)).perform();
		
	//	tAction.longPress(xpathList.get(index)).perform();
		tAction.longPress(xpathList.get(index), 2000).perform();
		
		tAction.tap(driver.findElementByName("Add")).perform();
	//	driver.findElementByName("Add").click();
		driver.findElementByName("Current playlist").click();
		driver.findElementById("pause").click();
		driver.findElementById("nowplaying_bar").click();
	//	driver.findElementById("currenttime").sendKeys("4:30");
		
	// Swipe function:-	
		Dimension dim = driver.manage().window().getSize();
		int startx = (int) (dim.getWidth()*0.9);
		int endx = (int) (dim.getWidth()*0.1);
		int starty = (int) (dim.getHeight()*0.5);
		int endy = (int) (dim.getHeight()*0.5);
		driver.swipe(startx, starty, endx, endy, 5000);
		
	}
	
	@Test(priority=1, enabled=true)
	public void MobilrBrowserTesting() throws InterruptedException{
		System.out.println("Hi");
		TouchAction tAction = new TouchAction(driver);
		tAction.press(500, 1100).moveTo(500, 300).release().perform();
		WebElement we = driver.findElementByXPath("//android.widget.ListView[@resource-id='com.google.android.gm:id/conversation_list_view']//android.widget.FrameLayout//android.view.View[contains(@content-desc,'Ticket Under Process')]");
		System.out.println(we.getText()); 
		while(!we.isDisplayed()){
			System.out.println(we.getText());
			tAction.longPress(500, 1100).moveTo(500, 300).release().perform();
			Thread.sleep(2000);
		}
		driver.findElementByXPath("//android.view.View[contains(@content-desc,'Ticket Under Process')]").click();
		Thread.sleep(5000);
		String text =driver.findElement(By.name("uTest Community about Project With US-Issued Credit Cards, Weekly Digest April 4th, 2016 We are paying up to $175 USD per day for people... on 4 Apr, conversation read")).getText();
		Thread.sleep(5000);
		System.out.println(text);
		driver.scrollTo(text);
		
		
/*		tAction.longPress(500, 1100).moveTo(500, 300).release().perform();
		driver.findElementByName("APPLY Link").click();
		driver.findElementByName("Chrome").click();
		driver.findElementByName("Similar Jobs").click();
		driver.findElementByName("Job Details").click();
		driver.findElementByName("Job Description:").click();
		*/
		//TouchAction tAction = new TouchAction(driver);
		driver.findElementByName("goibibo.com Link").click();
		driver.findElementByName("Chrome").click();
		driver.findElement(By.id("fltSearch")).click();
		tAction.tap(290, 460);
		Thread.sleep(2000);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	}
	
	@Test (priority = 2, enabled = false)
	public void chromeBrowserTest() throws InterruptedException{
		driver.get("http://google.com");
		Thread.sleep(2000);
		driver.get("http://flipkart.com");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[text()='Categories']")).click();
		Thread.sleep(2000);
//		Actions action = new Actions(driver);
		driver.findElement(By.xpath("//span[text()='Lifestyle']")).click();
//		action.tap(350, 820).perform();
		
	}

}
