package com.salesforce.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.salesforce.qa.base.Basecase;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Alert;
import java.util.Set;
import java.util.Iterator;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

@SuppressWarnings("unused")
public class UserdropDownTest extends Basecase {
	
	public UserdropDownTest() {
		super();
	}
	
	public WebDriver driver;
	public WebDriverWait wait;
	public Robot robot;
	
public WebDriverWait getWait() {
    return wait;
}

@BeforeMethod
public void setUp() {
	driver=initializebrowserAppOpen(properties.getProperty("browseredge"));
	WebElement Usernamebox =driver.findElement(By.xpath("//input[@id='username']"));
	Usernamebox.clear();
	Usernamebox.sendKeys(properties.getProperty("ValidUsername"));
	
	WebElement Passwordbox = driver.findElement(By.xpath("//input[@id='password']"));
	Passwordbox.clear();
	Passwordbox.sendKeys(properties.getProperty("ValidPassword"));
	
	driver.findElement(By.xpath("//input[@id='Login']")).click();
}

	@AfterMethod
	public void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}

	@Test
	public void selectUsermenu() throws  AWTException  {
		
		driver.findElement(By.xpath("//span[@id='userNavLabel']")).click();
		Assert.assertTrue(driver.findElement(By.xpath("//a[contains(text(),'My Profile')]")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//a[contains(text(),'My Settings')]")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.linkText("Logout")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//a[contains(text(),'Developer Console')]")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//tbody/tr[1]/td[3]/div[1]/div[3]/div[1]/div[1]/div[2]/div[3]/a[4]")).isDisplayed());
	}
	
	@Test
	public void postTab() throws AWTException {
		driver.findElement(By.xpath("//span[@id='userNavLabel']")).click();
		driver.findElement(By.xpath("//a[contains(text(),'My Profile')]")).click();
        
        WebElement postTextArea = driver.findElement(By.xpath("//span[normalize-space()='Post']"));
        try {
			Thread.sleep(9000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        postTextArea.click();
    	String word = "JoshuaO";
        // Copy the file path to the clipboard
        StringSelection selection = new StringSelection(word);   
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection, null);
        
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_TAB);
        robot.keyRelease(KeyEvent.VK_TAB);
        robot.keyPress(KeyEvent.VK_TAB);
        robot.keyRelease(KeyEvent.VK_TAB);
        robot.keyPress(KeyEvent.VK_TAB);
        robot.keyRelease(KeyEvent.VK_TAB);
        robot.keyPress(KeyEvent.VK_TAB);
        robot.keyRelease(KeyEvent.VK_TAB);
        robot.keyPress(KeyEvent.VK_CONTROL);   
		robot.keyPress(KeyEvent.VK_V);    
		robot.keyRelease(KeyEvent.VK_V);    
		robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_TAB);
        robot.keyRelease(KeyEvent.VK_TAB);
    	robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
	}
	
 @Test
 public void uploadFile()throws InterruptedException, AWTException  {		
				
	 driver.findElement(By.xpath("//span[@id='userNavLabel']")).click();
				
	 driver.findElement(By.xpath("//a[contains(text(),'My Profile')]")).click();
		
	 WebElement fileLink = driver.findElement(By.xpath("//tbody/tr[1]/td[1]/div[1]/div[3]/div[1]/div[1]"  
			 + "/div[1]/div[1]/div[2]/ul[1]/li[1]/div[1]/div[1]/div[1]/ul[1]/li[2]/a[1]/span[1]"));
			
	 try {	
		 Thread.sleep(3000);
		} catch (InterruptedException e) { 
			e.printStackTrace();	
		}
	 
	 fileLink.click();
		try {
				
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} 
		
		driver.findElement(By.xpath("//a[@id='chatterUploadFileAction']")).click();    
		String filePath = "C:\\Users\\Joshua.Onyena\\Downloads\\personal docum\\The Cucumber for Java Book.pdf";
		        // Copy the file path to the clipboard
		        
		StringSelection selection = new StringSelection(filePath);   
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection, null);

		        // Simulate key events: CTRL+V (paste the file path)
		       
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);   
		robot.keyPress(KeyEvent.VK_V);    
		robot.keyRelease(KeyEvent.VK_V);    
		robot.keyRelease(KeyEvent.VK_CONTROL);
		        
		// Simulate key event: ENTER (confirm the file selection)   
		robot.keyPress(KeyEvent.VK_ENTER);  
		robot.keyRelease(KeyEvent.VK_ENTER);	
			
 }
//	
	 @Test
	 public void uploadImage() throws InterruptedException, AWTException {
		
		 driver.findElement(By.xpath("//span[@id='userNavLabel']")).click();
	
		driver.findElement(By.xpath("//a[contains(text(),'My Profile')]")).click();
		WebElement photo = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[2]/table[1]"
				+ "/tbody[1]/tr[1]/td[1]/div[1]/div[2]/li[1]/div[1]/div[1]/a[1]"));
		try {
			Thread.sleep(9000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	        photo.click();
	        try {
				Thread.sleep(6000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        String filePath = "C:\\Users\\Joshua.Onyena\\Downloads\\personal docum\\Market700\\3.jpeg";
	        // Copy the file path to the clipboard
	        
	StringSelection selection = new StringSelection(filePath);   
	Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection, null);

	        // Simulate key events: CTRL+V (paste the file path)
	       
	Robot robot = new Robot();
	robot.keyPress(KeyEvent.VK_CONTROL);   
	robot.keyPress(KeyEvent.VK_V);    
	robot.keyRelease(KeyEvent.VK_V);    
	robot.keyRelease(KeyEvent.VK_CONTROL);
	        
	// Simulate key event: ENTER (confirm the file selection)   
	robot.keyPress(KeyEvent.VK_ENTER);  
	robot.keyRelease(KeyEvent.VK_ENTER);
	}    
}
