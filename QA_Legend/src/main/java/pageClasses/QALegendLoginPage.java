package pageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.DateUtility;
import utilities.ExcelUtilities;
import utilities.FakerUtility;
import utilities.PageUtility;
import utilities.WaitUtility;


public class QALegendLoginPage {
	
WebDriver driver;
PageUtility pageUtil = new PageUtility();
DateUtility dateUtil = new DateUtility();
ExcelUtilities excelUtil = new ExcelUtilities();
WaitUtility waitUtil = new WaitUtility();
FakerUtility fakerUtil = new FakerUtility();

@FindBy(name = "email")
WebElement usernameField;
@FindBy(id = "password")
WebElement passwordField;
@FindBy(xpath = "//button[@class='btn btn-lg btn-primary btn-block mt15']")
WebElement loginButton;
@FindBy(xpath = "//span[text()='Authentication failed!']")//"//h2[text()='Sign in']")
WebElement signInHeading;




public QALegendLoginPage(WebDriver driver) {
	// TODO Auto-generated constructor stub
	this.driver = driver;
	PageFactory.initElements(driver, this);
}





public void enterUsername(String username)
{
	pageUtil.enterText(usernameField, username);
}

public void enterPassword(String password)
{
	pageUtil.enterText(passwordField, password);
}

public void clickLoginButton()
{
	pageUtil.clickOnElement(loginButton);
}

public String getTextFromLoginPage()
{
	waitUtil.waitForElementToBePresent(driver, signInHeading);
	String text = pageUtil.getTextFromElement(signInHeading);
	return text;
}

}
