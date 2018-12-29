/*Test Case ID : RETC_024
Test Case Description : To Verify whether application allows admin to add new user*/

package com.training.rough.tests;

import java.awt.AWTException;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.BlogPOM;
import com.training.pom.LoginPOM;
import com.training.pom.UserLoginPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class OpenMultipleWindows {

	private WebDriver driver;
	private String userURL;
	private String baseURL;
	private LoginPOM loginPOM;
	private UserLoginPOM userloginPOM;
	private BlogPOM blogPOM;
	private static Properties properties;
	private ScreenShot screenShot;
	

	@BeforeClass
	public void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
		
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		loginPOM = new LoginPOM(driver);
		userloginPOM = new UserLoginPOM(driver);
		blogPOM = new BlogPOM(driver);
		userURL = properties.getProperty("userURL");
		//baseURL = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(userURL);
	}

	@AfterTest
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		//driver.quit();
	}
	
	
	@Test(priority=1)
	public void userLoginTest() throws InterruptedException{
		
		userloginPOM.clickOnLoginLink();
		userloginPOM.sendUserName("sunil");
		userloginPOM.sendPassword("sunil@123");
		userloginPOM.clickLoginBtn(); 
		screenShot.captureScreenShot();
	}
	
	@Test(priority=2)
	public void postCommentTest() throws InterruptedException, AWTException{
		
		userloginPOM.clickOnBlogLink();
		/*blogPOM.clickOnReadMoreLink("plots for sale");
		blogPOM.enterComment("Very Good for1");
		blogPOM.clickOnPostBtn();*/
		//userloginPOM.clickOnBackToTop();
    	blogPOM.clickOnDownArrow();
		Thread.sleep(3000);
		blogPOM.clickOnLogoutLink();
		/*String url="http://realestate.hommelle.com/admin";
		((JavascriptExecutor) driver).executeScript("window.open(arguments[0])", url);*/
		
	}
	
	@Test(priority=3)
	public void verifyCommentInAdminPageTest() throws InterruptedException{
		
		//String baseURL = properties.getProperty("baseURL");
		/*String url="http://realestate.hommelle.com/admin";
		((JavascriptExecutor) driver).executeScript("window.open(arguments[0])", url);*/
		
	}
}
