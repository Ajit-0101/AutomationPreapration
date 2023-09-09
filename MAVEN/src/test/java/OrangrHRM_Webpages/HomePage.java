package OrangrHRM_Webpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.SeleniumUtility;

public class HomePage extends SeleniumUtility{
	
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(css=".oxd-userdropdown-tab")
	private WebElement userProfile;
	
	@FindBy(xpath="//a[text()='Logout']")
	private WebElement logoutLink;
	
	@FindBy(css="ul.oxd-main-menu>li:nth-of-type(2) span")
	private WebElement PIMLink;

	
	public WebElement getUserProfile() {
		return userProfile;
	}

	
	public WebElement getLogoutLink() {
		return logoutLink;
	}

	

	public WebElement getPIMLink() {
		return PIMLink;
	}
	public void clickOnPIMLink() {
		clickOnElement(PIMLink);
	}
	
	public void logoutFromApplication() {
		clickOnElement(userProfile);
		clickOnElement(logoutLink);


	}
}