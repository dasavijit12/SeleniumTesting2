/*Test Case ID : RETC_084
Test Case Description : To Verify whether application displays error message upon entering
 						invalid details in required fields while creating user by admin
*/

package com.training.complex.tests;

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
import com.training.pom.AddUsersPOM;
import com.training.pom.ChangeRolePOM;
import com.training.pom.LoginPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;
import com.training.utility.TestUtil;

public class RETC_084_CreatInvalidUserTests {

	private WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
	private static Properties properties;
	private ScreenShot screenShot;
	//private WaitTypes wt;
	private ChangeRolePOM changerole;
	private AddUsersPOM addnewuser;
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
		addnewuser = new AddUsersPOM(driver);
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
	}

	@AfterTest
	public void tearDown() throws Exception {
		//driver.quit();
	}
	
	
	@Test(priority=1)
	public void validLogin() throws InterruptedException{
		loginPOM.sendUserName("admin");
		loginPOM.sendPassword("admin@123");
		loginPOM.clickLoginBtn(); 
		screenShot.captureScreenShot();
	}
	
	@Test(priority=2,dataProviderClass=TestUtil.class,dataProvider="dp")
	public void createInvalidUserTest(String uName, String email, String fName, String lName, String site, String pwrd, String role) throws InterruptedException{
		
		
		changerole.clickOnUsersLink();													//Click on Users link
		changerole.clickOnAddNewUserBtn();												//Click on Add New link
		addnewuser.addNewUser(uName, email, fName, lName, site, pwrd, role);			//Perform the tasks to add a new user
		screenShot.captureScreenShot();													//Take Screen Shot
		boolean status = addnewuser.confirmationMsg();									//Status of Adding user
		Assert.assertTrue(status);
		
	}
}
