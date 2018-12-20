package com.training.sanity.tests;

import org.testng.annotations.Test;

import com.training.pom.LoginPOM;

import org.testng.annotations.BeforeTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;

public class BaseTest_RETC_021_DeleteTag extends WebDriverLaunch {

	public WebDriver driver;
	public LoginPOM loginPOM;
	public RETC_021_DeleteTagPOM deletetags;

	@Test(priority = 1)
	public void loginToSite() {
		loginPOM = new LoginPOM(driver);
		loginPOM.sendUserName("admin");
		loginPOM.sendPassword("admin@123");
		loginPOM.clickLoginBtn();
		screenShot.captureScreenShot();
	}

	@Test(priority = 2)
	public void deleteTags() {
		deletetags = new RETC_021_DeleteTagPOM(driver);
		deletetags.mouseOverOnPostsLink();
		System.out.println("this is test...");
	}

}
