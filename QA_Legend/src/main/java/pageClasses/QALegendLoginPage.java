package pageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtility;
import utilities.WaitUtility;

public class QALegendLoginPage {
	
WebDriver driver;
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
	PageUtility.enterText(usernameField, username);
}

public void enterPassword(String password)
{
	PageUtility.enterText(passwordField, password);
}

public void clickLoginButton()
{
	PageUtility.clickOnElement(loginButton);
}

public String getTextFromLoginPage()
{
	WaitUtility.waitForElementToBePresent(driver, signInHeading);
	String text = PageUtility.getTextFromElement(signInHeading);
	return text;
}

}
