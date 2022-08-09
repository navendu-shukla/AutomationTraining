package atAssignment;


import org.testng.Assert;
import java.util.Set;

import org.openqa.selenium.By;

import org.testng.annotations.*;

public class ToDoListTest extends chromeDriverInitial{
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
	  ToDoList td=new ToDoList(driver);
	   
	//adding element in todo list 	
		    td.addElement();
		    
		  
	//deleting element in todo list	 
		    td.removeElement();
		    Thread.sleep(2000);
		    
		    

	    
	    
	    
}
@Test(priority=1)
public void verifyToDoListHeaderIsDisplayed()
{
	 Assert.assertTrue(driver.findElement(By.xpath
			 ("//div/h1")).isDisplayed());
}


}
