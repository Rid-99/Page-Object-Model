package page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class BasketOverviewPage extends TestBase {
	
	@FindBy(xpath = "//section[@class='oAHvAf']//a")
	public WebElement continueShoppoingLink;
	
	@FindBy(xpath = "//button[@class='yjHiqb']")
	public WebElement removeButton;

	@FindBy(xpath = "//select[@aria-label='Product quantity']")
	public WebElement quantity;
	
	@FindBy(xpath = "//div[@class='VfPpkd-dgl2Hf-ppHlrf-sM5MNb']/button")
	public WebElement signInAndCheckoutButton;

	
	public BasketOverviewPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String validateQuantity() {
		return quantity.getText();
	}
	
	public BasketPage clickonremoveButton() throws InterruptedException {
		Thread.sleep(5000);
		removeButton.click();
		Thread.sleep(2000);
		return new BasketPage();
	}
	
	public HomePage clickOncontinueShoppoingLink() throws InterruptedException {
		Thread.sleep(5000);
		continueShoppoingLink.click();
		return new HomePage();
	}
	
	public GmailSignInPage clickOnSignInAndCheckOutButton() throws InterruptedException {
		Thread.sleep(5000);
		signInAndCheckoutButton.click();
		return new GmailSignInPage();
	}
	
}



