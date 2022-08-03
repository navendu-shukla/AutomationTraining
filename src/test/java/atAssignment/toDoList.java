package atAssignment;


import org.testng.Assert;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;

public class toDoList extends chromeDriverInitial{
	@BeforeTest
	public void setup() {
		driver.get("http://webdriveruniversity.com/index.html");
	    String parentHandle= driver.getWindowHandle();
	    System.out.println("parent window- "+parentHandle);
	    driver.findElement(By.xpath("//a[@id='to-do-list']")).click(); 
	    
	 
	    
	    Set<String> handles=driver.getWindowHandles();
	    for(String handle:handles) {
		    System.out.println(handles);
		    if(!handle.equals(parentHandle)) {
		    driver.switchTo().window(handle);
		    }
	    }
	
	}	
  @Test(priority=2)
  public void toDoListAutomation() throws InterruptedException {
	   
	//adding element in todo list 	
		    WebElement element=driver.findElement(By.cssSelector
		    ("input[placeholder='Add new todo']"));
		    
		    element.sendKeys("make pizza");
		    element.sendKeys(Keys.ENTER);
		    
		  
	//deleting element in todo list	 
		    driver.findElement(By.xpath("//ul/li[3]/span/i")).click();
		    
		    
		    

	    
	    
	    
}
@Test(priority=1)
public void verifyToDoListHeaderIsDisplayed()
{
	 Assert.assertTrue(driver.findElement(By.xpath
			 ("//div/h1")).isDisplayed());
}


}
