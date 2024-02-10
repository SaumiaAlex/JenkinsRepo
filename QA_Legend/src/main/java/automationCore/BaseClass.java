package automationCore;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


import com.google.common.io.Files;


public class BaseClass {
	public WebDriver driver;
	
	
	public final String excelFilePath = "//src//main//java//testData//testData_Excel.xlsx";
	public WebDriver browserInitialization(String browserName) throws Exception
	{
		if(browserName.equalsIgnoreCase("Chrome"))
		{
			driver = new ChromeDriver();
		}
		else if(browserName.equalsIgnoreCase("Edge"))
		{
			driver = new EdgeDriver();
		}
		else if(browserName.equalsIgnoreCase("Firefox"))
		{
			driver = new FirefoxDriver();
		}
		else
		{
			throw new Exception("Invalid Name Exception");
		}
		driver.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS);	
		return driver;
		
		 
	}
	
	
	
	public String getScreenShotPath(String testCaseName, WebDriver driver) throws IOException
	{
		TakesScreenshot ts = (TakesScreenshot)driver; //to enable driver to take screenshot
		File source = ts.getScreenshotAs(OutputType.FILE);//captures screenshot as file
		String destinationFile = System.getProperty("user.dir")+"\\test-output\\"+testCaseName+".png";
		Files.copy(source,new File(destinationFile));
		return destinationFile;
		
	}
	
	
	
}
