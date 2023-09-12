package page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class AddtoCartPage extends TestBase {
	
	@FindBy(xpath = "(//div[@class='VfPpkd-dgl2Hf-ppHlrf-sM5MNb'])[1]")
	public WebElement goToBasketButton;
	
	@FindBy(xpath = "(//div[@class='noqMHd'])[1]")
	public WebElement addedLabel;
	
	public AddtoCartPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String validateAddedLabel() {
		return addedLabel.getText();
	}
	
	public BasketOverviewPage clickonGoToBasketButton() throws InterruptedException {
		Thread.sleep(5000);
		goToBasketButton.click();
		return new BasketOverviewPage();
	}
	

}
