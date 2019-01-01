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

public class ChangeRolePOM {
	
private WebDriver driver;
private WaitTypes wt;
	
	public ChangeRolePOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
		wt = new WaitTypes(driver);
	}
	
	//Finding the Users Link
	@FindBy(id="menu-users")
	private WebElement usersLink; 
	
	//Finding All Users Link
	@FindBy(xpath="//a[contains(text(),'All Users')]")
	private WebElement allUsersLink;
	
	//Finding the table body that contains all the users
	@FindBy(id="the-list")
	private WebElement usersTable;
	
	//Finding the Change role to list box
	@FindBy(id="new_role")
	private WebElement changeRole;
	
	//Finding the change button
	@FindBy(id="changeit")
	private WebElement changeBtn;
	
	//Finding the element that contains the message after changing user role
	@FindBy(xpath="//p[contains(text(),'Changed roles.')]")
	private WebElement changeRoleMsg;
	
	//Finding the Bulk Action List Box
	@FindBy(id="bulk-action-selector-top")
	private WebElement bulkAction;
	
	//Finding the Delete option in the Bulk Action List Box
	@FindBy(xpath="//select[@id='bulk-action-selector-top']//option[@value='delete'][contains(text(),'Delete')]")
	private WebElement deleteOption;
	
	//Finding the Apply Button
	@FindBy(id="doaction")
	private WebElement applyBtn;
	
	//Finding the Confirm Delete Button
	@FindBy(id="submit")
	private WebElement confirmDeleteBtn;
	
	//Finding the element that contains the message after deleting a User
	@FindBy(xpath="//p[contains(text(),'User deleted.')]")
	private WebElement msgAfterDeletingUser;
	
	//Finding the Add New Button to add a new user
	@FindBy(xpath="//a[@class='page-title-action']")
	private WebElement addNewUser;
	
	public void mouseOverOnUsersLink() {
		Actions action = new Actions(driver);
		action.moveToElement(this.usersLink).build().perform();
	}
	
	//Click on User Link
	public void clickOnUsersLink() {
		this.usersLink.click(); 
	}
	
	//Click on All User Link
	public void clickOnAllUsers() {
		this.allUsersLink.click(); 
	}
	
	//Method to select a particular user
	public void userToBeSelected() {
		List<WebElement> allUsers = this.usersTable.findElements(By.tagName("tr"));
		//System.out.println(allTags.get(0).getText());
		WebElement userToSelect = allUsers.get(2);
		userToSelect.findElement(By.name("users[]")).click();
	}
	
	public void userToBeDeleted() {
		List<WebElement> allUsers = this.usersTable.findElements(By.tagName("tr"));
		//System.out.println(allTags.get(0).getText());
		WebElement userToSelect = allUsers.get(2);
		userToSelect.findElement(By.name("users[]")).click();
	}
	
	//Click on the Change role to List Box
	public void clickOnChangeRoleToBtn() {
		this.changeRole.click(); 
	}
	
	//Select a valid role from the List Box
	public void changeRoleTo() {
		Select roles = new Select(this.changeRole);
		roles.selectByVisibleText("Agent");
	}
	
	//Click on the Change Button to change role of a user
	public void clickOnChangeBtn() {
		this.changeBtn.click(); 
	}
	
	//Return the message displayed on Page after changing the role of a user
	public String confirmationMsg() {
		return this.changeRoleMsg.getText();
	}
	
	//Click on the Bulk Action List Box
	public void clickOnBulkAction() {
		this.bulkAction.click(); 
	}
	
	//Select the Delete option from the Bulk Action List Box
	public void selectDeleteOption() {
		this.deleteOption.click(); 
	}
	
	//Click on Apply Button
	public void clickOnApplyBtn() {
		this.applyBtn.click(); 
	}
	
	//Click on Confirm Delete Button
	public void clickOnConfirmDeleteBtn() {
		this.confirmDeleteBtn.click(); 
	}
	
	//Return the message that is displayed on the page after deleting a user
	public String MsgAfterUserDelete() {
		return this.msgAfterDeletingUser.getText();
	}
	
	//Click on Add New Button to add a new user
	public void clickOnAddNewUserBtn() {
		wt.elementToBeClickable1(this.addNewUser, 20).click();
		//this.addNewUser.click(); 
	}
	
	public boolean verifyUserIsAdded(String uname) {

		List<WebElement> tableRows = this.usersTable.findElements(By.xpath("//tbody[@id='the-list']/tr"));
		int noOfRows = tableRows.size();
		System.out.println(noOfRows);
		boolean flag = false;
		for(int i=0; i<noOfRows; i++) {
			WebElement cellINeed = tableRows.get(i).findElement(By.xpath("//tbody[@id='the-list']/tr[" + (i+1) + "]/td[1]"));
			String data = cellINeed.getText();
			if(data.equals(uname)) {
				flag = true;
				break;
			}
		}
		if(flag) {
			return true;
		}else {
			return false;
		}
	}

}
