package atAssignment;

import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;

public class LoginPortalTest extends chromeDriverInitial {
	@BeforeTest
	public void setup() {
		driver.get("http://webdriveruniversity.com/index.html");
	    String parentHandle= driver.getWindowHandle();
	    System.out.println("parent window- "+parentHandle);
	    driver.findElement(By.xpath("//a[@id='login-portal']")).click(); 
	    
	 
	    
	    Set<String> handles=driver.getWindowHandles();
	    for(String handle:handles) {
		    System.out.println(handles);
		    if(!handle.equals(parentHandle)) {
		    driver.switchTo().window(handle);
		    }
	    }
	
	}	
  @Test(priority=2)
  public void loginPortalAutomation() throws InterruptedException{
	  LoginPortal lp=new LoginPortal(driver);
	    
	//entering username and pass	    
		    lp.keys();
	//clicking login button	    		    
		    lp.clickLoginBtn();
		    WebDriverWait wait= new WebDriverWait
		    		(driver,Duration.ofSeconds(30));
		    wait.until(ExpectedConditions.alertIsPresent());
		   
		   lp.handleAlert();
		   
		   

	    }
	    
  

  
  @Test(priority=1)
  public void verifyLoginFormIsDisplayed()
  {
	 Assert.assertTrue(driver.findElement(By.cssSelector
			 (".form")).isDisplayed());
	
  }

 
  
  
}

