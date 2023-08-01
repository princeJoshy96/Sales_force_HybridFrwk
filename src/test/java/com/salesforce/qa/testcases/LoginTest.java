package com.salesforce.qa.testcases;

import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.sales.qa.pageobject.LoginAssert;
import com.sales.qa.pageobject.LoginpageObj;
import com.salesforce.qa.base.Basecase;
import com.salesforceutilities.DataUtil;
import com.salesforceutilities.MyXLSReader;


public class LoginTest extends Basecase {
	MyXLSReader excelReader;
	
	public LoginTest() {
		super();
	}
	
	public WebDriver driver;
	
	@BeforeMethod
	public void setUp() {
		
		driver=initializebrowserAppOpen(properties.getProperty("browserchrome"));
	}
	
	@AfterMethod
	public void tearDown() {
		if (driver !=null) {
			driver.quit();
		}
	}
	
	@Test(priority =5)
	public void loginErrorMessage() {
		LoginpageObj  loginpage =new LoginpageObj(driver);
		loginpage.Usernameclear();
		loginpage.UsernameEnter(properties.getProperty("ValidUsername"));
		loginpage.PasswordboxClear();
		loginpage.Loginbox();
		
		LoginAssert loginassert = new LoginAssert(driver);
		String actualwarningmessage =loginassert.retrieveinvalidText();
		String expectedWarning = Dataprop.getProperty("loginErrorMessageExpect");
		Assert.assertTrue(actualwarningmessage.contains(expectedWarning),"Invalid Login Test unsuccesfull");

	}
	@Test(dataProvider="supplyTestinfo",priority = 4)
	public void ValidLogin(HashMap<String, String> hMap) {
		if (!DataUtil.isRunnable(excelReader, "LoginTest", "TesTcases")|| hMap.get("Runmode").equals("N")) {
			throw new SkipException("Run mode is set to N, hence not exceuted");
		}
		
		LoginpageObj  loginpage =new LoginpageObj(driver);
		loginpage.Usernameclear();
		loginpage.UsernameEnter(hMap.get("Username"));
		loginpage.PasswordboxClear();
		loginpage.PasswordEnter(hMap.get("Password"));
		loginpage.Loginbox();
		
		String expectedresult = hMap.get("ExpectedResult");
		
		boolean expectedConvertedResult = false;
		
		if (expectedresult.equalsIgnoreCase("Success")) {
			
			expectedConvertedResult = true;
			
		}else if (expectedresult.equalsIgnoreCase("Failure")){
			 
			expectedConvertedResult = false;
		}
		 boolean actualresult = false;
		 	LoginAssert loginasserts = new LoginAssert(driver);
		 	actualresult = loginasserts.verifyhomepage();
		 	Assert.assertEquals(actualresult, expectedConvertedResult);
		
		driver.quit();
	}
	
	@Test(priority = 3)
	public void CheckRemeberMe() {
	
		LoginpageObj  loginpage =new LoginpageObj(driver);
		loginpage.Usernameclear();
		loginpage.UsernameEnter(properties.getProperty("ValidUsername"));
		loginpage.PasswordboxClear();
		loginpage.PasswordEnter(properties.getProperty("ValidPassword"));
		loginpage.rember();
		loginpage.Loginbox();
		
		Assert.assertTrue(loginpage.expandAll());
		
		loginpage.profiletest();
		loginpage.logouttest();
		
		Assert.assertTrue(loginpage.Imageassert());
		
		String actualUsername = loginpage.actualUsernameassert("value");
		String expectedUsername = properties.getProperty("ValidUsername");
	
		Assert.assertTrue(actualUsername.contains(expectedUsername),"Invalid Loginpage ");
	}
	
	@Test(priority =2)
	public void forgetpassword() {
		LoginpageObj  loginpage =new LoginpageObj(driver);
		loginpage.forgetpassword();
		loginpage.Emailbox(Dataprop.getProperty("Email"));
		
		loginpage.resetpassword();
		
		String actualHeader = loginpage.actualheader();
		String expectedHeader = Dataprop.getProperty("forgetpasswordExpected");
		Assert.assertTrue(actualHeader.contains(expectedHeader),"invalid page");
	}
	
	@Test(priority = 1)
	public void invalidLogins() {
		
		LoginpageObj loginpage = new LoginpageObj(driver);
		loginpage.Usernameclear();
		loginpage.UsernameEnter(Dataprop.getProperty("InvalidUser"));
		
		loginpage.PasswordboxClear();
		loginpage.PasswordEnter(Dataprop.getProperty("InvalidPass"));
		
		loginpage.Loginbox();
		
		String actual = loginpage.ErrorHeader();
		String expected = Dataprop.getProperty("InvalidLoginTestWarning");
		
		Assert.assertTrue(actual.contains(expected),"invalid page");
	}
	@DataProvider
	public Object[][] supplyTestinfo()  {
		
		Object[][] data = null;
		
		try {
			excelReader = new MyXLSReader("src\\test\\resource\\TutorialsNinja.xlsx");
			data = DataUtil.getTestData(excelReader,"LoginTest", "Data");
		} catch(Throwable e) {
			
	}
		return data;
   }
}

