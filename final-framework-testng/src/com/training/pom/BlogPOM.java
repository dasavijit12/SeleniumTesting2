package com.training.pom;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
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
	
	//Finding the comment box
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
	
	//Finding the Name field
	@FindBy(id="author")
	private WebElement nameField;
	
	//Finding the Email field
	@FindBy(id="email")
	private WebElement emailField;
	
	
	//Clicking on Read More link
	public void clickOnReadMoreLink(String blogToAddComment) {
		List<WebElement> allBlogs = this.containerDiv.findElements(By.xpath("//div[contains(@class,'post-content')]//h3"));
		for(WebElement blog : allBlogs) {
			String myBlogText = blog.getText().trim();
			System.out.println("Blog Title is : " + myBlogText);
			WebElement readMore = blog.findElement(By.xpath("//div[contains(@class,'post-content')]//h3//following-sibling::a"));
			if(blogToAddComment.equals(myBlogText)) {
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
	public void clickOnDownArrow() throws AWTException {
		Actions action = new Actions(driver);
		action.moveToElement(this.downArrow).moveByOffset(124, 0).click().build().perform();
	}
		
	//Click on the Log Out Link
	public void clickOnLogoutLink() {
		this.logoutLink.click();
	}
	
	//Enter the Name of Author
	public void enterName(String nameOfAuthor) {
		this.nameField.clear();
		this.nameField.sendKeys(nameOfAuthor);
	}
	
	//Enter the Email of Author
	public void enterEmail(String emailOfAuthor) {
		this.emailField.clear();
		this.emailField.sendKeys(emailOfAuthor);
	}
}







