package com.salesforceutilities;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

import com.microsoft.schemas.office.visio.x2012.main.CellType;

public class Utilities {
	
	public static final int IMPLICIT_WAIT_TIME=60;
	public static final int PAGE_LOAD_TIME=60;	

public static String captureScreenshot(WebDriver driver,String testname) {
	File scrScreenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	String destinationscreenshotpath = System.getProperty("user.dir")+"\\srceenShots\\"+ testname+ ".png";	
	
	try {
		FileHandler.copy(scrScreenshot, new File(destinationscreenshotpath));
	} catch (IOException e) {
		e.printStackTrace();
	}
	
	return destinationscreenshotpath;
   }
}
