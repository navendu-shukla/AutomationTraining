package atAssignment;

import org.testng.annotations.Test;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;

public class fileUpload extends chromeDriverInitial{
	  @BeforeTest
	  public void setup()
		{
			 driver.get("http://webdriveruniversity.com/index.html");
			    String parentHandle= driver.getWindowHandle();
			    System.out.println("parent window- "+parentHandle);
			    
			    driver.findElement(By.cssSelector
			    		("a[id='file-upload']")).click(); 
			
			    
			    Set<String> handles=driver.getWindowHandles();
			    for(String handle:handles) {
				    System.out.println(handles);
				    if(!handle.equals(parentHandle)) {
				    driver.switchTo().window(handle);
				    }
			    }    
		}
@Test(priority=2)
public void fileUploadAutomation() throws InterruptedException {
	//clicking on choose file button
	WebElement chooseFile = driver.findElement(By.id("myFile"));
	chooseFile.sendKeys("/Users/sahil.pathak/Downloads/flower.jpeg");
	//clicking on submit button
	driver.findElement(By.cssSelector("input[id='submit-button']")).click();
	driver.switchTo().alert().accept();
	
	
	
	  
}

@Test(priority=1)
public void verifyFileUploadIsDisplayed()
{
	Assert.assertTrue(driver.findElement
			 (By.id("nav-title")).isDisplayed());
}


}
