package com.training.advance.tests;

import org.testng.annotations.BeforeSuite;

import com.training.generics.ScreenShot;
import com.training.pom.LoginPOM;
import com.training.pom.PropertiesPOM;
import com.training.pom.TagsPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterGroups;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeGroups;

public class ConfigFile {
	
	public static WebDriver driver;
	private String baseUrl;
	private static Properties properties;
	public ScreenShot screenShot;
	public LoginPOM loginPOM;
	public PropertiesPOM filterproperty;
	public TagsPOM tagsPOM;
  
  @BeforeGroups(alwaysRun=true)
  public void setUpBeforeSuite() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
		
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		baseUrl = properties.getProperty("baseURL");
		// open the browser 
		driver.get(baseUrl);
	}

  @AfterGroups(alwaysRun=true)
  public void tearDownAfterSuite() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}

}
