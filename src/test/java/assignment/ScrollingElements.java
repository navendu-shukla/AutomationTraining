package assignment;



import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import testing.ScrollingElementsPom;


public class ScrollingElements extends MainDriver{
	
	@SuppressWarnings("deprecation")
	@BeforeClass
	public void setup() {
		MainDriver.CreateInstance();

	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
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
	
	@Test (priority=2)
	public void runtests1() throws InterruptedException {
	ScrollingElementsPom info = new ScrollingElementsPom(driver);
	
	info.Zone1Scroll();
	info.Zone2Scroll();
	info.Zone4Scroll();
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

