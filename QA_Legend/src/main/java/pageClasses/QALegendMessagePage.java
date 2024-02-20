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


public class QALegendMessagePage {

WebDriver driver;
PageUtility pageUtil = new PageUtility();
DateUtility dateUtil = new DateUtility();
ExcelUtilities excelUtil = new ExcelUtilities();
WaitUtility waitUtil = new WaitUtility();
FakerUtility fakerUtil = new FakerUtility();

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
		waitUtil.waitForElementToBeClickable(driver, recepientDropDown);
		//pageUtil.clickOnElementUsingJavaScriptExecutor(recepientDropDown, driver);
		pageUtil.clickOnElement(recepientDropDown);
	}
	
	public void clickOnComposeButton()
	{pageUtil.pageRefresh(driver);
		waitUtil.waitForElementToBeClickable(driver, composeButton);
	//pageUtil.clickOnElementUsingJavaScriptExecutor(composeButton,driver);
		pageUtil.clickOnElement(composeButton);
	}
	
	public void selectRecepientFromDropdown()
	{waitUtil.waitForElementToBeClickable(driver, selectRecepient);
		//pageUtil.clickOnElementUsingJavaScriptExecutor(selectRecepient,driver);
	pageUtil.clickOnElement(selectRecepient);	
	
	}
	public String enterSubjectInComposeMessagePopUp(String excelFilePath) throws IOException
	{
		String subject = excelUtil.getString(0, 1, excelFilePath, "MessagePage")+fakerUtil.randomNumberCreation();
		pageUtil.enterText(subjectField, subject);
		return subject;
	}
	public String enterMessagetInComposeMessagePopUp(String excelFilePath) throws IOException
	{
		String message = excelUtil.getString(1, 1, excelFilePath, "MessagePage")+fakerUtil.randomNumberCreation();
		pageUtil.enterText(messageField, message);
		return message;
	}
	public void clickOnSaveButton()
	{
		pageUtil.clickOnElement(saveButton);
	}
	public void clickOnSentItems()
	{
		pageUtil.pageRefresh(driver);
		waitUtil.waitForElementToBeClickable(driver, sentItemsButton);
		pageUtil.clickOnElement(sentItemsButton);
	}
	public void clickOnTheMessageSentFromSentItems()
	{waitUtil.waitForElementToBePresent(driver, sentMessage);
		pageUtil.clickOnElement(sentMessage);
	}
	public String getActualSubject()
	{
		String actSubject = pageUtil.getTextFromElement(actualSubject);
		return actSubject;
	}
	public String getActualMessage()
	{
		String actMessage = pageUtil.getTextFromElement(actualMessage);
		return actMessage;
	}
}
