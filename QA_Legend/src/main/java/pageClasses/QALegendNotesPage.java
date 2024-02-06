package pageClasses;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.ExcelUtilities;
import utilities.FakerUtility;
import utilities.PageUtility;
import utilities.WaitUtility;

public class QALegendNotesPage {
	
	WebDriver driver;
	
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
	PageUtility.clickOnElement(notesButton);
}

public void clickOnAddNotesButton() 
{
	PageUtility.clickOnElement(addNotesButton);
}
public String enterTitleInAddNotesPopUp(String excelFilePath) throws IOException 
{
	String titleText = ExcelUtilities.getString(1, 0, excelFilePath, "Notes")+ FakerUtility.randomNumberCreation();
	PageUtility.enterText(enterTitle,titleText);
	return titleText;
}
public void clickOnSave()
{
	PageUtility.clickOnElement(saveButton);
}

public String getActualTitle()
{
	PageUtility.pageRefresh(driver);
	WaitUtility.waitForElementToBePresent(driver, actualTitle);
	return PageUtility.getTextFromElement(actualTitle);
}

}