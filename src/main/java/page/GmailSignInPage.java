package page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class GmailSignInPage extends TestBase{
	
	@FindBy(xpath = "//input[@type='email']")
	public WebElement emailOrPhone;
	
	@FindBy(xpath = "//div[@class='F9NWFb']//button")
	public WebElement nextButton;
	
	@FindBy(xpath = "//div[@class = 'o6cuMc Jj6Lae']")
	public WebElement emailErr;
	
	public GmailSignInPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void login(String a) throws InterruptedException {
		emailOrPhone.sendKeys(a);
		nextButton.click();
		
		Thread.sleep(3000);
	}
	
	public String readEmailErr() {
		String actualErr = emailErr.getText();
		System.out.println(actualErr);
		return actualErr;
	}
	
	
	
	
}
