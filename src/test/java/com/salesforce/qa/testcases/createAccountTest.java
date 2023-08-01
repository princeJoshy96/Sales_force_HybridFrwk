package com.salesforce.qa.testcases;

import java.time.Duration;
import java.util.Set;
import java.awt.*;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.salesforce.qa.base.Basecase;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.Alert;

import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

@SuppressWarnings("unused")
public class createAccountTest extends Basecase {
	
	public createAccountTest() {
		super();
	}
	
	public WebDriver driver;
	
	public WebDriver wait;
	public Robot robot;
	
	@BeforeMethod
	public void setup() {
		driver=initializebrowserAppOpen(properties.getProperty("browserfire"));
		WebElement Usernamebox =driver.findElement(By.xpath("//input[@id='username']"));
		Usernamebox.clear();
		Usernamebox.sendKeys(properties.getProperty("ValidUsername"));
		
		WebElement Passwordbox = driver.findElement(By.xpath("//input[@id='password']"));
		Passwordbox.clear();
		Passwordbox.sendKeys(properties.getProperty("ValidPassword"));
		
		driver.findElement(By.xpath("//input[@id='Login']")).click();
		
	}

	
	@Test
	public void accountView() {	
		
		driver.findElement(By.xpath("//img[@title='All Tabs']")).click();
		driver.findElement(By.linkText("Accounts")).click();
		
		driver.findElement(By.xpath("//a[@id='tryLexDialogX']")).click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		driver.findElement(By.xpath("//a[contains(text(),'Create New View')]")).click();
		WebElement viewname= driver.findElement(By.xpath("//input[@id='fname']"));
		viewname.clear();
		viewname.sendKeys("joshy");
		WebElement uniqueName=driver.findElement(By.xpath("//input[@id='devname']"));
		uniqueName.clear();
		uniqueName.sendKeys("prince");
		
		driver.findElement(By.xpath("//input[@name='save']")).click();
		
		WebElement dropdown = driver.findElement(By.xpath("//select[@name='fcf']"));
		Select drop = new Select(dropdown);
		drop.selectByVisibleText("joshy");
		String actual = driver.findElement(By.xpath("//select[@name='fcf']")).getText();
		System.out.println(actual);
		String expected = "joshy";
		Assert.assertTrue(actual.contains(expected),"wrong account name");
		
	}
@Test
public void editAccountTest() {

	driver.findElement(By.xpath("//img[@title='All Tabs']")).click();
	driver.findElement(By.linkText("Accounts")).click();
	
	driver.findElement(By.xpath("//a[@id='tryLexDialogX']")).click();
	try {
		Thread.sleep(3000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	driver.findElement(By.xpath("//a[normalize-space()='Edit']")).click();
	
	WebElement viewname= driver.findElement(By.xpath("//input[@id='fname']"));
	viewname.clear();
	viewname.sendKeys("joshuwa");
	
	WebElement fieddrop = driver.findElement(By.xpath("//select[@id='fcol1']"));
	Select field = new Select(fieddrop);
	field.selectByVisibleText("Account Name");
	
	WebElement operator = driver.findElement(By.xpath("//select[@id='fop1']"));
	Select oper = new Select(operator);
	oper.selectByVisibleText("contains");
	
	driver.findElement(By.xpath("//input[@id='fval1']")).sendKeys("a");
	
	driver.findElement(By.xpath("//input[@name='save']")).click();
	
	String actual = driver.findElement(By.xpath("//span[normalize-space()='Burlington Textiles Corp of America']")).getText();
	System.out.println(actual);
	String expected = "Burlington Textiles Corp of America";
	Assert.assertTrue(actual.contains(expected),"wrong filter");
	
	}
	
@Test
public void mergeAccountTest() {

	driver.findElement(By.xpath("//img[@title='All Tabs']")).click();
	driver.findElement(By.linkText("Accounts")).click();
	
	driver.findElement(By.xpath("//a[@id='tryLexDialogX']")).click();
	try {
		Thread.sleep(3000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	driver.findElement(By.linkText("Merge Accounts")).click();
	
	WebElement viewname= driver.findElement(By.xpath("//input[@id='srch']"));
	viewname.clear();
	viewname.sendKeys("Kar");
	
	driver.findElement(By.xpath("//input[@name='srchbutton']")).click();
	try {
		Thread.sleep(1000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	driver.findElement(By.xpath("//input[@name='goNext']")).click();
	
	driver.findElement(By.xpath("//input[@name='save']")).click();
	Alert alert= driver.switchTo().alert();
	alert.accept();

	}

@Test
public void reportAccountTest() throws AWTException{
	
	driver.findElement(By.xpath("//img[@title='All Tabs']")).click();
	driver.findElement(By.linkText("Accounts")).click();
	
	driver.findElement(By.xpath("//a[@id='tryLexDialogX']")).click();
	try {
		Thread.sleep(3000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	driver.findElement(By.partialLinkText("Accounts with last a")).click();
	
	driver.findElement(By.xpath("//input[@id='ext-gen20']")).click();
	driver.findElement(By.xpath("//div[contains(text(),'Created Date')]")).click();
	try {
		Thread.sleep(3000);
	} catch (InterruptedException e) {
		e.printStackTrace();
	}
	
	WebElement startdate=driver.findElement(By.xpath("//input[@id='ext-comp-1042']"));
	startdate.clear();
	startdate.sendKeys("6/22/23");
	try {
		Thread.sleep(2000);
	} catch (InterruptedException e) {
		e.printStackTrace();
	}
	
	WebElement enddate=driver.findElement(By.xpath("//input[@name='endDate']"));
	enddate.clear();
	enddate.sendKeys("6/22/23");
	try {
		Thread.sleep(2000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[1]/div[1]/div[1]/div[1]/table[1]"
			+ "/tbody[1]/tr[1]/td[1]/table[1]/tbody[1]/tr[1]/td[1]"
			+ "/table[1]/tbody[1]/tr[2]/td[2]/em[1]/button[1]")).click();
	try {
		Thread.sleep(7000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	driver.findElement(By.xpath("//input[@name='reportName']")).sendKeys("Joshu");
	driver.findElement(By.xpath("//input[@name='reportDevName']")).sendKeys("Urch");
	
	Robot robot = new Robot();
	robot.keyPress(KeyEvent.VK_ENTER);
    robot.keyRelease(KeyEvent.VK_ENTER);
  }
@AfterMethod
public void teardown() {
		if (driver != null) {
			driver.quit();
		}
	}
}