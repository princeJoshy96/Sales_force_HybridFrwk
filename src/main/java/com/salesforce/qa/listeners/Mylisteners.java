package com.salesforce.qa.listeners;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.salesforceutilities.ExtentReporter;
import com.salesforceutilities.Utilities;

public class Mylisteners implements ITestListener{
	
	ExtentReports extentReport;
	ExtentTest extentest;
	String testname;
		
	@Override
	public void onStart(ITestContext context) {
		
		extentReport=ExtentReporter.generateExtentReport();
	}
	
	@Override
	public void onTestStart(ITestResult result) {
		testname = result.getName();
		extentest = extentReport.createTest(testname); // Assign the created test to extentest
		extentest.log(Status.INFO, testname + " Testcase started executing at " + result.getStartMillis() + " ended at " + result.getEndMillis());
		}

	@Override
	public void onTestSuccess(ITestResult result) {
		extentest.log(Status.PASS,testname +" Testcase Was Successfully executed at " + result.getStartMillis() +" ended at "+ result.getEndMillis());

	}

	@Override
	public void onTestFailure(ITestResult result) {
		extentest.log(null, testname);
		System.out.println("Screenshots taken: " + result.getName());
		WebDriver driver = null;
		try {
		driver=(WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
		}catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e) {
			e.printStackTrace();
		}
		
		String destinationscreenshotpath= Utilities.captureScreenshot(driver, result.getName());
		extentest.addScreenCaptureFromPath(destinationscreenshotpath);
		extentest.log(Status.INFO,result.getThrowable());
		extentest.log(Status.FAIL,testname + " Testcase failed to execute at "+ result.getStartMillis() +" ended at" + result.getEndMillis());
	}

	@Override
	public void onTestSkipped(ITestResult result) {
	
		extentest.log(Status.INFO,result.getThrowable());
		extentest.log(Status.SKIP,testname + " Testcase got skipped at " + result.getStartMillis() +" ended at" + result.getEndMillis());
		System.out.println();
	}

	@Override
	public void onFinish(ITestContext context) {
		
		String pathofExtentReport = System.getProperty("user.dir")+"\\test-output\\ExtentReports\\extentReport.html";
		File extentrport = new File(pathofExtentReport);
		try {
			Desktop.getDesktop().browse(extentrport.toURI());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		extentReport.flush();
	}

}
