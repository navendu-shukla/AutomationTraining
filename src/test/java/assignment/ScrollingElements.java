package assignment;


import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ScrollingElements extends MainDriver{
	
	@BeforeClass
	public void setup() {
		MainDriver.CreateInstance();

	    driver.manage().window().maximize();
		driver.get("http://www.webdriveruniversity.com/");
		String expectedTitle = "WebDriverUniversity.com";
		String actualTitle = driver.getTitle();
		Assert.assertEquals(actualTitle,expectedTitle);
		String parentHandle = driver.getWindowHandle();
		System.out.println("parent window - " +parentHandle);
		driver.findElement(By.id("scrolling-around")).click();

		Set<String> handles = driver.getWindowHandles();
		for (String handle : handles) {
			System.out.println(handle);
			if(!handle.equals(parentHandle)) {
				driver.switchTo().window(handle);
			}
		}
	}
	
	@Test (priority = 1)
	public void verifyHeaderIsDisplayed() {
		Assert.assertTrue(driver.findElement(By.cssSelector("#main-header")).isDisplayed());
	}
	
	@Test(priority = 2)
    public void Zone1Scroll() throws InterruptedException {

		 WebElement element = driver.findElement(By.id("zone1"));
			Actions hover1 = new Actions(driver);
		    hover1.moveToElement(element).perform();
           Thread.sleep(2000);
	
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
        Thread.sleep(2000);
        
        WebElement element3 = driver.findElement(By.id("zone4"));
        Actions hover4 = new Actions(driver);
	    hover4.moveToElement(element3).perform();
	    Thread.sleep(2000);
	}
	
	
	@Test (priority = 5)
	public void verifyCopyrightIsDisplayed() {
		Assert.assertTrue(driver.findElement(By.cssSelector(".col-lg-12")).isDisplayed());
	}
	
	
	@AfterClass
	public void tierDown() {
		driver.quit();
	}
	
}

