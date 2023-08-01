package com.salesforce.qa.base;

import java.io.File;
import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import com.salesforceutilities.Utilities;

public class Basecase {
	
	public WebDriver driver;
	
	public Properties properties;
	public Properties Dataprop;
	
	public  Basecase() {
		properties = new Properties();
		File propertiesFile = new File(System.getProperty("user.dir")+"\\src\\main\\java\\com\\salesforce\\config\\Config.propertiesFile");
		
		Dataprop = new Properties();
		File Datapropfile = new File(System.getProperty("user.dir")+"\\src\\main\\java\\com\\salesforcetestData\\TestData.properties");
		try {
			FileInputStream fis2 = new FileInputStream(Datapropfile);
			Dataprop.load(fis2);
		}catch(Throwable t) {
			t.printStackTrace();
		}
		
		try {
		FileInputStream fis = new FileInputStream(propertiesFile);
		properties.load(fis);
		}catch (Throwable e) {
			e.printStackTrace();
		}
	}
	
	public WebDriver initializebrowserAppOpen(String BrowserName) {
		
		if (BrowserName.equalsIgnoreCase("Chrome")) {
			driver = new ChromeDriver();
			
		} else if (BrowserName.equalsIgnoreCase("Firefox")) {
			driver = new FirefoxDriver();
			
		}else if (BrowserName.equalsIgnoreCase("Edge")) {
			driver = new EdgeDriver();
			
		}else if (BrowserName.equalsIgnoreCase("Safari")) {
			driver = new SafariDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Utilities.IMPLICIT_WAIT_TIME));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Utilities.PAGE_LOAD_TIME));
	
		driver.get(properties.getProperty("Url"));	

		return driver;
	}
}
