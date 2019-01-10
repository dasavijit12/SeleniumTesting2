/*Test Case ID : RETC_081
Test Case Description : To Verify whether application allows admin to Add multiple New Feature 
						in the application & added feature details get displayed in database
*/

package com.training.complex.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.training.bean.LoginBean;
import com.training.dao.ELearningDAO;
import com.training.generics.ScreenShot;
import com.training.pom.FeaturesPOM;
import com.training.pom.LoginPOM;
import com.training.pom.MenuBarPOM;
import com.training.pom.PropertiesPOM;
import com.training.pom.RegionsPOM;
import com.training.utility.CompareDBData;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;
import com.training.utility.TestUtil;

public class RETC_081_FeatureDBTests {
	
	private WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
	private static Properties properties;
	private ScreenShot screenShot;
	private MenuBarPOM menubarPOM;
	private FeaturesPOM featuresPOM;
	private ELearningDAO edao;
	private CompareDBData comparedbdata;


	@BeforeClass
	public void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
		
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		loginPOM = new LoginPOM(driver);
		menubarPOM = new MenuBarPOM(driver);
		featuresPOM = new FeaturesPOM(driver);
		edao = new ELearningDAO();
		comparedbdata = new CompareDBData();
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
	public void addFeatureDBTest(String name, String slug, String pFeature, String desc) throws InterruptedException{
		
			
		menubarPOM.clickOnPropertyMenu(); 		 		//Click on properties link
		menubarPOM.clickOnFeatureLink();  				//Click on Features Link
		featuresPOM.enterFeatureName(name);				//Enter Valid Credentials in Name textbox
		featuresPOM.enterSlug(slug);					//Enter Valid Credentials in Slug textbox
		featuresPOM.clickOnParentFeature();				//Click on Parent Region
		featuresPOM.selectParentFeature(pFeature);		//Select Valid credentials in Parent Region list box
		featuresPOM.enterDescription(desc);				//Enter Valid Credentials in Description textbox
		featuresPOM.clickOnAddNewFeatureBtn();			//Click on Add New Feature button
		Assert.assertTrue(comparedbdata.dbMatch(name, slug, pFeature, desc));	//Verifying whether the data stored in the DB
		screenShot.captureScreenShot();
	}
}
