package pageClasses;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.ExcelUtilities;
import utilities.FakerUtility;
import utilities.PageUtility;

public class QALegendTaskPage {
	
	WebDriver driver;
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
		PageUtility.clickOnElement(addTaskButton);
		
	}
	

	public String addTextToTitleField(String excelFieldPath) throws IOException 
	{
		String title = ExcelUtilities.getString(0, 1, excelFieldPath, "TaskPage")+FakerUtility.randomNumberCreation();
		PageUtility.enterText(titleTextField, title);
		return title;
		
	}

	public void addProjectFromDropDown() throws IOException 
	{
		
		PageUtility.clickOnElement(projectDropdown);
		PageUtility.clickOnElement(projectName);
		
	}
	
	public String clickOnSaveAddTaskPopUp()
	{
		PageUtility.clickOnElement(addTaskPopUpSaveButton);
		PageUtility.pageRefresh(driver);
		String title = PageUtility.getTextFromElement(actualTaskTitle);
		return title;
		
	}
}
