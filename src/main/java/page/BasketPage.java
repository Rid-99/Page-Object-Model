package page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class BasketPage extends TestBase {
	
	@FindBy(xpath = "//a[@class='WpHeLc VfPpkd-mRLv6 VfPpkd-RLmnJb']")
	public WebElement continueShoppingButton;
	
	@FindBy(xpath = "//section[@class=\"CPFty\"]//h2")
	public WebElement emptyLabel;

	public BasketPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String validateEmptyLabel() {
		return emptyLabel.getText();
	}
	
	public HomePage clickonGoToBasketButton() {
		continueShoppingButton.click();
		return new HomePage();
	}
	
}
