package com.training.rough.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.LoginPOM;
import com.training.pom.LoginPOMRashmita;
import com.training.pom.TestPOMRashmita;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RashmitaTests {
	//To verify whether the application allows the student to take the authored test 
			private WebDriver driver;
			private String baseUrl = "http://elearning.hommelle.com";
			private LoginPOMRashmita loginPOM;
			private TestPOMRashmita testPOM;
			private static Properties properties;
			private ScreenShot screenShot;
			private  JavascriptExecutor js;

			@BeforeClass
			public void setUpBeforeClass() throws IOException {
				//subscribes selected course
				properties = new Properties();
				FileInputStream inStream = new FileInputStream("./resources/others.properties");
				properties.load(inStream);



				driver = DriverFactory.getDriver(DriverNames.CHROME);
				js = (JavascriptExecutor) driver;
				loginPOM = new LoginPOMRashmita(driver); 
				testPOM = new TestPOMRashmita(driver);
				/*Actions action =new Actions(driver);*/
				//baseUrl = properties.getProperty("baseURL");
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
			public void subscribeTest() throws InterruptedException {
				loginPOM.sendUserName("manzoor");
				loginPOM.sendPassword("mehadi");
				loginPOM.clickLoginBtn(); 
				screenShot.captureScreenShot("first");
				testPOM.clickMycourseslink();
				System.out.println("coursebtn");

				testPOM.clickLearnseleniumlink();
				System.out.println("lernseleniumlink");
				Thread.sleep(2000);
		        testPOM.clickOntesticon();
		        Thread.sleep(2000);
		        System.out.println("testicon");
		        Thread.sleep(2000);
		        testPOM.clickOntestnamelink();
		        Thread.sleep(2000);
		        testPOM.clickOnstarttestbtn();
		        Thread.sleep(2000);
		        testPOM.writeAnswer("selenium is a web automation tool");
		        Thread.sleep(2000);
		        testPOM.clickEndtestbtn();
		        Thread.sleep(2000);


				screenShot.captureScreenShot("Eighth");
			}


} 
