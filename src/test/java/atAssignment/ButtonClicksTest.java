package atAssignment;

import org.testng.annotations.Test;
import org.testng.Assert;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;

public class ButtonClicksTest extends chromeDriverInitial{
	@BeforeTest
	public void setup() {
		driver.get("http://webdriveruniversity.com/index.html");
	    String parentHandle= driver.getWindowHandle();
	    System.out.println("parent window- "+parentHandle);
	    driver.findElement(By.xpath("//a[@id='button-clicks']")).click(); 
	
	    
	    Set<String> handles=driver.getWindowHandles();
	    for(String handle:handles) {
		    System.out.println(handles);
		    if(!handle.equals(parentHandle)) {
		    driver.switchTo().window(handle);
		    }
	    }
	
	}
  @Test(priority = 2)
  public void buttonClickAutomation() throws InterruptedException {
	  ButtonClick btc=new ButtonClick();
	  WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(30));
	   
//clicking button1 using xpath and webElement click() method
		    btc.clickBtn1();
		    btc.clickCloseBtn1();
	
	//clicking button2 using cssSelector and JS click method
		    btc.clickBtn2();
		    
		    btc.clickCloseBtn2();
		    //Thread.sleep(5000);
		    
		   // js.executeScript("arguments[0].click();", element1);

	//clicking button3 using id and action,move click method
		   
		    wait.until(ExpectedConditions.visibilityOfElementLocated(btc.btn3));
		    
		    btc.clickBtn3();
		   wait.until(ExpectedConditions.visibilityOfElementLocated(btc.closeBtn3));
		    btc.clickCloseBtn3();
		    
		    
Thread.sleep(2000);
			//btc.clickCloseBtn3();
			//Thread.sleep(2000);
//		    WebElement element1ToClick=driver.findElement(By.xpath
//		    ("//div[@id='myModalMoveClick']/div/div/div[3]/button"));
//		    wait.until(ExpectedConditions.elementToBeClickable(By.xpath
//				    ("//div[@id='myModalMoveClick']/div/div/div[3]/button")));
//		   act.click(element1ToClick).perform();
//	   
		   

	    
	    
  	}
  @Test(priority=1)
  public void verifyButtonClickTitleIsDisplayed()
  {
  	Assert.assertTrue(driver.findElement
  			 (By.id("nav-title")).isDisplayed());
  }
	@Test(priority=1)
	public void verifyButtonsAreDisplayed()
	{
		 Assert.assertTrue(driver.findElement
				 (By.xpath("//span[@id='button1']")).isDisplayed());
		 
		 Assert.assertTrue(driver.findElement
				 (By.xpath("//span[@id='button2']")).isDisplayed());
		 
		 Assert.assertTrue(driver.findElement
				 (By.xpath("//span[@id='button3']")).isDisplayed());
	}
	
	
	
	
}
