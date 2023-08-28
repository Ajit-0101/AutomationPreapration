package SwitchExamples;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Utility.SeleniumUtil;

public class Example6 {

	public static void main(String[] args) {
		WebDriver driver=SeleniumUtil.setUp("chrome", "https://www.w3schools.com/js/tryit.asp?filename=tryjs_prompt");
		//first switch to the frame to perform action on the element present inside the frame
		driver.switchTo().frame("iframeResult");
		//click on try it button
		SeleniumUtil.clickOnElement(driver.findElement(By.xpath("//button[text()='Try it']")));
		//get text from the alert
		System.out.println("Alert text is: "+driver.switchTo().alert().getText());
		//type some text in popup
		driver.switchTo().alert().sendKeys("Pune");
		//to click on OK button again switch to alert
		//driver.switchTo().alert().accept();
		//to click on CANCEL button again switch to alert
		driver.switchTo().alert().dismiss();
	}
}
/**
open any browser and enter the application url as https://www.w3schools.com/js/tryit.asp?filename=tryjs_alert
click on tryit button
get the text from popup
click ok button
*/