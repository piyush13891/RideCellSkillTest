package RideCellSkillTest.RideCellSkillTest;
import java.util.TreeMap;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import PageObjects.GitHubProjectPage;
import WebServiceObjects.APITestBase;
import WebServiceObjects.RepositoriesAPI;

import java.lang.reflect.Method;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import utility.ExtentreportManager;
import utility.TestBase;

public class IntegrationTests1 extends TestBase{
	
	
	WebDriver driver;	
	GitHubProjectPage gitProjectPage;
	APITestBase RA;
	RequestSpecBuilder reqSpec;
	
	@BeforeTest
	public void setup(){
		
		RA = APITestBase.getInstance();	
		driver=getDriver();
	}
	
	@AfterTest
	public void TearDown(){
		driver.quit();		
	}
	
	@Test 
	public void repositoryDetailsTest(Method method) {
	  	
		ExtentTest extentTest = ExtentreportManager.startTest(method.getName(), "Repository details comparision test.");
		
		//Get repository data using UI 
		
		gitProjectPage = new GitHubProjectPage(driver);	
		
		gitProjectPage.goToRepositoryPage();			
		TreeMap<String, String> repoDetailUI = gitProjectPage.getRepositoriesDetailsUI();		
		extentTest.log(LogStatus.INFO, "This is Repository details from UI : " +  repoDetailUI);
		
		//get repository Details using API
		reqSpec = RA.getBaseRequestSpec();
		
		RepositoriesAPI repoAPI = new RepositoriesAPI();
		reqSpec = repoAPI.setBasePath(reqSpec);
		Response response = repoAPI.getRepositoryDataAPI(reqSpec.build());
		
		TreeMap<String, String> repoDetailAPI = repoAPI.extractDetailsAPI(response);
		extentTest.log(LogStatus.INFO, "This is Repository details from UI : " +  repoDetailAPI);
		
		if(repoDetailUI.equals(repoDetailAPI)){
			extentTest.log(LogStatus.PASS, "UI and API data are match.");
		}
		else{
			extentTest.log(LogStatus.PASS, "UI and API data are not matching. \nExpected : " + repoDetailAPI + "\nActual : " + repoDetailUI);
		}
	}
}
