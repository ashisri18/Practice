package com.Practice.Base.Lib;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.relevantcodes.extentreports.LogStatus;


public class TestNGListener implements ITestListener {

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		
		String instanceName =result.getInstanceName();
		String className = instanceName.substring(instanceName.lastIndexOf('.')+1);
		String methodName = result.getMethod().getMethodName();
		EventFiringWebDriver eDriver = new EventFiringWebDriver(BaseLib.driver);
		File srcImg = eDriver.getScreenshotAs(OutputType.FILE);
		String destImg_path = "D:\\CBT_Automation\\Workspace\\Practice\\Report\\Practice_PdfReport\\"+className+"_"+methodName+".png";
		File destImg = new File(destImg_path);
		try {
			FileUtils.copyFile(srcImg, destImg);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	//	Extent Report:------------------------------	
		String image= BaseLib.logger.addScreenCapture(destImg_path);
		BaseLib.logger.log(LogStatus.FAIL, methodName+" method has been failed", image);
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

}
