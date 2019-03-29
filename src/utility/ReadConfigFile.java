package utility;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadConfigFile {

	Properties prop;

	public ReadConfigFile() 
	{

		File source= new File("./Config/Configuration.properties");
		try {
			FileInputStream fileinput=new FileInputStream(source);
			prop = new Properties();
			prop.load(fileinput);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Exception Message ::::" + e);
		}


	}

	public String getApplicationURL() {String path=prop.getProperty("ApplicationURL");return path;}
	public String getChromeDriver() {String path= prop.getProperty("ChromeDriver");return path ;}
	public String getExcelPath() {String path=prop.getProperty("ExcelPath");return path;}
}
