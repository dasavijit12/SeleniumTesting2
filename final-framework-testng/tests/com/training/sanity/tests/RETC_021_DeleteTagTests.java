/*
 * Test Case ID: RETC_021
   Test Case Name:To verify whether application allows admin to delete tag from the tag page
*/

package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.ChangeRolePOM;
import com.training.pom.LoginPOM;
import com.training.pom.RETC_021_DeleteTagPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RETC_021_DeleteTagTests {

	private WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
	private static Properties properties;
	private ScreenShot screenShot;
	private RETC_021_DeleteTagPOM deletetag;
	private String actualResult;
	private String expectedResult = "Tags deleted.";

	@BeforeClass
	public void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
		
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		loginPOM = new LoginPOM(driver);
		deletetag = new RETC_021_DeleteTagPOM(driver);
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
	}
	
	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		//driver.quit();
	}
	
	
	@Test(priority=1)
	public void validLoginTest() throws InterruptedException{
		loginPOM.sendUserName("admin");
		loginPOM.sendPassword("admin@123");
		loginPOM.clickLoginBtn(); 
		screenShot.captureScreenShot();
	}
	
	@Test(priority=2)
	public void deleteTagsTest() throws InterruptedException{
		
		//Click on Posts link
		deletetag.clickOnPostsLink();
		Thread.sleep(1000);
		//Click on Tags link
		deletetag.clickOnTagsLink();
		//Click on the checkbox of the tag to be deleted
		deletetag.clickOnTagToBeDeleted();
		//Click Delete option
		deletetag.clickDeleteActions();
		//Click on Apply Button
		deletetag.clickOnApplyBtn();
		actualResult = deletetag.confirmationMsg();
		Assert.assertEquals(actualResult, expectedResult);
		screenShot.captureScreenShot();
	}
}
