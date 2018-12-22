/*Test Case ID: RETC_023
Test Case Name:To Verify whether application allows admin to delete user from the users list*/

package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;

import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.ChangeRolePOM;
import com.training.pom.LoginPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class DeleteUserTest {

	private WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
	private static Properties properties;
	private ScreenShot screenShot;
	private ChangeRolePOM deleteuser;
	private String actualResult;
	private String expectedResult = "User deleted.";

	@BeforeClass
	public void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
		
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		loginPOM = new LoginPOM(driver);
		deleteuser = new ChangeRolePOM(driver);
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
	}

	
	@AfterTest
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}
	
	
	@Test(priority=1)
	public void validLogin() throws InterruptedException{
		loginPOM.sendUserName("admin");
		loginPOM.sendPassword("admin@123");
		loginPOM.clickLoginBtn(); 
		screenShot.captureScreenShot();
	}
	
	@Test(priority=2)
	public void deleteUserTest() throws InterruptedException{
				
		//Click on Users Link in left menu bar
		deleteuser.clickOnUsersLink();
		Thread.sleep(1000);
		//Click on all user link under Users
		deleteuser.clickOnAllUsers();
		//Select a check box for user to be deleted
		deleteuser.userToBeDeleted();
		//Click on Bulk Actions List Box
		deleteuser.clickOnBulkAction();
		//Select Delete in Bulk Actions list box
		deleteuser.selectDeleteOption();
		//Click on Apply Button
		deleteuser.clickOnApplyBtn();
		//Click on Confirm Deletion Button
		deleteuser.clickOnConfirmDeleteBtn();
		//Get the actual result
		actualResult=deleteuser.MsgAfterUserDelete().trim();
		screenShot.captureScreenShot();
		//Comparing actual and expected result
		Assert.assertEquals(actualResult, expectedResult);
		
	}
}
