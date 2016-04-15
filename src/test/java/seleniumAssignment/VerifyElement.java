package seleniumAssignment;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.Practice.Base.Lib.BaseLib;

public class VerifyElement extends BaseLib{
	
	@Test
	public void UsingFindElementMethod(){
		driver.get("http://google.com");
		driver.manage().window().maximize();
		driver.findElement(By.id("//input[@id='gs_htif0']")).sendKeys("flip");
	}
	
	
	 
}
