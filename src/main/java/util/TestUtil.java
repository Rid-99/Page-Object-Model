package util;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import base.TestBase;

public class TestUtil extends TestBase{

	
	public static long page_Load_Timeout = 20;
	public static long implicitly_Wait = 20;

	public static void takeScreenshotAtEndOfTest() throws IOException {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrFile, new File("/Users/riddhi/Desktop/QA/Testing"+ "/screenshots/" + System.currentTimeMillis() + ".png"));

	}
}
