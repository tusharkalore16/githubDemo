package com.Udemy.util;

import java.io.File;
import java.io.FileInputStream;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Utility1 {
	 static XSSFWorkbook book;
	 static XSSFSheet sheet;
	 static String sheetpath = System.getProperty("user.dir") + "/src/main/java/com/Udemy/resources/credentials.xlsx";
	 static FileInputStream fis;
	 static String reportPath = System.getProperty("user.dir")+"\\reports\\index.html";
     static ExtentReports reports;
	public static Object[][] getData(String sheetName) {
		FileInputStream fis;
		try {
			fis = new FileInputStream(sheetpath);
			book = new XSSFWorkbook(fis);
		} catch (IOException e) {

			e.printStackTrace();
		}
		sheet = book.getSheet(sheetName);
		int lastRow = sheet.getLastRowNum();
		int lastColumn = sheet.getRow(0).getLastCellNum();
		Object[][] data = new Object[lastRow][lastColumn];
		for (int i = 0; i < lastRow; i++) {
			for (int j = 0; j < lastColumn; j++) {
				data[i][j] = sheet.getRow(i + 1).getCell(j).toString();
			}
		}
		return data;
	}
	public static String getScreenshot(String testName,WebDriver driver) {
	File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	String destinationPath = System.getProperty("user.dir")+"\\reports\\"+testName+".png";
	try {
		FileHandler.copy(src, new File(destinationPath));
	} catch (IOException e) {
		
		e.printStackTrace();
	}
	return destinationPath;
	}
	public static ExtentReports getReportObject() {
		ExtentSparkReporter reporter =  new ExtentSparkReporter(reportPath);
		reporter.config().setDocumentTitle("EEReport");
		reporter.config().setReportName("ReportByTushar");
		reports = new ExtentReports();
		reports.attachReporter(reporter);
		reports.setSystemInfo("Tester", "TusharK");
		return reports;
	}
}
