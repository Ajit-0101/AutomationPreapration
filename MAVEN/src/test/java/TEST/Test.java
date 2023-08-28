package TEST;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test {

	public static void main(String[] args) {
	
	//ChromeOptions chromeOptions = new ChromeOptions();
	WebDriverManager.chromedriver().setup();
	System.out.println("##########");
	WebDriver driver = new ChromeDriver();
	System.out.println("##########");
	
	driver.get("https://demo.actitime.com/login.do");
	
	//driver.quit();
	
	}
}
