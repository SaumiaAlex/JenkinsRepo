package pageClasses;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.DateUtility;
import utilities.ExcelUtilities;
import utilities.FakerUtility;
import utilities.PageUtility;
import utilities.WaitUtility;


public class QALegendTeamMembersPage {
	WebDriver driver;
	PageUtility pageUtil = new PageUtility();
	DateUtility dateUtil = new DateUtility();
	ExcelUtilities excelUtil = new ExcelUtilities();
	WaitUtility waitUtil = new WaitUtility();
	FakerUtility fakerUtil = new FakerUtility();
	
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
		pageUtil.clickOnElement(addMembersButton);
	}
	public String enterFirstName(String excelFilePath) throws IOException
	{
		String firstName = excelUtil.getString(0, 1, excelFilePath, "TeamMembers")+fakerUtil.randomNumberCreation();
		pageUtil.enterText(firstNameField, firstName);
		return firstName;
	}
	public String enterLastName(String excelFilePath) throws IOException
	{
		String lastName = excelUtil.getString(1, 1, excelFilePath, "TeamMembers")+fakerUtil.randomNumberCreation();
		pageUtil.enterText(lastNameField, lastName);
		return lastName;
	}
	
	public void clickOnNextButton()
	{
		pageUtil.clickOnElement(nextButton);
	}
	public String enterJobTitle(String excelFilePath) throws IOException
	{
		String jobTitle= excelUtil.getString(2, 1, excelFilePath, "TeamMembers")+fakerUtil.randomNumberCreation();
		pageUtil.enterText(jobTitleField, jobTitle);
		return jobTitle;
	}
	
	public String enterEmail(String excelFilePath) throws IOException
	{
		String email = fakerUtil.randomNumberCreation()+excelUtil.getString(3, 1, excelFilePath, "TeamMembers");
		pageUtil.enterText(emailField, email);
		return email;
	}
	public void enterPassword(String excelFilePath) throws IOException
	{
		String password = excelUtil.getString(4, 1, excelFilePath, "TeamMembers");
		pageUtil.enterText(passwordField, password);
	}
	public void clickOnSaveButton()
	{
		pageUtil.clickOnElement(saveButton);
		pageUtil.pageRefresh(driver);
	}
	public void searchForTeamMember(String expectedTeamMember)
	{
		//waitUtil.waitForElementToBePresent(driver, teamMembersSearchBox);
		waitUtil.waitForElementToBeClickable(driver, teamMembersSearchBox);
		//pageUtil.clickOnElement(teamMembersSearchBox);
		pageUtil.enterText(teamMembersSearchBox, expectedTeamMember);
		//pageUtil.enterTextUsingActionClass(driver, teamMembersSearchBox, expectedTeamMember);
	}
	public String[] actualTeamMemberDetails()
	{
	waitUtil.waitForElementToBePresent(driver,nameInTable);
		
		String actualMemberName = pageUtil.getTextFromElement(nameInTable);
		System.out.println(actualMemberName);
		String actualJobTitle = pageUtil.getTextFromElement(jobTitleInTable);
		System.out.println(actualJobTitle);
		String actualEmail = pageUtil.getTextFromElement(emailInTable);
		System.out.println(actualEmail);
		String memberDetails[]= {actualMemberName,actualJobTitle,actualEmail};
		return memberDetails;
		
	}
}
