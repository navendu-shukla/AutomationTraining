package assignment;


import java.util.Set;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import testing.AjaxPom;


public class Ajax extends MainDriver{
	
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
			driver.findElement(By.id("ajax-loader")).click();

			Set<String> handles = driver.getWindowHandles();
			for (String handle : handles) {
				System.out.println(handle);
				if(!handle.equals(parentHandle)) {
					driver.switchTo().window(handle);
				}
			}
		}

		//@Test (priority=2)
		//public void verifyButtonIsClicked() {
		//	Assert.assertTrue(driver.findElement(By.xpath("//button[@class='btn btn-default']")).isDisplayed());
		//}

					
					@Test (priority=1)
					public void runtests1() throws InterruptedException {
					AjaxPom click = new AjaxPom(driver);
					click.clickButton();
					}
					
					@AfterClass
					public void tierDown() {
					 driver.quit();
					}
					
					
	}
