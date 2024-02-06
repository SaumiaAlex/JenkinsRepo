package pageClasses;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.ExcelUtilities;
import utilities.FakerUtility;
import utilities.PageUtility;

public class QALegendTeamMembersPage {
	WebDriver driver;
	
	@FindBy(xpath = "//a[@title='Add member']")
WebElement addMembersButton;
	@FindBy(id = "first_name")
	WebElement firstNameField;
	@FindBy(id = "last_name")
	WebElement lastNameField;
	@FindBy(xpath = "//button[@id='form-next']")
	WebElement nextButton;
	@FindBy(xpath = "//button[@id='form-submit']")
	WebElement saveButton;
	@FindBy(xpath = "//input[@id='job_title']")
	WebElement jobTitleField;
	@FindBy(xpath="//input[@id='email']")
	WebElement emailField;
	@FindBy(xpath="//input[@id='password']")
	WebElement passwordField;
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public QALegendTeamMembersPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	
	
	
	public void clickOnAddMembersButton()
	{
		PageUtility.clickOnElement(addMembersButton);
	}
	public void enterFirstName(String excelFilePath) throws IOException
	{
		String firstName = ExcelUtilities.getString(0, 1, excelFilePath, "TeamMembers")+FakerUtility.randomNumberCreation();
		PageUtility.enterText(firstNameField, firstName);
	}
	public void enterLastName(String excelFilePath) throws IOException
	{
		String lastName = ExcelUtilities.getString(1, 1, excelFilePath, "TeamMembers")+FakerUtility.randomNumberCreation();
		PageUtility.enterText(lastNameField, lastName);
	}
	
	public void clickOnNextButton()
	{
		PageUtility.clickOnElement(nextButton);
	}
	public void enterJobTitle(String excelFilePath) throws IOException
	{
		String jobTitle= ExcelUtilities.getString(2, 1, excelFilePath, "TeamMembers")+FakerUtility.randomNumberCreation();
		PageUtility.enterText(jobTitleField, jobTitle);
	}
	
	public void enterEmail(String excelFilePath) throws IOException
	{
		String email = FakerUtility.randomNumberCreation()+ExcelUtilities.getString(3, 1, excelFilePath, "TeamMembers");
		PageUtility.enterText(emailField, email);
	}
	public void enterPassword(String excelFilePath) throws IOException
	{
		String password = ExcelUtilities.getString(4, 1, excelFilePath, "TeamMembers");
		PageUtility.enterText(passwordField, password);
	}
	public void clickOnSaveButton()
	{
		PageUtility.clickOnElement(saveButton);
	}
}
