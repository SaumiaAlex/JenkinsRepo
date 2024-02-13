package utilities;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtility
{
	
	public static void waitForElementToBeClickable(WebDriver driver, WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	public static void waitForElementToBePresent(WebDriver driver, WebElement element)
	{
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    wait.until(ExpectedConditions.visibilityOf(element));
		
	}
	
	public static void waitForAFrame (WebDriver driver, WebElement element)
	{
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(element));
		
	}
	
	
	
	public static void waitForListOfElements (WebDriver driver, List<WebElement>elements)
	{
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
    wait.until(ExpectedConditions.visibilityOfAllElements(elements));
		
	}
}
