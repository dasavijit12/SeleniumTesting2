package com.training.pom;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ChangeRolePOM {
	
private WebDriver driver; 
	
	public ChangeRolePOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="menu-users")
	private WebElement usersLink; 
	
	@FindBy(xpath="//a[contains(text(),'All Users')]")
	private WebElement allUsersLink;
	
	@FindBy(id="the-list")
	private WebElement usersTable;
	
	@FindBy(id="new_role")
	private WebElement changeRole;
	
	@FindBy(id="changeit")
	private WebElement changeBtn;
	
	@FindBy(xpath="//p[contains(text(),'Changed roles.')]")
	private WebElement changeRoleMsg;
	
	@FindBy(id="bulk-action-selector-top")
	private WebElement bulkAction;
	
	@FindBy(xpath="//select[@id='bulk-action-selector-top']//option[@value='delete'][contains(text(),'Delete')]")
	private WebElement deleteOption;
	
	@FindBy(id="doaction")
	private WebElement applyBtn;
	
	@FindBy(id="submit")
	private WebElement confirmDeleteBtn;
	
	@FindBy(xpath="//p[contains(text(),'User deleted.')]")
	private WebElement msgAfterDeletingUser;
	
	@FindBy(xpath="//a[@class='page-title-action']")
	private WebElement addNewUser;
	
	public void mouseOverOnUsersLink() {
		Actions action = new Actions(driver);
		action.moveToElement(this.usersLink).build().perform();
	}
	
	public void clickOnUsersLink() {
		this.usersLink.click(); 
	}
	
	public void clickOnAllUsers() {
		this.allUsersLink.click(); 
	}
	
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
	
	public void clickOnChangeRoleToBtn() {
		this.changeRole.click(); 
	}
	
	public void changeRoleTo() {
		Select roles = new Select(this.changeRole);
		roles.selectByVisibleText("Agent");
	}
	
	public void clickOnChangeBtn() {
		this.changeBtn.click(); 
	}
	
	public String confirmationMsg() {
		return this.changeRoleMsg.getText();
	}
	
	public void clickOnBulkAction() {
		this.bulkAction.click(); 
	}
	
	public void selectDeleteOption() {
		this.deleteOption.click(); 
	}
	
	public void clickOnApplyBtn() {
		this.applyBtn.click(); 
	}
	
	public void clickOnConfirmDeleteBtn() {
		this.confirmDeleteBtn.click(); 
	}
	
	public String MsgAfterUserDelete() {
		return this.msgAfterDeletingUser.getText();
	}
	
	public void clickOnAddNewUserBtn() {
		this.addNewUser.click(); 
	}

}
