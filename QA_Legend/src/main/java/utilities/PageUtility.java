package utilities;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class PageUtility {
	
	
	public  void clickOnElement(WebElement element)
	{
		element.click();
	}
	
	public  void enterText(WebElement element, String value)
	{
		element.sendKeys(value);
	}
	
	public  String getTextFromElement(WebElement element) 
	{
		return element.getText(); 
	} 
	
	public  void clearText(WebElement element) 
	{ 
		element.clear(); 
	} 
	public  boolean elementEnabled (WebElement element)
	{
		return element.isEnabled();
	}
	public  boolean elementDisplayed (WebElement element)
	{
		return element.isDisplayed();
		
	}
	public  void elementSubmit(WebElement element)
	{
		element.submit();
	}
	public  String getAttributeValue(WebElement element,String attributeName) 
	{ 
		return element.getAttribute(attributeName); 
		} 
	//Navigation keys
	public  void pageRefresh(WebDriver driver)
	{
	driver.navigate().refresh();
	}
	public  void navigateBack(WebDriver driver) 
	
	{ driver.navigate().back();
	} 
	
	public  void navigateForward(WebDriver driver)
	{
		driver.navigate().forward();
	}
	//Alert Handling
	public  void acceptAlert(WebDriver driver) 
	{ 
		driver.switchTo().alert().accept(); 
	} 
	public  void dismissAlert(WebDriver driver)
	{
		driver.switchTo().alert().dismiss();
	}
	public  void enterTextToAlert(WebDriver driver,String text)
	{
		driver.switchTo().alert().sendKeys(text);
	}
	//Action Class
	public  void rightClickOnElement(WebDriver driver,WebElement element) 
	{ 
		Actions actions= new Actions(driver); 
		actions.contextClick(element).build().perform(); 
		} 
	public  void rightClick(WebDriver driver) 
	{ 
		Actions actions= new Actions(driver); 
		actions.contextClick().build().perform(); 
	} 
	public  void clickOnElementUsingActionClass(WebDriver driver,WebElement element) 
	{ 
		Actions actions= new Actions(driver); 
		actions.click(element);
	} 
	public  void dragAndDrop(WebDriver driver, WebElement source, WebElement target) {
        Actions actions = new Actions(driver);
        actions.dragAndDrop(source, target).build().perform();
    }

    public  void pressKey(WebDriver driver, Keys key) {
        Actions actions = new Actions(driver);
        actions.sendKeys(key).build().perform();
    }

    public  void keyDown(WebDriver driver, Keys key) {
        Actions actions = new Actions(driver);
        actions.keyDown(key).build().perform();
    }

    public  void keyUp(WebDriver driver, Keys key) {
        Actions actions = new Actions(driver);
        actions.keyUp(key).build().perform();
    }
    public  void doubleClick(WebDriver driver, WebElement element) 
    {
        Actions actions = new Actions(driver);
        actions.doubleClick(element).build().perform();
        }
    public  void clickAndHold(WebDriver driver, WebElement element) {
        Actions actions = new Actions(driver);
        actions.clickAndHold(element).build().perform();
        }
	public  void enterTextUsingActionClass(WebDriver driver, WebElement element, String value)
	{ Actions actions = new Actions(driver);
	actions.sendKeys(element, value);
		
	}
	//Javascriptexecutor
	
	public  void clickOnElementUsingJavaScriptExecutor(WebElement element, WebDriver driver)
	{
		JavascriptExecutor jsc = (JavascriptExecutor)driver;
		 jsc.executeScript("arguements[0].click()", element);

	}
	public  void scrollPageUsingJavaScriptExecutor (WebDriver driver)
	{
		JavascriptExecutor jsc = (JavascriptExecutor)driver;
		jsc.executeScript("window.scrollBy(0,250)", "");

	}
	public  void scrollPageToMiddleUsingJavaScriptExecutor (WebDriver driver)
	{
		JavascriptExecutor jsc = (JavascriptExecutor)driver;
		jsc.executeScript("window.scrollBy(0,500)", "");

	}
	public  void scrollPageToBottomUsingJavaScriptExecutor (WebDriver driver)
	{
		JavascriptExecutor jsc = (JavascriptExecutor)driver;
		jsc.executeScript("window.scrollBy(0,1000)", "");

	}
	public  void scrollThePage(WebElement element,WebDriver driver)
	{
		
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].scrollIntoView(true)",element);
	}
	//Selection Class
	public  void selectItemFromDropdownbyIndex(WebElement element, int i)
	{
		Select sc = new Select(element);
		sc.selectByIndex(i);
	
		
	}
	public  void selectItemFromDropdownbyStringValue(WebElement element, String value)
	{
		Select sc = new Select(element);
		sc.selectByValue(value);
		
	}
	public  void selectItemFromDropdownbyVisibleText(WebElement element, String value)
	{
		Select sc = new Select(element);
		sc.selectByValue(value);
		
	}
	//window handling
	public  void windowHandling(WebDriver driver)
	{
		driver.getWindowHandle();
		Set<String> handles = driver.getWindowHandles();
		Iterator<String> it = handles.iterator();
		it.next();
		String childtab = it.next();
		driver.switchTo().window(childtab);
	}
    public  void switchWindowToParentTab(WebDriver driver)
    {
    	driver.switchTo().defaultContent();
    }

   
	
	
}


