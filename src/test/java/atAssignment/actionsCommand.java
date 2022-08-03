package atAssignment;

import org.testng.annotations.Test;
import org.testng.Assert;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;

public class actionsCommand extends chromeDriverInitial{
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
	  //drag and drop action
	  WebElement source=driver.findElement
			  (By.cssSelector("div[id='draggable']"));
	  WebElement target=driver.findElement
			  (By.cssSelector("div[id='droppable']"));
	  Actions ac=new Actions(driver);
	  ac.dragAndDrop(source, target).perform();
	  
	  //double click
	  ac.doubleClick(driver.findElement
			  (By.cssSelector("div[id='double-click']"))).perform();
	  

	  //hover over 1st button
	  ac.moveToElement(driver.findElement
			  (By.xpath("//div[@id='div-hover']/div[1]"))).perform();
	  

	  ac.click(driver.findElement
			  (By.xpath("//div[@id='div-hover']/div[1]/div/a"))).perform();
	  
	   //Using Alert class to first switch to or focus to the alert box  
	  Alert alert = driver.switchTo().alert();  
	            
	      //Using accept() method to accept the alert box  
	      alert.accept();  
		  

	//hover over 2nd button
	  ac.moveToElement(driver.findElement
			  (By.xpath("//div[@id='div-hover']/div[2]"))).perform();
	  

	  ac.click(driver.findElement
			  (By.xpath("//div[@id='div-hover']/div[2]/div/a"))).perform();
	  
	//Using Alert class to first switch to or focus to the alert box  
	  Alert alert1 = driver.switchTo().alert();  
	            
	      //Using accept() method to accept the alert box  
	      alert1.accept(); 
		  

	//hover over 3rd button
	  ac.moveToElement(driver.findElement
			  (By.xpath("//div[@id='div-hover']/div[3]"))).perform();
	  

	  ac.click(driver.findElement
			  (By.xpath("//div[@id='div-hover']/div[3]/div/a[1]"))).perform();
	  
	//Using Alert class to first switch to or focus to the alert box  
	  Alert alert2 = driver.switchTo().alert();  
	            
	      //Using accept() method to accept the alert box  
	      alert2.accept(); 
		  

	  ac.click(driver.findElement
			  (By.xpath("//div[@id='div-hover']/div[3]/div/a[2]"))).perform();
	  
	//Using Alert class to first switch to or focus to the alert box  
	  Alert alert3 = driver.switchTo().alert();  
	            
	      //Using accept() method to accept the alert box  
	      alert3.accept(); 
		  
		  
		  //click and hold button
		  ac.clickAndHold(driver.findElement
				  (By.cssSelector("div[id='click-box']"))).perform();
		  		  

	
	  
	
  }

  @Test(priority=1)
  public void verifyActionsHeaderIsDisplayed()
  {
  	Assert.assertTrue(driver.findElement
  			 (By.id("nav-title")).isDisplayed());
  }
  
 
  
}
