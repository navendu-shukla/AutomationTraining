package atAssignment;

import org.testng.annotations.Test;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;

public class hiddenElements extends chromeDriverInitial{
	  @BeforeTest
	  public void setup()
		{
			 driver.get("http://webdriveruniversity.com/index.html");
			    String parentHandle= driver.getWindowHandle();
			    System.out.println("parent window- "+parentHandle);
			    
			    driver.findElement(By.cssSelector
			    		("a[id='hidden-elements']")).click(); 
			
			    
			    Set<String> handles=driver.getWindowHandles();
			    for(String handle:handles) {
				    System.out.println(handles);
				    if(!handle.equals(parentHandle)) {
				    driver.switchTo().window(handle);
				    }
			    }    
		}
@Test(priority=2)
public void hiddenElementsAutomation() throws InterruptedException {
	//clicking not displayed element
	WebElement element= driver.findElement
			(By.cssSelector("span[id='button1']"));
	JavascriptExecutor js = (JavascriptExecutor)driver;
	js.executeScript("arguments[0].click();", element);
	driver.findElement(By.xpath
		    ("//div[@id='myModalClick']/div/div/div[3]/button")).click();
	
	//clicking visibility hidden element
	WebElement element1= driver.findElement
			(By.cssSelector("span[id='button2']"));
	js.executeScript("arguments[0].click();", element1);
	driver.findElement(By.xpath
		    ("//div[@id='myModalJSClick']/div/div/div[3]/button")).click();
	
	//clicking zero opacity element
	WebElement element2= driver.findElement
			(By.cssSelector("span[id='button3']"));
	js.executeScript("arguments[0].click();", element2);
	driver.findElement(By.xpath
		    ("//div[@id='myModalMoveClick']/div/div/div[3]/button")).click();
		  
	
}

@Test(priority=1)
public void verifyHiddenElementsHeaderIsDisplayed()
{
	Assert.assertTrue(driver.findElement
			 (By.id("nav-title")).isDisplayed());
}




}
