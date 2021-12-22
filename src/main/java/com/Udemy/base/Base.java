package com.Udemy.base;

import java.io.FileInputStream;

import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;


public class Base {
	public Properties prop;
	public   WebDriver driver;
	 String path = System.getProperty("user.dir")+"/src/main/java/com/Udemy/resources/EE.properties";
	
public Base() {
	prop = new Properties();
	try {
		FileInputStream fis = new FileInputStream(path);
		prop.load(fis);
	}catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}

public   WebDriver intialization() {
	String browser  = prop.getProperty("browser");
	//String browser  = System.getProperty("browser");
	// mvn test -Dbrowser=chrome
	//this is to control browser type from cmd or from jenkins.
	if(browser.equalsIgnoreCase("chrome")) {
		System.setProperty("webdriver.chrome.driver", "E://Selenium soft//chromedriver_win32 (4)//chromedriver_win32//chromedriver.exe");
		/*ChromeOptions options = new ChromeOptions();
		options.addArguments("--headless");
		driver = new ChromeDriver(options);*/ //this is to run browser in headless mode. 
		driver = new ChromeDriver();
	}
	else if(browser.equalsIgnoreCase("Firefox")) {
		System.setProperty("webdriver.gecko.driver", "E:\\Selenium soft\\geckodriver-v0.26.0-win64\\geckodriver.exe");
		driver = new FirefoxDriver();
	}
	driver.get(prop.getProperty("Url"));
	
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	return driver;
	
}

}
