package assignment;



import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import testing.AutoCompletePom;


public class AutoComplete extends MainDriver{
	
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
		driver.findElement(By.id("autocomplete-textfield")).click();

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
		Assert.assertTrue(driver.findElement(By.cssSelector(".section_header")).isDisplayed());
	}

	@Test (priority=2)
	public void runtests1() throws InterruptedException {
	AutoCompletePom info = new AutoCompletePom(driver);
	info.testAutoComplete();
	}
	
	@AfterClass
	public void tierDown() {
		driver.quit();
	}
	
}



