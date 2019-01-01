package com.training.pom;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.training.sanity.tests.ConfigFile;

public class BckupLoginPOM extends ConfigFile{
	private WebDriver driver; 
	
	public BckupLoginPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="user_login")
	private WebElement userName; 
	
	@FindBy(id="user_pass")
	private WebElement password;
	
	@FindBy(name="login")
	private WebElement loginBtn;
	
	@FindBy(partialLinkText="Howdy")
	private WebElement topRightMenu;
	
	@FindBy(linkText="Log Out")
	private WebElement logoutLink;
	
	public void sendUserName(String userName) {
		JavascriptExecutor je = (JavascriptExecutor) driver;
		je.executeScript("window.scrollBy(0,1000)");
		this.userName.clear();
		this.userName.sendKeys(userName);
	}
	
	public void sendPassword(String password) {
		this.password.clear(); 
		this.password.sendKeys(password); 
	}
	
	public void clickLoginBtn() {
		this.loginBtn.click(); 
	}
	
	public void clickOnLogOutLink() {
		Actions action = new Actions(driver);
		action.moveToElement(this.topRightMenu).build().perform();
		this.logoutLink.click();
	}
}
