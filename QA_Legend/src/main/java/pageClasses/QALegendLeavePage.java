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
import utilities.FakerUtility;
import utilities.PageUtility;
import utilities.WaitUtility;


public class QALegendLeavePage {

	WebDriver driver;
	PageUtility pageUtil = new PageUtility();
	DateUtility dateUtil = new DateUtility();
	ExcelUtilities excelUtil = new ExcelUtilities();
	WaitUtility waitUtil = new WaitUtility();
	FakerUtility fakerUtil = new FakerUtility();
@FindBy(xpath = "(//a[@class='btn btn-default'])[1]")
WebElement applyLeaveButton;
@FindBy(xpath = "(//a[@class='btn btn-default'])[2]")
WebElement assignLeaveButton;
@FindBy(xpath = "(//div[@class='select2-container select2 validate-hidden'])[1]")//(xpath = "//div[@class='select2-search']")
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
	pageUtil.clickOnElement(applyLeaveButton);
}
public void clickOnLeaveTypeDropDown() 
{
	pageUtil.clickOnElement(leaveTypeDropDown);
		
}

public void clickOnCasualLeave()
{
	waitUtil.waitForElementToBePresent(driver, casualLeave);
	pageUtil.clickOnElement(casualLeave);
}

public void clickOnDateField()
{
	pageUtil.clickOnElement(dateField);
	
}
public void enterDate(String excelFilePath) throws IOException
{
	String leaveDate = dateUtil.getCurrentDate();
	pageUtil.enterText(dateField, leaveDate);
			
}
public void clickOnApplyLeaveInPopUp()
{
	pageUtil.clickOnElement(applyLeaveButtonInPopUp);

}

public String enterReasonForLeave(String excelFilePath) throws IOException
{
	String reason = excelUtil.getString(1, 1, excelFilePath, "LeavePage");
	pageUtil.enterText(reasonTextField, reason);
	return reason;
}
public void clickOnDropdownToListAll()
{
	pageUtil.pageRefresh(driver);
	waitUtil.waitForElementToBeClickable(driver, dropDownToShowAll);
	pageUtil.clickOnElement(dropDownToShowAll);
}
public void clickOnAllfromDropdownToListAll()
{
	
	waitUtil.waitForElementToBePresent(driver, selectAllFromDropDown);
	pageUtil.clickOnElement(selectAllFromDropDown);
}
public String clickOnApplicationDetail()
{
	//waitUtil.waitForListOfElements(driver, applicationDetails);
	
	int i = applicationDetails.size();
	WebElement element =driver.findElement(By.xpath("("+"//a[@title='Application details']"+")"+"["+i+"]"));
	pageUtil.scrollThePage(element, driver);
	waitUtil.waitForElementToBeClickable(driver, element);
	element.click();
	String actualLeaveReason = pageUtil.getTextFromElement(resonForLeave);
	return actualLeaveReason;
	
}
}

