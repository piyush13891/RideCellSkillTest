package utility;

import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import org.openqa.selenium.OutputType;
import com.relevantcodes.extentreports.LogStatus;

import utility.ExtentreportManager;
import utility.TestBase;

public class TestListener implements ITestListener {

	public void onStart(ITestContext context) {	
		System.out.println("onStart method started" +  context.getName());
	}

	public void onFinish(ITestContext context) {
		System.out.println("onFinish method started" +  context.getName());
		ExtentreportManager.endTest();
        ExtentReportBase.getInstance().flush();
	}
	
	public void onTestStart(ITestResult result) {
		System.out.println("New Test Started" +result.getName());
	}
	
	public void onTestSuccess(ITestResult result) {
		System.out.println("onTestSuccess Method" +result.getName());
		ExtentreportManager.getTest().log(LogStatus.PASS, "Test passed");
	}

	public void onTestFailure(ITestResult result) {
		 //Get driver from BaseTest and assign to local webDriver variable.
        Object testClass = result.getInstance();
        WebDriver webDriver = ((TestBase) testClass).getDriver();
 
        //Take base64Screenshot screenshot.
        String base64Screenshot = ((TakesScreenshot) webDriver).getScreenshotAs(OutputType.BASE64);
 
        //ExtentReports log and screenshot operations for failed tests.
        ExtentreportManager.getTest().log(LogStatus.FAIL, "Test Failed",
        ExtentreportManager.getTest().addBase64ScreenShot(base64Screenshot));
		
	}

	public void onTestSkipped(ITestResult result) {
		System.out.println("onTestSkipped Method" +result.getName());
		ExtentreportManager.getTest().log(LogStatus.SKIP, "Test Skipped");
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		System.out.println("onTestFailedButWithinSuccessPercentage" +result.getName());
	}
}