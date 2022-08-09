package atAssignment;

import org.testng.annotations.Test;
import java.util.Set;


import org.openqa.selenium.By;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class ScrollingAroundTest extends chromeDriverInitial{
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
	ScrollingAround sa=new ScrollingAround();
	//scrolling to 1st button
	sa.scrollToElement(sa.zone1);
	//scrolling to 2nd button
	sa.scrollToElement(sa.zone2);
		
		//scrolling to 3rd button
	sa.scrollToElement(sa.zone3);
	sa.scrollToElement(sa.zone2);

	sa.scrollToElement(sa.zone3);

	sa.scrollToElement(sa.zone2);

	sa.scrollToElement(sa.zone3);



		
		//scrolling to 4th button
		
		sa.scrollDown();	  
		sa.scrollToElement(sa.zone4);

		sa.scrollUp();
	 
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
