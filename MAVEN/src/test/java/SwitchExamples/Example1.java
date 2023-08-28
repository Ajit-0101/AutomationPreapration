package SwitchExamples;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Utility.SeleniumUtil;

public class Example1 {

	public static void main(String[] args) {
	WebDriver driver=SeleniumUtil.setUp("chrome", "https://demo.actitime.com/login.do");
		
		//get active element from the application
		WebElement element=driver.switchTo().activeElement();
		String activeElementPlaceholderValue=SeleniumUtil.getAttributeForElement(element, "placeholder");
		System.out.println("Is mouse pointer available in username input field? "+
				activeElementPlaceholderValue.equals("Username"));	
		//check keyboard events, type admin and press TAB button
		element.sendKeys("admin",Keys.TAB);
		//now contril will be in password field, type manager and press ENTER button
		driver.switchTo().activeElement().sendKeys("manager",Keys.ENTER);
//SeleniumUtil.typeInput(SeleniumUtil.getAct
	}
}