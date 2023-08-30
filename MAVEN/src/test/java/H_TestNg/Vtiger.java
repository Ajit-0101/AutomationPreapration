package H_TestNg;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.github.dockerjava.api.model.Driver;

import Utilities.SeleniumUtility;

public class Vtiger extends SeleniumUtility {
	static WebDriver driver;

	@Test(priority = 1)
	public void Login() {

		driver = setUp("Chrome", "https://demo.vtiger.com/vtigercrm/index.php");

		WebElement inputUsername = driver.findElement(By.id("username"));
		inputUsername.clear();
		inputUsername.sendKeys("admin");
		WebElement passwordInput = driver.findElement(By.id("password"));
		passwordInput.clear();
		passwordInput.sendKeys("Test@123");
		WebElement singinButton = driver.findElement(By.className("button"));
		singinButton.click();
	}

	@Test(priority = 2)
	public void TestCase1_CreatLead() {
		// Click on menu
		clickOnElement(driver.findElement(By.xpath("//*[@id='appnavigator']/div")));
		// Click on marketing
		clickOnElement(driver.findElement(By.xpath("//*[@id='MARKETING_modules_dropdownMenu']")));
		// Select Lead
		clickOnElement(driver.findElement(By.xpath("//*[@id='mCSB_1_container']/li[2]/a")));
		// Click on new Lead
		clickOnElement(driver.findElement(By.xpath("//*[@id='Leads_listView_basicAction_LBL_ADD_RECORD']")));
		// Enter First Name
		driver.findElement(By.name("firstname")).sendKeys("PRADEEP");
		// Enter Last Name
		driver.findElement(By.name("lastname")).sendKeys("SHARMA");
		// Save the Details
		clickOnElement(driver.findElement(By.xpath("//button[@type='submit']")));

	}

	@Test(priority = 3)
	public void TestCase2_Update() {
		// Click on Edit button
		clickOnElement(driver.findElement(By.id("Leads_detailView_basicAction_LBL_EDIT")));
		// Eneter Compony nAme
		driver.findElement(By.id("Leads_editView_fieldName_company")).sendKeys("Google");
		// Enter Designation
		driver.findElement(By.id("Leads_editView_fieldName_designation")).sendKeys("Sr.Test Engineer");

		// Save the Updated Details-- Click on Save
		clickOnElement(driver.findElement(By.xpath("//button[@type='submit']")));

		// Click on Leads
		clickOnElement(driver.findElement(By.xpath("//a[@title='Leads']/h4")));
	}

	@Test(priority = 4)
	public void TestCase3_Delete() {
		// DELETE Created Lead ----Click on check Box to Select Lead
		clickOnElement(driver.findElement(By.className("listViewEntriesMainCheckBox")));
		// Click on Delete Option
		clickOnElement(driver.findElement(By.id("Leads_listView_massAction_LBL_DELETE")));
		// Comfirm Yes Option
		clickOnElement(driver.findElement(By.xpath("//button[@data-bb-handler='confirm']")));
		// Click on menu
		clickOnElement(driver.findElement(By.xpath("//*[@id='appnavigator']/div")));
		// BAck To DashBoard
		clickOnElement(driver.findElement(By.xpath("//*[@id='app-menu']/div/div[2]/div[1]")));

	}

	@Test(priority = 5)
	public void TestCase4_Validation_LogOut() {

		String expectedtHomePageTitle = "Dashboard";
		String actualHomePageTitle = driver.getTitle();
		System.out.println("Actual Home page title: " + actualHomePageTitle);
		System.out.println("Expected Home page title: " + expectedtHomePageTitle);
		System.out.println(
				"Validation of home page title  status: " + actualHomePageTitle.equals(expectedtHomePageTitle));
		if (actualHomePageTitle.equals(expectedtHomePageTitle)) {
			System.out.println("Home page validation is successfull, logout from the application now");
			// logout from the application

		
			WebElement profile = driver.findElement(By.className("fa-user"));
			profile.click();

			driver.findElement(By.linkText("Sign Out")).click();
			System.out.println("Logout Succssefully");
		} else {
			System.out.println("Home page validation is failed, not allowed to logout from the application");
		}
		driver.close();

	}
}