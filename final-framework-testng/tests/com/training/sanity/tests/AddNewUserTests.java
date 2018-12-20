package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.AddNewUserPOM;
import com.training.pom.ChangeRolePOM;
import com.training.pom.LoginPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class AddNewUserTests {

	private WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
	private static Properties properties;
	private ScreenShot screenShot;
	private ChangeRolePOM changerole;
	private AddNewUserPOM addnewuser;
	private String actualResult;
	private String tempResult;
	private String expectedResult = "New user created.";

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
		//driver.quit();
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
				
		changerole.clickOnUsersLink();
		Thread.sleep(1000);
		screenShot.captureScreenShot();
		changerole.clickOnAddNewUserBtn();
		addnewuser.enterUserName("manzoor");
		addnewuser.enterEmail("manzoor@gmail.com");
		addnewuser.enterFirstName("manzoor");
		addnewuser.enterLastName("mehadi");
		addnewuser.enterWebSite("www.google.com");
		addnewuser.clickOnShowPasswordBtn();
		Thread.sleep(1000);
		addnewuser.clickOnCancleBtn();
		Thread.sleep(1000);
		addnewuser.clickOnShowPasswordBtn();
		Thread.sleep(2000);
		Thread.sleep(2000);
		addnewuser.enterPassword("Manzoor@Mehadi123");
		addnewuser.clickOnRoleListBox();
		addnewuser.selectRole("Agent");
		screenShot.captureScreenShot();
		addnewuser.clickOnAddNewUserBtn();
		tempResult=addnewuser.confirmationMsg().trim();
		actualResult=tempResult.substring(0, 17);
		Assert.assertEquals(actualResult, expectedResult);
		screenShot.captureScreenShot();
	}
}
