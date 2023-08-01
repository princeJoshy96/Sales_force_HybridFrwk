package com.salesforce.qa.testcases;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.sales.qa.pageobject.LoginpageObj;
import com.sales.qa.pageobject.SettingpageObj;
import com.salesforce.qa.base.Basecase;

public class settingsTest extends Basecase{
	
	public settingsTest() {
		super();
	}
	
	public WebDriver driver;
	
	@BeforeMethod
	public void setUp() {
		
		driver=initializebrowserAppOpen(properties.getProperty("browserchrome"));
		
		LoginpageObj  loginpage =new LoginpageObj(driver);
		loginpage.Usernameclear();
		loginpage.UsernameEnter(properties.getProperty("ValidUsername"));
		loginpage.PasswordboxClear();
		loginpage.PasswordEnter(properties.getProperty("ValidPassword"));
		loginpage.rember();
		loginpage.Loginbox();
	}
	
	@AfterMethod
	public void tearDown() {
		if (driver !=null) {
			driver.quit();
		}
	}
	
	@Test
	public void settingsdropdown() throws Exception {
		
		SettingpageObj settingpage = new SettingpageObj(driver);
		settingpage.ProfileIcon();
		settingpage.Settingicon();
		Thread.sleep(6000);
		settingpage.PersonIcon();
		settingpage.Loginicon();
		String actualfile = settingpage.DownloadlinkText();
		
		
		String expectedfile =Dataprop.getProperty("downloadhistory"); 
		System.out.println(actualfile);
		Assert.assertTrue(actualfile.contains(expectedfile), "file description does not match expected file");
		driver.quit();
	}
	
	@Test
	public void disPlaylink() throws Exception {
		
		SettingpageObj settingpage = new SettingpageObj(driver);
		settingpage.ProfileIcon();
		settingpage.Settingicon();
		Thread.sleep(6000);
		settingpage.displayicon();
		settingpage.Customize();
		
		WebElement dropdown = settingpage.Dropdownicon();
		Select drop = new Select(dropdown);
		drop.selectByVisibleText("Salesforce Chatter");
		
		WebElement report = settingpage.Report();
		Actions action = new Actions(driver);
		action.moveToElement(report).perform();
		
		settingpage.Adicon();
		settingpage.Saveicon();
		
	driver.quit();
		
	}
	@Test
	public void eMailTest() throws Exception {
		
		SettingpageObj settingpage = new SettingpageObj(driver);
		settingpage.ProfileIcon();
		settingpage.Settingicon();
		Thread.sleep(6000);
		settingpage.Emaillink();
		Thread.sleep(6000);
		settingpage.Emailset();
		
		settingpage.Emailbxclear();
		settingpage.Emailname(Dataprop.getProperty("NamEmail"));
		
		settingpage.Emailboxclear();
		settingpage.EmailBox(Dataprop.getProperty("Email2"));
		
		settingpage.Popup();
		settingpage.Saveicon();
	
	
		String actualfile = driver.findElement(By.xpath("//div[contains(text(),'Your settings have been successfully saved.')]")).getText();
		String expectedfile = "Your settings have been successfully saved.";
		System.out.println(actualfile);
		Assert.assertTrue(actualfile.contains(expectedfile), "file description does not match expected file");
	
		driver.quit();
	}
	@Test
	public void caLenderTest() {
	
		driver.findElement(By.xpath("//span[@id='userNavLabel']")).click();
		driver.findElement(By.xpath("//a[contains(text(),'My Settings')]")).click();
	
		driver.findElement(By.xpath("//tbody/tr[1]/td[1]/div[1]/div[4]/div[6]/a[1]")).click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
		e.printStackTrace();
		}
		driver.findElement(By.xpath("//a[@id='Reminders_font']")).click();
	
		driver.findElement(By.xpath("//input[@id='testbtn']")).click();
		String mainWindowHandle = driver.getWindowHandle();
    
		Set<String> windowHandles = driver.getWindowHandles();

		// Switch to the popup window
		for (String windowHandle : windowHandles) {
         if (!windowHandle.equals(mainWindowHandle)) {
             driver.switchTo().window(windowHandle);
             break;
         }
     }
	 
		Assert.assertTrue(driver.findElement(By.xpath("//body/div[1]")).isDisplayed(), "New window not enabled");
	
		driver.switchTo().window(mainWindowHandle);
	 
		driver.findElement(By.xpath("//span[@id='userNavLabel']")).click();
		driver.findElement(By.linkText("Logout")).click();
	 
		driver.quit();
	}
}
	
