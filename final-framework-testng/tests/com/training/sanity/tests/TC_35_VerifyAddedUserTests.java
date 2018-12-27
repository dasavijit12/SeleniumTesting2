/*Test Case ID : RETC_024
Test Case Description : To Verify whether application allows admin to add new user*/

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
import com.training.pom.AddNewUserPOM;
import com.training.pom.ChangeRolePOM;
import com.training.pom.LoginPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class TC_35_VerifyAddedUserTests {

	private WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
	private static Properties properties;
	private ScreenShot screenShot;
	private ChangeRolePOM changerole;
	private AddNewUserPOM addnewuser;
	private boolean actualResult;
	private boolean expectedResult = true;

	@BeforeClass
	public void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
		
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		loginPOM = new LoginPOM(driver);
		changerole = new ChangeRolePOM(driver);
		addnewuser = new AddNewUserPOM(driver);
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
	public void changeUserRole() throws InterruptedException{
		
		//Click on Users link
		changerole.clickOnUsersLink();
		Thread.sleep(1000);
		//Take Screen shot
		screenShot.captureScreenShot();
		//Click on Add New link
		changerole.clickOnAddNewUserBtn();
		//Enter Valid credentials in Username textbox
		String userName = addnewuser.enterUserName("manzoor");
		//Enter Valid credentials in Email textbox --- manzoor@gmail.com
		addnewuser.enterEmail("manzoor@gmail.com");
		//Enter Valid credentials in First Name textbox --- manzoor
		addnewuser.enterFirstName("manzoor");
		//Enter Valid credentials in Last Name textbox --- mehadi
		addnewuser.enterLastName("mehadi");
		//Enter Valid credentials in Website textbox --- www.google.com
		addnewuser.enterWebSite("www.google.com");
		//Click on Show Password button
		addnewuser.clickOnShowPasswordBtn();
		Thread.sleep(1000);
		//Click on Cancel button of Password field
		addnewuser.clickOnCancleBtn();
		Thread.sleep(1000);
		//Again Click on Show Password button
		addnewuser.clickOnShowPasswordBtn();
		Thread.sleep(2000);
		Thread.sleep(2000);
		//Enter Valid credentials in Password textbox --- Manzoor@Mehadi123
		addnewuser.enterPassword("Manzoor@Mehadi123");
		//Click on Role list box
		addnewuser.clickOnRoleListBox();
		//Select Valid credentials in Role list box --- Agent
		addnewuser.selectRole("Agent");
		//Take Screen Shot
		screenShot.captureScreenShot();
		//Click on Add New User button
		addnewuser.clickOnAddNewUserBtn();
		//Take Screen Shot
		screenShot.captureScreenShot();
		//Click on All Users link
		changerole.clickOnAllUsers();
		//Verify whether user is added or not
		actualResult = changerole.verifyUserIsAdded(userName);
		Assert.assertEquals(actualResult, expectedResult);
		
	}
}
