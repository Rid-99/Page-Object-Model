package testclass;

import org.testng.annotations.Test;

import base.TestBase;
import page.HomePage;
import page.SearchPage;
import util.TestUtil;

import org.testng.annotations.BeforeMethod;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class SearchPageTest extends TestBase{
	SearchPage searchPage;
	HomePage homepage;
	TestUtil testUtil;

	
	public SearchPageTest() {
		super();
	}
	
	@BeforeMethod
    public void setUp() throws InterruptedException {
		initialization();
	    testUtil = new TestUtil();
		homepage = new HomePage();
		searchPage = homepage.googleStoreSearchBar(prop.getProperty("search"));
	}

    @Test(priority = 1)
    public void verifysearchResultTitleTest() {
  	  String title = searchPage.validateSearchResultTitle();
  	  Assert.assertEquals(title, "Search results for: 'watch''watch'");
    }
    
    @Test(priority = 2)
    public void numberOfResultTest() {
      String numberofResult = searchPage.numberOfResult();
  	  Assert.assertEquals(numberofResult, "12 results");
    }
    
    @Test(priority = 3)
    public void verifyWatchImageAndNameTest() {
  	  Assert.assertTrue(searchPage.validateWatchImage());
  	  Assert.assertTrue(searchPage.validateWatchName());
    }
   
    @Test(priority = 4)
    public void clickOnWatchToPurchase() throws InterruptedException {
  	  searchPage.clickOnGooglePixelWatch();
    }
    @AfterMethod
    public void closeBrowser() {
    	driver.quit();
    }

}
