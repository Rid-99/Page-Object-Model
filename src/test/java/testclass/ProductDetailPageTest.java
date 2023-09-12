package testclass;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.TestBase;
import page.HomePage;
import page.SearchPage;
import page.ProductDetailPage;
import util.TestUtil;

public class ProductDetailPageTest extends TestBase{
	ProductDetailPage watchpage;
	SearchPage searchPage;
	HomePage homepage;
	TestUtil testUtil;

	
			
	public ProductDetailPageTest() {
		super();
	}
	
	@BeforeMethod
    public void setUp() throws InterruptedException {
    	initialization();
    	testUtil = new TestUtil();
    	homepage = new HomePage();
		searchPage = homepage.googleStoreSearchBar(prop.getProperty("search"));
		watchpage = searchPage.clickOnGooglePixelWatch();
    }
	
	@Test(priority = 1)
	public void verifyWatchName() {
		String name = watchpage.validateWatchName();
		Assert.assertEquals(name, "Google Pixel Watch");
		watchpage.clickOnchalkActiveband();
	}

	@Test(priority = 2)
	public void ViewImage3DTest() throws InterruptedException {
		watchpage.clickOnchalkActiveband();
		watchpage.clickon3DViewButton();
	}
	
	@Test(priority = 3)
	public void buyButtonTest() {
		watchpage.clickOnBuyButton();
	}
	
    @AfterMethod
    public void afterMethod() {
    	driver.quit();
    }

}
