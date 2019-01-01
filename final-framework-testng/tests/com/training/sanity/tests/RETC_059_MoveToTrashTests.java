/*Test Case ID : RETC_059
Test Case Description : To verify whether application allows admin to add 
						property details into trash & display the same
*/

package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;

import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.AddPropertyPOM;
import com.training.pom.LoginPOM;
import com.training.pom.PropertiesPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RETC_059_MoveToTrashTests {

	private WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
	private static Properties properties;
	private ScreenShot screenShot;
	private PropertiesPOM propertiesPOM;
	private AddPropertyPOM addpropertyPOM;
	private JavascriptExecutor je;
	private boolean actualResult;
	private boolean expectedResult = true;
	private String propertyTitle = "Brigade1";

	@BeforeClass
	public void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
		
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		loginPOM = new LoginPOM(driver);
		propertiesPOM = new PropertiesPOM(driver);
		addpropertyPOM = new AddPropertyPOM(driver);
		je = (JavascriptExecutor) driver;
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
		//Click on Add New Button
		propertiesPOM.clickOnAddNewBtn();
		//Enter valid credentials in Enter Title Here textbox
		addpropertyPOM.enterTitle(propertyTitle);
		//Enter valid credentials in textbox
		addpropertyPOM.enterTextOnTextBox("Gateway1");
		//Click on checkbox beside created feature
		addpropertyPOM.selectCreatedFeature("best1");
		//Scrolling down
		je.executeScript("window.scrollBy(0,400)");
		//Click on checkbox beside created feature
		addpropertyPOM.selectCreatedRegion("North Bangalore");
		//Scrolling up again
		je.executeScript("window.scrollBy(0,-400)");
		//Click on Move to Trash Link
		addpropertyPOM.clickOnMoveToTrashLink();
		//Accepting the alert
		addpropertyPOM.acceptAlert();
		//Click on Trash Link
		propertiesPOM.clickOnTrashLink();
		//Fetching the actual result ---- Whether the property is getting displayed in Trash
		actualResult = propertiesPOM.isPropertyRestored(propertyTitle);
		screenShot.captureScreenShot();
		Assert.assertEquals(actualResult, expectedResult);
	}
}
