package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class eltc012POM {
private WebDriver driver; 
	
	public eltc012POM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//ul[@class='nav nav-pills nav-stacked']//li[2]")
	private WebElement pwd;
	
	@FindBy(id="lost_password_user")
	private WebElement usertxtbox; 
	
	@FindBy(id="lost_password_submit")
	private WebElement sendmessagebtn; 
	
	public void clickLostPwd() {
		this.pwd.click();
	}
	
	public void enterUserName(String uname) {
		this.usertxtbox.sendKeys(uname);
	}
	
	public void clickSendMsgBtn() {
		this.sendmessagebtn.click();
	}

}
