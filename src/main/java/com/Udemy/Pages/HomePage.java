package com.Udemy.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import com.Udemy.base.Base;

public class HomePage {
	public WebDriver driver;
@FindBy(xpath="//a[@id='welcome']")
WebElement userName;
	
@FindBy(id="menu_dashboard_index")
WebElement dashboard;

public HomePage(WebDriver driver) {
	this.driver= driver;
	PageFactory.initElements(driver, this);
}
public String verifyUsername() {
	return userName.getText();
}
public String verifyDashboardBackground() {
	return dashboard.getCssValue("background-color");
}
}
