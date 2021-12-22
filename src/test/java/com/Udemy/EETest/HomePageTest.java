package com.Udemy.EETest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.Udemy.Pages.HomePage;
import com.Udemy.Pages.LoginPage;
import com.Udemy.base.Base;

public class HomePageTest extends Base {
	WebDriver driver;
LoginPage loginpage;
HomePage homepage;
public static Logger log = LogManager.getLogger(Base.class.getName());
public HomePageTest() {
	super();
}
@BeforeMethod
public void setUp() {
	driver = intialization();
	log.info("browser launched with login page url");
	loginpage = new LoginPage(driver);
	homepage= new HomePage(driver);
	driver.navigate().refresh();
	loginpage.login(prop.getProperty("username"),prop.getProperty("password"));
	log.info("Logged in");
	//loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
	
	
}
@Test
public void verifyUsernameTest() {
	Assert.assertEquals(homepage.verifyUsername(), prop.getProperty("userNameOnHomePage"));
	log.info("username verified");
}
@Test
public void verifyDashboardBackgroundTest() {
	Assert.assertEquals(homepage.verifyDashboardBackground(), prop.getProperty("background-color"));
	log.info("Background color matched");
}
@Test
public void gitDemo2() {
	System.out.println("New demoTest added ");
}

@Test
public void gitDemo3() {
	System.out.println("Another Test Added"); 
}
@AfterMethod
public void tearDown() {
	driver.quit();
	log.info("browser has been closed");
}
}
