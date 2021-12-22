package com.Udemy.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import com.Udemy.base.Base;

public class LoginPage  {
public WebDriver driver;
	@FindBy(css ="input[id='txtUsername']")
	WebElement Username;
	@FindBy(id="txtPassword")
	WebElement Password;
	@FindBy(xpath="//div[@id='divLoginButton']/input")
	WebElement loginBtn;
	@FindBy(id="welcome")
	WebElement welcome;
	

public LoginPage(WebDriver driver) {
	this.driver = driver;
	PageFactory.initElements(driver, this);
}

public HomePage login(String uname,String pswd) {
		
		Username.sendKeys(uname);
		Password.sendKeys(pswd);
		loginBtn.click();
		
		return  new HomePage(driver);
		
	}
	public Boolean validateMsg() {
		return welcome.isDisplayed();
	}

}
