package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(id = "input-email")
	private WebElement emailfield;
	
	@FindBy(id = "input-password")
	private WebElement passwordfiled;

	@FindBy(css = "input[value='Login']")
	private WebElement loginButton;

	public WebElement getEmailfield() {
		return emailfield;
	}

	public WebElement getPasswordfiled() {
		return passwordfiled;
	}

	public WebElement getLoginButton() {
		return loginButton;
	}


}
