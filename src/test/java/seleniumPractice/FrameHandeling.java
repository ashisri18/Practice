package seleniumPractice;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class FrameHandeling {
	WebDriver driver;
	@Test
	public void frameHandeling() throws InterruptedException{
	System.setProperty("webdriver.ie.driver", "../Practice/src/test/resources/IEDriverServer.exe");
	driver = new InternetExplorerDriver();
	driver.get("http://gmail.com");
	driver.manage().window().maximize();
	String jcode = "document.getElementById('Email').value='ashi.sri.18@gmail.com'";
	JavascriptExecutor jse = (JavascriptExecutor)driver;
	jse.executeScript(jcode);
	String jCode1 = "document.getElementById('next').click()";
	jse.executeScript(jCode1);
	Thread.sleep(3000);
	String jCode2 = "document.getElementById('PersistentCookie').click()";
	jse.executeScript(jCode2);
	Thread.sleep(2000);
	}
	
	@AfterTest
	public void tearDown(){
		driver.close();
	}
}
