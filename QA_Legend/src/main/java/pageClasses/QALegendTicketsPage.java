package pageClasses;

import java.awt.AWTException;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.DateUtility;
import utilities.ExcelUtilities;
import utilities.FakerUtility;
import utilities.PageUtility;
import utilities.WaitUtility;


public class QALegendTicketsPage {
WebDriver driver;
PageUtility pageUtil = new PageUtility();
DateUtility dateUtil = new DateUtility();
ExcelUtilities excelUtil = new ExcelUtilities();
WaitUtility waitUtil = new WaitUtility();
FakerUtility fakerUtil = new FakerUtility();
	
	@FindBy(xpath = "//span[text()='Print']")
	WebElement buttonPrint;
	
	@FindBy(xpath = "//table")
	WebElement ticketsTable;
	
	@FindBy(xpath = "//tbody//child::tr")
	List<WebElement> noOfTickets;
	
	@FindBy(xpath = "//a[@title='Add ticket' and text()=' Add ticket']")
	WebElement addNewTicket;
	
	@FindBy(id="title")
	WebElement inputField_Title;
	
	@FindBy(xpath = "//div[@id='s2id_client_id']")//"(//span[@class='select2-chosen'])[2]")
	WebElement clientDropdown;
	
	@FindBy(xpath = "(//div[text()='AAC Corporation '])[1]")
	WebElement selectClient;
	
	@FindBy(xpath = "//textArea[@name='description']")//id="description")
	WebElement input_Description;
	
	@FindBy(xpath="//button[text()=' Save']")
	WebElement clickOnSave;
	
	@FindBy(xpath = "//input[@type='search']")
	WebElement searchField;
	
	@FindBy(xpath = "(//tr[@role='row'])[2]//child::td[2]//child::a")
	WebElement actualTicketTitle;
	
	@FindBy(xpath = "//div[@class='media-body']//child::p")
	WebElement actualDescription;
	
	@FindBy(xpath = "//span[text()='New']")
	List<WebElement> status;
	
	@FindBy(xpath = "(//span[@class='select2-chosen'])[1]")
	WebElement listDropdrown;
	
	@FindBy(xpath = "//div[text()='All']")
	WebElement selectAllfromDropdown;
	
	
	
	
	
	
	public QALegendTicketsPage(WebDriver driver)
	{
		// TODO Auto-generated constructor stub
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	
	
	
	
	
	
	
	public void clickOnAddTicket()
	{
		pageUtil.clickOnElement(addNewTicket);
	}
	public String input_Title(String excelFilePath) throws IOException
	{
		String title = excelUtil.getString(0, 1, excelFilePath, "TicketsPage")+fakerUtil.randomNumberCreation();
		pageUtil.enterText(inputField_Title, title);
		//pageUtil.clickOnElement(inputField_Title);
		return title;
	}
	public String input_Description(String excelFilePath) throws IOException
	{
		waitUtil.waitForElementToBePresent(driver, input_Description);
		String description = excelUtil.getString(1, 1, excelFilePath, "TicketsPage")+fakerUtil.randomNumberCreation();
		waitUtil.waitForElementToBePresent(driver, input_Description);
		pageUtil.enterText(input_Description, description);
		//pageUtil.clickOnElement(input_Description);
		return description;
	}
	public void clickOnPrint()
	{
		pageUtil.clickOnElement(buttonPrint);
	}
	
	public void inputClient()
	{
		waitUtil.waitForElementToBeClickable(driver, clientDropdown);
		pageUtil.clickOnElement(clientDropdown);
		pageUtil.clickOnElement(selectClient);
		
	}

	public void switchParentTab()
	{
		pageUtil.switchWindowToParentTab(driver);
	}
	public void clickOnSave()
	{
		pageUtil.clickOnElement(clickOnSave);
	}
	
	public void searchForTicket(String title)
	{
		pageUtil.pageRefresh(driver);
		pageUtil.enterText(searchField, title);
	}
	
	public String getActualTicketTitle()
	{
		waitUtil.waitForElementToBePresent(driver, actualTicketTitle);
		return pageUtil.getTextFromElement(actualTicketTitle);
	}
	
	public void clickOnActualTicketTitle()
	{
		pageUtil.clickOnElement(actualTicketTitle);
	}
	
	public String getActualTicketDescription()
	{
		return pageUtil.getTextFromElement(actualDescription);
	}
	
	public void listAllTicketsInTicketsPage()
	{
		pageUtil.navigateBack(driver);
		pageUtil.clickOnElement(listDropdrown);
		pageUtil.clickOnElement(selectAllfromDropdown);
		
	}
	
	public String getActualNewTicketNumber()
	{
		return String.valueOf(status.size());
	}
	
	
    
}



