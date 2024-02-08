package pageClasses;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.ExcelUtilities;
import utilities.PageUtility;
import utilities.WaitUtility;

public class QALegendInvoicePage {
	WebDriver driver;
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
{WaitUtility.waitForElementToBeClickable(driver, addInvoiceButton);
	PageUtility.clickOnElement(addInvoiceButton);
}
public void enterInvoiceDueDate(String excelFilePath) throws IOException
{
//	String dueDate = ExcelUtilities.getDateValue(1, 1, excelFilePath, "InvoicePage");
//	PageUtility.enterText(invoiceDueDateField, dueDate);
	PageUtility.clickOnElement(invoiceDueDateField);
	PageUtility.clickOnElement(dateFromPicker);
	
}
public String selectClientfromClientDropdown()
{
	WaitUtility.waitForElementToBePresent(driver, clientDropdown);
	PageUtility.clickOnElement(clientDropdown);
	String expectedClient = PageUtility.getTextFromElement(clientSelect);
	PageUtility.clickOnElement(clientSelect);
	
	return expectedClient;
}

public void clickOnSaveInAddInvoicePopUp()
{
	//PageUtility.clickOnElement(saveButtonForAddInvoicePopUp);
	WaitUtility.waitForElementToBeClickable(driver, saveButtonForAddInvoicePopUp);
	PageUtility.clickOnElement(saveButtonForAddInvoicePopUp);
	//PageUtility.clickOnElementUsingJavaScriptExecutor(saveButtonForAddInvoicePopUp, driver);
	
}
public void clickOnAddItem()
{WaitUtility.waitForElementToBeClickable(driver, addItemButton);
	PageUtility.clickOnElement(addItemButton);
}
public void selectItemFromItemDropdown()
{WaitUtility.waitForElementToBeClickable(driver, itemDropdown);
	PageUtility.clickOnElement(itemDropdown);
	PageUtility.clickOnElement(selectItemFromDropdown);
}

public String enterQuantity(String excelFilePath) throws IOException
{
	String quantity = ExcelUtilities.getNumeric(3,1, excelFilePath, "InvoicePage");
	PageUtility.enterText(quantityField, quantity);
return quantity;
}
public String getQuantityUnit() throws IOException
{
	String qtyUnit = PageUtility.getTextFromElement(quantityUnit);
	System.out.println(qtyUnit);
return qtyUnit;
}

public void clickOnSubmitFromAddItemPopUp()
{WaitUtility.waitForElementToBeClickable(driver, submitAddItemPopUp);
	PageUtility.clickOnElement(submitAddItemPopUp);
}
public String getActualClient()
{
	PageUtility.pageRefresh(driver);
	String actClient = PageUtility.getTextFromElement(actualClient);
	return actClient;
}
public String getActualQuantity()
{
	
	String actualQty = PageUtility.getTextFromElement(actualQuantity);
	return actualQty;
}
}
