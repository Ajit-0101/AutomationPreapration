
package datadriventesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Utilities.SeleniumUtility;
import utilitiesExcel.ExcelUtility;
public class ActitimeLogin extends SeleniumUtility{	
	String appUrl;
	String userName;
	String password;
	static int row=3;
	static String expectecTitle;
	static String actualTitle;
	@BeforeMethod
	public void getData() {
		appUrl=ExcelUtility.getCellValue(".\\src\\test\\resources\\AppTest.xlsx", "TC", row, 0);
		userName=ExcelUtility.getCellValue(".\\src\\test\\resources\\AppTest.xlsx", "TC", row, 1);
		password=ExcelUtility.getCellValue(".\\src\\test\\resources\\AppTest.xlsx", "TC", row, 2);
		expectecTitle=ExcelUtility.getCellValue(".\\src\\test\\resources\\AppTest.xlsx", "TC", row, 3);
	}
	@Test
	public void testActitimeLogin() {
			setUp("chrome", appUrl);	
			typeInput(driver.findElement(By.id("username")), userName);
			typeInput(driver.findElement(By.name("pwd")), password);
			clickOnElement(driver.findElement(By.id("loginButton")));
			actualTitle=getCurrentTitleOfApplication("actiTIME - Enter Time-Track");
			Assert.assertEquals(actualTitle, "actiTIME - Enter Time-Track");
	}
	@AfterMethod
	public void cleanUp1() {
		ExcelUtility.updateExcelContent(".\\src\\test\\resources\\AppTest.xlsx", "TC", row, 4,actualTitle);
		if(actualTitle.equals("actiTIME - Enter Time-Track")) {
			ExcelUtility.updateExcelContent(".\\src\\test\\resources\\AppTest.xlsx", "TC", row, 5,"Passed");
		}else {
			ExcelUtility.updateExcelContent(".\\src\\test\\resources\\AppTest.xlsx", "TC", row, 5,"failed");
		}
		cleanUp();
		++row;
	}
}