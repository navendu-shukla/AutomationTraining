package atAssignment;

import java.util.Set;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.*;

public class DropCheckRadioTest extends chromeDriverInitial{
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
  public void dropCheckRadioAutomation() throws InterruptedException {
	   		DropCheckRadio dcr =new DropCheckRadio(driver);
	//automation of dropdown menu    
		    dcr.dropDownAutomation();

	//automation of checkboxes
		    dcr.checkBoxAutomation();

//automation of radio button
		    dcr.radioButtonAutomation();
//automation of selected and disabled radio button
		    dcr.disabledRadioButtonAutomation();
		    
		  //automation of selected and disabled dropdown
		    dcr.disabledDropDownAutomation(); 
		    

		    
		  

	    
}
  @Test(priority=1)
  public void verifyDropCheckRadioTitleIsDisplayed()
  {
  	Assert.assertTrue(driver.findElement
  			 (By.id("nav-title")).isDisplayed());
  }
 

}
