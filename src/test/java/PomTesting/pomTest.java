package PomTesting;

import java.util.Set;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import PomMain.contactUsPom;
import PomMain.homePage;
import PomMain.ourProducts;
import atAssignment.chromeDriverInitial;

public class pomTest extends chromeDriverInitial{
	@BeforeTest
	public void setup() {
		driver.get("http://webdriveruniversity.com/index.html");
	    String parentHandle= driver.getWindowHandle();
	    System.out.println("parent window- "+parentHandle);
	    driver.findElement(By.cssSelector
	    		("a[href='Page-Object-Model/index.html']")).click(); 
	
	    
	    Set<String> handles=driver.getWindowHandles();
	    for(String handle:handles) {
		    System.out.println(handles);
		    if(!handle.equals(parentHandle)) {
		    driver.switchTo().window(handle);
		    }
	    }
	
	}
  @Test(priority = 2)
  public void pomAutomation() throws InterruptedException {
	   		homePage home=new homePage(driver);
	   		ourProducts prod=new ourProducts(driver);
	   		contactUsPom contact=new contactUsPom(driver);
	   		
	   		home.clickButton();
	   		prod.clickButton();
	   		contact.clickContactButton();
	   		contact.keys();
	   		contact.clickResetButton();
	   		contact.keys();	   		
	   		contact.clickSubmitButton();
	
		    
		   

	    
	    
  	}
	@Test(priority=1)
	public void verifyPomHeaderIsDisplayed()
	{
		 Assert.assertTrue(driver.findElement
				 (By.cssSelector("a[id='nav-title']")).isDisplayed());
		 
	}
	 @Test(priority=3)
	  public void verifyThankyouMsgIsDisplayed()
	  {
		 Assert.assertTrue(driver.findElement(By.id
				 ("contact_reply")).isDisplayed());
		 
	  }
	 
}
