package page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class SearchPage extends TestBase{
 
	@FindBy(xpath = "//h1[@class='bv5GNd']")
	public WebElement resulttitle;
	
	@FindBy(xpath = "//h1[@class='bv5GNd']/strong")
	public WebElement resultLabel;
	
	@FindBy(xpath = "//div[@class='ZaNmsc']/section[1]//h2")
	public WebElement numberofResult;
	
	@FindBy(xpath = "(//a[@class='P0LaXe'])[1]")
	public WebElement watch;
	
	@FindBy(xpath = "(//h2[@class = 'type-body-copy--standard'])[1]")
	public WebElement watchName;
	
	@FindBy(xpath = "(//div[@class = 'OGN3Ee'])[1]")
	public WebElement watchImage;
	

	public SearchPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String validateSearchResultTitle() {
		String searchResultTitle = resulttitle.getText() + resultLabel.getText();
		return searchResultTitle;
	}
	
	public String numberOfResult() {
		return numberofResult.getText();
	}
	
	public Boolean validateWatchImage() {
		return watchImage.isDisplayed();
	}
	
	public Boolean validateWatchName() {
		return watchName.isDisplayed();
	}
	
	public ProductDetailPage clickOnGooglePixelWatch() throws InterruptedException {
		watch.click();
		Thread.sleep(5000);
		return new ProductDetailPage();
	}	
	
	public void closeBrowser() {
		driver.quit();
	}
	
}
