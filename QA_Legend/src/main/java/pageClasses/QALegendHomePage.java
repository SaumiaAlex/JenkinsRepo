package pageClasses;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.DateUtility;
import utilities.ExcelUtilities;
import utilities.FakerUtility;
import utilities.PageUtility;
import utilities.WaitUtility;


public class QALegendHomePage {
	
	WebDriver driver;
	
	PageUtility pageUtil = new PageUtility();
	DateUtility dateUtil = new DateUtility();
	ExcelUtilities excelUtil = new ExcelUtilities();
	WaitUtility waitUtil = new WaitUtility();
	FakerUtility fakerUtil = new FakerUtility();
	
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
	@FindBy(xpath = "//li[@class='    main']")//"//img[@class='dashboard-image']")
	List<WebElement>dashboardImage;
	
	
	
	
	
	public QALegendHomePage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}








 public void userLogOut()
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
		wait.until(ExpectedConditions.visibilityOf(userNameDropDown));
		pageUtil.clickOnElement(userNameDropDown);
		pageUtil.clickOnElement(signOutButton);
	}
 public String getProfileName()
 {
 	return pageUtil.getTextFromElement(userNameDropDown);
 }
 
 //Clock In Clock Out Operations
 public boolean clockOutDisplayedOrNot()
 {
	 waitUtil.waitForElementToBePresent(driver, clockOutClockInPanel);
	if(pageUtil.getTextFromElement(clockOutClockInPanel).contains("Clock Out"))
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
		//waitUtil.waitForElementToBePresent(driver, clockOutClockInPanel);
		return pageUtil.getTextFromElement(clockedInText);
	}
 
 public void clickOnClockOut()
 {
	 waitUtil.waitForElementToBeClickable(driver, clockOutButton);
	 pageUtil.clickOnElement(clockOutButton);
	 
 }
 public String enterNotesInClockOutPopUp(String excelFilePath) throws IOException
 {
	 waitUtil.waitForElementToBeClickable(driver, clockOutNotesTextField);
	 String notes = excelUtil.getString(0, 1, excelFilePath, "ClockInOut")+ fakerUtil.randomNumberCreation();
	 pageUtil.enterText(clockOutNotesTextField, notes);
	 return notes;
 }
public void saveNotesInClockOutPopUp() 
{
	waitUtil.waitForElementToBeClickable(driver, clockOutNotesSaveButton);
	pageUtil.clickOnElement(clockOutNotesSaveButton);
	pageUtil.pageRefresh(driver);
}

public void clickOnClockIn() 
{
	waitUtil.waitForElementToBeClickable(driver, clockInButton);
	pageUtil.clickOnElement(clockInButton);
	pageUtil.pageRefresh(driver);
}

public void clickOnTimeCardButton()
{
	waitUtil.waitForElementToBeClickable(driver, timeCardButton);
	pageUtil.clickOnElement(timeCardButton);
}

public void clickOnLeaveButton()
{
	pageUtil.clickOnElement(leaveButton);
}
public void clickOnOpenMyTaskPanel()
{
	pageUtil.clickOnElement(openMyTaskPanel);
}
public void clickOnInvoiceButton()
{
	pageUtil.clickOnElement(invoiceButton);
}
public void clickOnTeamMemebersButton()
{
	pageUtil.clickOnElement(teamMembersButton);
}
public void clickOnAnnouncementsButton()
{
	pageUtil.clickOnElement(announcementsButton);
}
public void clickOnMessageButton()
{
	pageUtil.clickOnElement(messageButton);
}
public void clickOnTicketsButton()
{
	pageUtil.clickOnElement(ticketsButton);
}
public String noOfTickets()
{
	return noOfTicketsDisplayed.getText();
}
public void clickOnDashboardButton()
{
	pageUtil.clickOnElement(dashboardButton);
}

public boolean toCheckLoggedInorNot()
{
	pageUtil.pageRefresh(driver);
	int size = dashboardImage.size();
	if(size >1)
	{
		return true;
	}
	else
	{
		return false;
	}
}

}
