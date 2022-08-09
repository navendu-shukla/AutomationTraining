package assignment;

//import java.time.Duration;
import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.By;
//import org.openqa.selenium.Keys;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import testing.logInPom;

public class logIn extends MainDriver{
    		    
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
					driver.findElement(By.id("login-portal")).click();

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
					Assert.assertTrue(driver.findElement(By.cssSelector(".form")).isDisplayed());
				}

							
							@Test (priority=2)
							public void runtests1() throws InterruptedException {
							logInPom info = new logInPom(driver);
							
							ArrayList<String> details = new ArrayList<String>();
							details.add("webdriver");
							details.add("webdriver123");
							
							info.keys(details);
							info.clickButton();
							
							}
							
							@AfterClass
							public void tierDown() {
							 driver.quit();
							}
							
							
			}
			


