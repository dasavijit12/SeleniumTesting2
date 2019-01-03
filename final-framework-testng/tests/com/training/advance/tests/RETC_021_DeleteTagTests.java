/*
   Test Case ID: RETC_021
   Test Case Name:To verify whether application allows admin to delete tag from the tag page
*/

package com.training.advance.tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.TagsPOM;

public class RETC_021_DeleteTagTests extends ConfigFile {

	private String actualResult;
	private String expectedResult = "Tags deleted.";

	@BeforeTest(alwaysRun=true)
	public void setUpBeforeClass() throws IOException {
		
		tagsPOM = new TagsPOM(driver);
		screenShot = new ScreenShot(driver); 
	}
	
	
	@Test(groups = { "deletetag" })
	public void deleteTagsTest() throws InterruptedException{
		
		//Click on Posts link
		tagsPOM.clickOnPostsLink();
		//Click on Tags link
		tagsPOM.clickOnTagsLink();
		//Click on the checkbox of the tag to be deleted
		tagsPOM.clickOnTagToBeDeleted();
		//Click Delete option
		tagsPOM.clickDeleteActions();
		//Click on Apply Button
		tagsPOM.clickOnApplyBtn();
		actualResult = tagsPOM.confirmationMsg();
		Assert.assertEquals(actualResult, expectedResult);
		screenShot.captureScreenShot();
	}
}
