package com.sales.qa.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginpageObj {
	public WebDriver driver;
	
	@FindBy(xpath="//input[@id='username']")
	private WebElement Usernamebox;
	
	@FindBy(xpath="//input[@id='password']")
	private WebElement PasswordBox;
	
	@FindBy(xpath = "//input[@id='Login']")
	private WebElement LoginBox;
	
	@FindBy(linkText ="Expand All")
	private WebElement Expand;
	
	@FindBy(xpath ="//span[@id='userNavLabel']")
	private WebElement profile;
	
	@FindBy(linkText ="Logout")
	private WebElement logoutlink;
	
	@FindBy(xpath ="//img[@id='logo']")
	private WebElement Image;
	
	@FindBy(xpath ="//input[@id='username']")
	private WebElement actualUsername;
	
	@FindBy(xpath ="//input[@id='rememberUn']")
	private WebElement rember;
	
	
	
	@FindBy(xpath ="//a[@id='forgot_password_link']")
	private WebElement forgetPassword;
	
	@FindBy(xpath ="//input[@id='un']")
	private WebElement emailbox;
	
	@FindBy(xpath ="//input[@id='continue']")
	private WebElement continuebox;
	
	@FindBy(xpath ="//h1[@id ='header']")
	private WebElement Header;
	
	@FindBy(xpath ="//div[@id='error']")
	private WebElement ErrorHeader;
	
	public LoginpageObj(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//Actions
	public void Usernameclear(){
		Usernamebox.clear();
	}
	public void UsernameEnter(String Username){
		Usernamebox.sendKeys(Username);
	}
	
	public void PasswordboxClear(){
		PasswordBox.clear();
	}
	
	public void PasswordEnter(String Password){
		PasswordBox.sendKeys(Password);
	}
	
	public void Loginbox() {
		LoginBox.click();
	}
	
	public boolean expandAll() {
		boolean displaystatus =Expand.isDisplayed();
		return displaystatus;
	}
	
	public void profiletest() {
		profile.click();
	}
	
	public void logouttest() {
		logoutlink.click();
	}
	
	public boolean Imageassert() {
		boolean displaystatus =Image.isDisplayed();
		return displaystatus;
	}
	
	public String actualUsernameassert(String value) {
		String text = actualUsername.getAttribute(value);
		return text;
	}
	
	public void rember() {
		rember.click();
	}
	
	public void forgetpassword() {
		forgetPassword.click();
	}
	
	public void Emailbox(String value){
		emailbox.sendKeys(value);
	}
	public void resetpassword() {
		continuebox.click();
	}
	
	public String actualheader() {
		String text = Header.getText();
		return text;
	}
	
	public String ErrorHeader() {
		String Errortext = ErrorHeader.getText();
		return Errortext;
	}	
}	