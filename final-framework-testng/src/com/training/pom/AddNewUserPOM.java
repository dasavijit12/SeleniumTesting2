package com.training.pom;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddNewUserPOM {
	
private WebDriver driver; 
	
	public AddNewUserPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="user_login")
	private WebElement userNameField; 
	
	@FindBy(id="email")
	private WebElement emailField;
	
	@FindBy(id="first_name")
	private WebElement firstNameField;
	
	@FindBy(id="last_name")
	private WebElement lastNameField;
	
	@FindBy(id="url")
	private WebElement websiteField;
	
	@FindBy(xpath="//button[contains(text(),'Show password')]")
	private WebElement showPasswordBtn;
	
	@FindBy(xpath="//span[contains(text(),'Cancel')]")
	private WebElement cancleBtn;
	
	@FindBy(id="pass1-text")
	private WebElement passwordField;
	
	@FindBy(id="role")
	private WebElement roleListBox;
	
	@FindBy(id="createusersub")
	private WebElement addNewUserBtn;
	
	@FindBy(id="message")
	private WebElement msgAfterCreatingUser;
		
	
	
	public void enterUserName(String userName) {
		this.userNameField.sendKeys(userName); 
	}
	
	public void enterEmail(String email) {
		this.emailField.sendKeys(email); 
	}
	
	public void enterFirstName(String fName) {
		this.firstNameField.sendKeys(fName); 
	}
	
	public void enterLastName(String lName) {
		this.lastNameField.sendKeys(lName); 
	}
	
	public void enterWebSite(String webSite) {
		this.websiteField.sendKeys(webSite); 
	}
	
	public void clickOnShowPasswordBtn() {
		this.showPasswordBtn.click(); 
	}
	
	public void clickOnCancleBtn() {
		this.cancleBtn.click(); 
	}
	
	public void enterPassword(String password) {
		this.passwordField.clear();
		this.passwordField.sendKeys(password); 
	}
	
	public void clickOnRoleListBox() {
		this.roleListBox.click(); 
	}
	
	public void selectRole(String role) {
		Select roles = new Select(this.roleListBox);
		roles.selectByVisibleText(role);
	}
	
	public void clickOnAddNewUserBtn() {
		this.addNewUserBtn.click(); 
	}
	
	public String confirmationMsg() {
		return this.msgAfterCreatingUser.getText();
	}
	
}
