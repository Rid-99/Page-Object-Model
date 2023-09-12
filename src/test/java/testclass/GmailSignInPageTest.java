package testclass;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.TestBase;
import page.AddtoCartPage;
import page.BasketOverviewPage;
import page.GmailSignInPage;
import page.HomePage;
import page.ProductDetailPage;
import page.PurchasePage;
import page.SearchPage;
import testdata.DataFile;
import util.TestUtil;

public class GmailSignInPageTest extends TestBase{
	GmailSignInPage gmailsigninpage;
	BasketOverviewPage basketoverviewpage;
	AddtoCartPage addtocartpage;
	PurchasePage purchasepage;
	ProductDetailPage watchpage;
	SearchPage searchPage;
	HomePage homepage;
	TestUtil testUtil;
	DataFile data;
	
	public GmailSignInPageTest() {
		super();
	}
	
	@BeforeMethod
    public void setUp() throws InterruptedException {
    	initialization();
    	data = new DataFile();
	    testUtil = new TestUtil();
    	homepage = new HomePage();
		searchPage = homepage.googleStoreSearchBar(prop.getProperty("search"));
		watchpage = searchPage.clickOnGooglePixelWatch();
		purchasepage = watchpage.clickOnBuyButton();
		addtocartpage = purchasepage.clickOnAddtoBasket();
		basketoverviewpage = addtocartpage.clickonGoToBasketButton();
		gmailsigninpage = basketoverviewpage.clickOnSignInAndCheckOutButton();
	}
	
	@Test (priority = 1)
	public void loginEmailWithSpecialCharTest() throws InterruptedException {
    	gmailsigninpage.login(data.specialEmailChar);
    	Assert.assertEquals(gmailsigninpage.readEmailErr(), data.specialEmailCharErr);
	
	}
    
   @Test(priority = 2)
    public void loginWithEmptyEmailTest() throws InterruptedException {
	    gmailsigninpage.login("");
	    Assert.assertEquals(gmailsigninpage.readEmailErr(), data.emptyEmailOrPhoneErr);
    }
    
    @Test(priority = 3)
    public void loginWithWrongEmailTest() throws InterruptedException {
    	gmailsigninpage.login(data.wrongEmail);
    	Assert.assertEquals(gmailsigninpage.readEmailErr(), data.wrongEmailErr );
	
    }
    
    @Test (priority = 4)
	public void loginWithWrongPhoneTest() throws InterruptedException {
    	gmailsigninpage.login(data.wrongPhoneNumber);
    	Assert.assertEquals(gmailsigninpage.readEmailErr(), data.wrongPhoneErr);
   
	}
	
	@AfterMethod
	public void afterMethod() {
	   	driver.quit();
    }
	
}
