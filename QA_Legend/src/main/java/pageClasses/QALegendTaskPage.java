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


public class QALegendTaskPage {
	
	WebDriver driver;
	PageUtility pageUtil = new PageUtility();
	DateUtility dateUtil = new DateUtility();
	ExcelUtilities excelUtil = new ExcelUtilities();
	WaitUtility waitUtil = new WaitUtility();
	FakerUtility fakerUtil = new FakerUtility();
	
	@FindBy(xpath = "(//a[@title='Add task'])[2]")
	WebElement addTaskButton;
	@FindBy(xpath = "//input[@id='title']") 
	WebElement titleTextField;
	@FindBy (xpath = "//div[@title='Project']") 
	WebElement projectDropdown;
	@FindBy(xpath = "//button[@class='btn btn-primary']") 
	WebElement addTaskPopUpSaveButton;
	@FindBy(xpath = "//div[text()='CRM New Project']")
	WebElement projectName;
	@FindBy(xpath = "(//tr[@role='row'])[2]//child::td[2]")
	WebElement actualTaskTitle;
	  
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public QALegendTaskPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
















	public void clickOnAddTaskButton() 
	{
		pageUtil.clickOnElement(addTaskButton);
		
	}
	

	public String addTextToTitleField(String excelFieldPath) throws IOException 
	{
		String title = excelUtil.getString(0, 1, excelFieldPath, "TaskPage")+fakerUtil.randomNumberCreation();
		pageUtil.enterText(titleTextField, title);
		return title;
		
	}

	public void addProjectFromDropDown() throws IOException 
	{
		
		pageUtil.clickOnElement(projectDropdown);
		pageUtil.clickOnElement(projectName);
		
	}
	
	public String clickOnSaveAddTaskPopUp()
	{
		pageUtil.clickOnElement(addTaskPopUpSaveButton);
		pageUtil.pageRefresh(driver);
		String title = pageUtil.getTextFromElement(actualTaskTitle);
		return title;
		
	}
}
