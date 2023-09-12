package testclass;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.TestBase;
import page.HomePage;
import page.PurchasePage;
import page.SearchPage;
import page.ProductDetailPage;

public class PurchasePageTest extends TestBase{
	PurchasePage purchasepage;
	ProductDetailPage watchpage;
	SearchPage searchPage;
	HomePage homepage;
	
	public PurchasePageTest() {
		super();
	}
	
	@BeforeMethod
    public void setUp() throws InterruptedException {
    	initialization();
    	homepage = new HomePage();
		searchPage = homepage.googleStoreSearchBar(prop.getProperty("search"));
		watchpage = searchPage.clickOnGooglePixelWatch();
		purchasepage = watchpage.clickOnBuyButton();
    }
	
	@Test(priority = 1)
	public void verifyWatchName() {
		String name = purchasepage.validateProductName();
		Assert.assertEquals(name, "Google Pixel Watch");
	}

	@Test(priority = 2)
	public void viewImageTest() throws InterruptedException {
		purchasepage.clickOnImages();
	}
	
	@Test(priority = 3)
	public void clickOnchalkbandTest() {
		purchasepage.clickOnchalkActiveband();
	}

	@Test(priority = 4)
	public void clickOnConnectivityOptionTest() throws InterruptedException {
		purchasepage.clickOnConnectivityOption();
	}

	@Test(priority = 5)
	public void clickOnAddtoBasketTest() throws InterruptedException {
		purchasepage.clickOnchalkActiveband();
		purchasepage.clickOnConnectivityOption();
		purchasepage.clickOnAddtoBasket();
	}
    @AfterMethod
    public void afterMethod() {
    	driver.quit();
    }

  
}
