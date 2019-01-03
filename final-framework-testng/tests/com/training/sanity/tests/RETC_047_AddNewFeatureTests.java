/*Test Case ID : RETC_047
Test Case Description : To verify whether application allows admin to add 
						new Feature while adding new property
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
import com.training.pom.AddPropertyPOM;
import com.training.pom.LoginPOM;
import com.training.pom.PropertiesPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RETC_047_AddNewFeatureTests {

	private WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
	private static Properties properties;
	private ScreenShot screenShot;
	private PropertiesPOM propertiesPOM;
	private AddPropertyPOM addpropertyPOM;
	private String tempResult;
	private String actualResult;
	private String expectedResult = "Post published.";

	@BeforeClass
	public void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
		
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		loginPOM = new LoginPOM(driver);
		propertiesPOM = new PropertiesPOM(driver);
		addpropertyPOM = new AddPropertyPOM(driver);
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
		//Click on Add new Feature link in Feature section
		addpropertyPOM.clickOnAddNewFeatureLink();
		//Enter valid details in Textbox
		addpropertyPOM.enterDataOnFeatureTextBox("best4");
		//Select valid details in Parent Feature list box
		addpropertyPOM.selectParentFeature("interior");
		//Click on Add New Feature Button
		addpropertyPOM.clickOnAddNewFeatureBtn();
		//Enter valid credentials in Enter Title Here textbox
		addpropertyPOM.enterTitle("prestige");
		//Enter valid credentials in textbox
		addpropertyPOM.enterTextOnTextBox("home town");
		//Click on checkbox beside created feature
		addpropertyPOM.selectCreatedFeature("best4");
		//Thread.sleep(2000);
		//Click on Publish button
		addpropertyPOM.clickOnPublishBtn();
		//Storing the publish message temporarily
		tempResult = addpropertyPOM.getPublishedMsg().trim();
		//Getting the substring from the tempResult and storing it as actualResult
		actualResult = tempResult.substring(0, 15);
		screenShot.captureScreenShot();
		Assert.assertEquals(actualResult, expectedResult);
	}
}
