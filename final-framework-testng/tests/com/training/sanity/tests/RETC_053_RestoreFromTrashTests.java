/*Test Case ID : RETC_053
Test Case Description : To verify whether application displays property details home screen 
						upon clicking Restore link of selected property details in trash
*/

package com.training.sanity.tests;

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
import com.training.pom.HomePagePOM;
import com.training.pom.LoginPOM;
import com.training.pom.PropertiesPOM;
import com.training.pom.UserLoginPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RETC_053_RestoreFromTrashTests {

	private WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
	private static Properties properties;
	private ScreenShot screenShot;
	private PropertiesPOM propertiesPOM;
	private HomePagePOM homepagePOM;
	private UserLoginPOM userloginPOM;
	private boolean actualResult;
	private boolean expectedResult = true;

	@BeforeClass
	public void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
		
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		loginPOM = new LoginPOM(driver);
		propertiesPOM = new PropertiesPOM(driver);
		userloginPOM = new UserLoginPOM(driver);
		homepagePOM = new HomePagePOM(driver);
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
	public void validLoginTest() throws InterruptedException{
		loginPOM.sendUserName("admin");
		loginPOM.sendPassword("admin@123");
		loginPOM.clickLoginBtn(); 
		screenShot.captureScreenShot();
	}
	
	@Test(priority=2)
	public void changeUserRoleTest() throws InterruptedException{
		
		//Click on properties link		
		propertiesPOM.clickOnPropertiesLink();
		//Click on Trash Link
		propertiesPOM.clickOnTrashLink();
		//Click on Restore Link
		propertiesPOM.clickOnRestoreLink("test_fro");
		//Logout from Admin Profile
		loginPOM.clickOnLogOutLink();
		//Take Screen Shot
		screenShot.captureScreenShot();
	}
	
	@Test(priority=3)
	public void restorePropertyTest() throws InterruptedException{
		
		//Open the Home page in a new tab
		String url="http://realestate.hommelle.com";
		((JavascriptExecutor) driver).executeScript("window.open(arguments[0])", url);
		//Switching to the new Tab
		ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
	    driver.switchTo().window(tabs2.get(1));
		//Clicking on the Login Link
		userloginPOM.clickOnLoginLink();
		//Entering user name
		userloginPOM.sendUserName("sunil");
		//entering password
		userloginPOM.sendPassword("sunil@123");
		//Clicking on the Login Button
		userloginPOM.clickLoginBtn();
		//Clicking on the Real Estate Link
		homepagePOM.clickOnRealEstateLink();
		//Entering search item in the search box
		homepagePOM.enterSearchItem("test_fro");
		//Verify whether the search result is true
		actualResult=homepagePOM.verifySearchResult("test_fro");
		//Take Screen Shot
		screenShot.captureScreenShot();
		//Verifying Actual and Expected result
		Assert.assertEquals(actualResult, expectedResult);
	}
}
