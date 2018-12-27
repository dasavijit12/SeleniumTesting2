package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserLoginPOM {
	private WebDriver driver; 
	
	public UserLoginPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	//Finding the Log In/Register Link
	@FindBy(xpath="//a[@class='sign-in']")
	private WebElement loginLink; 
	
	//Finding the password field
	@FindBy(id="user_login")
	private WebElement userName;
	
	//Finding the password field
	@FindBy(id="user_pass")
	private WebElement password;
	
	//Finding the Sign In Button
	@FindBy(name="login")
	private WebElement loginBtn;
	
	//Finding the down arrow beside user name on top right
	@FindBy(xpath="//div[@class='user-name']")
	private WebElement downArrow;
	
	//Finding the Log Out Link
	@FindBy(xpath="//a[contains(text(),'Log Out')]")
	private WebElement logoutLink;
	
	//Finding the Blog Link
	@FindBy(xpath="//ul[@id='responsive']//li[7]")
	private WebElement blogLink;
	
	//Finding the Back to Top Arrow
	@FindBy(xpath="//div[@id='backtotop']//a[@href='#']")
	private WebElement backToTop;
	
	//Click on the Log In/Register Link
	public void clickOnLoginLink() {
		this.loginLink.click();
	}
	
	//Enter User Name
	public void sendUserName(String userName) {
		this.userName.clear(); 
		this.userName.sendKeys(userName); 
	}
	
	//Enter Password
	public void sendPassword(String password) {
		this.password.clear(); 
		this.password.sendKeys(password); 
	}
	
	//Click on Sign In Button
	public void clickLoginBtn() {
		this.loginBtn.click(); 
	}
	
	//Click on the down arrow that is in ::after pseudo element
	public void clickOnDownArrow() {
		Actions action = new Actions(driver);
		action.moveToElement(this.downArrow).moveByOffset(165, 0).click().build().perform();
	}
	
	//Click on the Log Out Link
	public void clickOnLogoutLink() {
		this.logoutLink.click();
	}
	
	//Click on Blog Link
	public void clickOnBlogLink() {
		this.blogLink.click();
	}
	
	//Click to go back to Top
	public void clickOnBackToTop() {
		this.backToTop.click();
	}
}
