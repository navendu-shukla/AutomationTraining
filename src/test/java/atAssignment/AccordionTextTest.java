package atAssignment;

import org.testng.annotations.Test;
import org.testng.Assert;
import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;

public class AccordionTextTest extends chromeDriverInitial{
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
	    
	  		AccordionText acc=new AccordionText(driver);
	//clicking on all buttons
		   acc.clickBtn(acc.btn1);
		   acc.clickBtn(acc.btn2);
		   acc.clickBtn(acc.btn3);
	//explicit wait on keep clicking button
		    WebDriverWait wait= new WebDriverWait
		    		(driver,Duration.ofSeconds(30));
		    wait.until(ExpectedConditions.textToBePresentInElementLocated
		    (acc.loadingStatus,"LOADING COMPLETE."));
		    
		    acc.clickBtn(acc.btn4);
		    	    
		 

	    
	    
	    
}
  @Test(priority=1)
  public void verifyAccordionTitleIsDisplayed()
  {
  	Assert.assertTrue(driver.findElement
  			 (By.id("nav-title")).isDisplayed());
  }
  
  
}

