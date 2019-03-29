package pageObjects;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.firefox.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class Register_Page {

	private static WebElement element= null;
	
	public static WebElement txt_firstname(WebDriver driver)
	{
		element=driver.findElement(By.name("firstName"));
		return element;	
		
	}
	
	
	public static WebElement txt_lastname(WebDriver driver)
	{
		element=driver.findElement(By.name("lastName"));
		return element;	
		
	}
	
	public static WebElement txt_phone(WebDriver driver)
	{
		element=driver.findElement(By.name("phone"));
		return element;	
		
	}
	
	public static WebElement txt_address1(WebDriver driver)
	{
		element=driver.findElement(By.name("address1"));
		return element;	
		
	}
	
	public static WebElement txt_city(WebDriver driver)
	{
		element=driver.findElement(By.name("city"));
		return element;	
		
	}
	
	public static WebElement txt_country(WebDriver driver)
	{
		element=driver.findElement(By.name("country"));
		return element;	
		
	}
	
	public static WebElement txt_email(WebDriver driver)
	{
		element=driver.findElement(By.name("email"));
		return element;	
		
	}
	
/* public static WebElement txt_username(WebDriver driver)
	
	{
		element=driver.findElement(By.name("userName"));
		return element;		
	}
	
	//password textbox element
   public static WebElement txt_password(WebDriver driver)
	
	{
		element=driver.findElement(By.name("password"));
		return element;		
	}
   */
   public static WebElement txt_confirmPassword(WebDriver driver)
	
  	{
  		element=driver.findElement(By.name("confirmPassword"));
  		return element;		
  	}
   public static WebElement btn_submit(WebDriver driver)
	
 	{
 		element=driver.findElement(By.name("submit"));
 		return element;		
 	}
    
}
