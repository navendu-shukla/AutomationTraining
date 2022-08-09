package atAssignment;

import org.testng.annotations.Test;
import java.util.Set;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;

public class HiddenElementsTest extends chromeDriverInitial{
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
	HiddenElements he=new HiddenElements();
	//clicking not displayed element
	he.clickBtn(he.btn1);
	he.clickCloseBtn(he.closeBtn1);
	
	//clicking visibility hidden element
	he.clickBtn(he.btn2);
	he.clickCloseBtn(he.closeBtn2);
	
	//clicking zero opacity element
	he.clickBtn(he.btn3);
	he.clickCloseBtn(he.closeBtn3);
		  
	
}

@Test(priority=1)
public void verifyHiddenElementsHeaderIsDisplayed()
{
	Assert.assertTrue(driver.findElement
			 (By.id("nav-title")).isDisplayed());
}




}
