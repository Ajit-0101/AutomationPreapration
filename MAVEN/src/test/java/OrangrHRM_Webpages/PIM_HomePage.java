package OrangrHRM_Webpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;

import Utilities.SeleniumUtility;

public class PIM_HomePage extends SeleniumUtility {
	public PIM_HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = ".orangehrm-header-container>button")
	private WebElement AddNew;

	@FindBy(xpath = "//input[@placeholder='Type for hints...']")
	private WebElement firstNameFiled;

	
	@FindBy(xpath = ("//button[@type='submit']"))
	private WebElement searchButton;

	@FindBy(className = ("bi-pencil-fill"))
	private WebElement editButton;

	@FindBy(css=".orangehrm-modal-footer>button:nth-of-type(2)")
	private WebElement deletePrmanantButton;

	@FindBy(xpath = ("//a[text()='Employee List']"))
	private WebElement employeListButton;

	@FindBy(className = ("oxd-checkbox-input"))
	private WebElement checkBoxButton;
	
	@FindBy(css = "i.bi-trash")
	private WebElement Delete;


	public WebElement getAddNew() {
		return AddNew;
	}

	public WebElement getFirstNameFiled() {
		return firstNameFiled;
	}
	public WebElement getSearchButton() {
		setSleepTime(2000);
		return searchButton;
	}


	@FindBy(css=".orangehrm-vertical-padding>span")
	private String searchResultCountMsg;
	
	public WebElement getEditButton() {
		return editButton;
	}
	public WebElement getDeleteButton() {
		return Delete;
	}

	public WebElement getListButton() {
		return employeListButton;
	}

	public WebElement getCheckBoxButton() {
		return checkBoxButton;
	}
	public WebElement getDeletePrmanantButton() {
		return deletePrmanantButton;
	}

	public void enterFirstName(String firstName) {
		typeInput(firstNameFiled, firstName);
	}

	public void clickOneditButton() {
		clickOnElement(editButton);
	}
	public void clickOnDeleteButton() {
		clickOnElement(Delete);
	}
	public void clickOnSearchButton() {
		clickOnElement(searchButton);
	}
	public void clickOnAddNewButton() {
		clickOnElement(AddNew);
	}
	public void clickOnListButton() {
		clickOnElement(employeListButton);
	}
	public void clickOnCheckBox() {
		clickOnElement(checkBoxButton);
	}
	public void clickOnDeletePermanantButton() {
		clickOnElement(deletePrmanantButton);
	}



	}
