package utility;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Screenshots {

	
public void getScreenShot(WebDriver driver) throws IOException {
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
		Date date = new Date();
		TakesScreenshot scrShot =((TakesScreenshot)driver);
		File filesrc= scrShot.getScreenshotAs(OutputType.FILE);
		String path = "C:\\Users\\srikanthp\\eclipse-workspace\\OnlineStore\\Screenshots\\Screenshots" +"_Image_" +dateFormat.format(date).toString()+".png";  
		FileHandler.copy(filesrc, new File(path));
		
				
	}
	
}
