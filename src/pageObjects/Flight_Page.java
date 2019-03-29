package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Flight_Page {

	private static WebElement element= null;

	//Radio button one way
	public static WebElement radiobtn_Oneway(WebDriver driver)
	{
		element=driver.findElement(By.xpath("//input[@value='oneway']"));
		return element;

	}

	//Radio button roundtrip 
	public static WebElement radiobtn_Roundtrip(WebDriver driver)
	{
		element=driver.findElement(By.xpath("//input[@value='roundtrip']"));
		return element;
	}

	//dropdown passenger
	public static WebElement ddl_Passengers(WebDriver driver)
	{
		element=driver.findElement(By.xpath("//select[@name='passCount']"));
		return element;
	}

	//Dropdown departing from
	public static WebElement ddl_DepartingFrom(WebDriver driver)
	{
		element=driver.findElement(By.xpath("//select[@name='fromPort']"));
		return element;
	}

	//Dropdown  from Month
	public static WebElement ddl_OnMonth(WebDriver driver)
	{
		element=driver.findElement(By.xpath("//select[@name='fromMonth']"));
		return element;
	}

	//Dropdown  from Day
	public static WebElement ddl_OnDay(WebDriver driver)
	{
		element=driver.findElement(By.xpath("//select[@name='fromDay']"));
		return element;
	}

	//Dropdown arriving in
	public static WebElement ddl_ArrivingIn(WebDriver driver)
	{
		element=driver.findElement(By.xpath("//select[@name='toPort']"));
		return element;
	}

	//Dropdown  to Month
	public static WebElement ddl_ToMonth(WebDriver driver)
	{
		element=driver.findElement(By.xpath("//select[@name='toMonth']"));
		return element;
	}

	//Dropdown  to day
	public static WebElement ddl_ToDay(WebDriver driver)
	{
		element=driver.findElement(By.xpath("//select[@name='toDay']"));
		return element;
	}

}
