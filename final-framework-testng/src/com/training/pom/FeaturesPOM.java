package com.training.pom;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.trianing.waits.WaitTypes;

public class FeaturesPOM {
	
	private WebDriver driver;
	private WaitTypes wt;
		
		public FeaturesPOM(WebDriver driver) {
			this.driver = driver; 
			PageFactory.initElements(driver, this);
			wt = new WaitTypes(driver);
		}
		
		//Finding the Name Field of Feature
		@FindBy(id="tag-name")
		private WebElement featureNameField;
		
		//Finding the Slug Field
		@FindBy(id="tag-slug")
		private WebElement slugField;
		
		//Finding the Parent Feature List
		@FindBy(id="parent")
		private WebElement parentFeature;
		
		//Finding the Description Field for Feature
		@FindBy(id="tag-description")
		private WebElement descField;
		
		//Finding the Add New Feature Button
		@FindBy(id="submit")
		private WebElement addNewFeature;
		
		
		
		
		
		
		
		
		
		//Enter a Feature name
		public void enterFeatureName(String name) {
			this.featureNameField.sendKeys(name); 
		}
		
		//Enter the Slug
		public void enterSlug(String slug) {
			this.slugField.sendKeys(slug); 
		}
		
		//Click on Parent Feature
		public void clickOnParentFeature() {
			this.parentFeature.click();
		}
		
		//Select Parent Feature
		public void selectParentFeature(String pRegion) {
			List<WebElement> allRegions = this.parentFeature.findElements(By.tagName("option"));
			for(WebElement region: allRegions) {
				String regText = region.getText().trim();
				//System.out.println("Region is: " + regText);
				if(regText.equalsIgnoreCase(pRegion)) {
					region.click();
					break;
				}
			}
		}
		
		//Enter Feature Description
		public void enterDescription(String desc) {
			this.descField.sendKeys(desc); 
		}
		
		//Click on the Add New Feature Button
		public void clickOnAddNewFeatureBtn() {
			this.addNewFeature.click();
		}
		
		
	

}
