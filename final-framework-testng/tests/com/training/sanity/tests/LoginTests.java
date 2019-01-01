package com.training.sanity.tests;

import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.training.generics.ScreenShot;
import com.training.pom.LoginPOM;

public class LoginTests extends ConfigFile {

	@BeforeClass
	public void setUpBeforeClass() throws IOException {
		
		loginPOM = new LoginPOM(driver);
		screenShot = new ScreenShot(driver);
	}
	
	@Test
	public void validLoginTest() throws InterruptedException{
		loginPOM.sendUserName("admin");
		loginPOM.sendPassword("admin@123");
		loginPOM.clickLoginBtn(); 
		screenShot.captureScreenShot();
	
	}
}
