package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.trianing.waits.WaitTypes;

public class MenuBarPOM {
	
	private WebDriver driver;
	private WaitTypes wt;
		
		public MenuBarPOM(WebDriver driver) {
			this.driver = driver; 
			PageFactory.initElements(driver, this);
			wt = new WaitTypes(driver);
		}
		
		//Finding the Posts Menu
		@FindBy(xpath="//div[contains(text(),'Posts')]")
		private WebElement postsMenu;
		
		//Finding the categories Link
		@FindBy(xpath="//a[@href='edit-tags.php?taxonomy=category']")
		private WebElement categoriesLink;
		
		//Finding the post Menu when we are in a sub Menu
		@FindBy(xpath="//li[@id='menu-posts']//div[contains(text(),'Posts')]")
		private WebElement post;
		
		//Finding the Add new Link under Properties Menu
		@FindBy(xpath="//a[@href='post-new.php?post_type=property']")
		private WebElement addNewLink;
		
		//Finding the Property Menu
		@FindBy(xpath="//div[contains(text(),'Properties')]")
		private WebElement propertyMenu;
		
		//Finding the Feature Link under property Menu
		@FindBy(xpath="//a[contains(text(),'Features')]")
		private WebElement featureLink;
		
		//Finding the Regions Link under property Menu
		@FindBy(xpath="//a[contains(text(),'Regions')]")
		private WebElement regionsLink;
		
		//Finding the Add New Link under the Posts Menu
		@FindBy(xpath="//a[@href='post-new.php']")
		private WebElement addNewPostLink;
		
		
		
		
		
		
		//Mouse Hover on the Posts Menu
		public void mouseHoverOnPosts() {
			Actions action = new Actions(driver);
	        action.moveToElement(this.postsMenu).build().perform();
		}
		
		//Click on Posts Link
		public void clickOnPostsLink() {
			this.postsMenu.click(); 
		}
		
		//Click on the Categories Link
		public void clickOnCategoriesLink() {
			wt.elementToBeClickable1(this.categoriesLink, 5).click();
		}
		
		//Click on Post Link when we are in a sub Menu
		public void clickingOnPostLink() {
			this.post.click();
		}
		
		//Click on the Add New link under Properties Menu
		public void clickOnAddNewPropertyLink() {
			this.addNewLink.click();
		}
		
		//Click on the Property Menu
		public void clickOnPropertyMenu() {
			this.propertyMenu.click();
		}
		
		//Click on the Feature Link under Property Menu
		public void clickOnFeatureLink() {
			this.featureLink.click();
		}
		
		//Click on the Regions Link under Property Menu
		public void clickOnRegionsLink() {
			this.regionsLink.click();
		}
		
		//Click on the Add New Link under the Posts Menu
		public void clickOnAddNewPostLink() {
			this.addNewPostLink.click();
		}
		
		

}
