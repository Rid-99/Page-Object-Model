/*
 * 
 * @Author = Riddhi
 * 
 */


package testclass;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.TestBase;
import page.HomePage;
import util.TestUtil;


public class HomePageTest extends TestBase {
	
	HomePage homepage;
	TestUtil testUtil;

	
	public HomePageTest() {
		super();
	}
 
  @BeforeMethod
  public void setUp() {
	  initialization();
	  testUtil = new TestUtil();
	  homepage = new HomePage();
  }
  
  @Test(priority = 1)
  public void verifyHomePageTitleTest() {
	  String title = homepage.validateHomePagetitle();
	  Assert.assertEquals(title, "Google Store for Google Made Devices & Accessories");
  }
  
  @Test(priority = 2)
  public void ValidateLabelTest() {
	  Assert.assertTrue(homepage.validateLogoImage());
	  Assert.assertTrue(homepage.validatePhoneLabel());
	  Assert.assertTrue(homepage.validateearbudsLabel());
	  Assert.assertTrue(homepage.validateTabletsLabel());
	  Assert.assertTrue(homepage.validateWatchLabel());
	  Assert.assertTrue(homepage.validateSmartHomeLabel());
	  Assert.assertTrue(homepage.validateAccessoriesLabel());
	  Assert.assertTrue(homepage.validateOffersLabel());
  }
  
  @Test(priority = 3)
  public void searchTest() throws InterruptedException {
	  homepage.googleStoreSearchBar(prop.getProperty("search"));
  }

  @AfterMethod
  public void closeBrowser() {
	  driver.quit();
  }


}
