package stepDefination;

import java.time.Duration;

import org.junit.runner.RunWith;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import com.Udemy.Pages.LoginPage;
import com.Udemy.base.Base;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
public class StepDefination extends Base {
	
	LoginPage loginpage;
	   @Given("^Intialize the chrome browser$")
	    public void intialize_the_chrome_browser() throws Throwable {
		   System.setProperty("webdriver.chrome.driver", "E://Selenium soft//chromedriver_win32 (4)//chromedriver_win32//chromedriver.exe");
			driver = new ChromeDriver();
			
	    }
	   @And("^Navigate to \"([^\"]*)\" site$")
	    public void navigate_to_something_site(String url) throws Throwable {
		   driver.get(url);
			
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
	    }

	    @When("^User enters (.+) and (.+) and logs in$")
	    public void user_enters_and_and_logs_in(String username, String password) throws Throwable {
	    
	    	 loginpage = new LoginPage(driver);
			driver.navigate().refresh();
			 loginpage.login(username, password);
	    }

	    @Then("^Verify whether user logged in$")
	    public void verify_whether_user_logged_in() throws Throwable {
	    	
	    	Assert.assertTrue(loginpage.validateMsg());
	       
	    }
	    @Then("^close the browser$")
	    public void close_the_browser() throws Throwable {
	        driver.close();
	    }

	   



}
