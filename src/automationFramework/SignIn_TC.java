package automationFramework;
import java.io.File;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.ITestResult;

import appModule.SignIn_Action;
import utility.Excel_Utils;
import utility.Log;
import utility.ReadConfigFile;
import utility.Reports;
import utility.Screenshots;

public class SignIn_TC {
	public WebDriver driver;
	ReadConfigFile readconfigfile= new ReadConfigFile();
	String sheetname="Sheet1";
	Reports extendReports= new Reports();
	Screenshots screenshot=new Screenshots();
	 	 
	 
	 @BeforeMethod
	public void beforeMethod() throws Exception {
		DOMConfigurator.configure("log4j.xml");
		Log.startTestCase("Testcase1");
		System.setProperty("webdriver.chrome.driver",readconfigfile.getChromeDriver());
		
		Log.info("::Driver path::");
		Log.info("::Excel sheet path::");
		driver=new ChromeDriver();
		Log.info("::Initialising Chrome driver::");
		driver.get(readconfigfile.getApplicationURL());
		Log.info("::Getting the application URL::");
		
	
	}

	@DataProvider(name = "Data")
	public Object[][] testData() throws Exception {
		Object[][] excelData = null;

		try {
		Log.info("=====Inside testData method======");
			Excel_Utils.setExcelFile(readconfigfile.getExcelPath(),sheetname);

			int row = Excel_Utils.getRowCount(sheetname);
			int columns = Excel_Utils.getcolCount(sheetname);
			excelData = new Object[row - 1][columns];
			for (int i = 1; i < row; i++) {
				for (int j = 0; j < columns; j++) {
					excelData[i - 1][j] = Excel_Utils.getCellData(sheetname, j, i);

				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw(e);
		}

		return excelData;
	}

	@Test(dataProvider = "Data")

	public void SignIn(String TestCaseName,String username, String password,String Result) throws Exception {
		try 
		{ 
			Log.info("=====Inside Sign method======");
			SignIn_Action.Execute(driver,username,password);
			Log.info("=====outside Execute method ran successfully======");
			extendReports.passTest(TestCaseName);
			screenshot.getScreenShot(driver);
		}

		catch(Exception e)
		{
			extendReports.failTest(TestCaseName);
			screenshot.getScreenShot(driver);
			e.printStackTrace();  

		}
	}

	
	
		
	
	@AfterMethod
/*	public void afterMethod(ITestResult result) throws Exception {

		
		if(result.getStatus() == ITestResult.FAILURE){
			 logger.log(LogStatus.FAIL, "Test Case Failed is "+result.getName());
			 logger.log(LogStatus.FAIL, "Test Case Failed is "+result.getThrowable());
			 }else if(result.getStatus() == ITestResult.SKIP){
			 logger.log(LogStatus.SKIP, "Test Case Skipped is "+result.getName());
			 }
		

	} */
	
	@AfterTest
	
	public void endReport()
	{
		
		extendReports.reportflush();
		driver.quit();
		//extent.close();
		
	}


}
