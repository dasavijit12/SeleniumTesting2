/*Test Case ID : RETC_085
Test Case Description : To verify whether application allows admin to create property details 
						based on the Region created & added property details should get displayed
						 on home screen for user
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
import com.training.pom.AddPropertyPOM;
import com.training.pom.HomePagePOM;
import com.training.pom.LoginPOM;
import com.training.pom.MenuBarPOM;
import com.training.pom.PropertiesPOM;
import com.training.pom.RegionsPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;
import com.training.utility.TestUtil;

public class RETC_085_DisplayAddedPropertyTests {
	
	private WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
	private static Properties properties;
	private ScreenShot screenShot;
	private MenuBarPOM menubarPOM;
	private RegionsPOM regionsPOM;
	private PropertiesPOM propertiesPOM;
	private HomePagePOM homepagePOM;
	private AddPropertyPOM addpropertyPOM;


	@BeforeClass
	public void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
		
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		loginPOM = new LoginPOM(driver);
		menubarPOM = new MenuBarPOM(driver);
		regionsPOM = new RegionsPOM(driver);
		propertiesPOM = new PropertiesPOM(driver);
		addpropertyPOM = new AddPropertyPOM(driver);
		homepagePOM = new HomePagePOM(driver);
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
	public void addPropertyTest(String regName, String slug, String pRegion, String desc, String title, String text) throws InterruptedException{
		
			
		propertiesPOM.clickOnPropertiesLink();  			//Click on properties link
		propertiesPOM.clickOnAllRegionsLink();  			//Click on Regions Link
		regionsPOM.enterName(regName);						//Enter Valid Credentials in Name textbox
		regionsPOM.enterSlug(slug);							//Enter Valid Credentials in Slug textbox
		regionsPOM.clickOnParentRegion();					//Click on Parent Region
		regionsPOM.selectParentRegion(pRegion);				//Select Valid credentials in Parent Region list box
		regionsPOM.enterDescription(desc);					//Enter Valid Credentials in Description textbox
		regionsPOM.clickOnAddNewRegionBtn();				//Click on Add New Region button
		menubarPOM.clickOnAddNewPropertyLink();				//Click on Add New Link under Properties Menu
		addpropertyPOM.enterTitle(title);					//Enter Title
		addpropertyPOM.enterTextOnTextBox(text);			//Enter Text on the Text box
		addpropertyPOM.selectCreatedRegion(regName);		//Select the created Region
		Thread.sleep(2000);
		addpropertyPOM.clickOnPublishBtn();					//Click on Publish Button
		System.out.println("Message is Published : " + addpropertyPOM.isMsgPublished());	//Waiting for the Property to be Published 
		loginPOM.clickOnLogOutLink();						//Click on Logout Link
		homepagePOM.clickOnRealEstateLink();				//Click on Real Estate Link
		homepagePOM.enterSearchItem(title);					//Enter search text in the Search Box
		screenShot.captureScreenShot();						//Taking Screen shot
		Assert.assertTrue(homepagePOM.verifySearchResult(title));	//Verify whether able to search the added Property
	}
}
