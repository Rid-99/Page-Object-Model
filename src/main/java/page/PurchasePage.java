package page;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class PurchasePage extends TestBase{


	@FindBy(xpath = "//div[@class='LR1jKc']/h1")
	public WebElement productName;
	
	@FindBy(xpath = "(//div[@class='KL4X6e TuA45b'])[1]")
	public WebElement Image1;
	
	@FindBy(xpath = "(//button[@class='vVIzYd'])[1]")
	public WebElement Image2;
	
	@FindBy(xpath = "(//li[@class='tR99w'])[3]/button/div")
	public WebElement Image3;
	
	@FindBy(xpath = "(//li[@class='tR99w'])[4]/button/div")
	public WebElement Image4;
	
	@FindBy(xpath = "(//button[@class='yQ6Ozb'])[3]")
	public WebElement chalkActiveband ;
	
	@FindBy(xpath = "//button[@class='yQ6Ozb d0rLhc u2nDAd']")
	public WebElement connectivityOption ;
	
	@FindBy(xpath = "//button[@aria-label='Add to basket']")
	public WebElement addToBasket ;
	
	JavascriptExecutor  jse = (JavascriptExecutor)driver;
	
	public PurchasePage() {
		PageFactory.initElements(driver, this);
	}
	
	public String validateProductName() {
		return productName.getText();
	}
	
	public void clickOnImages() throws InterruptedException {
		Image1.click();
		Thread.sleep(1500);
		Image2.click();
		Thread.sleep(1500);
		Image3.click();
		Thread.sleep(1500);
		Image4.click();
		Thread.sleep(1500);
	}
	public void clickOnchalkActiveband() {
		chalkActiveband.click();
	}
	public void clickOnConnectivityOption() throws InterruptedException {
		
		//System.out.println(connectivityOption.getLocation());
		jse.executeScript("window.scrollBy(925, 940)");
		Thread.sleep(3000);
		//jse.executeScript("arguments[0].click();", connectivityOption);
		
		connectivityOption.click();
	}
	public AddtoCartPage clickOnAddtoBasket() throws InterruptedException {
		
		clickOnchalkActiveband();
		
		clickOnConnectivityOption();
		
		//System.out.println(addToBasket.getLocation());
		jse.executeScript("window.scrollBy(925, 960)");
		Thread.sleep(3000);
		addToBasket.click();
		
		return new AddtoCartPage();
	}

}

