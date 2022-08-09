package testing;



import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class ScrollingElementsPom {

WebDriver driver = null; 
	
	public ScrollingElementsPom(WebDriver driver) {
		this.driver = driver;
	}
	
	@Test(priority = 2)
    public void Zone1Scroll() throws InterruptedException {

		 WebElement element = driver.findElement(By.id("zone1"));
			Actions hover1 = new Actions(driver);
		    hover1.moveToElement(element).perform();
           
	
	}
	
	@Test(priority = 3)
    public void Zone2Scroll() throws InterruptedException {

		 WebElement element1 = driver.findElement(By.id("zone2-entries"));
         //JavascriptExecutor js = (JavascriptExecutor) driver;
         //js.executeScript("arguments[0].scrollIntoView()",element1);
         Actions hover2 = new Actions(driver);
		    hover2.moveToElement(element1).perform();
         //Thread.sleep(2000);
         
         WebElement element2 = driver.findElement(By.id("zone3-entries"));
         Actions hover3 = new Actions(driver);
		    hover3.moveToElement(element2).perform();
	
	}
	

	@Test(priority = 4)
    public void Zone4Scroll() throws InterruptedException {

		JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollBy(0, document.body.scrollHeight);");
       
        
        WebElement element3 = driver.findElement(By.id("zone4"));
        Actions hover4 = new Actions(driver);
	    hover4.moveToElement(element3).perform();
	   
	}
	

	
}
