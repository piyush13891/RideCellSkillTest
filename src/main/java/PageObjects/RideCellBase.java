package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RideCellBase {
	
	 public WebDriver driver;
	 public WebDriverWait wait;
	
	public RideCellBase(WebDriver driver){
		
		 this.driver = driver;
	     wait = new WebDriverWait(driver, 10);
	}	
	
	 //Wait
    public void waitVisibility(By by){
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }
    
}
