package com.training.pom;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.trianing.waits.WaitTypes;

public class AddNewPostPOM {
	
private WebDriver driver;
private WaitTypes wt;
	
	public AddNewPostPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
		wt = new WaitTypes(driver);
	}
	
	//Finding the Title Field
	@FindBy(xpath="//input[@name='post_title']")
	private WebElement titleField;
	
	/*//Finding the Paragraph Field
	@FindBy(id="tinymce")
	private WebElement paragraphField;*/
	
	//
	@FindBy(id="content")
	private WebElement paragraphField;
	
	//Finding the div that contains all the categories
	@FindBy(id="category-all")
	private WebElement allCategories;
	
	//Finding the Publish Button
	@FindBy(id="publish")
	private WebElement publishBtn;
	
	//Finding the div that contains the confirmation message after Post Publish
	@FindBy(id="message")
	private WebElement publishMsg;
	
	
	
	
	//Enter Title
	public void enterTitle(String title) {
		wt.presenceElementLocated1(this.titleField, 5).sendKeys(title);
	}
	
	//Enter text on the Paragraph
	public void enterParagraph(String paragraph) {
		//driver.switchTo().frame(0);
		this.paragraphField.sendKeys(paragraph);
		//driver.switchTo().defaultContent();
	}
	
	//Select the created Category
	public void selectCreatedCategory(String selectedCategory) {
		List<WebElement> categories = this.allCategories.findElements(By.xpath
				("//div[@id='category-all']//label[@class='selectit']"));
		for(WebElement category : categories) {
			String myCategory = category.getText().trim();
			//System.out.println(myFeature);
			if(myCategory.equals(selectedCategory)) {
				System.out.println("This is my Category...." + myCategory);
				category.click();
				break;
			}
		}
		
	}
	
	//Click on the Publish Button
	public void clickOnPublishBtn() {
		wt.elementToBeClickable1(this.publishBtn, 5).click();
	}
	
	//Getting the Confirmation message after post publish
	public String getPublishMsg() {
		return this.publishMsg.getText().trim().substring(0, 15);
	}
	

}
