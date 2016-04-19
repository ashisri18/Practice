package seleniumPractice;

import org.testng.annotations.Test;

import com.Practice.Base.Lib.BaseLib;

import atu.testng.reports.ATUReports;
import atu.testng.reports.utils.Utils;

public class FileDownload extends BaseLib{
// set Author info for ATU reports.	
	private void setAuthorInfoForReports() {
		   ATUReports.setAuthorInfo("Ashish Srivastava", Utils.getCurrentTime(),"1.0");
	}		
	
	@Test(enabled=true)
	public void fileDownload(){
		setAuthorInfoForReports();					// used for ATU reports
		logger = report.startTest("FileDownload");		// used for Extent reports
		 
		
	}

}
