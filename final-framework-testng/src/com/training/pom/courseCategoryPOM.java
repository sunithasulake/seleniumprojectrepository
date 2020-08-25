package com.training.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class courseCategoryPOM {
	private WebDriver driver; 
	
	public courseCategoryPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
		
	@FindBy(xpath="//button[contains(@class, 'btn btn-default')]")
	private WebElement searchBtn; 
	
	@FindBy(className="form-control")
	private WebElement courseText; 
	
	@FindBy(xpath="//div/a[@title='selenium-sunitha']/img[@class='img-responsive']")
	private WebElement courseImage; 
		
	public boolean isElementDisplayed(WebElement ele) {
		return ele.isDisplayed();
	}
	public void clickCourseCatalog(WebElement courseCatalog) {
		courseCatalog.click(); 
	}
	public void sendCourseText(String text)
	{
		this.courseText.clear();
		this.courseText.sendKeys(text);
		
	}
	
	public String getCourseText()
	{
		return this.courseText.getAttribute("value");
		
	}
	
	public void clickSearch() {
		this.searchBtn.click();
	}
	public String getCourseSearched()
	{
		String courseSearched = driver.findElement(By.xpath("//div[@class='block-title']//a")).getText();
		return  courseSearched;
		
	}
	public void clickCourseDetails() {
		this.courseImage.click();
	}
}
