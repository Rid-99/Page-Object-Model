package testclass;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.TestBase;
import page.AddtoCartPage;
import page.BasketOverviewPage;
import page.HomePage;
import page.PurchasePage;
import page.SearchPage;
import page.ProductDetailPage;
import util.TestUtil;

public class BasketOverViewTest extends TestBase{
	BasketOverviewPage basketoverviewpage;
	AddtoCartPage addtocartpage;
	PurchasePage purchasepage;
	ProductDetailPage watchpage;
	SearchPage searchPage;
	HomePage homepage;
	TestUtil testUtil;

	
	public BasketOverViewTest() {
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
		basketoverviewpage = addtocartpage.clickonGoToBasketButton();
    
	}
	
	@Test(priority = 1)
	public void verifyQuantityTest() {
		String label = basketoverviewpage.validateQuantity();
		Assert.assertEquals(label, "1");
	}
	
	@Test(priority = 2)
	public void clickonRemoveButtonTest() throws InterruptedException {
		basketoverviewpage.clickonremoveButton();
	}
	
	@Test(priority = 3)
	public void clickOncontinueShoppoingTest() throws InterruptedException {
		basketoverviewpage.clickOncontinueShoppoingLink();
	}
	
	@Test(priority = 4)
	public void clickOnSignInAndCheckOutTest() throws InterruptedException {
		basketoverviewpage.clickOnSignInAndCheckOutButton();
	}
	
	@AfterMethod
	public void afterMethod() {
	   	driver.quit();
    }
	
 
}
