package appModule;
import pageObjects.Home_Page;
import pageObjects.Register_Page;
import pageObjects.SignOn_Page;
import org.openqa.selenium.WebDriver;
import utility.Log;

public class Register_Action {

	public static void Register_Execute(WebDriver driver,String firstname,String lastname,String phone,String email,String address1,String City,String Country,String username,String password,String confirmPassword)
	{
		Log.info("Your in Register_Execute method");
		Home_Page.link_Register(driver).click();
		Log.info("Clicked Register link");
		Register_Page.txt_firstname(driver).sendKeys(firstname);
		Register_Page.txt_lastname(driver).sendKeys(lastname);
		Register_Page.txt_phone(driver).sendKeys(phone);
		Register_Page.txt_email(driver).sendKeys(email);
		Register_Page.txt_address1(driver).sendKeys(address1);
		Register_Page.txt_city(driver).sendKeys(City);
		Register_Page.txt_country(driver).sendKeys(Country);
		SignOn_Page.txt_username(driver).sendKeys(username);
		SignOn_Page.txt_password(driver).sendKeys(password);
		Register_Page.txt_confirmPassword(driver).sendKeys(confirmPassword);
		Register_Page.btn_submit(driver).click();
		
		
	}
	
}
