package Test;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.AccountPage;
import pageObjects.LandingPage;
import pageObjects.LoginPage;
import utilities.Base;

public class LoginTest extends Base {

	WebDriver driver;
	LandingPage landingPage;
	LoginPage loginPage;
	AccountPage accountpage;
	
	@BeforeMethod
	public void Setup() throws IOException {
		driver = initializeBrowser();
		driver.get(prop.getProperty("url"));
		landingPage = new LandingPage(driver);
		loginPage = new LoginPage(driver);
		accountpage= new AccountPage(driver);

		
	}
	@Test(dataProvider="getData")
	public void login(String email, String Password ,String expectedResult) throws IOException {

		
		landingPage.getMyAccount().click();
		landingPage.getLoginOption().click();
		loginPage.getEmailfield().sendKeys(email);
		loginPage.getPasswordfiled().sendKeys(Password);
		loginPage.getLoginButton().click();
		
		 String acutualResult=null;
		try {
				
				if(accountpage.getAccountInfo().isDisplayed()) {
				   acutualResult = "Success";
				}
				
			}catch(Exception e) {
				
				acutualResult = "Failure";
				
			}
			
			Assert.assertEquals(acutualResult,expectedResult);
		// driver.close();
	
	}
	@AfterTest
	public void teardown()
	{
		driver.close();
	}
	
	@DataProvider
	public Object[][] getData() {
		
		Object[][] data= new Object[2][3];
		
		data[0][0]="ajitsawant12@gmail.com";
		data[0][1]="Second123";
		data[0][2]="Success";
		data[1][0]="ajitsawant@gmail.com";
		data[1][1]="Second222123";
		data[1][2]="Failure";
		
	return data;
		
	}
}