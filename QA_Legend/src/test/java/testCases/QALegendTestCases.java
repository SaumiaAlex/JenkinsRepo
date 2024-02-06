package testCases;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import automationCore.BaseClass;
import pageClasses.QALegendAnnouncementsPAge;
import pageClasses.QALegendHomePage;
import pageClasses.QALegendInvoicePage;
import pageClasses.QALegendLeavePage;
import pageClasses.QALegendLoginPage;
import pageClasses.QALegendNotesPage;
import pageClasses.QALegendTaskPage;
import pageClasses.QALegendTeamMembersPage;
import pageClasses.QALegendTimeCardPage;
import utilities.DateUtility;
import utilities.FakerUtility;
import utilities.PageUtility;
import utilities.WaitUtility;

public class QALegendTestCases extends BaseClass
{
	public WebDriver driver;
	FileInputStream fis;
	Properties prop;
	QALegendLoginPage loginPage;
	QALegendHomePage homePage;
	QALegendNotesPage notesPage;
	QALegendTimeCardPage timeCardPage;
	QALegendLeavePage leavePage;
	QALegendTaskPage taskPage;
	QALegendInvoicePage invoicePage;
	QALegendTeamMembersPage teamMembersPage;
	QALegendAnnouncementsPAge announcementsPage;
	String excelFilePath = "/src/main/java/testData/testData_Excel.xlsx";
	
	@BeforeMethod
	@Parameters({"browser"})
	public void initialization(String browser) throws Exception
	{System.out.println("Before method");
		driver = browserInitialization(browser);
		fis = new FileInputStream("C:\\Users\\SAUMIA\\eclipse-workspace\\QA_Legend\\src\\main\\java\\testData\\testData.properties");
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
		
		prop.load(fis);
	 driver.get(prop.getProperty("url"));
	 driver.manage().window().maximize();
	 loginPage.enterUsername(prop.getProperty("username"));
		loginPage.enterPassword(prop.getProperty("password"));
		loginPage.clickLoginButton();
		
	}
	
	@Test(priority =1)
	public void loginCRM()
	{
	
		homePage.userLogOut();
		loginPage.enterUsername(prop.getProperty("username"));
		loginPage.enterPassword(prop.getProperty("password"));
		loginPage.clickLoginButton();
		String expectedUserName = prop.getProperty("profileName");
		String actulalUserName = homePage.getProfileName();
		Assert.assertEquals(actulalUserName, expectedUserName);
//		System.out.println(FakerUtility.randomNumberCreation());
//		System.out.println(DateUtility.getCurrentDate());
	}
	@Test(priority =2)
	public void notesPageCRM() throws Exception
	{
		notesPage.clickOnNotesButton();
		notesPage.clickOnAddNotesButton();
		String expectedNotesTitle = notesPage.enterTitleInAddNotesPopUp(excelFilePath);
		notesPage.clickOnSave();
		
		String actualNotesTitle  = notesPage.getActualTitle();
		Assert.assertEquals(actualNotesTitle, expectedNotesTitle);
	}
	@Test(priority =3)
	public void clockInClockOut() throws IOException
	{
		String expectedNotes;
		String expectedStatus;
		if(homePage.clockOutDisplayedOrNot() == true)
		{
			homePage.clickOnClockOut();
			expectedNotes = homePage.enterNotesInClockOutPopUp(excelFilePath);
			homePage.saveNotesInClockOutPopUp();
			System.out.println(expectedNotes);
			 
			
		}
		else
		{
			homePage.clickOnClockIn();
			 
		}
		expectedStatus = homePage.getTextFromClockOutClockInPanel();
		System.out.println(expectedStatus);
		homePage.clickOnTimeCardButton();
		timeCardPage.clickOnClockInClouckOutTab();
		timeCardPage.enterTextInSearchField(prop.getProperty("profileName"));
		String actualStatus = timeCardPage.getTextFromClockInClockOutStatus();
		System.out.println(actualStatus);
		
	}
	@Test(priority =4)
	public void applyAndAssignLeave() throws IOException 
	{
		homePage.clickOnLeaveButton();
		leavePage.clickOnApplyLeaveButton();
		leavePage.clickOnLeaveTypeDropDown();
		leavePage.clickOnCasualLeave();
		leavePage.enterDate(excelFilePath);
		leavePage.enterReasonForLeave(excelFilePath);
		leavePage.clickOnDateApplyLeaveInPopUp();
	}
	@Test(priority =5)
	public void addTask() throws IOException 
	{
		homePage.clickOnOpenMyTaskPanel();
		taskPage.clickOnAddTaskButton();
		taskPage.addTextToTitleField(excelFilePath);
		taskPage.addProjectFromDropDown();
		taskPage.clickOnSaveAddTaskPopUp();
	}
	@Test(priority =6)
public void addInvoiceAndPerformPayment() throws IOException
{
	homePage.clickOnInvoiceButton();
	invoicePage.clickOnAddInvoice();
	invoicePage.enterInvoiceDueDate(excelFilePath);
	invoicePage.clickOnClientDropdown();
	invoicePage.selectFromClientDropdown();
	invoicePage.clickOnAddInvoice(); 
}
	@Test(priority =7)
	public void addTeamMembers() throws IOException
	{homePage.clickOnTeamMemebersButton();
		teamMembersPage.clickOnAddMembersButton();
		teamMembersPage.enterFirstName(excelFilePath);
		teamMembersPage.enterLastName(excelFilePath);
		teamMembersPage.clickOnNextButton();
		teamMembersPage.enterJobTitle(excelFilePath);
		teamMembersPage.clickOnNextButton();
		teamMembersPage.enterEmail(excelFilePath);
		teamMembersPage.enterPassword(excelFilePath);
		teamMembersPage.clickOnSaveButton();
	}
	@Test(priority =8)
	public void addAnnouncements() throws IOException
	{
		homePage.clickOnAnnouncementsButton();
		announcementsPage.clickOnAddAnnouncementButton();
		announcementsPage.enterTitle(excelFilePath);
		announcementsPage.enterStartDate(excelFilePath);
		announcementsPage.enterEndDate(excelFilePath);
		announcementsPage.clickOnSave();
	}
}
