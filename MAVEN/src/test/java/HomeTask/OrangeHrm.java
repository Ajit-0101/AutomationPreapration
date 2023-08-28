package HomeTask;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Utility.SeleniumUtil;

public class OrangeHrm {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = SeleniumUtil.setUp("Chrome",
				"https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

		// validate page title

		String expectedTitle = "OrangeHRM";
		String actutalTitle = driver.getTitle();
		if (actutalTitle.equals(expectedTitle)) {
			System.out.println("Login page validation is passed");
		} else {
			System.out.println("Login page validation is failed");
		}

		// validate username
		WebElement username = driver.findElement(By.cssSelector("input[placeholder='Username']"));
		username.sendKeys("Admin");

		Thread.sleep(1000);
		// enter pass
		WebElement password = driver.findElement(By.cssSelector("input[placeholder='Password']"));
		password.sendKeys("admin123");
		// click on login btn
		WebElement btn = driver.findElement(By.className("orangehrm-login-button"));
		btn.click();
		// move to emp listClick on PIM
		driver.findElement(By.xpath("/html/body/div/div[1]/div[1]/aside/nav/div[2]/ul/li[2]/a")).click();
		// click on add btn
		// driver.findElement(By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div[2]/div[1]/button")).click();
		SeleniumUtil.clickOnElement(
				driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div[1]/button")));
		// enter first name
		driver.findElement(By.cssSelector("input[placeholder='First Name']")).sendKeys("ALEX");

		// enter last name
		driver.findElement(By.cssSelector("input[placeholder='Last Name']")).sendKeys("FRANSIS");

		// enter emp id

		driver.findElement(By.xpath(
				"//*[@id='app']/div[1]/div[2]/div[2]/div/div/form/div[1]/div[2]/div[1]/div[2]/div/div/div[2]/input"))
				.sendKeys("0020");
		// click on save btn
		SeleniumUtil.clickOnElement(driver.findElement(By.xpath("//button[@type='submit']")));
		// driver.findElement(By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div/form/div[2]/button[2]")).click();
		// created
		// click on emp list
		// driver.findElement(By.xpath("/html/body/div/div[1]/div[1]/header/div[2]/nav/ul/li[2]/a")).click();
		SeleniumUtil.clickOnElement(
				driver.findElement(By.xpath("//*[@id='app']/div[1]/div[1]/header/div[2]/nav/ul/li[2]/a")));

		
		// Update User Job Title and Employment Status
		// 1)Click on Edit button
		// SeleniumUtil.clickOnElement(driver.findElement(By.xpath("//*[@id='app']/div[1]/div[2]/div[2]/div/div[2]/div[3]/div/div/div[6]/div/div/div[1]/div[2]/div/div/button[2]")));
//		SeleniumUtil.clickOnElement(driver.findElement(By.xpath(
//				"//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div[3]/div/div/div[26]/div/div/div[1]/div[2]/div/div/button[2]/i")));
//		// Employee Status
//		SeleniumUtil.getDropdown(driver.findElement(By.xpath(
//				"//*[@id='app']/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[3]/div/div[2]/div/div")));

		// Search User in Employee list fisrt
		driver.findElement(By.xpath(
				"//*[@id='app']/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[1]/div/div[2]/div/div/input"))
				.sendKeys("ALEX FRANSIS");
		// Click on Search Button

		SeleniumUtil.clickOnElement(driver
				.findElement(By.xpath("//*[@id='app']/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[2]/button[2]")));
		// After find User, Click on Checkbox, and Edit button
		SeleniumUtil.clickOnElement(driver
				.findElement(By.xpath("//*[@id='app']/div[1]/div[2]/div[2]/div/div[2]/div[3]/div/div/div/div/div")));
		SeleniumUtil.clickOnElement(driver.findElement(By.xpath(
				"//*[@id='app']/div[1]/div[2]/div[2]/div/div[2]/div[3]/div/div[2]/div/div/div[9]/div/button[2]/i")));
		// Update Job Title
		SeleniumUtil.clickOnElement(
				driver.findElement(By.xpath("//*[@id='app']/div[1]/div[2]/div[2]/div/div/div/div[1]/div[2]/div[6]/a")));
		// SeleniumUtil.clickOnElement(driver.findElement(By.xpath("//*[@id='app']/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[1]/div/div[2]/div/div[2]/div/div/div[1]")));
		// SeleniumUtil.clickOnElement(driver.findElement(By.xpath("//*[@id='app']/div[1]/div[2]/div[2]/div/div/div/div[1]/div[2]/div[6]/a")));
		WebElement JobTitle = driver.findElement(By.xpath(
				"//*[@id='app']/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[1]/div/div[2]/div/div[2]/div/div/div[1]"));
		JobTitle.click();
		JobTitle.sendKeys("q");
		// JobTitle.sendKeys(Keys.ENTER);
		SeleniumUtil.clickOnElement(driver.findElement(By.xpath("//*[@id='app']/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[3]/button")));
		 Thread.sleep(5000);
//		 WebElement SubUnit=   driver.findElement(By.xpath("//*[@id='app']/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[1]/div/div[5]/div/div[2]/div/div"));
//		 SubUnit.click();
//		 SubUnit.sendKeys("q");
//	
//	 SeleniumUtil.clickOnElement(driver.findElement(By.xpath("//*[@id='app']/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[3]/button")));
////	//Check Employee List
		SeleniumUtil.clickOnElement(
				driver.findElement(By.xpath("//*[@id='app']/div[1]/div[1]/header/div[2]/nav/ul/li[2]/a")));

		// Thread.sleep(20000);
//		 Dropdown.sendKeys(Keys.chord(Keys.ARROW_DOWN,Keys.ARROW_DOWN,Keys.ENTER));
//		 SeleniumUtil.clickOnElement(driver.findElement(By.xpath("//*[@id='app']/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[3]/button")));
//		 

		// Search User in Employee list fisrt
		driver.findElement(By.xpath(
				"//*[@id='app']/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[1]/div/div[2]/div/div/input"))
				.sendKeys("ALEX FRANSIS");

		// Click on Search Button

		SeleniumUtil.clickOnElement(driver.findElement(By.xpath("//*[@id='app']/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[2]/button[2]")));
		 Thread.sleep(1000);
		// After find User, Click on Checkbox
		SeleniumUtil.clickOnElement(driver.findElement(By.xpath("//*[@id='app']/div[1]/div[2]/div[2]/div/div[2]/div[3]/div/div/div/div/div")));

		// delete
 SeleniumUtil.clickOnElement(driver.findElement(By.xpath("//*[@id='app']/div[1]/div[2]/div[2]/div/div[2]/div[2]/div/div/button")));
//to click on OK button again switch to alert
	
 //driver.switchTo().alert().accept();
		 SeleniumUtil.clickOnElement(driver.findElement(By.xpath("//*[@id='app']/div[3]/div/div/div/div[3]/button[2]")));
	//Log OUT --First Click on profile---> Click on LOOut Button
		 SeleniumUtil.clickOnElement(driver.findElement(By.xpath("//*[@id='app']/div[1]/div[1]/header/div[1]/div[2]/ul/li")));
		 SeleniumUtil.clickOnElement(driver.findElement(By.xpath("//*[@id='app']/div[1]/div[1]/header/div[1]/div[2]/ul/li/ul/li[4]/a")));
		 
	}
}
