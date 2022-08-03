package atAssignment;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.*;

public class dropCheckRadio extends chromeDriverInitial{
	@BeforeTest
	public void setup()
	{
		 driver.get("http://webdriveruniversity.com/index.html");
		    String parentHandle= driver.getWindowHandle();
		    System.out.println("parent window- "+parentHandle);
		    
		    driver.findElement(By.xpath
		    		("//a[@id='dropdown-checkboxes-radiobuttons']")).click(); 
		
		    
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
	   
	//automation of dropdown menu    
		    Select dropdown = new Select(driver.findElement(By.xpath
		    		("//select[@id='dropdowm-menu-1']")));  
		    dropdown.selectByVisibleText("Python");  
		    Select dropdown2 = new Select(driver.findElement(By.xpath
		    		("//select[@id='dropdowm-menu-2']")));  
		    dropdown2.selectByIndex(2);  

		    Select dropdown3 = new Select(driver.findElement(By.xpath
		    		("//select[@id='dropdowm-menu-3']")));  
		    dropdown3.selectByValue("javascript"); 

	//automation of checkboxes
		    driver.findElement(By.cssSelector
		    		("input[value=option-3]")).click();

		    
		    driver.findElement(By.cssSelector
		    		("input[value=option-1]")).click();
		    
		    driver.findElement(By.cssSelector
		    		("input[value=option-4]")).click();

//automation of radio button
		    driver.findElement(By.cssSelector
		    		("input[value=green]")).click();
		    
		    int a=driver.findElements(By.cssSelector
		    		("input[name=color]")).size();
		    System.out.println(a);
		    for(int i=0;i<a;i++)
		    {
		    	driver.findElements(By.xpath
	            		("//input[@name='color']")).get(i).click(); 
		    }
//automation of selected and disabled radio button
		    int a1=driver.findElements(By.cssSelector
		    		("input[name='vegetable']")).size();
		    System.out.println(a1);
		    for(int i=0;i<a1;i++)
		    {
		    	
		    	WebElement e=driver.findElements(By.xpath
	            		("//input[@name='vegetable']")).get(i); 
		    	boolean selectState = e.isEnabled();
				
		    	//performing click operation only if element is enabled
		    	if(selectState == true) {
		    		e.click();

		    	}
		    }
		    
		  //automation of selected and disabled dropdown
		    Select sel = new Select(driver.findElement(By.xpath
		    		("//select[@id='fruit-selects']")));  
		    sel.selectByVisibleText("Apple");  
		     
		    sel.selectByIndex(2);  

		   
		    sel.selectByValue("grape"); 
		    

		    
		  

	    
}
  @Test(priority=1)
  public void verifyDropCheckRadioTitleIsDisplayed()
  {
  	Assert.assertTrue(driver.findElement
  			 (By.id("nav-title")).isDisplayed());
  }
 

}
