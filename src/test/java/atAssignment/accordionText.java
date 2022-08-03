package atAssignment;

import org.testng.annotations.Test;
import org.testng.Assert;
import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;

public class accordionText extends chromeDriverInitial{
	@BeforeTest
	public void setup() {
		driver.get("http://webdriveruniversity.com/index.html");
	    String parentHandle= driver.getWindowHandle();
	    System.out.println("parent window- "+parentHandle);
	    
	    driver.findElement(By.cssSelector
	    		("a[href='Accordion/index.html']")).click(); 
	
	    
	    Set<String> handles=driver.getWindowHandles();
	    for(String handle:handles) {
		    System.out.println(handles);
		    if(!handle.equals(parentHandle)) {
		    driver.switchTo().window(handle);
		    }
	    }
	
	}
  @Test(priority=2)
  public void pomAutomation() throws InterruptedException {
	    
	//clicking on all buttons
		    driver.findElement(By.cssSelector
		    		("button[id=manual-testing-accordion]")).click();
		    driver.findElement(By.cssSelector
		    		("button[id=cucumber-accordion]")).click();
		    driver.findElement(By.cssSelector
		    		("button[id=automation-accordion]")).click();
	//explicit wait on keep clicking button
		    WebDriverWait wait= new WebDriverWait
		    		(driver,Duration.ofSeconds(30));
		    wait.until(ExpectedConditions.textToBePresentInElementLocated
		    (By.xpath("//p[@id='hidden-text']"),"LOADING COMPLETE."));
		    //Thread.sleep(11000);
		    driver.findElement(By.cssSelector
		    		("button[id=click-accordion]")).click();
		    
		 

	    
	    
	    
}
  @Test(priority=1)
  public void verifyAccordionTitleIsDisplayed()
  {
  	Assert.assertTrue(driver.findElement
  			 (By.id("nav-title")).isDisplayed());
  }
  
  
}

