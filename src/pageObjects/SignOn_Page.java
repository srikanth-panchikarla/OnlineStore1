package pageObjects;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.firefox.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utility.Log;



public class SignOn_Page {

	private static WebElement element= null;
	
	
	
	//user name textbox element
	public static WebElement txt_username(WebDriver driver)
	
	{
		element=driver.findElement(By.name("userName"));
		Log.info("Username text box found");
		return element;		
	}
	
	//password textbox element
   public static WebElement txt_password(WebDriver driver)
	
	{
		element=driver.findElement(By.name("password"));
		Log.info("Password text box found");
		return element;		
	}
	
   //submit button element
   public static WebElement btn_submit(WebDriver driver)
	
	{
		element=driver.findElement(By.name("submit"));
		Log.info("Submit button found");
		return element;		
	}
   
}
