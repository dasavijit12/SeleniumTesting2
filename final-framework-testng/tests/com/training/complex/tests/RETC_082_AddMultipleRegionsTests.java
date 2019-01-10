/*Test Case ID : RETC_082
Test Case Description : To Verify whether application allows 
						admin to Add Multiple Region in the application
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
import com.training.pom.LoginPOM;
import com.training.pom.MenuBarPOM;
import com.training.pom.PropertiesPOM;
import com.training.pom.RegionsPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;
import com.training.utility.TestUtil;

public class RETC_082_AddMultipleRegionsTests {
	
	private WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
	private static Properties properties;
	private ScreenShot screenShot;
	private RegionsPOM regionsPOM;
	private PropertiesPOM propertiesPOM;
	private MenuBarPOM menubarPOM;


	@BeforeClass
	public void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
		
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		loginPOM = new LoginPOM(driver);
		regionsPOM = new RegionsPOM(driver);
		propertiesPOM = new PropertiesPOM(driver);
		menubarPOM = new MenuBarPOM(driver);
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
	public void validLoginTest() throws InterruptedException{
		loginPOM.sendUserName("admin");
		loginPOM.sendPassword("admin@123");
		loginPOM.clickLoginBtn(); 
		//loginPOM.clickOnLogOutLink();
		screenShot.captureScreenShot();
	}
	
	@Test(priority=2,dataProviderClass=TestUtil.class,dataProvider="dp")
	public void addRegionsTest(String name, String slug, String pRegion, String desc) throws InterruptedException{
		
			
		menubarPOM.clickOnPropertyMenu();  				//Click on properties link
		menubarPOM.clickOnRegionsLink();  				//Click on Regions Link
		regionsPOM.enterName(name);						//Enter Valid Credentials in Name textbox
		regionsPOM.enterSlug(slug);						//Enter Valid Credentials in Slug textbox
		regionsPOM.clickOnParentRegion();				//Click on Parent Region
		regionsPOM.selectParentRegion(pRegion);			//Select Valid credentials in Parent Region list box
		regionsPOM.enterDescription(desc);				//Enter Valid Credentials in Description textbox
		regionsPOM.clickOnAddNewRegionBtn();			//Click on Add New Region button
		regionsPOM.enterSearchItem(name.trim());		//Enter search Item in the search text box
		regionsPOM.clickOnSearchRegionBtn();			//Click on the Search Region Button
		Assert.assertTrue(regionsPOM.searchForAddedRegion(name.trim()));	//Verifying whether the Region is added or not
		screenShot.captureScreenShot();
	}
}
