package com.training.pom;

//import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPOM {
	private WebDriver driver; 
	
	public LoginPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="login")
	private WebElement userName; 
	
	@FindBy(id="password")
	private WebElement password;
	
	@FindBy(id="form-login_submitAuth")
	private WebElement loginBtn; 
	
	@FindBy(xpath="//a[contains(text(),'Edit profile')]")
	private WebElement editProfile; 
	
	@FindBy(xpath="//div/input[contains(@id,'profile_password0')]")
	private WebElement oldPwd; 
	
	@FindBy(xpath="//div/input[contains(@id,'password1')]")
	private WebElement newPwd; 
	
	@FindBy(xpath="//div/input[contains(@id,'password2')]")
	private WebElement confNewPwd; 
	
	@FindBy(id="profile_apply_change")
	private WebElement saveBtn; 
	
	public void sendUserName(String userName) {
		this.userName.clear();
		this.userName.sendKeys(userName);
	}
	
	public void sendPassword(String password) {
		this.password.clear(); 
		this.password.sendKeys(password); 
	}
	
	public void clickLoginBtn() {
		this.loginBtn.click(); 
	}
	
	public void clickEditProfile()
	{
		this.editProfile.click();
	}
	public void editPwd(String pwd1,String pwd2,String pwd3) {
		this.oldPwd.clear(); 
		this.oldPwd.sendKeys(pwd1); 
		this.newPwd.clear(); 
		this.newPwd.sendKeys(pwd2); 
		this.confNewPwd.clear(); 
		this.confNewPwd.sendKeys(pwd3); 
	}
	public void clickSave()
	{
		this.saveBtn.click();
	}
	
	
}
