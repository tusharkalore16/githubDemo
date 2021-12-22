package stepDefination;

import java.time.Duration;

import org.junit.runner.RunWith;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import com.Udemy.Pages.HomePage;
import com.Udemy.Pages.LoginPage;
import com.Udemy.base.Base;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
public class StepDefinationHome extends Base {
	LoginPage loginpage;
	HomePage homepage;
	   @Given("^user on  login page with url \"([^\"]*)\"$")
	    public void user_on_login_page_with_url(String url) throws Throwable {
		   System.setProperty("webdriver.chrome.driver", "E://Selenium soft//chromedriver_win32 (4)//chromedriver_win32//chromedriver.exe");
			driver = new ChromeDriver();
			 driver.get(url);
			 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
				driver.manage().window().maximize();
				driver.manage().deleteAllCookies();
	    }
	   

	   @Given("^user logged in with  (.+) and  (.+)$")
	    public void user_logged_in_with_and(String username, String password) throws Throwable {
		   loginpage= new LoginPage(driver);
		   driver.navigate().refresh();
		   loginpage.login(username,password);
	    }
		   
	   



	   
	
	  
	   @Then("^verify dashboard background color$")
	    public void verify_dashboard_background_color() throws Throwable {
		   homepage = new HomePage(driver);
			Assert.assertEquals(homepage.verifyDashboardBackground(),"rgba(242, 140, 56, 1)");
	    }

	    @Then("^Verify username as \"([^\"]*)\" on login page$")
	    public void verify_username_on_login_page(String username) throws Throwable {
	    	Assert.assertEquals(homepage.verifyUsername(),username );
	       
	    }
	    @Then("^quit the browser$")
	    public void quit_the_browser() throws Throwable {
	       driver.close();
	    }

	 
	
	   

}
