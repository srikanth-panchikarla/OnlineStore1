package pageObjects;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.firefox.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utility.Log;


public class Home_Page {

	private static WebElement element = null;
	
	//Register link
	public static WebElement link_Register(WebDriver driver)
	
	{
		
		element= driver.findElement((By.xpath("//a[contains(text(),'REGISTER')]")));
		Log.info("Link register found");
		return element;
		
	}
	
	
	  //SignOn link
		public static WebElement link_signon(WebDriver driver)
		
		{
			
			element= driver.findElement((By.xpath("//a[contains(text(),'SIGN-ON')]")));
			Log.info("Link sign on found");
			return element;
			
		}
		
		//Flight link
		
		public static WebElement link_flight(WebDriver driver)
		{
			
			element=driver.findElement(By.xpath("//a[contains(text(),'Flights')]"));
			return element;
		}
	
	
	
}
