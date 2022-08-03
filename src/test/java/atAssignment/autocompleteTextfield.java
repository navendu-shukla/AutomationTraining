package atAssignment;

import org.testng.annotations.Test;
import org.testng.Assert;
import java.util.Set;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeTest;

public class autocompleteTextfield extends chromeDriverInitial{
	  @BeforeTest
	  public void setup()
		{
			 driver.get("http://webdriveruniversity.com/index.html");
			    String parentHandle= driver.getWindowHandle();
			    System.out.println("parent window- "+parentHandle);
			    
			    driver.findElement(By.cssSelector
			    		("a[id='autocomplete-textfield']")).click(); 
			
			    
			    Set<String> handles=driver.getWindowHandles();
			    for(String handle:handles) {
				    System.out.println(handles);
				    if(!handle.equals(parentHandle)) {
				    driver.switchTo().window(handle);
				    }
			    }    
		}
@Test(priority=2)
public void autocompleteAutomation() throws InterruptedException {
	//clicking on input textfield and sending keys
	driver.findElement(By.cssSelector("input[id='myInput']")).sendKeys("a");
	//selecting input from list using index
	driver.findElement(By.xpath
			("//div[@id='myInputautocomplete-list']/div[2]")).click();
	//clicking submit button
	driver.findElement(By.cssSelector("input[id='submit-button']")).click();
	//clicking on input textfield and sending keys
		driver.findElement(By.cssSelector
				("input[id='myInput']")).sendKeys("c");
		//selecting input from list using index
		driver.findElement(By.xpath
				("//div[@id='myInputautocomplete-list']/div[4]")).click();
		//clicking submit button
		driver.findElement(By.cssSelector
				("input[id='submit-button']")).click();
	
	
	  
}

@Test(priority=1)
public void verifyautocompleteHeaderIsDisplayed()
{
	Assert.assertTrue(driver.findElement
			 (By.cssSelector("h2[name='contactme']")).isDisplayed());
}


}