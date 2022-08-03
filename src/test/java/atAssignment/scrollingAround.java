package atAssignment;

import org.testng.annotations.Test;
import java.util.Set;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class scrollingAround extends chromeDriverInitial{
	  @BeforeTest
	  public void setup()
		{
			 driver.get("http://webdriveruniversity.com/index.html");
			    String parentHandle= driver.getWindowHandle();
			    System.out.println("parent window- "+parentHandle);
			    
			    driver.findElement(By.cssSelector
			    		("a[id='scrolling-around']")).click(); 
			
			    
			    Set<String> handles=driver.getWindowHandles();
			    for(String handle:handles) {
				    System.out.println(handles);
				    if(!handle.equals(parentHandle)) {
				    driver.switchTo().window(handle);
				    }
			    }    
		}
@Test(priority=2)
public void scrollAutomation() throws InterruptedException {
	//scrolling to 1st button
	WebElement zone1=driver.findElement(By.cssSelector("div[id=zone1]"));
	JavascriptExecutor js =(JavascriptExecutor)driver ;
	Actions ac=new Actions(driver);
	ac.moveToElement(zone1).perform();
	//scrolling to 2nd button
		WebElement zone2=driver.findElement(By.cssSelector("div[id=zone2]"));
		
		js.executeScript("arguments[0].scrollIntoView();", zone2);		  
		ac.moveToElement(zone2).perform();
		
		//scrolling to 3rd button
		WebElement zone3=driver.findElement(By.cssSelector("div[id=zone3]"));
		
		js.executeScript("arguments[0].scrollIntoView();", zone3);		  
		ac.moveToElement(zone3).perform();

		ac.moveToElement(zone2).perform();

		ac.moveToElement(zone3).perform();

		ac.moveToElement(zone2).perform();

		ac.moveToElement(zone3).perform();

		
		//scrolling to 4th button
		WebElement zone4=driver.findElement(By.cssSelector("div[id=zone4]"));
		
		js.executeScript("window.scrollBy(0,1500)","");		  
		ac.moveToElement(zone4).perform();
		js.executeScript("window.scrollBy(0,-1500)","");	

	 
}

@Test(priority=1)
public void verifyScrollHeaderIsDisplayed()
{
	Assert.assertTrue(driver.findElement
			 (By.id("nav-title")).isDisplayed());
}

@AfterTest
public void tearDown() {
	  driver.close();
}


}
