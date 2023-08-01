package com.sales.qa.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginAssert {

	public WebDriver driver;
	
	public LoginAssert(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText ="Expand All")
	private WebElement verificationoption;
	
	public boolean verifyhomepage() {
		
		boolean displaystatus = false;
		
		try {
			return verificationoption.isDisplayed();
		}catch(Throwable e) {
			
			displaystatus = false;
		}
		
		return displaystatus;
	}
	
	@FindBy(xpath ="//div[@id='error']")
	WebElement invalidLog;

	public String retrieveinvalidText() {
		String text = invalidLog.getText();
		return text;
	}
}
	
	