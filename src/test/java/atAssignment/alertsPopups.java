package atAssignment;

import org.testng.annotations.Test;
import org.testng.Assert;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeTest;

public class alertsPopups extends chromeDriverInitial{
	  @BeforeTest
	  public void setup()
		{
			 driver.get("http://webdriveruniversity.com/index.html");
			    String parentHandle= driver.getWindowHandle();
			    System.out.println("parent window- "+parentHandle);
			    
			    driver.findElement(By.cssSelector
			    		("a[id='popup-alerts']")).click(); 
			
			    
			    Set<String> handles=driver.getWindowHandles();
			    for(String handle:handles) {
				    System.out.println(handles);
				    if(!handle.equals(parentHandle)) {
				    driver.switchTo().window(handle);
				    }
			    }    
		}
@Test(priority=2)
public void alertsPopupAutomation() throws InterruptedException {
	//handling alert of button1
	driver.findElement(By.cssSelector("span[id='button1']")).click();
	Alert al=driver.switchTo().alert();
	al.accept();

	//handling modal popup
	driver.findElement(By.cssSelector("span[id='button2']")).click();
	driver.findElement(By.xpath
		    ("//div[@id='myModal']/div/div/div[3]/button")).click();
	
	//handling ajax loader modal popup
		driver.findElement(By.cssSelector("span[id='button3']")).click();
		 driver.findElement(By.cssSelector("span[id='button1']")).click();;
		  driver.findElement(By.xpath
				("//div[@id='myModalClick']/div/div/div[3]/button")).click();
		  driver.navigate().back();
		  //handling javascript confirmbox and clicking ok
		  driver.findElement(By.cssSelector("span[id='button4']")).click();
			Alert al1=driver.switchTo().alert();
			al1.accept();
			//handling javascript confirmbox and clicking cancel
			driver.findElement(By.cssSelector("span[id='button4']")).click();
			Alert al2=driver.switchTo().alert();
			al2.dismiss();
		  
	 
}

@Test(priority=1)
public void verifyAlertPopupHeaderIsDisplayed()
{
	Assert.assertTrue(driver.findElement
			 (By.id("nav-title")).isDisplayed());
}



}
