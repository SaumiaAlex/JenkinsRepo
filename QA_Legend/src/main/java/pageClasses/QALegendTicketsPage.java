package pageClasses;

import java.awt.AWTException;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtility;

public class QALegendTicketsPage {
WebDriver driver;
	
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
	
	@FindBy(id="title")
	WebElement input_FieldTitle;
	@FindBy(xpath = "//div[@class='form-group']//label[@for='client_id']")
	WebElement dropdownIcon;
	
	@FindBy(xpath  = "//select[@name='client_id']")
	WebElement selectDropDown;
	
	@FindBy(xpath="//ul//li//div[@class='select2-result-label' and text()='APS Test Company ']]")
	WebElement inputSearch_Client;
	
	@FindBy(id="description")
	WebElement input_Description;
	
	@FindBy(xpath="//button[text()=' Save']")
	WebElement clickOnSave;
	
	public QALegendTicketsPage(WebDriver driver)
	{
		// TODO Auto-generated constructor stub
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	public void input_AddTicket()
	{
		PageUtility.clickOnElement(addNewTicket);
	}
	public void input_Title()
	{
		PageUtility.clickOnElement(input_FieldTitle);
	}
	public void input_Description()
	{
		PageUtility.clickOnElement(input_Description);
	}
	public void clickOnPrint()
	{
		PageUtility.clickOnElement(buttonPrint);
	}
	
	public void inputClient()
	{
		PageUtility.clickOnElement(dropdownIcon);
	}
	public void selectFromDropDown(String company) throws AWTException
	{
		PageUtility.clickOnElementUsingJavaScriptExecutor(selectDropDown,driver);
		PageUtility.scrollThePage(inputSearch_Client, driver);
		PageUtility.clickOnElementUsingJavaScriptExecutor(inputSearch_Client,driver);
		PageUtility.robotSearchClient();
	}
	public String countTheNoOfTickets()
	{
		PageUtility.windowHandling(driver);
		//List<Integer> rowSizes = new ArrayList<>();
		List<WebElement> rows = noOfTickets; // Assuming rows are within a <tbody>
		System.out.println(rows.size());// assertion
		
		  return String.valueOf(rows.size()-1);
		
		
	}
	public void switchParentTab()
	{
		PageUtility.switchWindowToParentTab(driver);
	}
	public void clickOnSave()
	{
		PageUtility.clickOnElement(clickOnSave);
	}
    
}



