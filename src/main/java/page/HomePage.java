package page;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class HomePage extends TestBase {
		
	@FindBy(xpath = "//div[@id='desktop-products']/a[1]")
	public WebElement phone;
	
	@FindBy(xpath = "//div[@id='desktop-products']/a[2]")
	public WebElement earbuds;
	
	@FindBy(xpath = "//div[@id='desktop-products']/a[3]")
	public WebElement tablets;
	
	@FindBy(xpath = "//div[@id='desktop-products']/a[4]")
	public WebElement watch;
	
	@FindBy(xpath = "//div[@id='desktop-products']/a[5]")
	public WebElement smartHome;
	
	@FindBy(xpath = "//div[@id='desktop-products']/a[6]")
	public WebElement accessories;
	
	@FindBy(xpath = "//div[@id='desktop-products']/a[7]")
	public WebElement offers;
	
	@FindBy(xpath = "//div[@class='gn5mEf uFvxge']")
	public WebElement searchbutton;
	
	@FindBy(xpath = "//input[@placeholder='Search Google Store']")
	public WebElement searchBar;
	
	@FindBy(xpath = "(//i[@role='button'])[2]")
	public WebElement closeButton;
	
	@FindBy(xpath = "//a[@class = 'ECZKFf']")
	public WebElement googlelogo;

	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	public String validateHomePagetitle() {
		return driver.getTitle();
	}
	
	public Boolean validatePhoneLabel() {
		return phone.isDisplayed();
	}
	
	public Boolean validateearbudsLabel() {
		return earbuds.isDisplayed();
	}
	
	public Boolean validateTabletsLabel() {
		return tablets.isDisplayed();
	}
	
	public Boolean validateWatchLabel() {
		return watch.isDisplayed();
	}
	
	public Boolean validateSmartHomeLabel() {
		return smartHome.isDisplayed();
	}
	
	public Boolean validateAccessoriesLabel() {
		return accessories.isDisplayed();
	}
	
	public Boolean validateOffersLabel() {
		return offers.isDisplayed();
	}
	
	public Boolean validateLogoImage() {
		return googlelogo.isDisplayed();
	}
	
	public SearchPage googleStoreSearchBar(String s) throws InterruptedException {
		searchbutton.click();
		searchBar.sendKeys(s + Keys.ENTER);
		Thread.sleep(4000);
//		closeButton.click();
		return new SearchPage();
	}
	
	public void closeBrowser() {
		driver.quit();
	}
	
}
