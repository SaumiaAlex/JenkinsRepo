package pageClasses;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utilities.DateUtility;
import utilities.ExcelUtilities;
import utilities.PageUtility;
import utilities.WaitUtility;

public class QALegendLeavePage {

	WebDriver driver;
@FindBy(xpath = "(//a[@class='btn btn-default'])[1]")
WebElement applyLeaveButton;
@FindBy(xpath = "(//a[@class='btn btn-default'])[2]")
WebElement assignLeaveButton;
@FindBy(xpath = "//div[@class='select2-container select2 validate-hidden']")//(xpath = "//div[@class='select2-search']")
WebElement leaveTypeDropDown;
@FindBy(xpath = "(//div[@class='select2-result-label'])[2]")//select2-result-label-10
WebElement casualLeave;
@FindBy(xpath = "//input[@id='single_date']")
WebElement dateField;
@FindBy(xpath = "//button[@class='btn btn-primary']")
WebElement applyLeaveButtonInPopUp;
@FindBy(xpath = "//textarea[@name='reason']")
WebElement reasonTextField;
@FindBy(xpath = "//b[@role='presentation']")
WebElement dropDownToShowAll;
@FindBy(xpath = "//div[text()='All']")
WebElement selectAllFromDropDown;
@FindBy(xpath = "//a[@title='Application details']")
List<WebElement>applicationDetails;
@FindBy(xpath = "//td[text()=' Reason']//following-sibling::td")
WebElement resonForLeave;














public QALegendLeavePage(WebDriver driver) {
	// TODO Auto-generated constructor stub
	this.driver = driver;
	PageFactory.initElements(driver,this);
}














public void clickOnApplyLeaveButton()
{
	PageUtility.clickOnElement(applyLeaveButton);
}
public void clickOnLeaveTypeDropDown() 
{
	PageUtility.clickOnElement(leaveTypeDropDown);
		
}

public void clickOnCasualLeave()
{
	WaitUtility.waitForElementToBePresent(driver, casualLeave);
	PageUtility.clickOnElement(casualLeave);
}

public void clickOnDateField()
{
	PageUtility.clickOnElement(dateField);
	
}
public void enterDate(String excelFilePath) throws IOException
{
	String leaveDate = DateUtility.getCurrentDate();
	PageUtility.enterText(dateField, leaveDate);
			
}
public void clickOnApplyLeaveInPopUp()
{
	PageUtility.clickOnElement(applyLeaveButtonInPopUp);

}

public String enterReasonForLeave(String excelFilePath) throws IOException
{
	String reason = ExcelUtilities.getString(1, 1, excelFilePath, "LeavePage");
	PageUtility.enterText(reasonTextField, reason);
	return reason;
}
public void clickOnDropdownToListAll()
{
	PageUtility.pageRefresh(driver);
	WaitUtility.waitForElementToBeClickable(driver, dropDownToShowAll);
	PageUtility.clickOnElement(dropDownToShowAll);
}
public void clickOnAllfromDropdownToListAll()
{
	
	WaitUtility.waitForElementToBePresent(driver, selectAllFromDropDown);
	PageUtility.clickOnElement(selectAllFromDropDown);
}
public String clickOnApplicationDetail()
{
	//WaitUtility.waitForListOfElements(driver, applicationDetails);
	
	int i = applicationDetails.size();
	WebElement element =driver.findElement(By.xpath("("+"//a[@title='Application details']"+")"+"["+i+"]"));
	PageUtility.scrollThePage(element, driver);
	WaitUtility.waitForElementToBeClickable(driver, element);
	element.click();
	String actualLeaveReason = PageUtility.getTextFromElement(resonForLeave);
	return actualLeaveReason;
	
}
}

