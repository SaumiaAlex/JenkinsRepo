package pageClasses;

import java.io.IOException;
import java.sql.Date;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.DateUtility;
import utilities.ExcelUtilities;
import utilities.FakerUtility;
import utilities.PageUtility;
import utilities.WaitUtility;

public class QALegendAnnouncementsPAge {

WebDriver driver;
	
	@FindBy(xpath = "//a[@title='Add announcement']")
WebElement addAnnouncementButton;
	@FindBy(xpath = "//input[@id='title']")
	WebElement titleField;
	@FindBy(xpath = "//input[@id='start_date']")
	WebElement startDateField;
	@FindBy(xpath = "//input[@id='end_date']")
	WebElement endDateField;
	@FindBy(xpath = "//button[@type='submit']")
	WebElement saveButton;
	@FindBy(xpath ="//input[@type='search']")
	WebElement announcementsSearchBox;
	@FindBy(xpath = "//a[@title='View']")
	WebElement announcementActualTitle;
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public QALegendAnnouncementsPAge(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	
	
	
	
	
	
	public void clickOnAddAnnouncementButton()
	{
		PageUtility.clickOnElement(addAnnouncementButton);
	}
	public String enterTitle(String excelFilePath) throws IOException
	{
		String title= ExcelUtilities.getString(0, 1, excelFilePath, "Announcements")+FakerUtility.randomNumberCreation();
		PageUtility.enterText(titleField, title);
		return title;
	}
	public void enterStartDate(String excelFilePath) throws IOException
	{
		String startDate = DateUtility.getCurrentDate();
		PageUtility.enterText(startDateField, startDate);
	}
	public void enterEndDate(String excelFilePath) throws IOException
	{
		String endDate = DateUtility.getCurrentDate() ;
		PageUtility.enterText(endDateField, endDate);
	}
	public void clickOnSave()
	{
		
		PageUtility.scrollThePage(saveButton, driver);
		WaitUtility.waitForElementToBeClickable(driver, saveButton);
		PageUtility.clickOnElement(saveButton);
	}
	public void goBackToAnnouncementsPage()
	{
		PageUtility.navigateBack(driver);
	}
	public void searchForExpectedAnnouncement(String expectedAnnouncement)
	{
		PageUtility.enterText(announcementsSearchBox, expectedAnnouncement);
	}
	public String getTextOfActualAnnouncementTitle()
	{
		return PageUtility.getTextFromElement(announcementActualTitle);
		
	}
}
