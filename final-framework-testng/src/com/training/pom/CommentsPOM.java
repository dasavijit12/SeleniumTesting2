package com.training.pom;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CommentsPOM {
	private WebDriver driver; 
	
	public CommentsPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	//Finding the Comments Link
	@FindBy(id="menu-comments")
	private WebElement commentsLink;
	
	//Finding the Table body that contains comments
	@FindBy(id="the-comment-list")
	private WebElement tableBody;
	
	
	
	//Click on the Comments link
	public void clickOnCommentsLink() {
		this.commentsLink.click();
	}
	
	//Verify whether Added Comment is getting displayed
	public boolean searchForAddedComment(String commentText) {
		List<WebElement> comments = this.tableBody.findElements(By.xpath("//tbody[@id='the-comment-list']//tr"));
		int count = comments.size();
		boolean flag = false;
		for(int i=0; i<count; i++) {
			WebElement myComment = comments.get(i).findElement(By.xpath("//tbody[@id='the-comment-list']//tr[" + (i+1) + "]//td[2]"));
			String myCommentText = myComment.getText().trim();
			//System.out.println(myCommentText);
			if(commentText.equals(myCommentText)) {
				System.out.println("This is what I was looking for..." + myCommentText);
				flag = true;
				break;
			}
		}
		if(flag) {
			return true;
		} else {
			return false;
		}
	}
	
	
	
}
