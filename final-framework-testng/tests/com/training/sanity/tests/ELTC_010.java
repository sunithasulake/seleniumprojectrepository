package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.LoginPOM;
import com.training.pom.courseCategoryPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class ELTC_010 {
	private WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
	private static Properties properties;
	private ScreenShot screenShot;
	
	private String adminUrl; 
	private courseCategoryPOM coursecatPOM;
	
	@FindBy(linkText="Course catalog")
	private WebElement courseCatalog; 

	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
	}

	@BeforeMethod
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		loginPOM = new LoginPOM(driver); 
		coursecatPOM = new courseCategoryPOM(driver);
		baseUrl = properties.getProperty("baseURL");
		adminUrl = properties.getProperty("adminURL"); 
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
		loginPOM.sendUserName("sunithasulake");
		loginPOM.sendPassword("sunitha@123");
		loginPOM.clickLoginBtn(); 
		screenShot.captureScreenShot("First");
	}
	
	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}
	@Test
	public void verifyCourseList() throws InterruptedException {
		
		Thread.sleep(2000);
		Boolean courseCatDisp = coursecatPOM.isElementDisplayed(courseCatalog);
		Assert.assertTrue(courseCatDisp);
		System.out.println("Successfully passed!-1");
		
		Thread.sleep(2000);
		coursecatPOM.clickCourseCatalog(courseCatalog);
				
		Thread.sleep(2000);
		coursecatPOM.sendCourseText("selenium-sunitha");
		String actCourseText = coursecatPOM.getCourseText();
		Assert.assertEquals(actCourseText, "selenium-sunitha");
		System.out.println("Successfully passed!-2");
		
		Thread.sleep(2000);
		coursecatPOM.clickSearch();
		String  actCourseSearched = coursecatPOM.getCourseSearched();
		//System.out.println("Course search content is "+ actCourseSearched);
		Assert.assertEquals(actCourseSearched, "selenium-sunitha");
		System.out.println("Successfully passed!-3");
		
		Thread.sleep(2000);
		coursecatPOM.clickCourseDetails();
		
		
		
	}
	
}





