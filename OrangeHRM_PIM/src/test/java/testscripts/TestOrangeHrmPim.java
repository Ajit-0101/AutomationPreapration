package testscripts;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import utilities.SeleniumUtility;
import webpagesfororangehrm.AddEmployeePage;
import webpagesfororangehrm.HomePage;
import webpagesfororangehrm.LoginPage;
import webpagesfororangehrm.PersonalDetailsPage;
import webpagesfororangehrm.PimHomePage;

public class TestOrangeHrmPim extends SeleniumUtility {
	LoginPage getLoginPage;
	HomePage getHomePage;
	PimHomePage getPimHomePage;
	AddEmployeePage getAddEmployeePage;
	PersonalDetailsPage getPersonalDetailsPage;

	@BeforeMethod
	public void precondition() {
		WebDriver driver = setUp("chrome", "https://opensource-demo.orangehrmlive.com/");
		getLoginPage = new LoginPage(driver);
		getHomePage = new HomePage(driver);
		getPimHomePage = new PimHomePage(driver);
		getAddEmployeePage = new AddEmployeePage(driver);
		getPersonalDetailsPage = new PersonalDetailsPage(driver);
		getLoginPage.loginIntoOrangeHrm("Admin", "admin123");
		getHomePage.clickOnPIM();
	}

	@Test(priority=1)
	public void testPimCreation() {
		getPimHomePage.clickOnAddButton();
		getAddEmployeePage.createEmployee("SAMSUNG", "Lead", 12356);
		getHomePage.clickOnPIM();
		getPimHomePage.searchCreatedEmployee(12356);
		String acutalMsg = getPimHomePage.getSearchResultMsg();
		String expectedMsg = "(1) Record Found";
		Assert.assertEquals(acutalMsg, expectedMsg);
	}

	@Test(priority=2,dependsOnMethods = "testPimCreation")
	public void testPimEdit() {
		getHomePage.clickOnPIM();
		getPimHomePage.searchCreatedEmployee(12356);
		getPimHomePage.editCreatedEmployee();
		getPersonalDetailsPage.UpdateCreatedEmployee();
		getHomePage.clickOnPIM();
		getPimHomePage.searchCreatedEmployee(12356);
	}

	@Test(priority=3,dependsOnMethods = "testPimCreation")
	public void testPimDeletion() {
		getHomePage.clickOnPIM();
		getPimHomePage = new PimHomePage(driver);
		getPimHomePage.searchCreatedEmployee(12356);
		getPimHomePage.deleteCreatedEmployee();
		String acutalMsg = getPimHomePage.getSearchResultMsg();
		String expectedMsg = "No Records Found";
		Assert.assertEquals(acutalMsg, expectedMsg);
	}

	@AfterMethod
	public void postcondition() {
		getHomePage.logoutFromHrm();
		tearDown();
	}
}
