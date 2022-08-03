package atAssignment;

import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;

public class loginPortal extends chromeDriverInitial {
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
	    
	//entering username and pass	    
		    driver.findElement(By.cssSelector
		    ("input[placeholder='Username']")).sendKeys("webdriver");
		    
		    driver.findElement(By.xpath
		    ("//input[@placeholder='Password']")).sendKeys("webdriver123");
	//clicking login button	    		    
		    driver.findElement(By.cssSelector
		    		("button[id='login-button']")).click();
		    WebDriverWait wait= new WebDriverWait
		    		(driver,Duration.ofSeconds(30));
		    wait.until(ExpectedConditions.alertIsPresent());
		   
		    Alert al=driver.switchTo().alert();
		    al.accept();
		   
		   

	    }
	    
  

  
  @Test(priority=1)
  public void verifyLoginFormIsDisplayed()
  {
	 Assert.assertTrue(driver.findElement(By.cssSelector
			 (".form")).isDisplayed());
	
  }

 
  
  
}

