/*Test Case ID: RETC_023
Test Case Name: To Verify whether application allows admin to delete user from the users list
*/

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

public class RETC_023_DeleteUserTest {

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
				
		
		deleteuser.clickOnUsersLink(); //Click on Users Link in left menu bar
		deleteuser.clickOnAllUsers();  //Click on all user link under Users
		deleteuser.userToBeDeleted();  //Select a check box for user to be deleted
		deleteuser.clickOnBulkAction();  //Click on Bulk Actions List Box
		deleteuser.selectDeleteOption();  //Select Delete in Bulk Actions list box
		deleteuser.clickOnApplyBtn();  //Click on Apply Button
		deleteuser.clickOnConfirmDeleteBtn();  //Click on Confirm Deletion Button
		actualResult=deleteuser.MsgAfterUserDelete().trim();  //Get the actual result
		screenShot.captureScreenShot();
		Assert.assertEquals(actualResult, expectedResult);  //Comparing actual and expected result
		
	}
}
