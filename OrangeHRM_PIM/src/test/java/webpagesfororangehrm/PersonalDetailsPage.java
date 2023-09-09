package webpagesfororangehrm;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.SeleniumUtility;

public class PersonalDetailsPage extends SeleniumUtility {

	public PersonalDetailsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}	
	//Job Link
	@FindBy(xpath="//a[text()='Job']")
	private WebElement jobTab;
	@FindBy(css = (".oxd-select-text-input"))
	private WebElement JobTitle;
	
	@FindBy(xpath = ("//button[@type='submit']"))
	private WebElement saveButton;

	@FindBy(css=".oxd-table-body>div:nth-child(1) label")
	private WebElement firstEmpCheckBox;
	
	public WebElement getJobTitle() {
		return JobTitle;
	}
	
	
	public void UpdateCreatedEmployee() {
		clickOnElement(jobTab);
		setSleepTime(2000);
		clickOnElement(JobTitle);
		setSleepTime(2000);
	getActiveElementFromUI().sendKeys(Keys.chord("q"),Keys.ENTER);
		clickOnElement(saveButton);
	}
}
	
	//Job Title Dropdown
	
	//Job Title Dropdown Elements
	
	//Save Button
	
	//Function: Update PIM
