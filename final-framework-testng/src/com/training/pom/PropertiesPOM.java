package com.training.pom;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class PropertiesPOM {
	
private WebDriver driver; 
	
	public PropertiesPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="menu-posts-property")
	private WebElement propertiesLink; 
	
	@FindBy(xpath="//a[@class='wp-first-item current']")
	private WebElement allPropertiesLink;
	
	@FindBy(id="filter-by-date")
	private WebElement allDatesListBox;
	
	@FindBy(id="post-query-submit")
	private WebElement filterBtn;
	
		
	public void clickOnPropertiesLink() {
		this.propertiesLink.click(); 
	}
	
	public void clickOnAllPropertiesLink() {
		this.allPropertiesLink.click(); 
	}
	
	public void clickOnAlldatesListBox() {
		this.allDatesListBox.click(); 
	}
	
	public void selectValidDate(String date) {
		Select validDate = new Select(this.allDatesListBox);
		validDate.selectByVisibleText(date);
	}
	
	public void clickOnFilterBtn() {
		this.filterBtn.click(); 
	}
	
}
