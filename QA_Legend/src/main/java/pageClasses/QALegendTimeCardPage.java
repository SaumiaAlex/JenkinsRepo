package pageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtility;
import utilities.WaitUtility;

public class QALegendTimeCardPage {

    WebDriver driver;
//	@FindBy(xpath = "//span[text()='Time cards']")
//	WebElement timeCardButton;
	@FindBy(xpath = "//a[text()='Clock In / Out']")
	WebElement clockInClockOutTab;
	@FindBy(xpath = "(//input[@type='search'])[2]")
	WebElement searchField;
	@FindBy(xpath = "(//tr[@role='row']//child::td)[10]")
	WebElement clockInClockOutStatus;
	
	
	
	
	
	
	
	
	
	
	
	
	
	public QALegendTimeCardPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	
	
	
	
	
	
//	public void clickOnTimeCardButton()
//	{
//		WaitUtility.waitForElementToBeClickable(driver, timeCardButton);
//		PageUtility.clickOnElement(timeCardButton);
//	}
	public void clickOnClockInClockOutTab()
	{PageUtility.pageRefresh(driver);
		PageUtility.clickOnElement(clockInClockOutTab);
	}
	
	public void enterTextInSearchField(String profileName)
	{
		PageUtility.enterText(searchField, profileName);
	}
	
	public String getTextFromClockInClockOutStatus()
	{
		return PageUtility.getTextFromElement(clockInClockOutStatus);
	}
}
