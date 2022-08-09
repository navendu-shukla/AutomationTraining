package atAssignment;

import org.testng.annotations.Test;
import org.testng.Assert;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;

public class ActionsCommandTest extends chromeDriverInitial{
	  @BeforeTest
	  public void setup()
		{
			 driver.get("http://webdriveruniversity.com/index.html");
			    String parentHandle= driver.getWindowHandle();
			    System.out.println("parent window- "+parentHandle);
			    
			    driver.findElement(By.cssSelector
			    		("a[id='actions']")).click(); 
			
			    
			    Set<String> handles=driver.getWindowHandles();
			    for(String handle:handles) {
				    System.out.println(handles);
				    if(!handle.equals(parentHandle)) {
				    driver.switchTo().window(handle);
				    }
			    }    
		}
  @Test(priority=2)
  public void actionsAutomation() throws InterruptedException {
	  ActionCommand act=new ActionCommand();
	  //drag and drop action
	  WebElement source=driver.findElement(act.source);
	  WebElement target=driver.findElement(act.target);
	  act.dragDrop(source, target);
	  //double click
	  act.doubleClick();
	  

	  //hover over 1st button
	  act.hover(act.hover1);
	  

	  act.clickHoverLink(act.hvr1Link1);
	  
	   //Using Alert class to first switch to or focus to the alert box  
	  act.handleAlert();  
		  

	//hover over 2nd button
		act.hover(act.hover2);
			  
		
			  act.clickHoverLink(act.hvr2Link1);
	  
	//Using Alert class to first switch to or focus to the alert box  
	   act.handleAlert();
		  

	//hover over 3rd button
	   act.hover(act.hover3);
		  

		  act.clickHoverLink(act.hvr3Link1);
	  
	//Using Alert class to first switch to or focus to the alert box  
	   act.handleAlert(); 
		  

	   act.hover(act.hover3);
		  

		  act.clickHoverLink(act.hvr3Link2);
	  
	//Using Alert class to first switch to or focus to the alert box  
	   act.handleAlert();
		  
		  
		  //click and hold button
		  act.holdClickHold();

	
	  
	
  }

  @Test(priority=1)
  public void verifyActionsHeaderIsDisplayed()
  {
  	Assert.assertTrue(driver.findElement
  			 (By.id("nav-title")).isDisplayed());
  }
  
 
  
}
