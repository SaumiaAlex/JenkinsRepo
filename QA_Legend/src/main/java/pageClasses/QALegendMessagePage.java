package pageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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
	
	
	
	
	
	
	
	
	public QALegendMessagePage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	
	public void clickOnRecepientDropDown()
	{
		WaitUtility.waitForElementToBeClickable(driver, recepientDropDown);
		PageUtility.clickOnElementUsingJavaScriptExecutor(recepientDropDown, driver);
		//PageUtility.clickOnElement(recepientDropDown);
	}
	
	public void clickOnComposeButton()
	{WaitUtility.waitForElementToBeClickable(driver, composeButton);
	PageUtility.clickOnElementUsingJavaScriptExecutor(composeButton,driver);;
	}
	
	public void selectRecepientFromDropdown()
	{WaitUtility.waitForElementToBeClickable(driver, selectRecepient);
		PageUtility.clickOnElementUsingJavaScriptExecutor(selectRecepient,driver);
	
	
	}
}
