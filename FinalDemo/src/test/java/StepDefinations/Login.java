package StepDefinations;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.AccountPage;
import pageObjects.LandingPage;
import pageObjects.LoginPage;
import utilities.Base;

public class Login extends Base{
	
	WebDriver driver;
	LandingPage landingPage;
	LoginPage loginPage;
	AccountPage accountPage;
	
	@Given("^Open any Browser$")
    public void open_any_browser() throws IOException  {
		
		driver = initializeBrowser();
        
    }
	
	 @And("^Navigate to Login page$")
	 public void navigate_to_login_page() throws InterruptedException  {
		 
		 driver.get(prop.getProperty("url"));
		 landingPage = new LandingPage(driver);
		 landingPage.getMyAccount().click();
		 landingPage.getLoginOption().click();
		 Thread.sleep(3000);
	       
	 }

    @When("^User enters username as \"([^\"]*)\" and password as \"([^\"]*)\" into the fields$")
    public void user_enters_username_as_something_and_password_as_something_into_the_fields(String email, String password)  {
    	
    	loginPage = new LoginPage(driver);
		loginPage.getEmailfield().sendKeys(email);
		loginPage.getPasswordfiled().sendKeys(password);
		
        
    }

    @And("^User clicks on Login button$")
    public void user_clicks_on_login_button()  {
       
    	loginPage.getLoginButton().click();
    	
    }
    
    @Then("^Verify user is able to successfully login$")
    public void verify_user_is_able_to_successfully_login() {
    	
    	accountPage = new AccountPage(driver);
    	Assert.assertTrue(accountPage.getAccountInfo().isDisplayed());
    	
    }
    
    @After
    public void closure() {
    	
    	driver.close();
    	
    }

}