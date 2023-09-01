package datadriventesting;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import Utilities.SeleniumUtility;

public class Example1 extends SeleniumUtility{

	@Test
	public void uploadFile() {
		setUp("chrome", "https://demo.automationtesting.in/Register.html");
		driver.findElement(By.id("imagesrc")).sendKeys("C:\\Users\\Asus\\Desktop\\download.png");
	}

}