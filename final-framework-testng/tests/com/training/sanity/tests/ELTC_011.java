package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
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

public class ELTC_011 {
	private WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
	private static Properties properties;
	private ScreenShot screenShot;
	
	private String adminUrl; 
	
	private courseCategoryPOM coursecatPOM; //Declaring  instance variable for POM file

	
		
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
		coursecatPOM = new courseCategoryPOM(driver); //instantiating course POM
		baseUrl = properties.getProperty("baseURL");
		adminUrl = properties.getProperty("adminURL"); 
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
		loginPOM.sendUserName("sunithasulake");
		loginPOM.sendPassword("selenium@123");
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
		
		Thread.sleep(200);
		loginPOM.clickEditProfile();
		
		String actTitle = "My Organization - My education - Profile";
		String getTitle = driver.getTitle();
		Assert.assertEquals(actTitle, getTitle);
		System.out.println("Successfully passed!-1");
		Thread.sleep(2000);
		
		loginPOM.editPwd("selenium@123","selenium@1234","selenium@1234");
		Thread.sleep(1000);
		loginPOM.clickSave();
		System.out.println("Successfully passed!-2");
		
		
		WebElement alertInfo = driver.findElement(By.xpath("//div[@class='alert alert-info']")); 
		System.out.println(alertInfo.getText());
		Boolean txt = coursecatPOM.isElementDisplayed(alertInfo);
		Assert.assertTrue(txt);
		System.out.println("Successfully passed!-3");
		
		
	}
}
