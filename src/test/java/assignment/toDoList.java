package assignment;

//import java.time.Duration;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class toDoList extends MainDriver{

	@SuppressWarnings("deprecation")
	@BeforeClass
	public void setup() {
		MainDriver.CreateInstance();

	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("http://www.webdriveruniversity.com/");
		String expectedTitle = "WebDriverUniversity.com";
		String actualTitle = driver.getTitle();
		Assert.assertEquals(actualTitle,expectedTitle);
		String parentHandle = driver.getWindowHandle();
		System.out.println("parent window - " +parentHandle);
		driver.findElement(By.id("to-do-list")).click();

		Set<String> handles = driver.getWindowHandles();
		for (String handle : handles) {
			System.out.println(handle);
			if(!handle.equals(parentHandle)) {
				driver.switchTo().window(handle);
			}
		}
	}
	
	
	@Test(priority = 2)
    public void testWebUniversity() throws InterruptedException {
		//add in to-do list			
		driver.findElement(By.xpath("//i[starts-with(@id,'plus-icon')]")).click();
		
		driver.findElement(By.xpath("//input[starts-with(@placeholder,'Add new todo')]")).sendKeys("Gym",Keys.ENTER);
		
        //strike a task
		driver.findElement(By.xpath("//ul/li[1]")).click();
		
		//delete in to-do list
		
		driver.findElement(By.xpath("//ul/li[4]/span/i")).click();
		
	}
	
	@Test (priority = 1)
	public void verifyToDoHeaderIsDisplayed() {
		Assert.assertTrue(driver.findElement(By.cssSelector("#container")).isDisplayed());
	}
	
	@AfterClass
	public void tierDown() {
		driver.quit();
	}
	
}



