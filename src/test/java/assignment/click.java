package assignment;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
//import java.time.Duration;
import java.util.Set;
//import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
//import org.openqa.selenium.Keys;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
//import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class click extends MainDriver{
	 
	//@SuppressWarnings("deprecation")
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
		driver.findElement(By.id("button-clicks")).click();

		Set<String> handles = driver.getWindowHandles();
		for (String handle : handles) {
			System.out.println(handle);
			if(!handle.equals(parentHandle)) {
				driver.switchTo().window(handle);
			}
		}
	}
	
	@Test (priority = 2)
	public void webElementClick() {
        driver.findElement(By.xpath("//span[starts-with(@id,'button1')]")).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='myModalClick']/div/div/div[3]/button"))).click();
	}
	
	@Test (priority = 3)
	public void JSClick() {
		driver.findElement(By.cssSelector("span#button2")).click();
		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='myModalJSClick']/div/div/div[3]/button"))).click();
		
	}
	

	@SuppressWarnings("deprecation")
	@Test (priority = 4)
	public void ActionMoveClick() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		WebElement clickable = driver.findElement(By.cssSelector("span#button3"));
       Actions act = new Actions(driver);
    		   act.doubleClick(clickable).perform();
        //Thread.sleep(2000);
       WebElement close=driver.findElement(By.xpath("//div[@id='myModalMoveClick']/div/div/div[3]/button"));
       act.click(close).perform();
        //WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(10));
		//wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='myModalMoveClick']/div/div/div[3]/button"))).click();
        //Thread.sleep(2000);
	}
	
	@Test (priority = 1)
	public void verifyLetUsClickingIsDisplayed() {
		Assert.assertTrue(driver.findElement(By.cssSelector("#main-header")).isDisplayed());
	}
	
	
	
	@AfterClass
	public void tierDown() {
		driver.quit();
	}
	
}




