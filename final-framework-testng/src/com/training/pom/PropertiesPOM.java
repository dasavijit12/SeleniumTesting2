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
	
	//Finding the Properties Link
	@FindBy(id="menu-posts-property")
	private WebElement propertiesLink;
	
	//Finding the All Properties Link
	@FindBy(xpath="//a[@class='wp-first-item current']")
	private WebElement allPropertiesLink;
	
	//Finding the All Dates List Box
	@FindBy(id="filter-by-date")
	private WebElement allDatesListBox;
	
	//Finding the Filter Button
	@FindBy(id="post-query-submit")
	private WebElement filterBtn;
	
	//Finding the Table contains Filtered data
	@FindBy(id="the-list")
	private WebElement filterTable;
	
	
	//Click on properties link
	public void clickOnPropertiesLink() {
		this.propertiesLink.click(); 
	}
	
	//Click on All Properties Link
	public void clickOnAllPropertiesLink() {
		this.allPropertiesLink.click(); 
	}
	
	//Click on All Dates list box
	public void clickOnAlldatesListBox() {
		this.allDatesListBox.click(); 
	}
	
	//Select valid credentials in All Dates list box
	public void selectValidDate(String date) {
		Select validDate = new Select(this.allDatesListBox);
		validDate.selectByVisibleText(date);
	}
	
	//Click on Filter button
	public void clickOnFilterBtn() {
		this.filterBtn.click(); 
	}
	
	//Fetching the data of the Posted Column
	public String actualFilterData() {
		List<WebElement> allRows = this.filterTable.findElements(By.tagName("tr"));
		
		WebElement userToSelect = allRows.get(0);
		WebElement tableData = userToSelect.findElement(By.xpath("//td[@class='property_posted column-property_posted']"));
		//System.out.println(tableData.getText());
		return tableData.getText();
	}
	
}
