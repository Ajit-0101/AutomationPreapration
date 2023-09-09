package H_TestNg;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Utilities.SeleniumUtility;

public class ActiTime extends SeleniumUtility {
WebDriver driver;

@BeforeTest
 public void start() {
driver=setUp("chrome", "https://demo.actitime.com/login.do");
 }

@Test(priority=1)
public void login() {
driver.findElement(By.xpath("//input[@id='username']")).sendKeys(" admin");
driver.findElement(By.name("pwd")).sendKeys("manager");
driver.findElement(By.id("loginButton")).click();
}
@Test(priority=2)
public void Addnewelement(){
driver.findElement(By.id("addTaskButtonId")).click();
driver.findElement(By.xpath("//input[@class='inputFieldWithPlaceholder' and @maxlength='255' and @placeholder='Enter task name'][1]")).sendKeys("");
driver.findElement(By.className("commitButtonPlaceHolder")).click();
}
@Test(priority=3)
public void Editelement(){
driver.findElement(By.xpath("(//input[@class='text inputTT'])[4]")).sendKeys("24");
driver.findElement(By.xpath("//input[@class='saveButton submitTTSaveButton']")).click();
}
@Test(priority=4)
public void Deletelement() throws InterruptedException{
   driver.findElement(By.xpath("//a[@class='content tasks']")).click();
   driver.findElement(By.xpath("(//input[@placeholder='Start typing name ...'])[2]")).sendKeys("keval");
   Thread.sleep(200);
   driver.findElement(By.className("checkmark")).click();
   driver.findElement(By.xpath("//div[@class='delete button']")).click();
   driver.findElement(By.xpath("(//div[@class='buttonIcon'])[5]")).click();
}
}