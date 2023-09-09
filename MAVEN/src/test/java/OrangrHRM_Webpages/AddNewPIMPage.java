package OrangrHRM_Webpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.SeleniumUtility;

public class AddNewPIMPage extends SeleniumUtility {

	public AddNewPIMPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	

	@FindBy(css = "input[placeholder='First Name']")
	private WebElement firstNameFiled;

	@FindBy(css = ("input[placeholder='Last Name']"))
	private WebElement lastNameFiled;

	@FindBy(xpath = ("//button[@type='submit']"))
	private WebElement saveButton;
	
	public WebElement getFirstNameFiled() {
		return firstNameFiled;
	}
	public WebElement getLastNameFiled() {
		return lastNameFiled;
	}
	public WebElement getSaveButton() {
		return saveButton;
	}
	public void enterFirstName(String firstName) {
		typeInput(firstNameFiled, firstName);
	}
	public void enterLastname(String lastName) {
		typeInput(lastNameFiled, lastName);
	}
	public void clickOnSaveButton() {
		clickOnElement(saveButton);
	}

}
