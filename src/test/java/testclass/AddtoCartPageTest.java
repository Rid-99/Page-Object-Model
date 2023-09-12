package testclass;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.TestBase;
import page.AddtoCartPage;
import page.HomePage;
import page.PurchasePage;
import page.SearchPage;
import page.ProductDetailPage;
import util.TestUtil;

public class AddtoCartPageTest extends TestBase {
	AddtoCartPage addtocartpage;
	PurchasePage purchasepage;
	ProductDetailPage watchpage;
	SearchPage searchPage;
	HomePage homepage;
	TestUtil testUtil;
	
	public  AddtoCartPageTest() {
		super();
	}
	
	@BeforeMethod
    public void setUp() throws InterruptedException {
    	initialization();
	    testUtil = new TestUtil();
    	homepage = new HomePage();
		searchPage = homepage.googleStoreSearchBar(prop.getProperty("search"));
		watchpage = searchPage.clickOnGooglePixelWatch();
		purchasepage = watchpage.clickOnBuyButton();
		addtocartpage = purchasepage.clickOnAddtoBasket();
    }
	
	@Test(priority = 1)
	public void verifyAddedLabelTest() {
		String label = addtocartpage.validateAddedLabel();
		Assert.assertEquals(label, "Added");
	}
	
	@Test(priority = 2)
	public void clickonGoToBasketButtonTest() throws InterruptedException {
		addtocartpage.clickonGoToBasketButton();
	}
	
	@AfterMethod
	public void afterMethod() {
	   	driver.quit();
    }
  
}
