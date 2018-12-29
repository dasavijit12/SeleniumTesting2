package com.training.pom;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePagePOM {
	private WebDriver driver; 
	
	public HomePagePOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	//Finding the Real Estate Link
	@FindBy(xpath="//a[@title='Real Estate']")
	private WebElement realEstateLink;
	
	//Finding the Search Box in the home page 
	@FindBy(xpath="//input[@title='Search input']")
	private WebElement searchBox;
	
	//Finding the search results
	@FindBy(id="mCSBap_1_container")
	private WebElement searchResult;
	
	
	//Finding the Blog Link
	@FindBy(xpath="//ul[@id='responsive']//a[@href='http://realestate.hommelle.com/blog/']")
	private WebElement blogLink;
	
	
	//Click on Real Estate Link
	public void clickOnRealEstateLink() {
		this.realEstateLink.click();
	}
	
	//Enter Search text
	public void enterSearchItem(String srchItem) {
		JavascriptExecutor je = (JavascriptExecutor) driver;
		je.executeScript("window.scrollBy(0,1500)");
		//je.executeScript("arguments[0].scrollIntoView(true);",searchBox);
		this.searchBox.sendKeys(srchItem);
	}
	
	//Verify whether search result is getting displayed
	public boolean verifySearchResult(String searchText) {
		List<WebElement> results = this.searchResult.findElements(By.xpath("//div[@id='mCSBap_1_container']//h3"));
		boolean flag = false;
		for(WebElement myResult : results) {
			String resultText = myResult.getText().trim();
			//System.out.println(myResult.getText());
			if(searchText.equals(resultText)) {
				System.out.println("This is what I was looking for..." + resultText);
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
	
	//Click on the Blog link
	public void clickOnBlogLink() {
		this.blogLink.click();
	}
	
}
