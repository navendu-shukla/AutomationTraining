package assignment;

import java.util.ArrayList;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


import testing.contactUs_pom;
import testing.home;

import testing.ourProducts;


public class iFrameChallenge extends MainDriver {
	
	@SuppressWarnings("deprecation")
	@BeforeClass
	public void setup() throws InterruptedException {
		MainDriver.CreateInstance();
		
	     driver.manage().window().maximize();
	     driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		 driver.get("http://www.webdriveruniversity.com/");
			String expectedTitle = "WebDriverUniversity.com";
			String actualTitle = driver.getTitle();
			Assert.assertEquals(actualTitle,expectedTitle);
			String parentHandle = driver.getWindowHandle();
			System.out.println("parent window - " +parentHandle);
		driver.findElement(By.id("iframe")).click();
       
		Set<String> handles = driver.getWindowHandles();
		for (String handle : handles) {
			System.out.println(handle);
			if(!handle.equals(parentHandle)) {
				driver.switchTo().window(handle);
				driver.switchTo().frame(driver.findElement(By.id("frame")));
			}
		}
	}


	@Test (priority=1)
	public void verifyCopyrightIsDisplayed() {
		Assert.assertTrue(driver.findElement(By.cssSelector(".col-lg-12")).isDisplayed());
	}

				@Test (priority=2)
				public void runtests1() throws InterruptedException {
					 home search = new home(driver);
					 ourProducts offers = new ourProducts(driver); 
					 contactUs_pom info = new contactUs_pom(driver);
				
				
					 search.clickButton();
					 offers.clickButton();
					 info.openContactUsPage();
						
						
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

