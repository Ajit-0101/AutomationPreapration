package OrangrHRM_Webpages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.SeleniumUtility;

public class PersonalDetailsPage extends SeleniumUtility {
	public PersonalDetailsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = ("//a[text()='Job']"))
	private WebElement JobLink;
	
	
	public WebElement getJobLink() {
		return JobLink;
	}

	public void clickOnJobLink() {
		clickOnElement(JobLink);
	}



}