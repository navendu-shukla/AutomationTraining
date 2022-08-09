package atAssignment;

import org.testng.annotations.Test;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;

public class DatePickerTest extends chromeDriverInitial{
	  @BeforeTest
	  public void setup()
		{
			 driver.get("http://webdriveruniversity.com/index.html");
			    String parentHandle= driver.getWindowHandle();
			    System.out.println("parent window- "+parentHandle);
			    
			    driver.findElement(By.cssSelector
			    		("a[id='datepicker']")).click(); 
			
			    
			    Set<String> handles=driver.getWindowHandles();
			    for(String handle:handles) {
				    System.out.println(handles);
				    if(!handle.equals(parentHandle)) {
				    driver.switchTo().window(handle);
				    }
			    }    
		}
@Test(priority=2)
public void datePickerAutomation() throws InterruptedException {
	DatePicker date=new DatePicker(driver);
	date.selectDate();
    
}
    

	
	
	  


@Test(priority=1)
public void verifyDatePickerHeaderIsDisplayed()
{
	Assert.assertTrue(driver.findElement
			 (By.id("nav-title")).isDisplayed());
}


}
