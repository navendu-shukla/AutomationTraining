package atAssignment;

import org.testng.Assert;
import java.util.Set;


import org.openqa.selenium.By;
import org.testng.annotations.*;


public class contactUs extends chromeDriverInitial{
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
	    
//sending values to input fields
		    driver.findElement(By.xpath("//input[@name='first_name']")).
		    sendKeys("sahil");
		    
		    driver.findElement(By.xpath
		    ("//form[@id='contact_form']/input[2]")).sendKeys("pathak");
		    
		    driver.findElement(By.xpath
		    ("//form[@id='contact_form']/input[3]")).
		    sendKeys("sahilpathak232@gmail.com");
		    
		    driver.findElement(By.cssSelector("textarea[name='message']")).
		    sendKeys("hello this is my assignment number 1");
		    //reset button 
		    driver.findElement(By.cssSelector("input[type='reset']")).
		    click();
//sending values to input fields
		    driver.findElement(By.xpath("//input[@name='first_name']")).
		    sendKeys("sahil");
		    
		    driver.findElement(By.xpath
		    ("//form[@id='contact_form']/input[2]")).sendKeys("pathak");
		    
		    driver.findElement(By.xpath
		    ("//form[@id='contact_form']/input[3]")).
		    sendKeys("sahilpathak232@gmail.com");
		    
		    driver.findElement(By.cssSelector("textarea[name='message']")).
		    sendKeys("hello this is my assignment number 1");
		    
		    
//submit button
		    driver.findElement(By.xpath
		    ("//input[@class='contact_button' and @value='SUBMIT']")).click();
		    
		    
		    

	    
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
