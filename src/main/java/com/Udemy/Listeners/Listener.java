package com.Udemy.Listeners;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.Udemy.base.Base;
import com.Udemy.util.Utility1;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class Listener extends Base implements ITestListener {
	 ExtentReports extent = Utility1.getReportObject();
	ExtentTest test;
	ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();
	public void onTestStart(ITestResult result) {
		test = extent.createTest(result.getMethod().getMethodName());
		extentTest.set(test);
		
	}

	public void onTestSuccess(ITestResult result) {
		extentTest.get().log(Status.PASS, "Test passed");
		
	}

	public void onTestFailure(ITestResult result) {
		extentTest.get().fail(result.getThrowable());
		extentTest.get().log(Status.FAIL, "Test failed");
		String testName = result.getMethod().getMethodName();
		WebDriver driver = null;
		try {
			driver = (WebDriver) result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
		} 
		 catch (Exception e1) {
			
			e1.printStackTrace();
		}
		try {
			test.addScreenCaptureFromPath(Utility1.getScreenshot(testName, driver), testName);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	public void onFinish(ITestContext context) {
		extent.flush();
		
	}

}
