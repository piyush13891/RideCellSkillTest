package PageObjects;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import java.util.List;
import java.util.TreeMap;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GitHubProjectPage extends RideCellBase{

	WebDriver driver;	
	WebDriverWait wait;
	String baseURL = "https://github.com/django";
	
	//Elements 
	@FindBy(xpath="//*[@class = 'org-repos repo-list']/ul/li")
	List<WebElement> ownedRepositoryList;
	
	public GitHubProjectPage(WebDriver driver){
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	 /**
	  * METHODS
	  */
	
	/**
	 * Launch repositories page
	 */
	public void goToRepositoryPage(){
		driver.get(baseURL);
		driver.manage().window().maximize();
		verifyPageTitle();
	}
	
	/**
	 * Get page title
	 * @return
	 */
	public String getPageTitle() {
		String title = driver.getTitle();
		return title;
	}
	
	/**
	 * verify Page title
	 */
	public void verifyPageTitle(){
			assertEquals(getPageTitle(), "Django · GitHub", "Page title is not correct.");
	}
	
	/**
	 * Retrieve Repository Name and description as Key-Value Pair
	 * @return
	 */
	public TreeMap<String, String> getRepositoriesDetailsUI(){
				
		assertTrue(ownedRepositoryList.size()>0,"No associated repositories");	    
		TreeMap<String,String> repoDetailsUI= new TreeMap<String,String>();
		
		for(WebElement repo : ownedRepositoryList){
			
			String name = repo.findElement(By.xpath(".//a[contains(@itemprop, 'name')]")).getText();
			String description = null;
			
			//Checking for size as description is optional
			if(repo.findElements(By.xpath(".//p[contains(@itemprop, 'description')]")).size()>0){
				description = repo.findElement(By.xpath(".//p[contains(@itemprop, 'description')]")).getText();
			}
			repoDetailsUI.put(name,description);
		}		
		return repoDetailsUI;		
	}
	
	
		
}
