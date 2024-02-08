package pageClasses;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.ExcelUtilities;
import utilities.FakerUtility;
import utilities.PageUtility;
import utilities.WaitUtility;

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
	@FindBy(xpath = "//input[@type='search']")
	WebElement teamMembersSearchBox;
@FindBy(xpath = "((//tr[@role='row'])[2]//child::td)[3]")
WebElement jobTitleInTable;
@FindBy(xpath = "((//tr[@role='row'])[2]//child::a)[1]")
WebElement nameInTable;
@FindBy(xpath = "((//tr[@role='row'])[2]//child::td)[4]")
WebElement emailInTable;
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public QALegendTeamMembersPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	
	
	
	public void clickOnAddMembersButton()
	{
		PageUtility.clickOnElement(addMembersButton);
	}
	public String enterFirstName(String excelFilePath) throws IOException
	{
		String firstName = ExcelUtilities.getString(0, 1, excelFilePath, "TeamMembers")+FakerUtility.randomNumberCreation();
		PageUtility.enterText(firstNameField, firstName);
		return firstName;
	}
	public String enterLastName(String excelFilePath) throws IOException
	{
		String lastName = ExcelUtilities.getString(1, 1, excelFilePath, "TeamMembers")+FakerUtility.randomNumberCreation();
		PageUtility.enterText(lastNameField, lastName);
		return lastName;
	}
	
	public void clickOnNextButton()
	{
		PageUtility.clickOnElement(nextButton);
	}
	public String enterJobTitle(String excelFilePath) throws IOException
	{
		String jobTitle= ExcelUtilities.getString(2, 1, excelFilePath, "TeamMembers")+FakerUtility.randomNumberCreation();
		PageUtility.enterText(jobTitleField, jobTitle);
		return jobTitle;
	}
	
	public String enterEmail(String excelFilePath) throws IOException
	{
		String email = FakerUtility.randomNumberCreation()+ExcelUtilities.getString(3, 1, excelFilePath, "TeamMembers");
		PageUtility.enterText(emailField, email);
		return email;
	}
	public void enterPassword(String excelFilePath) throws IOException
	{
		String password = ExcelUtilities.getString(4, 1, excelFilePath, "TeamMembers");
		PageUtility.enterText(passwordField, password);
	}
	public void clickOnSaveButton()
	{
		PageUtility.clickOnElement(saveButton);
		PageUtility.pageRefresh(driver);
	}
	public void searchForTeamMember(String expectedTeamMember)
	{
		//WaitUtility.waitForElementToBePresent(driver, teamMembersSearchBox);
		WaitUtility.waitForElementToBeClickable(driver, teamMembersSearchBox);
		//PageUtility.clickOnElement(teamMembersSearchBox);
		PageUtility.enterText(teamMembersSearchBox, expectedTeamMember);
		//PageUtility.enterTextUsingActionClass(driver, teamMembersSearchBox, expectedTeamMember);
	}
	public String[] actualTeamMemberDetails()
	{
	WaitUtility.waitForElementToBePresent(driver,nameInTable);
		
		String actualMemberName = PageUtility.getTextFromElement(nameInTable);
		System.out.println(actualMemberName);
		String actualJobTitle = PageUtility.getTextFromElement(jobTitleInTable);
		System.out.println(actualJobTitle);
		String actualEmail = PageUtility.getTextFromElement(emailInTable);
		System.out.println(actualEmail);
		String memberDetails[]= {actualMemberName,actualJobTitle,actualEmail};
		return memberDetails;
		
	}
}
