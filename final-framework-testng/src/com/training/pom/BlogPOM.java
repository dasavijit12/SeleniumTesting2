package com.training.pom;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BlogPOM {
	private WebDriver driver; 
	
	public BlogPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	//Finding the div that contains all the blog in that page
	@FindBy(xpath="//div[@class='col-md-8']")
	private WebElement containerDiv;
	
	//Finding the div that contains all the blog in that page
	@FindBy(id="comment")
	private WebElement commentBox;
	
	//Finding the Post Comment button
	@FindBy(id="submit")
	private WebElement postCommentBtn;
	
	//Finding the down arrow beside user name on top right
	@FindBy(xpath="//div[@class='user-name']")
	private WebElement downArrow;
	
	//Finding the Log Out Link
	@FindBy(xpath="//a[contains(text(),'Log Out')]")
	private WebElement logoutLink;
	
	//Clicking on Read More link
	public void clickOnReadMoreLink(String blockToAddComment) {
		List<WebElement> allBlogs = this.containerDiv.findElements(By.xpath("//div[contains(@class,'post-content')]//h3"));
		for(WebElement block : allBlogs) {
			String myBlockText = block.getText().trim();
			System.out.println(myBlockText);
			WebElement readMore = block.findElement(By.xpath("//div[contains(@class,'post-content')]//h3//following-sibling::a"));
			if(blockToAddComment.equals(myBlockText)) {
				readMore.click();
				break;
			}
		}
	}
	
	//Enter comment in the comment box
	public void enterComment(String comment) {
		this.commentBox.sendKeys(comment); 
	}
	
	//Click on the Post Comment Button
	public void clickOnPostBtn() {
		this.postCommentBtn.click();; 
	}
	
	//Click on the down arrow that is in ::after pseudo element
		public void clickOnDownArrow() {
			Actions action = new Actions(driver);
			action.moveToElement(this.downArrow).moveByOffset(124, 0).click().build().perform();
		}
		
	//Click on the Log Out Link
		public void clickOnLogoutLink() {
			this.logoutLink.click();
		}
}
