package com.training.pom;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.trianing.waits.WaitTypes;

public class RegionsPOM {
	
private WebDriver driver;
private WaitTypes wt;
	
	public RegionsPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
		wt = new WaitTypes(driver);
	}
	
	//Finding the Name Field
	@FindBy(id="tag-name")
	private WebElement nameField;
	
	//Finding the Slug Text Box
	@FindBy(id="tag-slug")
	private WebElement slugField;
	
	//Finding the parent region dropdown
	@FindBy(id="parent")
	private WebElement parentRegion;
	
	//Finding the description field
	@FindBy(id="tag-description")
	private WebElement descField;
	
	//Finding the Add New Region Button
	@FindBy(id="submit")
	private WebElement addNewRegion;
	
	//Finding the Search box
	@FindBy(id="tag-search-input")
	private WebElement searchRegion;
	
	//Finding the search button
	@FindBy(id="search-submit")
	private WebElement searchBtn;
	
	//Finding the table that contains all the created regions
	@FindBy(id="the-list")
	private WebElement regionsTable;
	
	
	
	
	
	//Enter the name for the region
	public void enterName(String name) {
		this.nameField.sendKeys(name); 
	}
	
	//Enter data on Slug Field
	public void enterSlug(String slug) {
		this.slugField.sendKeys(slug); 
	}
	
	//Click on Parent Region
	public void clickOnParentRegion() {
		this.parentRegion.click();
	}
	
	//Select Parent Region
	public void selectParentRegion(String pRegion) {
		List<WebElement> allRegions = this.parentRegion.findElements(By.tagName("option"));
		for(WebElement region: allRegions) {
			String regText = region.getText().trim();
			//System.out.println("Region is: " + regText);
			if(regText.equalsIgnoreCase(pRegion)) {
				region.click();
				break;
			}
		}
	}
	
	//Enter the Description
	public void enterDescription(String desc) {
		this.descField.sendKeys(desc); 
	}
	
	//Click on Add New Region Button
	public void clickOnAddNewRegionBtn() {
		this.addNewRegion.click();
	}
	
	//Enter Search Item
	public void enterSearchItem(String regionName) {
		wt.presenceElementLocated1(this.searchRegion, 5).sendKeys(regionName);
		//this.searchRegion.sendKeys(regionName);
	}
	
	//Click on the Search Region Button
	public void clickOnSearchRegionBtn() {
		wt.elementToBeClickable1(this.searchBtn, 5).click();
	}
	
	//Verify whether the Region is added or not
	public boolean searchForAddedRegion(String regionName) {
		List<WebElement> regions = wt.presenceElementLocated1(this.regionsTable, 5).findElements(By.xpath("//tbody[@id='the-list']//tr"));
		int count = regions.size();
		boolean flag = false;
		for(int i=0; i<count; i++) {
			WebElement myRegion = regions.get(i).findElement(By.xpath("//tbody[@id='the-list']//tr[" + (i+1) + "]//td[1]"));
			String myRegionText = wt.presenceElementLocated1(myRegion, 5).getText().trim();
			System.out.println(myRegionText);
			if(regionName.equals(myRegionText)) {
				System.out.println("This is the region I was looking for..." + myRegionText);
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
