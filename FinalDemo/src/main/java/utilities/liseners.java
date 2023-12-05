package utilities;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class liseners extends Base implements ITestListener {
//	ExtendReports.
	WebDriver driver;
	String testMethodName;
	ExtentReports extendReport = ExtendReports.getExtentReport();;
	ExtentTest extendTest;
	ThreadLocal<ExtentTest> extentTestThread = new ThreadLocal<ExtentTest>();
	public void onTestStart(ITestResult result) {

		String testName = result.getName();
		extentTestThread.set( extendReport.createTest(testName ));
	//extendTest = extendReport.createTest(testName );

	}

	public void onTestSuccess(ITestResult result) {
		String testName = result.getName();
	//	extendTest.log(Status.PASS, testName + " Test got Pass");
		extentTestThread.get().log(Status.PASS,"Test Passed");

	}

	public void onTestFailure(ITestResult result) {
		
		
	//	extendTest.log(Status.FAIL," Test got Fail");
	//	extendTest.fail(result.getThrowable());
		extentTestThread.get().fail(result.getThrowable());

		String testMethodName = result.getName();

		try {
			driver = (WebDriver) result.getTestClass().getRealClass().getDeclaredField("driver")
					.get(result.getInstance());
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			String screenshotFilePath = takeScreenshot(testMethodName,driver);
			extentTestThread.get().addScreenCaptureFromPath(screenshotFilePath, testMethodName);
		} catch (IOException e) {

			e.printStackTrace();
		}
		

	}

	public void onTestSkipped(ITestResult result) {

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}

	public void onTestFailedWithTimeout(ITestResult result) {

	}

	public void onStart(ITestContext context) {

	}

	public void onFinish(ITestContext context) {
		extendReport.flush();

	}

}
