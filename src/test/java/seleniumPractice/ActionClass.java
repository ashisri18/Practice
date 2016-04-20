package seleniumPractice;

import com.Practice.Base.Lib.BaseLib;

import atu.testng.reports.ATUReports;
import atu.testng.reports.utils.Utils;

public class ActionClass extends BaseLib{
	public void setAuthorInfoReport(){
		ATUReports.setAuthorInfo("Ashish Srivastava", Utils.getCurrentTime(), "1.0");
	}
	
	

}
