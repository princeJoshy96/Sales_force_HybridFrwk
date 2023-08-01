package com.sales.qa.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SettingpageObj {
	WebDriver driver ;
	
	@FindBy(xpath ="//span[@id='userNavLabel']")
		private WebElement profileicon; 
	
	@FindBy(xpath ="//a[@title='My Settings']")
		private WebElement settingsicon;
	
	@FindBy(xpath ="//span[@id='PersonalInfo_font']")
		private WebElement personalicon;
	
	@FindBy(xpath ="//span[@id='LoginHistory_font']")
		private WebElement loginhistorylink;
	
	@FindBy(partialLinkText ="Download login histo")
		private WebElement Download;
	
	@FindBy(xpath = "//span[@id='DisplayAndLayout_font']")
		private WebElement Displayicon;
	
	@FindBy(xpath = "//span[@id='CustomizeTabs_font']")
		private WebElement CustomizeLink;
	
	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[2]/table[1]/tbody[1]"
			+ "/tr[1]/td[2]/form[1]/div[1]/div[2]/div[2]/table[1]/tbody[1]/tr[2]/td[1]/select[1]")
		private WebElement Dropdown;
	
	@FindBy(xpath = "//option[contains(text(),'Reports')]")
		private WebElement Reports;
	
	@FindBy(xpath = "//div[contains(text(),'Add')]")
		private WebElement Addicon;
	
	@FindBy(xpath = "//input[@name='save']")
		private WebElement Saveicon;
	
	@FindBy(xpath = "//tbody/tr[1]/td[1]/div[1]/div[4]/div[4]/a[1]")
		private WebElement Emailicon;
	
	@FindBy(xpath = "//a[@id='EmailSettings_font']")
		private WebElement Emailsettings;
	
	@FindBy(xpath = "//input[@id='sender_name']")
	private WebElement Emailboxname;
	
	@FindBy(xpath = "//input[@id='sender_email']")
	private WebElement Emailbx;
	
	@FindBy(xpath = "//input[@name='auto_bcc']")
	private WebElement pop;
	
	@FindBy(xpath = "//input[@name='save']")
	private WebElement saveicon;
	
	
	public SettingpageObj(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//Actions
	public void ProfileIcon() {
		profileicon.click();
	}
	
	public void PersonIcon() {
		personalicon.click();
	}
	
	public void Settingicon() {
		settingsicon.click();
	}
	
	public void Loginicon() {
		loginhistorylink.click();
	}
	
	public String DownloadlinkText() {
		String text = Download.getText();
		return text;
	}
	
	public void displayicon() {
		Displayicon.click();
	}
	
	public void Customize() {
		CustomizeLink.click();
	}
	
	public WebElement Dropdownicon() {
		Dropdown.click();
		return Dropdown;
	}
	
	public WebElement Report() {
		Reports.click();
		return Reports;
	}
	
	public void Adicon() {
		Addicon.click();
	}
	
	public void Saveicon() {
		Saveicon.click();
	}
	
	public void Emaillink() {
		Emailicon.click();
	}
	
	public void Emailset() {
		Emailsettings.click();
	}
	
	public void Emailbxclear() {
		Emailboxname.clear();
	}
	public void Emailname(String name) {
		Emailboxname.sendKeys(name);
	}
	public void Emailboxclear() {
		Emailbx.clear();
	}
	public void EmailBox(String name) {
		Emailbx.sendKeys(name);
  }
	public void Popup() {
		pop.click();
	}
	public void Savicon() {
		saveicon.click();
	}
}