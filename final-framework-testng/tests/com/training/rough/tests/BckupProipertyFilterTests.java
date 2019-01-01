/*Test Case ID : RETC_025
Test Case Description : TO Verify whether application allows admin to filter 
						properties details based on the search criteria
*/

package com.training.rough.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;

import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.LoginPOM;
import com.training.pom.PropertiesPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class BckupProipertyFilterTests {

	private WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
	private static Properties properties;
	private ScreenShot screenShot;
	private PropertiesPOM filterproperty;
	private String tempResult;
	private String actualResult;
	private String expectedResult = "Mar";

	@BeforeClass
	public void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
		
		//driver = DriverFactory.getDriver(DriverNames.CHROME);
		loginPOM = new LoginPOM(driver);
		filterproperty = new PropertiesPOM(driver);
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		//driver.get(baseUrl);
	}

	
	@AfterTest
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}
	
	
	/*@Test(priority=1)
	public void validLoginTest() throws InterruptedException{
		loginPOM.sendUserName("admin");
		loginPOM.sendPassword("admin@123");
		loginPOM.clickLoginBtn(); 
		screenShot.captureScreenShot();
	}*/
	
	@Test(priority=2)
	public void changeUserRoleTest() throws InterruptedException{
		
		//Click on properties link		
		filterproperty.clickOnPropertiesLink();
		Thread.sleep(1000);
		//Click on All Properties Link
		filterproperty.clickOnAllPropertiesLink();
		//Click on All Dates list box
		filterproperty.clickOnAlldatesListBox();
		//Select valid credentials in All Dates list box
		filterproperty.selectValidDate("March 2018");
		//Click on Filter button
		filterproperty.clickOnFilterBtn();
		//Storing the result in a temporary variable
		tempResult=filterproperty.actualFilterData();
		//getting the Sub String from the temporary result
		actualResult=tempResult.substring(0, 3);
		//System.out.println(actualResult);
		Assert.assertEquals(actualResult, expectedResult);
		screenShot.captureScreenShot();
	}
}
