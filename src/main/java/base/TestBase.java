package base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import util.TestUtil;
import util.WebEventListener;

public class TestBase {

	public static WebDriver driver;
	public static Properties prop;
	public static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;
	
	public TestBase(){
		
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream("/Users/riddhi/Desktop/QA/SeleniumWorkSpace/PageObjectModel/src/main/java/config/config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	
	}
	
	public static void initialization() {
		String browser = prop.getProperty("browser");
		
		if(browser.equals("Firefox")){
			System.setProperty("webdriver.gecko.driver", "/Users/riddhi/Downloads/geckodriver");
			driver = new FirefoxDriver();
		}else if(browser.equals("Chrome")){
			System.setProperty("webdriver.chrome.driver", "/Users/riddhi/Downloads/chromedriver_mac64/chromedriver");
			driver = new ChromeDriver();
		}else {
			driver = new SafariDriver();
		}
		
		e_driver = new EventFiringWebDriver(driver);
		//register evenListener class obj[eventListener] with  EventFiringWebDriver object[e_driver]
		eventListener = new  WebEventListener();
		e_driver.register(eventListener);
		driver = e_driver;
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.page_Load_Timeout, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.implicitly_Wait, TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("url"));
		
		
		
	
	}
	

}
