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


public class QALegendNotesPage {
	
	WebDriver driver;
	PageUtility pageUtil = new PageUtility();
	DateUtility dateUtil = new DateUtility();
	ExcelUtilities excelUtil = new ExcelUtilities();
	WaitUtility waitUtil = new WaitUtility();
	FakerUtility fakerUtil = new FakerUtility();
	
@FindBy(xpath = "//span[text()='Notes']")
WebElement notesButton;
@FindBy(xpath = "//a[@class='btn btn-default']")
WebElement addNotesButton;
@FindBy(xpath = "//input[@id='title']")
WebElement enterTitle;
@FindBy(xpath = "//button[@class='btn btn-primary']")
WebElement saveButton;
@FindBy (xpath = "(//a[@title='Note'])[1]")
WebElement actualTitle;













public QALegendNotesPage(WebDriver driver) {
	// TODO Auto-generated constructor stub
	this.driver = driver;
	PageFactory.initElements(driver, this);
}














public void clickOnNotesButton()
{
	pageUtil.clickOnElement(notesButton);
}

public void clickOnAddNotesButton() 
{
	pageUtil.clickOnElement(addNotesButton);
}
public String enterTitleInAddNotesPopUp(String excelFilePath) throws IOException 
{
	String titleText = excelUtil.getString(1, 0, excelFilePath, "Notes")+ fakerUtil.randomNumberCreation();
	pageUtil.enterText(enterTitle,titleText);
	return titleText;
}
public void clickOnSave()
{
	pageUtil.clickOnElement(saveButton);
}

public String getActualTitle()
{
	pageUtil.pageRefresh(driver);
	waitUtil.waitForElementToBePresent(driver, actualTitle);
	return pageUtil.getTextFromElement(actualTitle);
}

}