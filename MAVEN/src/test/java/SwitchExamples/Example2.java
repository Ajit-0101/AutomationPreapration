package SwitchExamples;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Utility.SeleniumUtil;

public class Example2 {

	public static void main(String[] args) {
		//WebDriver driver=SeleniumUtil.setUp("chrome", "https://demo.actitime.com/login.do");
		WebDriver driver=SeleniumUtil.setUp("firefox", "https://demo.actitime.com/login.do");
		
		//get active element from the application		
		WebElement element=SeleniumUtil.getActiveElementFromScreen();
		String activeElementPlaceholderValue=SeleniumUtil.getAttributeForElement(element, "placeholder");
		System.out.println("Is mouse pointer available in username input field? "+
				activeElementPlaceholderValue.equals("Username"));	
		//check keyboard events, type admin and press TAB button
		SeleniumUtil.typeInput(element, "admin");
		element.sendKeys(Keys.TAB);
		//now contril will be in password field, type manager and press ENTER button
		SeleniumUtil.typeInput(SeleniumUtil.getActiveElementFromScreen(), "manager");
		SeleniumUtil.getActiveElementFromScreen().sendKeys(Keys.ENTER);

	}
}