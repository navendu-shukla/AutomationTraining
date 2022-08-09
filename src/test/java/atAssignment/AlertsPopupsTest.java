package atAssignment;

import org.testng.annotations.Test;
import org.testng.Assert;
import java.util.Set;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeTest;

public class AlertsPopupsTest extends chromeDriverInitial{
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
	AlertPopups ap=new AlertPopups(driver);
	//handling alert of button1
	ap.clickBtn(ap.btn1);
	ap.alertAccept();

	//handling modal popup
	ap.clickBtn(ap.btn2);	
	ap.clickCloseBtn(ap.closeBtnBtn2);
	
	//handling ajax loader modal popup
	ap.clickBtn(ap.btn3);
	ap.clickBtn(ap.btnAjax);
	ap.clickCloseBtn(ap.closeBtnAjax);
		  driver.navigate().back();
		  //handling javascript confirmbox and clicking ok
		  ap.clickBtn(ap.btn4);
			ap.alertAccept();
			//handling javascript confirmbox and clicking cancel
			ap.clickBtn(ap.btn4);
			ap.alertDismiss();
		  
	 
}

@Test(priority=1)
public void verifyAlertPopupHeaderIsDisplayed()
{
	Assert.assertTrue(driver.findElement
			 (By.id("nav-title")).isDisplayed());
}



}
