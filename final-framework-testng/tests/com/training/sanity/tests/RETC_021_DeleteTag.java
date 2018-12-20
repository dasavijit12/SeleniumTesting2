package com.training.sanity.tests;

import org.testng.annotations.Test;

import com.training.generics.ScreenShot;

import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class RETC_021_DeleteTag {
	private WebDriver driver;
	private RETC_021_DeleteTagPOM deletetag;
	private String actualResult;
	private String expectedResult = "Tags deleted.";
	private ScreenShot screenShot;
	
	RETC_021_DeleteTag(WebDriver driver) {
		this.driver = driver;
	}

	@BeforeTest
	public void beforeTest() {
		deletetag = new RETC_021_DeleteTagPOM(driver);
		System.out.println("This is before test....");
	}

	@Test
	public void f() throws InterruptedException {

		deletetag.mouseOverOnPostsLink();
		Thread.sleep(1000);
		deletetag.clickOnTagsLink();
		deletetag.clickOnTagToBeDeleted();
		Thread.sleep(2000);
		deletetag.clickDeleteActions();
		deletetag.clickOnApplyBtn();
		Thread.sleep(3000);
		actualResult = deletetag.confirmationMsg();
		Assert.assertEquals(actualResult, expectedResult);
		screenShot.captureScreenShot();
		System.out.println("This is test method....");

	}

	@AfterTest
	public void afterTest() {
		System.out.println("This is after test....");
		//driver.quit();
	}

}
