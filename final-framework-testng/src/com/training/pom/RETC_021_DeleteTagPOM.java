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
	
	@FindBy(id="menu-posts")
	private WebElement postsLink;
	
	@FindBy(xpath="//a[@href='edit-tags.php?taxonomy=post_tag']")
	private WebElement tagsLink;
	
	@FindBy(id="the-list")
	private WebElement tagsTable;
	
	@FindBy(id="bulk-action-selector-top")
	private List<WebElement> bulkActions;
	
	@FindBy(xpath="//select[@id='bulk-action-selector-top']//option[@value='delete'][contains(text(),'Delete')]")
	private WebElement deleteAction;
	
	@FindBy(id="doaction")
	private WebElement applyBtn;
	
	@FindBy(xpath="//p[contains(text(),'Tags deleted.')]")
	private WebElement deletionmsg;
	
	
	
	public void clickOnPostsLink() {
		this.postsLink.click(); 
	}
	
	public void clickOnTagsLink() {
		this.tagsLink.click(); 
	}
	
	public void clickOnTagToBeDeleted() {
		List<WebElement> allTags = this.tagsTable.findElements(By.tagName("tr"));
		System.out.println(allTags.get(0).getText());
		WebElement firstTag = allTags.get(1);
		firstTag.findElement(By.name("delete_tags[]")).click();
	}
	
	public void selectActions() {
		this.bulkActions.get(0).click(); 
	}
	
	public void clickDeleteActions() {
		this.deleteAction.click(); 
	}
	
	public void clickOnApplyBtn() {
		this.applyBtn.click(); 
	}
	
	public String confirmationMsg() {
		return this.deletionmsg.getText();
	}

}
