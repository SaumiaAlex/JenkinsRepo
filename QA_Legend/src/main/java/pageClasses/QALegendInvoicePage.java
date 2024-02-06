package pageClasses;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.ExcelUtilities;
import utilities.PageUtility;

public class QALegendInvoicePage {
	WebDriver driver;
	@FindBy(xpath = "//a[@title='Add invoice']")
	WebElement addInvoiceButton;
	@FindBy(name = "invoice_due_date")
	WebElement invoiceDueDateField;
	@FindBy(xpath = "((//label[text()='Client']//parent::div)[3]")
	WebElement clientDropdown;
	@FindBy (xpath = "(//div[text()='AAC Corporation '])[1]")
	WebElement clientSelect;
	@FindBy (xpath = "//button[@class='btn btn-primary']")
	WebElement saveButtonForAddInvoicePopUp;
	@FindBy(xpath = "//td[text()='10']")
	WebElement dateFromPicker;
	
	
	



















public QALegendInvoicePage(WebDriver driver) {
		// TODO Auto-generated constructor stub
	this.driver = driver;
	PageFactory.initElements(driver, this);
	}




















public void clickOnAddInvoice()
{
	PageUtility.clickOnElement(addInvoiceButton);
}
public void enterInvoiceDueDate(String excelFilePath) throws IOException
{
//	String dueDate = ExcelUtilities.getDateValue(1, 1, excelFilePath, "InvoicePage");
//	PageUtility.enterText(invoiceDueDateField, dueDate);
	PageUtility.clickOnElement(invoiceDueDateField);
	PageUtility.clickOnElement(dateFromPicker);
	
}
public void clickOnClientDropdown()
{
	PageUtility.clickOnElement(clientDropdown);
	
}
public void selectFromClientDropdown()
{
	PageUtility.clickOnElement(clientSelect);
	
}
public void clickOnSaveInAddInvoicePopUp()
{
	PageUtility.clickOnElement(saveButtonForAddInvoicePopUp);
	
}

}