package testclass;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.TestBase;
import page.AddtoCartPage;
import page.BasketOverviewPage;
import page.BasketPage;
import page.HomePage;
import page.PurchasePage;
import page.SearchPage;
import page.ProductDetailPage;
import util.TestUtil;

public class BasketPageTest extends TestBase{
	BasketPage basketpage;	
	BasketOverviewPage basketoverviewpage;
	AddtoCartPage addtocartpage;	
	PurchasePage purchasepage;
	ProductDetailPage watchpage;
	SearchPage searchPage;
	HomePage homepage;
	TestUtil testUtil;
		
	public BasketPageTest() {
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
		basketpage = basketoverviewpage.clickonremoveButton();
	    
	}
		
	@Test(priority = 1)
	public void verifyEmptyLabelTest() {
		String label = basketpage.validateEmptyLabel();		
		Assert.assertEquals(label, "Your basket is empty");
	}
		
	@Test(priority = 2)
	public void clickonGoToBasketButtonTest() {
		basketpage.clickonGoToBasketButton();
	}
		
	@AfterMethod
	public void afterMethod() {
	   	driver.quit();
    }
		

}
