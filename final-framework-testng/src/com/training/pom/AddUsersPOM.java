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

public class AddUsersPOM {
	
private WebDriver driver;
private WaitTypes wt;
private String errorMsg = null;
private boolean flag = false;

	
	public AddUsersPOM(WebDriver driver) {
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
	
	//Finding the box that contains error message
	@FindBy(xpath="//div[@class='error']//p")
	private WebElement errorMsgBox;
	
	//Finding weak password check box
	@FindBy(name="pw_weak")
	private WebElement weakPwrdChckBox;
	
	
		
	
	//Enter User name
	public void addNewUser(String uName, String email, String fName, String lName, String site, String pwrd, String role) {
		if(!uName.isEmpty()) {
			this.userNameField.sendKeys(uName);
		}
		
		if(!email.isEmpty()) {
			this.emailField.sendKeys(email);
			}
		
		if(!fName.isEmpty()) {
			this.firstNameField.sendKeys(fName);
			}
		
		if(!lName.isEmpty()) {
			this.lastNameField.sendKeys(lName);
			}
		
		if(!site.isEmpty()) {
			this.websiteField.sendKeys(site);
			}
		
		if(!pwrd.isEmpty()) {
			this.showPasswordBtn.click();
			this.cancleBtn.click();
			this.showPasswordBtn.click();
			WebElement afterWait = wt.presenceElementLocated1(this.passwordField, 20);
			afterWait.clear();
			afterWait.sendKeys(pwrd);
			}
		
		if(wt.presenceElementLocated2(this.weakPwrdChckBox, 2)) {
			this.weakPwrdChckBox.click();
		}

		if(!role.isEmpty()) {
			this.roleListBox.click();
			Select roles = new Select(this.roleListBox);
			roles.selectByVisibleText(role);
			}
		
		this.addNewUserBtn.click();

	}
	
	//Get the message from the web site after creating new user.
	public boolean confirmationMsg() {
		String userName = this.userNameField.getAttribute("value");
		String email = this.emailField.getAttribute("value");
		if(wt.presenceElementLocated2(this.errorMsgBox, 2)) {
			errorMsg = this.errorMsgBox.getText().trim();
			System.out.println("The error message is: " + errorMsg);
		}
		
		if(!userName.isEmpty() || !email.isEmpty() || !errorMsg.isEmpty()) {
			System.out.println("Please enter valid username & email");
			System.out.println("Again Printing the error message : " + errorMsg);
			flag = true;
		}
		return flag;
	}

	
	
}
