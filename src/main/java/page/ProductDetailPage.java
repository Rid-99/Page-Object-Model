package page;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class ProductDetailPage extends TestBase{
		
	@FindBy(xpath = "//h1[@data-test='title']")
	public WebElement watchName;
	
	@FindBy(xpath = "//button[@data-test='pdp-Overview']/span[2]")
	public WebElement overViewButton;
	
	@FindBy(xpath = "(//bento-swatch[@role='radio'])[4]")
	public WebElement chalkActiveband;
	
	@FindBy(xpath = "(//div[@class='mqn3-template-hero-split-color-picker__ar'])[4]/bento-icon-button")
	public WebElement viewIn3DButton;
	
	@FindBy (xpath = "//bento-button[@doc-id='google_pixel_watch']")
	public WebElement buyButton;
	
	@FindBy (xpath = "//button[@class='mqn3-view-in-ar-modal__x']")
	public WebElement closeButton;
	
	JavascriptExecutor  jse = (JavascriptExecutor)driver;

	public ProductDetailPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String validateWatchName() {
		return watchName.getText();
	}
	
	public void clickOnchalkActiveband() {
		chalkActiveband.click();
	}
	
	public void clickon3DViewButton() throws InterruptedException {
		//jse.executeScript("arguments[0].scrollIntoView(true);", viewIn3DButton);
		Thread.sleep(4000);
		viewIn3DButton.click();
		Thread.sleep(7000);
		new Actions(driver).clickAndHold().moveByOffset(15, 15).perform();
		closeButton.click();	
	}
	
	public PurchasePage clickOnBuyButton() {
		buyButton.click();
		return new PurchasePage();
	}
	
	
	
	
}
