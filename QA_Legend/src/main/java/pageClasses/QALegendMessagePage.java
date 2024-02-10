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

public class QALegendMessagePage {

WebDriver driver;
	@FindBy(xpath = "//span[@id='select2-chosen-3']")
	WebElement recepientDropDown;
	@FindBy(xpath = "//a[text()='Compose']")
	WebElement composeButton;
	@FindBy(xpath = "//div[text()='Saumia Alex']")
	WebElement selectRecepient;
	@FindBy(xpath = "//input[@id='subject']")
	WebElement subjectField;
	@FindBy(xpath = "//textarea[@id='message']")
	WebElement messageField;
	@FindBy(xpath = "//button[@type='submit']")
	WebElement saveButton;
	@FindBy(xpath = "//a[text()='Sent items']")
	WebElement sentItemsButton;
	@FindBy(xpath = "(//div[@class='media-body'])[1]")
	WebElement sentMessage;
	@FindBy(xpath  ="((//div[@class='row'])[2]//child::p)[1]")
	WebElement actualSubject;
	@FindBy(xpath = "((//div[@class='row'])[2]//child::p)[2]")
	WebElement actualMessage;
	
	
	
	
	
	
	
	public QALegendMessagePage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	
	public void clickOnRecepientDropDown()
	{
		WaitUtility.waitForElementToBeClickable(driver, recepientDropDown);
		//PageUtility.clickOnElementUsingJavaScriptExecutor(recepientDropDown, driver);
		PageUtility.clickOnElement(recepientDropDown);
	}
	
	public void clickOnComposeButton()
	{PageUtility.pageRefresh(driver);
		WaitUtility.waitForElementToBeClickable(driver, composeButton);
	//PageUtility.clickOnElementUsingJavaScriptExecutor(composeButton,driver);
		PageUtility.clickOnElement(composeButton);
	}
	
	public void selectRecepientFromDropdown()
	{WaitUtility.waitForElementToBeClickable(driver, selectRecepient);
		//PageUtility.clickOnElementUsingJavaScriptExecutor(selectRecepient,driver);
	PageUtility.clickOnElement(selectRecepient);	
	
	}
	public String enterSubjectInComposeMessagePopUp(String excelFilePath) throws IOException
	{
		String subject = ExcelUtilities.getString(0, 1, excelFilePath, "MessagePage")+FakerUtility.randomNumberCreation();
		PageUtility.enterText(subjectField, subject);
		return subject;
	}
	public String enterMessagetInComposeMessagePopUp(String excelFilePath) throws IOException
	{
		String message = ExcelUtilities.getString(1, 1, excelFilePath, "MessagePage")+FakerUtility.randomNumberCreation();
		PageUtility.enterText(messageField, message);
		return message;
	}
	public void clickOnSaveButton()
	{
		PageUtility.clickOnElement(saveButton);
	}
	public void clickOnSentItems()
	{
		PageUtility.pageRefresh(driver);
		WaitUtility.waitForElementToBeClickable(driver, sentItemsButton);
		PageUtility.clickOnElement(sentItemsButton);
	}
	public void clickOnTheMessageSentFromSentItems()
	{WaitUtility.waitForElementToBePresent(driver, sentMessage);
		PageUtility.clickOnElement(sentMessage);
	}
	public String getActualSubject()
	{
		String actSubject = PageUtility.getTextFromElement(actualSubject);
		return actSubject;
	}
	public String getActualMessage()
	{
		String actMessage = PageUtility.getTextFromElement(actualMessage);
		return actMessage;
	}
}
