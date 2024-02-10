package pageClasses;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.ExcelUtilities;
import utilities.FakerUtility;
import utilities.PageUtility;
import utilities.WaitUtility;

public class QALegendHomePage {
	
	WebDriver driver;
	@FindBy(id = "user-dropdown-icon") 
	WebElement userNameDropDown;
	@FindBy(xpath = "//a[text()=' Sign Out']")
	WebElement signOutButton;
	@FindBy (id = "timecard-clock-out")
	WebElement clockOutButton;
	@FindBy (xpath = "(//textarea[@name='note'])[2]")
	WebElement clockOutNotesTextField;
	@FindBy (xpath = "//button[@class='btn btn-primary']")
	WebElement clockOutNotesSaveButton;
	@FindBy(xpath = "//a[@title='Clock In']") 
	WebElement clockInButton;
	@FindBy(xpath = "((//div[@class='panel-body '])[1]//child::div)[2]")
	WebElement clockOutClockInPanel;
	@FindBy(xpath = "((//div[@class='panel-body '])[1]//child::div)[2]//child::div")
	WebElement clockedInText;
	@FindBy(xpath = "//span[text()='Time cards']")
	WebElement timeCardButton;
	@FindBy(xpath = "//span[text()='Leave']")
	WebElement leaveButton;
	@FindBy (xpath = "(//div[@class='panel-body '])[2]")
	WebElement openMyTaskPanel;
	@FindBy (xpath = "//span[text()='Invoices']")
	WebElement invoiceButton;
	@FindBy(xpath = "//span[text()='Team members']")
WebElement teamMembersButton;	
	@FindBy(xpath = "//span[text()='Announcements']")
	WebElement announcementsButton;	
	@FindBy(xpath = "//span[text()='Messages']")
	WebElement messageButton;	
	@FindBy(xpath = "//span[text()='Tickets']")
	WebElement ticketsButton;
	@FindBy (xpath = "//span[text()='Tickets']//following-sibling::span")
	WebElement noOfTicketsDisplayed;
	@FindBy(xpath ="//span[text()='Dashboard']")
	WebElement dashboardButton;
	
	
	
	
	
	public QALegendHomePage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}








 public void userLogOut()
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
		wait.until(ExpectedConditions.visibilityOf(userNameDropDown));
		PageUtility.clickOnElement(userNameDropDown);
		PageUtility.clickOnElement(signOutButton);
	}
 public String getProfileName()
 {
 	return PageUtility.getTextFromElement(userNameDropDown);
 }
 
 //Clock In Clock Out Operations
 public boolean clockOutDisplayedOrNot()
 {
	 WaitUtility.waitForElementToBePresent(driver, clockOutClockInPanel);
	if(PageUtility.getTextFromElement(clockOutClockInPanel).contains("Clock Out"))
	{
		return true;
	}
	else
	{
		return false;
	}
 }
	public String getTextFromClockOutClockInPanel() 
	{
		WaitUtility.waitForElementToBePresent(driver, clockOutClockInPanel);
		return PageUtility.getTextFromElement(clockedInText);
	}
 
 public void clickOnClockOut()
 {
	 WaitUtility.waitForElementToBeClickable(driver, clockOutButton);
	 PageUtility.clickOnElement(clockOutButton);
	 
 }
 public String enterNotesInClockOutPopUp(String excelFilePath) throws IOException
 {
	 WaitUtility.waitForElementToBeClickable(driver, clockOutNotesTextField);
	 String notes = ExcelUtilities.getString(0, 1, excelFilePath, "ClockInOut")+ FakerUtility.randomNumberCreation();
	 PageUtility.enterText(clockOutNotesTextField, notes);
	 return notes;
 }
public void saveNotesInClockOutPopUp() 
{
	WaitUtility.waitForElementToBeClickable(driver, clockOutNotesSaveButton);
	PageUtility.clickOnElement(clockOutNotesSaveButton);
	PageUtility.pageRefresh(driver);
}

public void clickOnClockIn() 
{
	WaitUtility.waitForElementToBeClickable(driver, clockInButton);
	PageUtility.clickOnElement(clockInButton);
	PageUtility.pageRefresh(driver);
}

public void clickOnTimeCardButton()
{
	WaitUtility.waitForElementToBeClickable(driver, timeCardButton);
	PageUtility.clickOnElement(timeCardButton);
}

public void clickOnLeaveButton()
{
	PageUtility.clickOnElement(leaveButton);
}
public void clickOnOpenMyTaskPanel()
{
	PageUtility.clickOnElement(openMyTaskPanel);
}
public void clickOnInvoiceButton()
{
	PageUtility.clickOnElement(invoiceButton);
}
public void clickOnTeamMemebersButton()
{
	PageUtility.clickOnElement(teamMembersButton);
}
public void clickOnAnnouncementsButton()
{
	PageUtility.clickOnElement(announcementsButton);
}
public void clickOnMessageButton()
{
	PageUtility.clickOnElement(messageButton);
}
public void clickOnTicketsButton()
{
	PageUtility.clickOnElement(ticketsButton);
}
public String noOfTickets()
{
	return noOfTicketsDisplayed.getText();
}
public void clickOnDashboardButton()
{
	PageUtility.clickOnElement(dashboardButton);
}
//public void getTextOf
//}
}
