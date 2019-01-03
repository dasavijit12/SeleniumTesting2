package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TakeAssessmentPOM {
	//To verify whether the application allows the student to take the authored assessment
private WebDriver driver; 

	public TakeAssessmentPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);

}
	@FindBy(xpath="//a[contains(text(),'Learn Selenium')]")
	private WebElement learnselenium1link ;

	public void clickLearnselenium1link1() {
		this.learnselenium1link.click(); 
	}
	@FindBy(xpath="//*[contains(title(),'Assessments')]")
	private WebElement assessmenticon  ;

	public void clickAssessmenticon() {
		this.learnselenium1link.click(); 
	}
	@FindBy(xpath="//a[contains(text(),'Test1')]")
	private WebElement test1link  ;

	public void clickOntest1link() {
		this.test1link.click(); 
	}
	@FindBy(xpath="//a[@class='btn btn-success btn-large']")
	private WebElement starttest1btn  ;

	public void clickOnstarttest1btn() {
		this.starttest1btn.click(); 
	}
	@FindBy(xpath="//body[@class='cke_editable cke_editable_themed cke_contents_ltr cke_show_borders']")
	private WebElement answerbox1 ;

	public void writeAnswer1(String value3) {

			driver.switchTo().frame(0);
			this.answerbox1.sendKeys(value3);
			driver.switchTo().defaultContent();

	}
	@FindBy(name="save_now")
	private WebElement endtestbtn1 ;

	public void clickEndtestbtn1() {
		this.endtestbtn1.click(); 
	}
} 