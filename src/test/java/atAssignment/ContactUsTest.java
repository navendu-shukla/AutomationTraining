package atAssignment;

import org.testng.Assert;
import java.util.Set;


import org.openqa.selenium.By;
import org.testng.annotations.*;

import PomMain.contactUsPom;


public class ContactUsTest extends chromeDriverInitial{
	@BeforeTest
	public void setup() {
		driver.get("http://webdriveruniversity.com/index.html");
	    String parentHandle= driver.getWindowHandle();
	    System.out.println("parent window- "+parentHandle);
	    driver.findElement(By.xpath("//a[@id='contact-us']")).click(); 

	    
	    Set<String> handles=driver.getWindowHandles();
	    for(String handle:handles) {
		    System.out.println(handles);
		    if(!handle.equals(parentHandle)) {
		    driver.switchTo().window(handle);
		    }
	    }
	
	}	
	
	
  @Test(priority=2)
  public void contactUsAutomation() throws InterruptedException {
	  contactUsPom con=new contactUsPom(driver);
 		con.keys();
 		con.clickResetButton();
 		con.keys();	   		
 		con.clickSubmitButton();
	    

	    
	    }
	    
  
  @Test(priority=1)
  public void verifyContactUsIsDisplayed()
  {
	 Assert.assertTrue(driver.findElement(By.cssSelector
			 (".section_header")).isDisplayed());
  }
  @Test(priority=1)
  public void verifyContactUsFormIsDisplayed()
  {
	 Assert.assertTrue(driver.findElement(By.id
			 ("contact_form")).isDisplayed());
	
  }
  @Test(priority=3)
  public void verifyThankyouMsgIsDisplayed()
  {
	 Assert.assertTrue(driver.findElement(By.id
			 ("contact_reply")).isDisplayed());
  }
  
  @AfterTest
  public void tearDownClose() {
	  driver.close();
  }

  
}
