package atAssignment;

import org.testng.annotations.Test;
import java.util.Set;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;

public class FileUploadTest extends chromeDriverInitial{
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
	FileUpload fu=new FileUpload(driver);
	//clicking on choose file button
	fu.enterFilepath();
	//clicking on submit button
	fu.clickSubmitBtn();
	
	fu.handleAlert();
	
	
	
	  
}

@Test(priority=1)
public void verifyFileUploadIsDisplayed()
{
	Assert.assertTrue(driver.findElement
			 (By.id("nav-title")).isDisplayed());
}


}
