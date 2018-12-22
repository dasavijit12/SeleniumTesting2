package com.training.pom;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RETC_021_DeleteTagPOM {
	
private WebDriver driver; 
	
	public RETC_021_DeleteTagPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	//Finding the Posts Link
	@FindBy(id="menu-posts")
	private WebElement postsLink;
	
	//Finding the Tags Link
	@FindBy(xpath="//a[@href='edit-tags.php?taxonomy=post_tag']")
	private WebElement tagsLink;
	
	//Finding the table that contains all the Tags
	@FindBy(id="the-list")
	private WebElement tagsTable;
	
	//Find the Bulk Actions List Box
	@FindBy(id="bulk-action-selector-top")
	private List<WebElement> bulkActions;
	
	//Find the Delete option in the Bulk Action List Box
	@FindBy(xpath="//select[@id='bulk-action-selector-top']//option[@value='delete'][contains(text(),'Delete')]")
	private WebElement deleteAction;
	
	//Finding the Apply Button
	@FindBy(id="doaction")
	private WebElement applyBtn;
	
	//Finding the Element that contains the message after deleting Tags
	@FindBy(xpath="//p[contains(text(),'Tags deleted.')]")
	private WebElement deletionmsg;
	
	
	//Click on Posts Link
	public void clickOnPostsLink() {
		this.postsLink.click(); 
	}
	
	//Click on Tags Link
	public void clickOnTagsLink() {
		this.tagsLink.click(); 
	}
	
	//Select the Tag that needs to be deleted
	public void clickOnTagToBeDeleted() {
		List<WebElement> allTags = this.tagsTable.findElements(By.tagName("tr"));
		System.out.println(allTags.get(0).getText());
		WebElement firstTag = allTags.get(1);
		firstTag.findElement(By.name("delete_tags[]")).click();
	}
	
	public void selectActions() {
		this.bulkActions.get(0).click(); 
	}
	
	//Click on the Delete option
	public void clickDeleteActions() {
		this.deleteAction.click(); 
	}
	
	//Click on the Apply Button
	public void clickOnApplyBtn() {
		this.applyBtn.click(); 
	}
	
	//Returns the message displayed on the page after deleting Tags
	public String confirmationMsg() {
		return this.deletionmsg.getText();
	}

}
