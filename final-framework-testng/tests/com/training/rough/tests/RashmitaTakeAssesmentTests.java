package com.training.rough.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.LoginPOMRashmita;
import com.training.pom.TakeAssessmentPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RashmitaTakeAssesmentTests {
	private WebDriver driver;
	private String baseUrl;
	private LoginPOMRashmita loginPOM;
	private TakeAssessmentPOM takeassessmentPOM;
	private static Properties properties;
	private ScreenShot screenShot;


	@BeforeClass
	public void setUpBeforeClass() throws IOException {
		//subscribes selected course
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);



		driver = DriverFactory.getDriver(DriverNames.CHROME);

		loginPOM = new LoginPOMRashmita(driver); 
		takeassessmentPOM = new TakeAssessmentPOM(driver);
		Actions action =new Actions(driver);
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
	}



	/*@AfterTest
	public void close() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}*/

	@Test
	public void assessmentTest() throws InterruptedException {
		loginPOM.sendUserName("manzoor");
		loginPOM.sendPassword("mehadi");
		loginPOM.clickLoginBtn(); 
		screenShot.captureScreenShot("first");
		takeassessmentPOM.clickLearnselenium1link1();
		System.out.println("coursebtn");
		Thread.sleep(2000);

		Thread.sleep(5000);
		takeassessmentPOM.clickAssessmenticon();
		System.out.println("lernseleniumlink");
		Thread.sleep(5000);
		takeassessmentPOM.clickOntest1link();
        Thread.sleep(2000);
        System.out.println("testicon");
        Thread.sleep(2000);
        takeassessmentPOM.clickOnstarttest1btn();
        Thread.sleep(2000);
        takeassessmentPOM.writeAnswer1("selenium is a web automation tool");
        Thread.sleep(2000);

        takeassessmentPOM.clickEndtestbtn1();
        Thread.sleep(2000);


		screenShot.captureScreenShot("ninth");
	}
}
