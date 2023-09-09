package OrangrHRM_Webpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.SeleniumUtility;

public class JobDetailsPage extends SeleniumUtility {
	public JobDetailsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	@FindBy(css = (".oxd-select-text-input"))
	private WebElement JobTitle;
	
	@FindBy(css = ("//button[@type='submit']"))
	private WebElement saveButton;
	
	@FindBy(css=".oxd-table-body>div:nth-child(1) label")
	private WebElement firstEmpCheckBox;
	public WebElement getJobTitle() {
		return JobTitle;
	}
	public WebElement getSaveButton() {
		return saveButton;
	}
	
	

	public void enterJobTitle(String TypeQ) {
		typeInput(JobTitle, TypeQ);
	}
	public void clickOnJobTitle() {
		clickOnElement(JobTitle);
	}
	public void clickOnSaveButton() {
		clickOnElement(saveButton);
	}
	public void UpdateCreatedEmployee() {
		clickOnElement(firstEmpCheckBox);
		clickOnElement(saveButton);
		
	}
}
