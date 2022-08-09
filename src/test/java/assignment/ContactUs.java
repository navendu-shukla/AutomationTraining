package assignment;


import java.util.ArrayList;
import java.util.Set;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import testing.TestContactUsPom;


public class ContactUs extends MainDriver{
	
	@BeforeClass
	public void setup() throws InterruptedException {
		MainDriver.CreateInstance();
		
	     driver.manage().window().maximize();
		 driver.get("http://www.webdriveruniversity.com/");
			String expectedTitle = "WebDriverUniversity.com";
			String actualTitle = driver.getTitle();
			Assert.assertEquals(actualTitle,expectedTitle);
			String parentHandle = driver.getWindowHandle();
			System.out.println("parent window - " +parentHandle);
		driver.findElement(By.id("contact-us")).click();
       
		Set<String> handles = driver.getWindowHandles();
		for (String handle : handles) {
			System.out.println(handle);
			if(!handle.equals(parentHandle)) {
				driver.switchTo().window(handle);
			}
		}
	}


	@Test (priority=1)
	public void verifyThankyouPageIsDisplayed() {
		Assert.assertTrue(driver.findElement(By.cssSelector(".section_header")).isDisplayed());
	}

				
				@Test (priority=2)
				public void runtests1() throws InterruptedException {
				TestContactUsPom info = new TestContactUsPom(driver);
				
				
				ArrayList<String> details = new ArrayList<String>();
				details.add("Ria");
				details.add("Sengar");
				details.add("sengarria4321@gmail.com");
				details.add("Automation Testing");
				info.keys(details);
				info.clickButton();
				
				}
				
				@AfterClass
				public void tierDown() {
				 driver.quit();
				}
				
				
}
	