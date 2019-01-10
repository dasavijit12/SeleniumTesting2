package com.trianing.waits;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


/**
 * 
 * @author Naveen
 * @see  this class shall have explicit wait for any location 
      	any type on either present, visibility etc 
   		and participants can have more of these explicitWait depending on requirement 
	@since 16-Dec-2018 
 */
public class WaitTypes {
	private WebDriver driver;
	
	public WaitTypes(WebDriver driver){
		this.driver = driver;
	}
	
	
	// we will have methods which returns the WebElement 
	// on demand of explicit wait 
	
	
	// this method will return WebElement 
	// when on the page it is available for presence
	// presenceOfElementLocated
	public WebElement presenceElementLocated(By locator, int timeout){
		try{
			WebDriverWait wait = new WebDriverWait(driver, timeout);
			WebElement element  = wait.until(
					ExpectedConditions.presenceOfElementLocated(locator)
					);
			System.out.println("Element Located");
			return element;
		}catch(Exception e ){
			System.out.println("Element Not Located " + e);
		}
		return null;
	}
	
	// this method shall take String parameter, and assumiing that it will 
	// only send by id 
	public WebElement presenceElementLocated(String locator, int timeout){
		try{
			WebDriverWait wait = new WebDriverWait(driver, timeout);
			WebElement element  = wait.until(
					ExpectedConditions.presenceOfElementLocated(By.id(locator))
					);
			System.out.println("Element Located");
			return element;
		}catch(Exception e ){
			System.out.println("Element Not Located " + e);
		}
		return null;
	}
	
	
	
	public WebElement waitForElement(By locator, int timeout){
		try{
			WebDriverWait wait = new WebDriverWait(driver, timeout);
			WebElement element  = wait.until(
					ExpectedConditions.visibilityOfElementLocated(locator)
					);
			System.out.println("Element Located");
			
			return element;
		}catch(Exception e ){
			System.out.println("Element Not Located " + e);
		}
		return null;
	}
	
	

	public WebElement elementToBeClickable(By locator, int timeout){
		try{
			WebDriverWait wait = new WebDriverWait(driver, timeout);
			WebElement element  = wait.until(
					ExpectedConditions.elementToBeClickable(locator)
					);
			System.out.println("Element Located");
			
			return element;
		}catch(Exception e ){
			System.out.println("Element Not Located " + e);
		}
		return null;
	}
	
	
	public WebElement elementToBeClickable1(WebElement element, int timeout){
		try{
			WebDriverWait wait = new WebDriverWait(driver, timeout);
			WebElement element1  = wait.until(
					ExpectedConditions.elementToBeClickable(element)
					);
			System.out.println("Element is clickable now.");
			
			return element1;
		}catch(Exception e ){
			System.out.println("Element Not clickable " + e);
		}
		return null;
	}
	
	
	
	public WebElement presenceElementLocated1(WebElement element, int timeout){
		try{
			WebDriverWait wait = new WebDriverWait(driver, timeout);
			WebElement element1  = wait.until(
					ExpectedConditions.visibilityOf(element));
			System.out.println("Element Located");
			return element1;
		}catch(Exception e ){
			System.out.println("Element Not Located " + e);
		}
		return null;
	}
	
	
	public Boolean presenceElementLocated2(WebElement element, int timeout){
		try{
			WebDriverWait wait = new WebDriverWait(driver, timeout);
			WebElement element1  = wait.until(
					ExpectedConditions.visibilityOf(element));
			System.out.println("Element Located");
			return true;
		}catch(Exception e ){
			System.out.println("Element Not Located " + e);
		}
		return false;
	}
	
	
	/*public WebElement presenceOfAlert(int timeout){
		try{
			WebDriverWait wait = new WebDriverWait(driver, timeout);
			wait.until(
					ExpectedConditions.alertIsPresent());
			System.out.println("Element Located");
			
		}catch(Exception e ){
			System.out.println("Element Not Located " + e);
		}
		return null;
	}*/
	
}



