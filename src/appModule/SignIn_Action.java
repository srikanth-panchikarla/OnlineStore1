package appModule;
import pageObjects.SignOn_Page;
import pageObjects.Home_Page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utility.Log;

public class SignIn_Action {

	
	public static void Execute(WebDriver driver,String sUsername,String sPassword ) throws Exception
	{
	
		//String sUsername=Excel_Utils.getCellData(1,1);
	    Log.info("Username picked from Excel is "+ sUsername );
	   // String sPassword=Excel_Utils.getCellData(1,2);
	    Log.info("Password picked from Excel is "+ sPassword );
		Home_Page.link_signon(driver).click();
		Log.info("Clicked on Signon button");
		WebDriverWait wait= new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.visibilityOfAllElements(SignOn_Page.txt_username(driver)));
		SignOn_Page.txt_username(driver).sendKeys(sUsername);
		Log.info("Entered user name" +sUsername );
		SignOn_Page.txt_password(driver).sendKeys(sPassword);
		Log.info("Entered password" +sPassword );
		SignOn_Page.btn_submit(driver).click();
		Log.info("Click action performed on Submit button");
	}
}
