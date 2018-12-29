/*Test Case ID : RETC_041
Test Case Description : To verify whether application display comments added by the user in admin page*/

package com.training.sanity.tests;

import java.awt.AWTException;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.BlogPOM;
import com.training.pom.CommentsPOM;
import com.training.pom.HomePagePOM;
import com.training.pom.LoginPOM;
import com.training.pom.UserLoginPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RETC_041_VerifyCommentTests {

	private WebDriver driver;
	private String userURL;
	private String baseURL;
	private LoginPOM loginPOM;
	private HomePagePOM homepagePOM;
	private UserLoginPOM userloginPOM;
	private CommentsPOM commentsPOM;
	private BlogPOM blogPOM;
	private static Properties properties;
	private ScreenShot screenShot;
	private boolean actualResult;
	private boolean expectedResult=true;
	private String comment = "Verry Good2";
	

	@BeforeClass
	public void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
		
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		loginPOM = new LoginPOM(driver);
		userloginPOM = new UserLoginPOM(driver);
		blogPOM = new BlogPOM(driver);
		homepagePOM = new HomePagePOM(driver);
		commentsPOM = new CommentsPOM(driver);
		userURL = properties.getProperty("userURL");
		baseURL = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(userURL);
	}

	@AfterTest
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}
	
	
	@Test(priority=1)
	public void userLoginTest() throws InterruptedException{
		
		//Clicking on the Blog Link
		homepagePOM.clickOnBlogLink();
		//Clicking on the read more link of the added post
		blogPOM.clickOnReadMoreLink("Test_Post_Avi_1");
		//Enter the comment
		blogPOM.enterComment(comment);
		//Enter name of the Author
		blogPOM.enterName("Avi");
		//Enter the Email of the Author
		blogPOM.enterEmail("demoavimail1@gmail.com");
		//Click on the Post Comment Button
		blogPOM.clickOnPostBtn();
		//Take Screen shot
		screenShot.captureScreenShot();
	}
	
	
	@Test(priority=2)
	public void verifyCommentInAdminPageTest() throws InterruptedException{
		
		//Opening the Admin url in a new Tab
		((JavascriptExecutor) driver).executeScript("window.open(arguments[0])", baseURL);
		//Switching to the new Tab
		ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
	    driver.switchTo().window(tabs2.get(1));
	    //Enter the user name
		loginPOM.sendUserName("admin");
		//Enter the Password
		loginPOM.sendPassword("admin@123");
		//Click on Sign in Button
		loginPOM.clickLoginBtn();
		//Click on Comments Link
		commentsPOM.clickOnCommentsLink();
		//verify whether application display comments added by the user in admin page
		actualResult = commentsPOM.searchForAddedComment(comment);
		//Take Screen shot
		screenShot.captureScreenShot();
		System.out.println(actualResult);
		Assert.assertEquals(actualResult, expectedResult);
		
	}
}
