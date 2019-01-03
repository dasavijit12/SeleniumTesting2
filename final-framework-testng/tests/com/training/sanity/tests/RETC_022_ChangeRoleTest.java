/*Test Case ID : RETC_022
Test Case Description : To Verify whether application allows admin to change 
						the role of registered user in Users module
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

public class RETC_022_ChangeRoleTest {

	private WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
	private static Properties properties;
	private ScreenShot screenShot;
	private ChangeRolePOM changerole;
	private String actualResult;
	private String expectedResult = "Changed roles.";

	@BeforeClass
	public void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
		
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		loginPOM = new LoginPOM(driver);
		changerole = new ChangeRolePOM(driver);
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
	public void changeUserRole() throws InterruptedException{
		
		//Click on Users Link
		changerole.clickOnUsersLink();
		//Click on All User Link
		changerole.clickOnAllUsers();
		//Click on the checkbox beside the user
		changerole.userToBeSelected();
		//Click on Change role to list box
		changerole.clickOnChangeRoleToBtn();
		//Select valid credentials in change role to list box
		changerole.changeRoleTo();
		//Take Screen Shot
		screenShot.captureScreenShot();
		//Click on Change button
		changerole.clickOnChangeBtn();
		//Get the message that displayed on page after changing the role of User
		actualResult=changerole.confirmationMsg();
		screenShot.captureScreenShot();
		Assert.assertEquals(actualResult, expectedResult);
	}
}
