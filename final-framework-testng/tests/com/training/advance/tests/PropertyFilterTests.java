/*Test Case ID : RETC_025
Test Case Description : TO Verify whether application allows admin to filter 
						properties details based on the search criteria
*/

package com.training.advance.tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.training.generics.ScreenShot;
import com.training.pom.PropertiesPOM;

public class PropertyFilterTests extends ConfigFile {

	private String tempResult;
	private String actualResult;
	private String expectedResult = "Mar";

	@BeforeTest(alwaysRun=true)
	public void setUpBeforeClass() throws IOException {
		
		filterproperty = new PropertiesPOM(driver);
		screenShot = new ScreenShot(driver);
	}

	
	@Test(groups = { "propertyfilter" })
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
