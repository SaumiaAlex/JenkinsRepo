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
PageUtility pageUtil = new PageUtility();
DateUtility dateUtil = new DateUtility();
ExcelUtilities excelUtil = new ExcelUtilities();
WaitUtility waitUtil = new WaitUtility();
FakerUtility fakerUtil = new FakerUtility();

	
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
		pageUtil.clickOnElement(addAnnouncementButton);
	}
	public String enterTitle(String excelFilePath) throws IOException
	{
		String title= excelUtil.getString(0, 1, excelFilePath, "Announcements")+fakerUtil.randomNumberCreation();
		pageUtil.enterText(titleField, title);
		return title;
	}
	public void enterStartDate(String excelFilePath) throws IOException
	{
		String startDate = dateUtil.getCurrentDate();
		pageUtil.enterText(startDateField, startDate);
	}
	public void enterEndDate(String excelFilePath) throws IOException
	{
		String endDate = dateUtil.getCurrentDate() ;
		pageUtil.enterText(endDateField, endDate);
	}
	public void clickOnSave()
	{
		
		pageUtil.scrollThePage(saveButton, driver);
		waitUtil.waitForElementToBeClickable(driver, saveButton);
		pageUtil.clickOnElement(saveButton);
	}
	public void goBackToAnnouncementsPage()
	{
		pageUtil.navigateBack(driver);
	}
	public void searchForExpectedAnnouncement(String expectedAnnouncement)
	{
		pageUtil.enterText(announcementsSearchBox, expectedAnnouncement);
	}
	public String getTextOfActualAnnouncementTitle()
	{
		return pageUtil.getTextFromElement(announcementActualTitle);
		
	}
}
