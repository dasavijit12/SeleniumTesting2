package com.training.pom;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddPropertyPOM {
	
private WebDriver driver; 
	
	public AddPropertyPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	//Finding the Add New Feature Link
	@FindBy(id="property_feature-add-toggle")
	private WebElement addNewFeatureLink;
	
	//Finding the Textbox that displayed after clicking on Add New Feature Link
	@FindBy(id="newproperty_feature")
	private WebElement newFeatureTextBox;
	
	//Finding the Parent Feature List Box
	@FindBy(id="newproperty_feature_parent")
	private WebElement parentFeature;
	
	//Finding the Parent Feature List Box
	@FindBy(id="property_feature-add-submit")
	private WebElement addNewFeatureBtn;
	
	//Finding the Enter Title here box
	@FindBy(id="title")
	private WebElement enterTitleField;
	
	//Finding the text box Field
	@FindBy(id="content")
	private WebElement textBoxField;
	
	//Finding all the Features
	@FindBy(id="property_feature-all")
	private WebElement allFeatures;
	
	//
	@FindBy(id="region-all")
	private WebElement allRegions;
	
	//Finding the Publish Button
	@FindBy(id="publish")
	private WebElement publishBtn;
	
	//Finding the Paragraph that contains the message after a feature is published successfully
	@FindBy(xpath="//div[@id='message']//p")
	private WebElement publishMesaage;
	
	//Finding the Move To Trash Link
	@FindBy(xpath="//div[@id='delete-action']//a")
	private WebElement moveToTrashLink;

	
	
	//Click on Add New Feature Link in Features section
	public void clickOnAddNewFeatureLink() {
		this.addNewFeatureLink.click(); 
	}
	
	//Enter data in the text box of Feature section
	public void enterDataOnFeatureTextBox(String featureData) {
		this.newFeatureTextBox.sendKeys(featureData); 
	}
	
	//Select a parent feature
	public void selectParentFeature(String parentFeatureOption) {
		Select pFeature = new Select(this.parentFeature);
		pFeature.selectByVisibleText("interior");
	}
	
	//Click on Add New Feature Link in Features section
	public void clickOnAddNewFeatureBtn() {
		this.addNewFeatureBtn.click();
		driver.navigate().refresh();
	}
	
	//Enter Title
	public void enterTitle(String title) {
		this.enterTitleField.sendKeys(title);
	}
	
	//Enter valid credentials in textbox
	public void enterTextOnTextBox(String text) {
		this.textBoxField.sendKeys(text);
	}
	
	//Select the created Feature from all the features
	public void selectCreatedFeature(String selectedFeature) {
		List<WebElement> features = this.allFeatures.findElements(By.xpath
				("//div[@id='property_feature-all']//label[@class='selectit']"));
		for(WebElement feature : features) {
			String myFeature = feature.getText().trim();
			//System.out.println(myFeature);
			if(myFeature.equals(selectedFeature)) {
				feature.click();
				break;
			}
		}
		
	}
	
	//Select the created Region from all the Regions
	public void selectCreatedRegion(String selectedRegion) {
		List<WebElement> regions = this.allRegions.findElements(By.xpath
				("//div[@id='region-all']//label[@class='selectit']"));
		for(WebElement region : regions) {
			String myRegion = region.getText().trim();
			//System.out.println(myFeature);
			if(myRegion.equals(selectedRegion)) {
				System.out.println("This is my Region...." + myRegion);
				region.click();
				break;
			}
		}
		
	}
	
	//Click on Publish button
	public void clickOnPublishBtn() {
		this.publishBtn.click();
	}
	
	//Click on Publish button
	public String getPublishedMsg() {
		return this.publishMesaage.getText();
	}
	
	//Click on Move to Trash Link
	public void clickOnMoveToTrashLink() {
		this.moveToTrashLink.click();
	}
	
	//
	public void acceptAlert() {
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}
	
}
