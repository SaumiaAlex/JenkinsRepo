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
	@FindBy(xpath = "//button[@id='submit']")
	WebElement saveButton;
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public QALegendAnnouncementsPAge(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	
	
	
	
	
	
	public void clickOnAddAnnouncementButton()
	{
		PageUtility.clickOnElement(addAnnouncementButton);
	}
	public void enterTitle(String excelFilePath) throws IOException
	{
		String title= ExcelUtilities.getString(0, 1, excelFilePath, "Announcements")+FakerUtility.randomNumberCreation();
		PageUtility.enterText(titleField, title);
	}
	public void enterStartDate(String excelFilePath) throws IOException
	{
		String startDate = DateUtility.convertToDateFormat(ExcelUtilities.getDateValue(1, 1, excelFilePath, "Announcements")) ;
		PageUtility.enterText(startDateField, startDate);
	}
	public void enterEndDate(String excelFilePath) throws IOException
	{
		String endDate = DateUtility.convertToDateFormat(ExcelUtilities.getDateValue(1, 1, excelFilePath, "Announcements")) ;
		PageUtility.enterText(endDateField, endDate);
	}
	public void clickOnSave()
	{
		PageUtility.clickOnElement(saveButton);
	}
}
