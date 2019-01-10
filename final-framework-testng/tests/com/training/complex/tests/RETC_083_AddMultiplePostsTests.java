/*Test Case ID : RETC_083
Test Case Description : TO verify whether application allows admin to add 
						multiple post based on the created category
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
import com.training.pom.AddNewPostPOM;
import com.training.pom.CategoriesPOM;
import com.training.pom.LoginPOM;
import com.training.pom.MenuBarPOM;
import com.training.pom.PropertiesPOM;
import com.training.pom.RegionsPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;
import com.training.utility.TestUtil;

public class RETC_083_AddMultiplePostsTests {
	
	private WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
	private static Properties properties;
	private ScreenShot screenShot;
	private CategoriesPOM categoriesPOM;
	private AddNewPostPOM addnewpostPOM;
	private MenuBarPOM menubarPOM;
	private String actualResult;
	private String expectedResult = "Post published.";


	@BeforeClass
	public void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
		
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		loginPOM = new LoginPOM(driver);
		menubarPOM = new MenuBarPOM(driver);
		categoriesPOM = new CategoriesPOM(driver);
		addnewpostPOM = new AddNewPostPOM(driver);
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
	public void addPostsTest(String catgName, String slug, String pCatg, String desc, String title, String body, String catg) throws InterruptedException{
		
		
		menubarPOM.clickOnPostsLink();						//Mouse Hover on the Posts Menu
		menubarPOM.clickOnCategoriesLink();					//Click on Categories Link
		categoriesPOM.enterCategoryName(catgName);			//Enter Valid Credentials in Name textbox for Category
		categoriesPOM.enterSlug(slug);						//Enter Valid Credentials in Slug textbox
		categoriesPOM.clickOnParentCategory();				//Click on Parent Category
		categoriesPOM.selectParentCategory(pCatg);			//Select Valid credentials in Parent Category list box
		categoriesPOM.enterDescription(desc);				//Enter Valid Credentials in Description textbox
		categoriesPOM.clickOnAddNewCategoryBtn();			//Click on Add New Region button
		menubarPOM.clickOnAddNewPostLink();					//Click on Add New Link under Posts Menu
		//categoriesPOM.clickOnAddNewPostBtn();				//Click on Add New Post Button
		addnewpostPOM.enterTitle(title);					//Enter Valid credentials in Enter title here textbox
		addnewpostPOM.enterParagraph(body); 				//Enter valid credentials in body textbox
		addnewpostPOM.selectCreatedCategory(catg); 			//Click on Checkbox beside created category name of category section
		Thread.sleep(2000);									//Putting the Thread as it is not working after adding Explicit wait as well
		addnewpostPOM.clickOnPublishBtn();					//Clicking on the Publish Button
		actualResult = addnewpostPOM.getPublishMsg();		//Getting the message after post publish
		Assert.assertEquals(actualResult, expectedResult);	//Verifying whether the post published successfully
		screenShot.captureScreenShot();
	}
}
