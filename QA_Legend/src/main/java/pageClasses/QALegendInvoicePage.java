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


public class QALegendInvoicePage {
	WebDriver driver;
	PageUtility pageUtil = new PageUtility();
	DateUtility dateUtil = new DateUtility();
	ExcelUtilities excelUtil = new ExcelUtilities();
	WaitUtility waitUtil = new WaitUtility();
	
	@FindBy(xpath = "//a[@title='Add invoice']")
	WebElement addInvoiceButton;
	@FindBy(name = "invoice_due_date")
	WebElement invoiceDueDateField;
	@FindBy(xpath = "//div[@id='s2id_invoice_client_id']")//"((//label[text()='Client']//parent::div)[3]")
	WebElement clientDropdown;
	@FindBy (xpath = "(//div[text()='AAC Corporation '])[1]")
	WebElement clientSelect;
	@FindBy (xpath = "//button[@type='submit']")//"//button[@class='btn btn-primary']")
	WebElement saveButtonForAddInvoicePopUp;
	@FindBy(xpath = "//td[text()='10']")
	WebElement dateFromPicker;
	@FindBy (xpath = "(//th[@class='next'])[1]")
	WebElement nextMonth;
	@FindBy(xpath = "//a[@title='Add item']")
	WebElement addItemButton;
	@FindBy(xpath = "//span[text()='Select from list or create new item...']")
	WebElement itemDropdown;
	@FindBy(xpath ="//div[text()='Item new']")
	WebElement selectItemFromDropdown;
	@FindBy(xpath ="//input[@id='invoice_item_quantity']")
	WebElement quantityField;
	@FindBy(xpath = "//input[@id='invoice_item_rate']")
	WebElement rateField;
	@FindBy(xpath = "//button[@type='submit']")
	WebElement submitAddItemPopUp;
	@FindBy(xpath = "//strong[text()='AAC Corporation ']")
	WebElement actualClient;
	@FindBy(xpath = "(//tr[@role='row']//child::td)[2]")
	WebElement actualQuantity;
	@FindBy(xpath = "//input[@id='invoice_unit_type']")
	WebElement quantityUnit;
	
	
	



















public QALegendInvoicePage(WebDriver driver) {
		// TODO Auto-generated constructor stub
	this.driver = driver;
	PageFactory.initElements(driver, this);
	}




















public void clickOnAddInvoice()
{waitUtil.waitForElementToBePresent(driver, addInvoiceButton);
	pageUtil.clickOnElement(addInvoiceButton);
}
public void enterInvoiceDueDate(String excelFilePath) throws IOException
{
//	String dueDate = excelUtil.getDateValue(1, 1, excelFilePath, "InvoicePage");
//	pageUtil.enterText(invoiceDueDateField, dueDate);
	pageUtil.clickOnElement(invoiceDueDateField);
	pageUtil.clickOnElement(nextMonth);
	pageUtil.clickOnElement(dateFromPicker);
	
}
public String selectClientfromClientDropdown()
{
	waitUtil.waitForElementToBePresent(driver, clientDropdown);
	pageUtil.clickOnElement(clientDropdown);
	String expectedClient = pageUtil.getTextFromElement(clientSelect);
	pageUtil.clickOnElement(clientSelect);
	
	return expectedClient;
}

public void clickOnSaveInAddInvoicePopUp()
{
	//pageUtil.clickOnElement(saveButtonForAddInvoicePopUp);
	waitUtil.waitForElementToBeClickable(driver, saveButtonForAddInvoicePopUp);
	pageUtil.clickOnElement(saveButtonForAddInvoicePopUp);
	//pageUtil.clickOnElementUsingJavaScriptExecutor(saveButtonForAddInvoicePopUp, driver);
	
}
public void clickOnAddItem()
{waitUtil.waitForElementToBeClickable(driver, addItemButton);
	pageUtil.clickOnElement(addItemButton);
}
public void selectItemFromItemDropdown()
{waitUtil.waitForElementToBeClickable(driver, itemDropdown);
	pageUtil.clickOnElement(itemDropdown);
	pageUtil.clickOnElement(selectItemFromDropdown);
}

public String enterQuantity(String excelFilePath) throws IOException
{
	String quantity = excelUtil.getNumeric(3,1, excelFilePath, "InvoicePage");
	pageUtil.enterText(quantityField, quantity);
return quantity;
}
public String getQuantityUnit() throws IOException
{
	String qtyUnit = pageUtil.getTextFromElement(quantityUnit);
	System.out.println(qtyUnit);
return qtyUnit;
}

public void clickOnSubmitFromAddItemPopUp()
{waitUtil.waitForElementToBeClickable(driver, submitAddItemPopUp);
	pageUtil.clickOnElement(submitAddItemPopUp);
}
public String getActualClient()
{
	pageUtil.pageRefresh(driver);
	String actClient = pageUtil.getTextFromElement(actualClient);
	return actClient;
}
public String getActualQuantity()
{
	waitUtil.waitForElementToBePresent(driver, actualQuantity);
	String actualQty = pageUtil.getTextFromElement(actualQuantity);
	return actualQty;
}
}
