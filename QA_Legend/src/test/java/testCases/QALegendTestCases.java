package testCases;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import automationCore.BaseClass;
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
import utilities.DateUtility;
import utilities.ExcelUtilities;
import utilities.FakerUtility;
import utilities.PageUtility;
import utilities.WaitUtility;

public class QALegendTestCases extends BaseClass
{
	public WebDriver driver;
	
	
	
	
	@Test(priority =1,groups= {"regression"})
	public void loginCRM()
	{
	
		homePage.userLogOut();
		loginPage.enterUsername(prop.getProperty("username"));
		loginPage.enterPassword(prop.getProperty("password"));
		loginPage.clickLoginButton();
		String expectedUserName = prop.getProperty("profileName");
		String actulalUserName = homePage.getProfileName();
		Assert.assertEquals(actulalUserName, expectedUserName);

	}
//	@DataProvider (name="login_Details")
//	public Object[][] testData() throws IOException
//	{
//		Object[][] loginData = new Object[3][2];
//		loginData[0][0] = ExcelUtilities.getString(1, 0, excelFilePath, "LoginPage");
//		loginData[0][1] = ExcelUtilities.getNumeric(1, 1, excelFilePath, "LoginPage");
//		loginData[1][0] = ExcelUtilities.getString(2, 0, excelFilePath, "LoginPage");
//		loginData[1][1] = ExcelUtilities.getString(2, 1, excelFilePath, "LoginPage");
//		loginData[2][0] = ExcelUtilities.getString(3, 0, excelFilePath, "LoginPage");
//		loginData[2][1] = ExcelUtilities.getString(3, 1, excelFilePath, "LoginPage");
//		
//		return loginData;
//				}
	@Test(priority =2,groups= {"smoke test"})
	public void notesPageCRM() throws Exception
	{
		notesPage.clickOnNotesButton();
		notesPage.clickOnAddNotesButton();
		String expectedNotesTitle = notesPage.enterTitleInAddNotesPopUp(excelFilePath);
		notesPage.clickOnSave();
		
		String actualNotesTitle  = notesPage.getActualTitle();
		Assert.assertEquals(actualNotesTitle, expectedNotesTitle);
	}
	@Test(priority =3,groups= {"regression"})
	public void clockInClockOut() throws IOException
	{
		String expectedNotes;
		String expectedStatus;
		String status;
		if(homePage.clockOutDisplayedOrNot() == true)
		{
			homePage.clickOnClockOut();
			expectedNotes = homePage.enterNotesInClockOutPopUp(excelFilePath);
			homePage.saveNotesInClockOutPopUp();
			System.out.println(expectedNotes);
			 status ="Clocked Out";
			
		}
		else
		{
			homePage.clickOnClockIn();
			
			status = "Clocked In";
			 
		}
		expectedStatus = homePage.getTextFromClockOutClockInPanel();
		System.out.println(expectedStatus);
		homePage.clickOnTimeCardButton();
		timeCardPage.clickOnClockInClockOutTab();
		timeCardPage.enterTextInSearchField(prop.getProperty("profileName"));
		String actualStatus = timeCardPage.getTextFromClockInClockOutStatus();
		System.out.println(actualStatus);
		if(status.contains("Clocked out"))
				{
		Assert.assertTrue(actualStatus.contains("Not clocked in yet")&&expectedStatus.contains("You are currently clocked out"));
				}
		else
		{
			Assert.assertTrue(actualStatus.contains(expectedStatus));
		}
	}
	@Test(priority =4,groups= {"smoke test"})
	public void applyLeave() throws IOException 
	{
		homePage.clickOnLeaveButton();
		leavePage.clickOnApplyLeaveButton();
		leavePage.clickOnLeaveTypeDropDown();
		leavePage.clickOnCasualLeave();
		leavePage.enterDate(excelFilePath);
		String expectedLeaveReason = leavePage.enterReasonForLeave(excelFilePath);
		leavePage.clickOnApplyLeaveInPopUp();
		leavePage.clickOnDropdownToListAll();
		leavePage.clickOnAllfromDropdownToListAll();
		String actualLeaveReason = leavePage.clickOnApplicationDetail();
		
		Assert.assertEquals(actualLeaveReason, expectedLeaveReason);
		}
	@Test(priority =5,groups= {"regression"})
	public void addTask() throws IOException 
	{
		homePage.clickOnOpenMyTaskPanel();
		taskPage.clickOnAddTaskButton();
		String expectedTaskTitle = taskPage.addTextToTitleField(excelFilePath);
		taskPage.addProjectFromDropDown();
		String actualTaskTitle=taskPage.clickOnSaveAddTaskPopUp();
		Assert.assertEquals(actualTaskTitle, expectedTaskTitle);
	}
	@Test(priority =6,groups= {"smoke test"})
public void addInvoice() throws IOException
{
	homePage.clickOnInvoiceButton();
	invoicePage.clickOnAddInvoice();
	invoicePage.enterInvoiceDueDate(excelFilePath);
	String expectedClient = invoicePage.selectClientfromClientDropdown();
	invoicePage.clickOnSaveInAddInvoicePopUp();
	
	invoicePage.clickOnAddItem();
	invoicePage.selectItemFromItemDropdown();
	String expectedItemQuantity=invoicePage.enterQuantity(excelFilePath)+" "+invoicePage.getQuantityUnit();
	invoicePage.clickOnSubmitFromAddItemPopUp();
	
	String actualClient = invoicePage.getActualClient();
	String actualItemQuantity = invoicePage.getActualQuantity();
	
	Assert.assertEquals(actualClient, expectedClient);
	//Assert.assertEquals(actualItemQuantity, expectedItemQuantity);
	
	Assert.assertTrue(actualItemQuantity.contains(expectedItemQuantity));
	
	
}
	@Test(priority =7,groups = {"regression"})
	public void addTeamMembers() throws IOException
	{homePage.clickOnTeamMemebersButton();
		teamMembersPage.clickOnAddMembersButton();
		String expectedFirstName=teamMembersPage.enterFirstName(excelFilePath);
		String expectedLastName=teamMembersPage.enterLastName(excelFilePath);
		teamMembersPage.clickOnNextButton();
		String expectedJobTitle=teamMembersPage.enterJobTitle(excelFilePath);
		teamMembersPage.clickOnNextButton();
		String expectedEmail=teamMembersPage.enterEmail(excelFilePath);
		teamMembersPage.enterPassword(excelFilePath);
		teamMembersPage.clickOnSaveButton();
		String expectedName = expectedFirstName+" "+expectedLastName;
		teamMembersPage.searchForTeamMember(expectedName);
		
		  String memberDetails[] = teamMembersPage.actualTeamMemberDetails();
		  Assert.assertEquals(memberDetails[0], expectedName);
		 Assert.assertEquals(memberDetails[1], expectedJobTitle);
		  Assert.assertEquals(memberDetails[2], expectedEmail);
		 
	}
	@Test(priority =8,groups= {"smoke test"})
	public void addAnnouncements() throws IOException
	{
		homePage.clickOnAnnouncementsButton();
		announcementsPage.clickOnAddAnnouncementButton();
		String expectedTitle = announcementsPage.enterTitle(excelFilePath);
		announcementsPage.enterStartDate(excelFilePath);
		announcementsPage.enterEndDate(excelFilePath);
		announcementsPage.clickOnSave();
		announcementsPage.goBackToAnnouncementsPage();
		announcementsPage.searchForExpectedAnnouncement(expectedTitle);
		String actualTitle = announcementsPage.getTextOfActualAnnouncementTitle();
		Assert.assertEquals(actualTitle, expectedTitle);
		
	}
	@Test(priority =9,groups= {"regression"})
	public void messageInCRM() throws IOException
	{
		homePage.clickOnMessageButton();
		messagePage.clickOnComposeButton();
		messagePage.clickOnRecepientDropDown();
		messagePage.selectRecepientFromDropdown();
		String expSubject = messagePage.enterSubjectInComposeMessagePopUp(excelFilePath);
		String expMessage = messagePage.enterMessagetInComposeMessagePopUp(excelFilePath);
		messagePage.clickOnSaveButton();
		messagePage.clickOnSentItems();
		messagePage.clickOnTheMessageSentFromSentItems();
		String actualSubject = messagePage.getActualSubject();
		String actualMessage = messagePage.getActualMessage();
		Assert.assertTrue(actualMessage.contains(expMessage)&&actualSubject.contains(expSubject));
		
	}
	@Test(priority=10,groups= {"smoke test"})
	
	public void addTickets() throws IOException
	{
		
		homePage.clickOnTicketsButton();
		 
		
		ticketsPage.clickOnAddTicket();
		String expectedTitle=ticketsPage.input_Title(excelFilePath);
		ticketsPage.inputClient();
		String expectedDescription = ticketsPage.input_Description(excelFilePath);
		ticketsPage.clickOnSave();
		ticketsPage.searchForTicket(expectedTitle);
		String actualTitle = ticketsPage.getActualTicketTitle();
		ticketsPage.clickOnActualTicketTitle();
		String actualDescription = ticketsPage.getActualTicketDescription();
		ticketsPage.listAllTicketsInTicketsPage();
		String numberOfActualNewTickets = ticketsPage.getActualNewTicketNumber();
		
		homePage.clickOnDashboardButton();
		String numberOfTicketsDisplayedInHomePage = homePage.noOfTickets();
		System.out.println("ticket no in homePage ="+ numberOfTicketsDisplayedInHomePage);
		System.out.println("ticket no in ticketsPage ="+ numberOfActualNewTickets);
		
		Assert.assertTrue(actualTitle.contains(expectedTitle) && actualDescription.contains(expectedDescription));
		Assert.assertEquals(numberOfActualNewTickets, numberOfTicketsDisplayedInHomePage);
		
		
		
		
	}
	

}
