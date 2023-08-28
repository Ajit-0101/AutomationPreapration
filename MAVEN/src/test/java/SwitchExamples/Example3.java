package SwitchExamples;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Utility.SeleniumUtil;

public class Example3 {

	public static void main(String[] args)  {
		WebDriver driver=SeleniumUtil.setUp("chrome", "https://jqueryui.com/");
		
		SeleniumUtil.clickOnElement(driver.findElement(By.xpath("//a[text()='Draggable']")));
		System.out.println("Draggable page url: "+SeleniumUtil.getApplicationUrl());
		
		//DragElement is present inside the Frame, 1st identify the frame
		WebElement frameObject=driver.findElement(By.cssSelector(".demo-frame"));
	driver.switchTo().frame(frameObject);
				//or
	//	driver.switchTo().frame(0);
		
		//now the control is in Frame, you are allowed to perform any operation inside the frame
		WebElement elementToDrag=driver.findElement(By.id("draggable"));
		SeleniumUtil.action.dragAndDropBy(elementToDrag, 200, 0).build().perform();
		
		//As your control is in frame you are not allowed to perform any operation out side the frame
		//so now switch your control back to main page
		driver.switchTo().defaultContent();
		SeleniumUtil.clickOnElement(driver.findElement(By.cssSelector(".logo")));		
		System.out.println("Home page url: "+SeleniumUtil.getApplicationUrl());
	}

}
/**
open any browser and enter the application url as https://jqueryui.com/
click on Draggable and print the url
drag the object
click on application logo and get the url
*/
