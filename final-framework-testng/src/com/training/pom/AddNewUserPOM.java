package com.training.pom;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.trianing.waits.WaitTypes;

public class AddNewUserPOM {
	
private WebDriver driver;
private WaitTypes wt;
	
	public AddNewUserPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
		wt = new WaitTypes(driver);
	}
	
	//Finding the User name field
	@FindBy(id="user_login")
	private WebElement userNameField; 
	
	//Finding the Email field
	@FindBy(id="email")
	private WebElement emailField;
	
	//Finding the First Name field
	@FindBy(id="first_name")
	private WebElement firstNameField;
	
	//Finding the Last Name field
	@FindBy(id="last_name")
	private WebElement lastNameField;
	
	//Finding the Web site field
	@FindBy(id="url")
	private WebElement websiteField;
	
	//Finding the Show Password Button
	@FindBy(xpath="//button[contains(text(),'Show password')]")
	private WebElement showPasswordBtn;
	
	//Finding the Cancel Button of the Password field
	@FindBy(xpath="//span[contains(text(),'Cancel')]")
	private WebElement cancleBtn;
	
	//Finding the Password Text Box to enter password
	@FindBy(id="pass1-text")
	private WebElement passwordField;
	
	//Finding the Role List Box
	@FindBy(id="role")
	private WebElement roleListBox;
	
	//Finding the Add New User Button
	@FindBy(id="createusersub")
	private WebElement addNewUserBtn;
	
	//Finding the Element that contains message after creating new user
	@FindBy(id="message")
	private WebElement msgAfterCreatingUser;
		
	
	//Enter User name
	public String enterUserName(String userName) {
		this.userNameField.sendKeys(userName);
		return this.userNameField.getAttribute("value");
	}
	
	//Enter Email
	public void enterEmail(String email) {
		this.emailField.sendKeys(email); 
	}
	
	//Enter First Name
	public void enterFirstName(String fName) {
		this.firstNameField.sendKeys(fName); 
	}
	
	//Enter Last Name
	public void enterLastName(String lName) {
		this.lastNameField.sendKeys(lName); 
	}
	
	//Enter Web Site
	public void enterWebSite(String webSite) {
		this.websiteField.sendKeys(webSite); 
	}
	
	//Click on Show Password Button
	public void clickOnShowPasswordBtn() {
		this.showPasswordBtn.click(); 
	}
	
	//Click on Cancel Button of Password field
	public void clickOnCancleBtn() {
		this.cancleBtn.click(); 
	}
	
	//Enter Password
	public void enterPassword(String password) {
		WebElement afterWait = wt.presenceElementLocated1(this.passwordField, 20);
		afterWait.clear();
		afterWait.sendKeys(password); 
	}
	
	//Click on Role List Box
	public void clickOnRoleListBox() {
		this.roleListBox.click(); 
	}
	
	//Select Valid credentials in Role list box
	public void selectRole(String role) {
		Select roles = new Select(this.roleListBox);
		roles.selectByVisibleText(role);
	}
	
	//Click on Add New User Button
	public void clickOnAddNewUserBtn() {
		this.addNewUserBtn.click(); 
	}
	
	//Get the message from the web site after creating new user.
	public String confirmationMsg() {
		return this.msgAfterCreatingUser.getText();
	}
	
}
