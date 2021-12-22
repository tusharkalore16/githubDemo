package com.Udemy.EETest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.Udemy.Pages.HomePage;
import com.Udemy.Pages.LoginPage;
import com.Udemy.base.Base;
import com.Udemy.util.Utility1;

public class LoginPageTest extends Base{
	WebDriver driver;
	LoginPage loginpage;
	HomePage homepage;
	public static Logger log = LogManager.getLogger(Base.class.getName());
	
	public LoginPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		driver = intialization();
		log.info("browser launched with login page url");
		loginpage = new LoginPage(driver);
		
		driver.navigate().refresh();
		
		
}
	
	@DataProvider(name="dataprovider")
	public Object[][] getTestData(){
		return Utility1.getData("Sheet1");
	} 
	
	
	@Test
	(dataProvider="dataprovider")
	public void loginTest(String username,String password ) {
		
		
			 loginpage.login(username, password);
			 log.info("signed in successfully");
			Assert.assertTrue(loginpage.validateMsg());
			log.info("login name verified successfully");
			
		}
	
	
	@AfterMethod
	public void teaerDown() {
		driver.quit();
	}
}