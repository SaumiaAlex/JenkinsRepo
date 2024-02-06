package utilities;

import java.nio.channels.SelectionKey;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class PageUtility {
	
	
	public static void clickOnElement(WebElement element)
	{
		element.click();
	}
	
	public static void enterText(WebElement element, String value)
	{
		element.sendKeys(value);
	}
	
	public static String getTextFromElement(WebElement element) 
	{
		return element.getText(); 
	} 
	
	public static void clearText(WebElement element) 
	{ 
		element.clear(); 
	} 
	public static boolean elementEnabled (WebElement element)
	{
		return element.isEnabled();
	}
	public static boolean elementDisplayed (WebElement element)
	{
		return element.isDisplayed();
		
	}
	public static void elementSubmit(WebElement element)
	{
		element.submit();
	}
	public static String getAttributeValue(WebElement element,String attributeName) 
	{ 
		return element.getAttribute(attributeName); 
		} 
	//Navigation keys
	public static void pageRefresh(WebDriver driver)
	{
	driver.navigate().refresh();
	}
	public static void navigateBack(WebDriver driver) 
	
	{ driver.navigate().back();
	} 
	
	public static void navigateForward(WebDriver driver)
	{
		driver.navigate().forward();
	}
	//Alert Handling
	public static void acceptAlert(WebDriver driver) 
	{ 
		driver.switchTo().alert().accept(); 
	} 
	public static void dismissAlert(WebDriver driver)
	{
		driver.switchTo().alert().dismiss();
	}
	public static void enterTextToAlert(WebDriver driver,String text)
	{
		driver.switchTo().alert().sendKeys(text);
	}
	//Action Class
	public static void rightClickOnElement(WebDriver driver,WebElement element) 
	{ 
		Actions actions= new Actions(driver); 
		actions.contextClick(element).build().perform(); 
		} 
	public static void rightClick(WebDriver driver) 
	{ 
		Actions actions= new Actions(driver); 
		actions.contextClick().build().perform(); 
	} 
	public static void clickOnElementUsingActionClass(WebDriver driver,WebElement element) 
	{ 
		Actions actions= new Actions(driver); 
		actions.click(element);
	} 
	
	//Javascriptexecutor
	
	public static void clickOnElementUsingJavaScriptExecutor(WebElement element, WebDriver driver)
	{
		JavascriptExecutor jsc = (JavascriptExecutor)driver;
		 jsc.executeScript("arguements[0].click()", element);

	}
	public static void scrollPageUsingJavaScriptExecutor (WebDriver driver)
	{
		JavascriptExecutor jsc = (JavascriptExecutor)driver;
		jsc.executeScript("window.scrollBy(0,250)", "");

	}
	//Selection Class
	public static void selectItemFromDropdownbyIndex(WebElement element, int i)
	{
		Select sc = new Select(element);
		sc.selectByIndex(i);
	
		
	}
	public static void selectItemFromDropdownbyStringValue(WebElement element, String value)
	{
		Select sc = new Select(element);
		sc.selectByValue(value);
		
	}
	public static void selectItemFromDropdownbyVisibleText(WebElement element, String value)
	{
		Select sc = new Select(element);
		sc.selectByValue(value);
		
	}
	
	
}


