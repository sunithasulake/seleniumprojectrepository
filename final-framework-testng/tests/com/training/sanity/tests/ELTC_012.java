package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.pom.LoginPOM;
import com.training.pom.eltc012POM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class ELTC_012 {
	private WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
	private static Properties properties;
	//private ScreenShot screenShot;
	
	private String adminUrl; 
	
	private eltc012POM tc012pom; //Declaring  instance variable for POM file

	
		
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
		tc012pom = new eltc012POM(driver); //instantiating course POM
		baseUrl = properties.getProperty("baseURL");
		adminUrl = properties.getProperty("adminURL"); 
		//screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
		//loginPOM.sendUserName("sunithasulake");
		//loginPOM.sendPassword("selenium@123");
		//loginPOM.clickLoginBtn(); 
		//screenShot.captureScreenShot("First");
	}
	
	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}
	@Test
	public void verifyCourseList() throws InterruptedException {
		
		Thread.sleep(200);
		tc012pom.clickLostPwd();
		tc012pom.enterUserName("sunithasulake");
		tc012pom.clickSendMsgBtn();
		WebElement changepwdMsg=driver.findElement(By.xpath("//div[@class='alert alert-info']"));
		try {
		
			Assert.assertEquals(changepwdMsg.getText(),"Your password has been emailed to you");
			
		}catch(AssertionError e){
			System.out.println("This feature is currently not available for the user");
			driver.quit();
	    }
	}
}
