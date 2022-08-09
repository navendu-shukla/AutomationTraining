package assignment;

import java.util.ArrayList;
//import java.time.Duration;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;


import testing.TodoListPom;

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
	
	@Test (priority=2)
	public void runtests1() throws InterruptedException {
	TodoListPom info = new TodoListPom(driver);
	
	
	ArrayList<String> details = new ArrayList<String>();
	details.add("Gym");
	
	info.keys(details);
	info.clickButton();
	info.clickButton2();
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



