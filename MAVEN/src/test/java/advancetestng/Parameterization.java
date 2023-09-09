package advancetestng;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Utilities.SeleniumUtility;


public class Parameterization extends SeleniumUtility {
	
	@Parameters({ "browser" })
	@Test
	public void testCaseOne(String browser) {
		System.out.println("browser passed as :- " + browser);
	}
	@Parameters({ "username", "password" })
	@Test
	public void testCaseTwo(String username, String password) {
		System.out.println("Parameter for User Name passed as :- " + username);
		System.out.println("Parameter for Password passed as :- " + password);
	}
	@Parameters({"browser", "username", "password" ,"URL"})
	@Test
	public void testCaseThree(String browser,String username, String password, String URL) {
		System.out.println("Browser name: "+browser);
		System.out.println("URL name: "+URL);
		System.out.println("Parameter for User Name passed as :- " + username);
		System.out.println("Parameter for Password passed as :- " + password);
	}
	@Parameters({"browser", "username", "password" ,"URL"})
	@Test
	public void testLoginOfVtiger(String browser,String username, String password, String URL) {
		setUp(browser,URL);
			
			driver.findElement(By.id("username")).clear();
			driver.findElement(By.id("username")).sendKeys(username);
			driver.findElement(By.id("password")).clear();
			driver.findElement(By.id("password")).sendKeys(password,Keys.ENTER);
	}
}