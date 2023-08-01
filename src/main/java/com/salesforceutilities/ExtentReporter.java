package com.salesforceutilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReporter {
	public static ExtentReports generateExtentReport() {
		
		ExtentReports extentreport = new ExtentReports();
		
		File extentReportFile = new File(System.getProperty("user.dir")+"\\test-output\\ExtentReports\\extentReport.html");
		ExtentSparkReporter sparkReporter = new ExtentSparkReporter(extentReportFile);
		
		sparkReporter.config().setTheme(Theme.DARK);
		sparkReporter.config().setReportName("Salesforce Testautomation testcase");
		sparkReporter.config().setDocumentTitle("Salesforce Automation Report");
		sparkReporter.config().setTimeStampFormat("dd/MM/yyyy HH:MM:SS");
		
		extentreport.attachReporter(sparkReporter);
		Properties configprop = new Properties();
		File configpropfile = new File(System.getProperty("user.dir")+"\\src\\main\\java\\com\\salesforce\\config\\Config.propertiesFile");
		
		try {
		FileInputStream Finsconfig = new FileInputStream(configpropfile);
		configprop.load(Finsconfig);
		}catch (Throwable e) {
			e.printStackTrace();
	}
		extentreport.setSystemInfo("Application URL", configprop.getProperty("Url"));
		extentreport.setSystemInfo("Operating System", System.getProperty("os.name"));
		extentreport.setSystemInfo("User Name", System.getProperty("user.name"));	
		extentreport.setSystemInfo("Java Version", System.getProperty("java.version"));
		
		return extentreport;
		
	}

}
