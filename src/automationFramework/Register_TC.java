package automationFramework;
import org.openqa.selenium.OutputType;
import com.relevantcodes.extentreports.*;

import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.TakesScreenshot;
import java.lang.Object;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.io.FileHandler;
import java.io.File;
import java.io.IOException;
import java.lang.Object;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.testng.annotations.Test;
import appModule.SignIn_Action;
import appModule.Register_Action;
import utility.Excel_Utils;
import utility.Log;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.AfterMethod;
import utility.ReadConfigFile;
import utility.Screenshots;
import utility.Reports;

public class Register_TC {
	public WebDriver driver;
	ReadConfigFile readconfigfile= new ReadConfigFile();
	String sheetname="Sheet2";
	Screenshots screenshot= new Screenshots();
	Reports extendReports=new Reports();
	
	@BeforeMethod
	public void beforeMethod() throws Exception {
		DOMConfigurator.configure("log4j.xml");
		//Log.startTestCase("Testcase1");
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
			System.out.println("=====Inside testData method======");
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

	public void Register(String TestCaseName,String firstname,String lastname,String phone,String email,String address1,String City,String Country,String username, String password, String confirmPassword) throws Exception {
		try 
		{ 
			Log.info("=====Inside Register method======");
			Register_Action.Register_Execute(driver, firstname, lastname, phone, email, address1, City, Country, username,  password,confirmPassword);
			Log.info("=====inside Register_Action method======");
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
	public void afterMethod() throws Exception {

		extendReports.reportflush();
		driver.quit();

	}
}
