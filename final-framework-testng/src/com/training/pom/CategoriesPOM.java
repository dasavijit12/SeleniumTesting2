package com.training.pom;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.trianing.waits.WaitTypes;

public class CategoriesPOM {
	
private WebDriver driver; 
private WaitTypes wt;
	
	public CategoriesPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
		wt = new WaitTypes(driver);
	}
	
	//Finding the Posts Link
	@FindBy(id="menu-posts")
	private WebElement postsLink;
	
	//Finding the Categories Link
	@FindBy(xpath="//a[@href='edit-tags.php?taxonomy=category']")
	private WebElement categoriesLink;
	
	//Finding the Category name field
	@FindBy(id="tag-name")
	private WebElement categoryNameField;
	
	//Finding the Slug Field
	@FindBy(id="tag-slug")
	private WebElement slugsField;
	
	//Finding the parent Category dropdown
	@FindBy(id="parent")
	private WebElement parentCategory;
	
	//Finding the description field
	@FindBy(id="tag-description")
	private WebElement descField;
	
	//Finding the Add New Category Button
	@FindBy(id="submit")
	private WebElement addNewCategory;
	
	//Finding the Add New Post Link
	@FindBy(xpath="//li[@id='menu-posts']//div[contains(text(),'Posts')]")
	private WebElement post;
	
	//Finding the Add New button
	@FindBy(xpath="//a[@class='page-title-action']")
	private WebElement addNewBtn;
	
	
	
	
	
	//Click on Posts Link
	public void clickOnPostsLink() {
		this.postsLink.click(); 
	}
	
	//Click on Categories Link
	public void clickOnCategoriesLink() {
		this.categoriesLink.click(); 
	}
	
	//Enter the name for the Category
	public void enterCategoryName(String catgName) {
		this.categoryNameField.sendKeys(catgName);; 
	}
	
	//Enter data on the Slug Field
	public void enterSlug(String slugName) {
		this.slugsField.sendKeys(slugName);; 
	}
	
	//Click on parent Category
	public void clickOnParentCategory() {
		this.parentCategory.click();
	}
	
	//Select Parent Category
	public void selectParentCategory(String pCategory) {
		List<WebElement> allCategories = this.parentCategory.findElements(By.tagName("option"));
		for(WebElement category: allCategories) {
			String catgText = category.getText().trim();
			//System.out.println("Region is: " + regText);
			if(catgText.equalsIgnoreCase(pCategory)) {
				category.click();
				break;
			}
		}
	}
	
	//Enter the Description
	public void enterDescription(String desc) {
		this.descField.sendKeys(desc); 
	}
	
	//Click on the Add New Category Button
	public void clickOnAddNewCategoryBtn() {
		this.addNewCategory.click();
	}
	
	//Click on Post Link
	public void clickingOnPostLink() {
		this.post.click();
	}
	
	//Click on Add New Button to add a new post
	public void clickOnAddNewPostBtn() {
		//wt.elementToBeClickable1(this.addNewBtn, 5).click();
		this.addNewBtn.click();
	}
	
	
	

}
