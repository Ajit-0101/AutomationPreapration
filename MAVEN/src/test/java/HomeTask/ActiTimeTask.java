package HomeTask;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import Utility.SeleniumUtil;

public class ActiTimeTask {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = SeleniumUtil.setUp("chrome", "https://demo.actitime.com/login.do");
		// type user name as admin
		driver.findElement(By.id("username")).sendKeys("admin");
		// type password as manager
		driver.findElement(By.name("pwd")).sendKeys("manager");
		// click on login button
		driver.findElement(By.id("loginButton")).click();

		// Identify Task and Click on it (Create, Edit, Delete)
		driver.findElement(By.id("container_tasks")).click();
		// Create--Add new Task .clik on add New Down icon

		SeleniumUtil.clickOnElement(driver
				.findElement(By.xpath("//*[@id='taskManagementPage']/div[1]/div[1]/div[1]/div[1]/div[3]/div/div[3]")));

		// Click on New Task Dropdown
		SeleniumUtil.clickOnElement(driver.findElement(By.xpath("/html/body/div[19]/div[3]")));
		Thread.sleep(500);
		// 1) Select project
		SeleniumUtil.clickOnElement(driver.findElement(By.xpath("//*[@id='createTasksPopup_content']/div[1]/div[1]/div/div[1]/div/table/tbody/tr[1]/td[1]/div/div/div[1]/div[1]")));
		// 1) Select project new Project
		SeleniumUtil.clickOnElement(driver.findElement(By.cssSelector(".customerSelector > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1)")));
		//Enter Customer NAme
	//	driver.findElement(By.cssSelector("input[placeholder='Enter Customer Name']")).sendKeys("BAJAJ");
	     SeleniumUtil.typeInput	(driver.findElement(By.cssSelector("td>input[placeholder='Enter Customer Name']")), "BAJAJ") ;
		//Enter New Project NAme
	 	SeleniumUtil.typeInput(driver.findElement(By.cssSelector("td>input[placeholder='Enter Project Name']")), "TESTING");	
	 	//Enter Task Name
	 	SeleniumUtil.typeInput(driver.findElement(By.cssSelector("input[placeholder='Enter task name']")), "TESTCASE1");
		//Save New Task
	 	SeleniumUtil.clickOnElement( driver.findElement(By.xpath("//div[text()='Create Tasks']")));
	 	//Update Status Of Created task
	 	SeleniumUtil.clickOnElement(driver.findElement(By.xpath("//*[@id='taskListBlock']/div[2]/div[1]/div[1]/div/div[1]/div[1]/div[1]/div[1]/table/tbody/tr/td[3]/div/div/div")));
		//Change Status New to Done
	 SeleniumUtil.clickOnElement(driver.findElement(By.xpath("//*[@class='workflowStatusNode']")));
	 Thread.sleep(2000);
	 	//Click On Check box
	 		SeleniumUtil.clickOnElement(driver.findElement(By.xpath("//td[@class='selection']")));
//Delet Task
	 SeleniumUtil.clickOnElement(driver.findElement(By.className("delete")));
	 	//td[@class='selection']
		SeleniumUtil.clickOnElement(driver.findElement(By.xpath("//*[@id='taskManagementPage']/div[2]/div[2]/div[1]/div[1]/div/div[5]/div[1]/div")));
		//Delete Project--1)Search Project
		//Click on Project
		SeleniumUtil.typeInput(driver.findElement(By.cssSelector("input[placeholder='Start typing name ...']")), "BAJAJ");
		SeleniumUtil.clickOnElement(driver.findElement(By.xpath("//*[@id='taskManagementPage']/div[1]/div[1]/div[2]/div/div[3]/div/div[1]/div[2]/div[1]")));
		Thread.sleep(1000);
		
			//Click On Edit Button
		SeleniumUtil.clickOnElement(driver.findElement(By.xpath("//*[@id='taskManagementPage']/div[1]/div[1]/div[2]/div/div[3]/div/div[1]/div[2]/div[1]/div[4]")));
		//Click On Action Button
		SeleniumUtil.clickOnElement(driver.findElement(By.xpath("//*[text()='ACTIONS']")));
		//click for delete
		driver.findElement(By.className("deleteButton")).click();
		SeleniumUtil.clickOnElement(driver.findElement(By.xpath("//*[text()='Delete permanently']")));
		Thread.sleep(1000);
		//LogOut
		SeleniumUtil.clickOnElement(driver.findElement(By.className("logout")));
		Thread.sleep(500);
		driver.close();
		
		
		
		
		
		
		
		
		
		
		
		
		
		
/*
		  List<WebElement> optionList=driver.findElements(By.xpath( "//*[@id='createTasksPopup_content']/div[1]/div[1]/div/div[1]/div/table/tbody/tr[3]/td[1]/div/div/div[2]/div/div[1]/div")); 
		  System.out.println("Option count: "+optionList.size());
		  optionList.get(0).getText();
		  for(int i=0;i<optionList.size();i++) {
		  System.out.println(optionList.get(i).getText());
		  
		  }
*/
	}

}
