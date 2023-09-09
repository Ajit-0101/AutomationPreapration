package OrangeHrm_TestScripts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import OrangrHRM_Webpages.AddNewPIMPage;
import OrangrHRM_Webpages.JobDetailsPage;
import OrangrHRM_Webpages.LoginPage;
import OrangrHRM_Webpages.HomePage;
import OrangrHRM_Webpages.PersonalDetailsPage;
import OrangrHRM_Webpages.PIM_HomePage;
import Utilities.SeleniumUtility;

public class TestOrangeHrmPIM extends SeleniumUtility {
	WebDriver driver;
	LoginPage getLoginPage;
	HomePage getHomePage;
	PIM_HomePage getPIMHomePage;
	PersonalDetailsPage getPIMDetailsPage;
	AddNewPIMPage getAddNewPIMPage;
	JobDetailsPage getJobDetailsPage;

	@BeforeMethod
	public void preCondition() {
		driver = setUp("chrome", "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		getLoginPage = new LoginPage(driver);
		getHomePage = new HomePage(driver);
		getPIMHomePage = new PIM_HomePage(driver);
		getPIMDetailsPage = new PersonalDetailsPage(driver);
		getAddNewPIMPage = new AddNewPIMPage(driver);
		getJobDetailsPage = new JobDetailsPage(driver);
		getLoginPage.loginIntoOrangeHrm("Admin", "admin123");
		getHomePage.clickOnPIMLink();

	}

	
	@Test(priority = 1)

	public void testPIMAddition() {

		getPIMHomePage.clickOnAddNewButton();
		getAddNewPIMPage.enterFirstName("AUTO");
		getAddNewPIMPage.enterLastname("TEST");
		getAddNewPIMPage.clickOnSaveButton();
		getPIMHomePage.clickOnListButton();
	}
	@Test(priority = 2)
	public void testPIMUpdate() throws Throwable {
		getPIMHomePage.clickOnListButton();
		getPIMHomePage.enterFirstName("AUTO TEST");
		Thread.sleep(500);
		getPIMHomePage.clickOnSearchButton();
		Thread.sleep(500);
		getPIMHomePage.clickOnCheckBox();
		getPIMHomePage.clickOneditButton();
		getPIMDetailsPage.clickOnJobLink();
		getJobDetailsPage.clickOnJobTitle();
		getJobDetailsPage.enterJobTitle("Q");
		
		getJobDetailsPage.getSaveButton();
		Thread.sleep(500);
	}
	@Test(priority = 3)
	public void testPIMDelete() throws Throwable {
		getPIMHomePage.clickOnListButton();
		getPIMHomePage.enterFirstName("AUTO TEST");
		Thread.sleep(500);
		getPIMHomePage.clickOnSearchButton();
		Thread.sleep(500);
		getPIMHomePage.clickOnCheckBox();
		getPIMHomePage.clickOnDeleteButton();
		getPIMHomePage.clickOnDeletePermanantButton();
		
	
		
	}
	@AfterMethod
	public void postCondition() {
		getHomePage.logoutFromApplication();
		cleanUp();
	}
}