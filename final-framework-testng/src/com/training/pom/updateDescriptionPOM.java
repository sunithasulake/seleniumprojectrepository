package com.training.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class updateDescriptionPOM {
	private WebDriver driver; 
	
	public updateDescriptionPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[@class='btn btn-default' and @title='Edit']")
	private WebElement introduction;
	
		
	public void clickCourseLink(String coursename) {
		
	driver.findElement(By.xpath("//div[@class='col-md-10']//h4[@class='course-items-title']//a[normalize-space(text()) = '"+coursename+"']")).click();
					
	}
	
	public void editIntroduction() {
		this.introduction.click();
	}
	public boolean isDisplayed(WebElement ele) {
		return ele.isDisplayed();
	}

}
