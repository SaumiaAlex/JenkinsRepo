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
	public static void dragAndDrop(WebDriver driver, WebElement source, WebElement target) {
        Actions actions = new Actions(driver);
        actions.dragAndDrop(source, target).build().perform();
    }

    public static void pressKey(WebDriver driver, Keys key) {
        Actions actions = new Actions(driver);
        actions.sendKeys(key).build().perform();
    }

    public static void keyDown(WebDriver driver, Keys key) {
        Actions actions = new Actions(driver);
        actions.keyDown(key).build().perform();
    }

    public static void keyUp(WebDriver driver, Keys key) {
        Actions actions = new Actions(driver);
        actions.keyUp(key).build().perform();
    }
    public static void doubleClick(WebDriver driver, WebElement element) 
    {
        Actions actions = new Actions(driver);
        actions.doubleClick(element).build().perform();
        }
    public static void clickAndHold(WebDriver driver, WebElement element) {
        Actions actions = new Actions(driver);
        actions.clickAndHold(element).build().perform();
        }
	public static void enterTextUsingActionClass(WebDriver driver, WebElement element, String value)
	{ Actions actions = new Actions(driver);
	actions.sendKeys(element, value);
		
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
	public static void scrollPageToMiddleUsingJavaScriptExecutor (WebDriver driver)
	{
		JavascriptExecutor jsc = (JavascriptExecutor)driver;
		jsc.executeScript("window.scrollBy(0,500)", "");

	}
	public static void scrollPageToBottomUsingJavaScriptExecutor (WebDriver driver)
	{
		JavascriptExecutor jsc = (JavascriptExecutor)driver;
		jsc.executeScript("window.scrollBy(0,1000)", "");

	}
	public static void scrollThePage(WebElement element,WebDriver driver)
	{
		
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].scrollIntoView(true)",element);
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
	public static void windowHandling(WebDriver driver)
	{
		driver.getWindowHandle();
		Set<String> handles = driver.getWindowHandles();
		Iterator<String> it = handles.iterator();
		it.next();
		String childtab = it.next();
		driver.switchTo().window(childtab);
	}
    public static void switchWindowToParentTab(WebDriver driver)
    {
    	driver.switchTo().defaultContent();
    }

    public static void robotSearchClient() throws AWTException
    {
    	Robot robot= new Robot();
    	robot.keyPress(KeyEvent.VK_A);
		robot.keyRelease(KeyEvent.VK_A);
		robot.keyPress(KeyEvent.VK_P);
		robot.keyRelease(KeyEvent.VK_P);
		robot.keyPress(KeyEvent.VK_S);
		robot.keyRelease(KeyEvent.VK_S);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		}
	
	
}


