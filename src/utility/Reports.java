package utility;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
public class Reports {

	WebDriver driver;
	 ExtentReports extent;
	 ExtentTest logger;
	
	 public Reports()
	 
	 {
		 
		//Extended reports:
			extent = new ExtentReports(System.getProperty("user.dir") +"/test-output/STMExtentReport.html", true);
			extent.loadConfig(new File(System.getProperty("user.dir")+"\\extent-config.xml"));
		 
	 }
	 
	 public void passTest(String testcasename){
		 logger = extent.startTest("passTest"+ testcasename);
		 Assert.assertTrue(true);
		 //To generate the log when the test case is passed
		 logger.log(LogStatus.PASS, "Test Case Passed" + testcasename);
		 }
		
		 public void failTest(String testcasename){
			 logger = extent.startTest("failTest"+testcasename);
			 Assert.assertTrue(false);
			 //To generate the log when the test case is failed
			 logger.log(LogStatus.FAIL, "Test Case failed "+ testcasename);
			 }
public void reportflush()
{
extent.flush();	
}
		 
}
