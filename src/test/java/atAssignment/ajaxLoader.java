package atAssignment;

import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;

import java.util.Set;

import org.openqa.selenium.By;

public class ajaxLoader extends chromeDriverInitial{
  @Test(priority=2)
  public void ajaxLoaderAutomation() throws InterruptedException {
	  
	  driver.findElement(By.cssSelector("span[id='button1']")).click();;
	  driver.findElement(By.xpath
			("//div[@id='myModalClick']/div/div/div[3]/button")).click();
	  
  }
  @BeforeTest
  public void setup()
	{
		 driver.get("http://webdriveruniversity.com/index.html");
		    String parentHandle= driver.getWindowHandle();
		    System.out.println("parent window- "+parentHandle);
		    
		    driver.findElement(By.xpath
		    		("//a[@id='ajax-loader']")).click(); 
		
		    
		    Set<String> handles=driver.getWindowHandles();
		    for(String handle:handles) {
			    System.out.println(handles);
			    if(!handle.equals(parentHandle)) {
			    driver.switchTo().window(handle);
			    }
		    }    
	}
  @Test(priority=1)
  public void verifyAjaxLoaderIsDisplayed()
  {
  	Assert.assertTrue(driver.findElement
  			 (By.id("nav-title")).isDisplayed());
  }
  
 

}
