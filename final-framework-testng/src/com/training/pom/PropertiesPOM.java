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
	
	//Finding the Add New Button
	@FindBy(xpath="//a[@class='page-title-action']")
	private WebElement addNewBtn;
	
	//Finding the Trash Link
	@FindBy(xpath="//a[@href='edit.php?post_status=trash&post_type=property']")
	private WebElement trashLink;
	
	//Finding the table body that contains all the properties
	@FindBy(id="the-list")
	private WebElement usersTable;
	
	
	
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
	
	//Click on Add New Button to add new property
	public void clickOnAddNewBtn() {
		this.addNewBtn.click(); 
	}
	
	//Click on Add New Button to add new property
	public void clickOnTrashLink() {
		this.trashLink.click(); 
	}
	
	//Click on Restore Link after hovering mouse on a certain property
	public void clickOnRestoreLink(String pName) {

		List<WebElement> propertyRows = this.usersTable.findElements(By.xpath("//tbody[@id='the-list']/tr"));
		int noOfRows = propertyRows.size();
		System.out.println(noOfRows);
		boolean flag = false;
		for(int i=0; i<noOfRows; i++) {
			WebElement cellINeed = propertyRows.get(i).findElement(By.xpath("//tbody[@id='the-list']/tr[" + (i+1) + "]/td[1]"));
			String myProperty = cellINeed.getText();
			if(myProperty.equals(pName)) {
				Actions action = new Actions(driver);
				action.moveToElement(cellINeed).build().perform();
				cellINeed.findElement(By.linkText("Restore")).click();;
				break;
			}
		}
	}
	
	//
	public boolean isPropertyRestored(String RestoredPName) {

		List<WebElement> propertyRows = this.usersTable.findElements(By.xpath("//tbody[@id='the-list']/tr"));
		int noOfRows = propertyRows.size();
		System.out.println(noOfRows);
		boolean flag = false;
		for(int i=0; i<noOfRows; i++) {
			WebElement cellINeed = propertyRows.get(i).findElement(By.xpath("//tbody[@id='the-list']/tr[" + (i+1) + "]/td[1]"));
			String myProperty = cellINeed.getText();
			if(myProperty.equals(RestoredPName)) {
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
