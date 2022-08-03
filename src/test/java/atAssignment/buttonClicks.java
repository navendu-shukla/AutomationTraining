package atAssignment;

import org.testng.annotations.Test;
import org.testng.Assert;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;

public class buttonClicks extends chromeDriverInitial{
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
	   
//clicking button1 using xpath and webElement click() method
		    driver.findElement(By.xpath("//span[@id='button1']")).click();
		    driver.findElement(By.xpath
		    ("//div[@id='myModalClick']/div/div/div[3]/button")).click();
	
	//clicking button2 using cssSelector and JS click method
		    WebElement element = driver.findElement
		    (By.cssSelector("span[id='button2']"));
		    JavascriptExecutor js = (JavascriptExecutor)driver;
		    js.executeScript("arguments[0].click();", element);
		    
		    WebElement element1=driver.findElement(By.xpath
		    ("//div[@id='myModalJSClick']/div/div/div[3]/button"));
		    WebDriverWait wait= new WebDriverWait
		    		(driver,Duration.ofSeconds(30));
		    wait.until(ExpectedConditions.invisibilityOf(element1));
				    
		    element1.click();
		   // js.executeScript("arguments[0].click();", element1);

	//clicking button3 using id and action,move click method
		    Actions act = new Actions(driver);
		    WebElement elementToClick=driver.findElement(By.xpath("//span[@id='button3']"));
		   
		    
		    act.click(elementToClick).perform();
		    Thread.sleep(2000);

		    WebElement element1ToClick=driver.findElement(By.xpath
		    ("//div[@id='myModalMoveClick']/div/div/div[3]/button"));

		    act.click(element1ToClick).perform();
//		   
		   

	    
	    
  	}
  @Test(priority=1)
  public void verifyAccordionTitleIsDisplayed()
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
