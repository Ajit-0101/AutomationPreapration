package H_TestNg;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import Utilities.SeleniumUtility;
import Utility.SeleniumUtil;

	public class OrangeHRM extends SeleniumUtility {
		static WebDriver driver;

		@Test(priority = 1)
		public void LoginAndValidation() throws Exception {

			driver = setUp("Chrome", "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
			String expectedTitle = "OrangeHRM";
			String actutalTitle = driver.getTitle();
			if (actutalTitle.equals(expectedTitle)) {
				System.out.println("Login page validation is passed");
			} else {
				System.out.println("Login page validation is failed");
			}
			// validate username
			typeInput(driver.findElement(By.cssSelector("input[placeholder='Username']")), "Admin");
			Thread.sleep(1000);
			// enter pass
			typeInput(driver.findElement(By.cssSelector("input[placeholder='Password']")), "admin123");
			// click on login btn
			WebElement btn = driver.findElement(By.className("orangehrm-login-button"));
			btn.click();
}
		@Test(priority = 2)
		public void TestCase1_CreatPIM() throws Throwable {
			
			// move to emp listClick on PIM
			clickOnElement(driver.findElement(By.linkText("PIM")));
			// click on add btn
			clickOnElement(driver.findElement(By.cssSelector(".orangehrm-header-container>button")));
			// enter first name
			driver.findElement(By.cssSelector("input[placeholder='First Name']")).sendKeys("ALEX");
			// enter last name
			driver.findElement(By.cssSelector("input[placeholder='Last Name']")).sendKeys("FRANSIS");
			Thread.sleep(500);
			// click on save btn
			clickOnElement(driver.findElement(By.xpath("//button[@type='submit']")));
			// click on emp list
			clickOnElement(driver.findElement(By.xpath("//a[text()='Employee List']")));

		}
		@Test(priority = 3)
		public void TestCase2_Update() throws Throwable {
			
			// Search User in Employee list fisrt
			typeInput(driver.findElement(By.xpath("//input[@placeholder='Type for hints...']")),"ALEX FRANSIS");
			// Click on Search Button
			Thread.sleep(1000);
			clickOnElement(driver.findElement(By.xpath("//button[@type='submit']")));
			
			Thread.sleep(500);
			// After find User, Click on Checkbox, and Edit button
			clickOnElement(driver.findElement(By.className("oxd-checkbox-input")));
			clickOnElement(driver.findElement(By.className("bi-pencil-fill")));
			// Update Job Title
			clickOnElement(driver.findElement(By.xpath("//a[text()='Job']")));
			Thread.sleep(1000);
		//	clickOnElement(driver.findElement(By.linkText("JOBDETAILS")));
			//WebElement JobTitle = driver.findElement(By.xpath("//*[@tabindex='0']"));
			WebElement JobTitle = driver.findElement(By.cssSelector(".oxd-select-text-input"));
			JobTitle.click();
			JobTitle.sendKeys("q");
			//Save the changes
			clickOnElement(driver.findElement(By.xpath("//button[@type='submit']")));
			//Check Employee List
			Thread.sleep(500);
			clickOnElement(driver.findElement(By.xpath("//*[text()='Employee List']")));
			// Search User in Employee list fisrt
			typeInput(driver.findElement(By.xpath("//input[@placeholder='Type for hints...']")),"ALEX FRANSIS");
			// Click on Search Button
			Thread.sleep(1000);
			clickOnElement(driver.findElement(By.xpath("//button[@type='submit']")));
			Thread.sleep(500);

		}
		

		@Test(priority = 4)
		public void TestCase3_Delete() {
			
			
			// After find User, Click on Checkbox, 
			clickOnElement(driver.findElement(By.className("oxd-checkbox-input")));
			clickOnElement(driver.findElement(By.cssSelector("i.bi-trash")));
			clickOnElement(driver.findElement(By.xpath("//*[text()=' Yes, Delete ']")));
			//LogOut--Click On Profile
			clickOnElement(driver.findElement(By.cssSelector("li.oxd-userdropdown")));
			clickOnElement(driver.findElement(By.linkText("Logout")));
			driver.close();
		}
		
}
	