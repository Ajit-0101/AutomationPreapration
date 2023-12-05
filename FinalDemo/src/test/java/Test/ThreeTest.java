package Test;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import utilities.Base;

public class ThreeTest extends Base {
	public WebDriver driver;
	@Test
	public void testThree() throws IOException {
		System.out.println("Test Three execute");
		driver = initializeBrowser();
		driver.get(prop.getProperty("url"));
	
		Assert.assertTrue(false);
	}
	@AfterTest
	public void teardown()
	{
		driver.close();
	}
	
}
