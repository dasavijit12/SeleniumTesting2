package com.training.rough.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.ChangeRolePOM;
import com.training.pom.LoginPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class VerifyAddedUserTest {

	private WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
	private static Properties properties;
	private ScreenShot screenShot;
	private ChangeRolePOM changerole;

	@BeforeClass
	public void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
		
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		loginPOM = new LoginPOM(driver);
		changerole = new ChangeRolePOM(driver);
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
	}
	
	@AfterTest
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}
	
	
	@Test(priority=1)
	public void validLoginTest() throws InterruptedException{
		loginPOM.sendUserName("admin");
		loginPOM.sendPassword("admin@123");
		loginPOM.clickLoginBtn(); 
		screenShot.captureScreenShot();
	}
	
	@Test(priority=2)
	public void verifyUserPresentTest() throws InterruptedException{
		
		//Click on Users Link
		changerole.clickOnUsersLink();
		Thread.sleep(1000);
		//Click on All User Link
		changerole.clickOnAllUsers();
		
		WebElement baseTable = driver.findElement(By.tagName("table"));
		List<WebElement> tableRows = baseTable.findElements(By.xpath
				("//tbody[@id='the-list']/tr"));
		int noOfRows = tableRows.size();
		System.out.println(noOfRows);
		boolean flag = false;
		for(int i=0; i<noOfRows; i++) {
			WebElement cellINeed = tableRows.get(i).findElement(By.xpath("//tbody[@id='the-list']/tr[" + (i+1) + "]/td[1]"));
			String data = cellINeed.getText();
			System.out.println(data);
			if(data.equals("avijit")) {
				flag = true;
				//break;
			}
		}
		
		if(flag) {
			System.out.println("Test case Passed.....");
		}
		
		
		WebElement cellIneed = baseTable.findElement(By.xpath
				("//table[@class='wp-list-table widefat fixed striped users']/tbody/tr[4]/td[1]"));
		String cellValue = cellIneed.getText();
		System.out.println(cellValue);
		
	}
}
