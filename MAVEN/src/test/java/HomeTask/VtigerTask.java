package HomeTask;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Utility.SeleniumUtil;

public class VtigerTask {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = SeleniumUtil.setUp("Chrome","https://demo.vtiger.com/vtigercrm/index.php");
		
		//Validation of LOGIN Page
		// username field - visible, editable, default text
			WebElement inputUsername = driver.findElement(By.id("username"));
			System.out.println("is Username input field visible   :  " + inputUsername.isDisplayed());
			System.out.println("is Username input field editable   :  " + inputUsername.isEnabled());
			System.out.println("is any default text in Username input field    :  " + inputUsername.getAttribute("placeholder"));

			// password field - visible, editable, default text
			WebElement passwordInput = driver.findElement(By.id("password"));
			System.out.println("is Password input field visible   :  " + passwordInput.isDisplayed());
			System.out.println("is Password input field editable   :  " + passwordInput.isEnabled());
			System.out.println("is any default text in Password input field    :  " + passwordInput.getAttribute("placeholder"));

			// SignIn button - visible, clickable, button name
			WebElement singinButton = driver.findElement(By.className("button"));
			System.out.println("is SignIn button visible   :  " + singinButton.isDisplayed());
			System.out.println("is SignIn button clickable   :  " + singinButton.isEnabled());
			System.out.println("button text is: " + singinButton.getText());

		
		//Enter Username and Password
		//WebElement inputUsername = driver.findElement(By.id("username"));
		inputUsername.clear();
		inputUsername.sendKeys("admin");
	//	WebElement passwordInput = driver.findElement(By.id("password"));
		passwordInput.clear();
		passwordInput.sendKeys("Test@123");
		//Login 
	//	WebElement singinButton = driver.findElement(By.className("button"));
		singinButton.click();
		//Click on menu
		SeleniumUtil.clickOnElement(driver.findElement(By.xpath("//*[@id='appnavigator']/div")));
		//Click on marketing
		SeleniumUtil.clickOnElement(driver.findElement(By.xpath("//*[@id='MARKETING_modules_dropdownMenu']")));
		//Select Lead
		SeleniumUtil.clickOnElement(driver.findElement(By.xpath("//*[@id='mCSB_1_container']/li[2]/a")));
		//Click on new Lead
		SeleniumUtil.clickOnElement(driver.findElement(By.xpath("//*[@id='Leads_listView_basicAction_LBL_ADD_RECORD']")));
		//Enter First Name
		//driver.findElement(By.xpath("//*[@id='Leads_editView_fieldName_firstname")).sendKeys("PRADEEP");
		driver.findElement(By.name("firstname")).sendKeys("PRADEEP");
		//Enter Last Name
		driver.findElement(By.name("lastname")).sendKeys("SHARMA");
		//Save the Details
		SeleniumUtil.clickOnElement(driver.findElement(By.xpath("//*[@id='EditView']/div[3]/div/div/button")));
		//Update Details.. Click on Edit button
		SeleniumUtil.clickOnElement(driver.findElement(By.id("Leads_detailView_basicAction_LBL_EDIT")));
		//Eneter Compony nAme
		driver.findElement(By.id("Leads_editView_fieldName_company")).sendKeys("Google");
		//Enter Designation
		driver.findElement(By.id("Leads_editView_fieldName_designation")).sendKeys("Sr.Test Engineer");
	
		//Save the Updated Details-- Click on Save
		SeleniumUtil.clickOnElement(driver.findElement(By.xpath("//*[@id='EditView']/div[3]/div/div/button")));
		
		//Click on Leads
		SeleniumUtil.clickOnElement(driver.findElement(By.xpath("//*[@id='page']/nav/div[2]/div/div[3]/div/div[1]/a")));
		// DELETE Created Lead ----Click on check Box to Select Lead
		SeleniumUtil.clickOnElement(driver.findElement(By.xpath("//*[@id='Leads_listView_row_1']/td[1]/div/span[1]/input")));
		//SeleniumUtil.clickOnElement(driver.findElement(By.className("listViewEntriesCheckBox")));
		//Click on Delete Option
		SeleniumUtil.clickOnElement(driver.findElement(By.id("Leads_listView_massAction_LBL_DELETE")));
		//Comfirm Yes Option
		SeleniumUtil.clickOnElement(driver.findElement(By.xpath("/html/body/div[6]/div[2]/div/div[2]/button[2]")));
		//Click on menu
		SeleniumUtil.clickOnElement(driver.findElement(By.xpath("//*[@id='appnavigator']/div")));
		//BAck To DashBoard
		SeleniumUtil.clickOnElement(driver.findElement(By.xpath("//*[@id='app-menu']/div/div[2]/div[1]")));
		
		//validate home page - title/url
		
				String expectedtHomePageTitle="Dashboard";	
				String actualHomePageTitle=driver.getTitle();
				System.out.println("Actual Home page title: "+actualHomePageTitle);
				System.out.println("Expected Home page title: "+expectedtHomePageTitle);
				System.out.println("Validation of home page title  status: " + actualHomePageTitle.equals(expectedtHomePageTitle));
				if(actualHomePageTitle.equals(expectedtHomePageTitle)) {
					System.out.println("Home page validation is successfull, logout from the application now");
					//logout from the application
					
					//driver.findElement(By.id("menubar_item_right_LBL_SIGN_OUT")).click();
					WebElement profile = driver.findElement(By.className("fa-user"));
					profile.click();
					
					driver.findElement(By.linkText("Sign Out")).click();
					System.out.println("Logout Succssefully");
				}else {
					System.out.println("Home page validation is failed, not allowed to logout from the application");
				}
			driver.close();
		
	}

}
