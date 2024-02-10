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
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.google.common.io.Files;

import pageClasses.QALegendAnnouncementsPAge;
import pageClasses.QALegendHomePage;
import pageClasses.QALegendInvoicePage;
import pageClasses.QALegendLeavePage;
import pageClasses.QALegendLoginPage;
import pageClasses.QALegendMessagePage;
import pageClasses.QALegendNotesPage;
import pageClasses.QALegendTaskPage;
import pageClasses.QALegendTeamMembersPage;
import pageClasses.QALegendTicketsPage;
import pageClasses.QALegendTimeCardPage;

public class BaseClass {
	public WebDriver driver;
	public FileInputStream fis;
	public Properties prop;
	public QALegendLoginPage loginPage;
	public QALegendHomePage homePage;
	public QALegendNotesPage notesPage;
	public QALegendTimeCardPage timeCardPage;
	public QALegendLeavePage leavePage;
	public QALegendTaskPage taskPage;
	public QALegendInvoicePage invoicePage;
	public QALegendTeamMembersPage teamMembersPage;
	public QALegendAnnouncementsPAge announcementsPage;
	public QALegendMessagePage messagePage;
	public QALegendTicketsPage ticketsPage;
	
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
	
	@BeforeMethod
	@Parameters({"browser"})
	public void initialization(String browser) throws Exception
	{System.out.println("Before method");
		driver = browserInitialization(browser);
		fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\testData\\testData.properties");
		prop = new Properties();
		loginPage = new QALegendLoginPage(driver);
		homePage = new QALegendHomePage(driver);
		notesPage = new QALegendNotesPage(driver);
		timeCardPage = new QALegendTimeCardPage(driver);
		leavePage = new QALegendLeavePage(driver);
		taskPage = new QALegendTaskPage(driver);
		invoicePage = new QALegendInvoicePage(driver);
		teamMembersPage = new QALegendTeamMembersPage(driver);
		announcementsPage = new QALegendAnnouncementsPAge(driver);
		messagePage = new QALegendMessagePage(driver);
		ticketsPage = new QALegendTicketsPage(driver);
		
		prop.load(fis);
	 driver.get(prop.getProperty("url"));
	 driver.manage().window().maximize();
	 loginPage.enterUsername(prop.getProperty("username"));
		loginPage.enterPassword(prop.getProperty("password"));
		loginPage.clickLoginButton();
		
	}
	
	public String getScreenShotPath(String testCaseName, WebDriver driver) throws IOException
	{
		TakesScreenshot ts = (TakesScreenshot)driver; //to enable driver to take screenshot
		File source = ts.getScreenshotAs(OutputType.FILE);//captures screenshot as file
		String destinationFile = System.getProperty("user.dir")+"\\test-output\\"+testCaseName+".png";
		Files.copy(source,new File(destinationFile));
		return destinationFile;
		
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	
}
