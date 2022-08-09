package assignment;


import java.util.Set;



import testing.testAffects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
public class accordion extends MainDriver {
	
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
					driver.findElement(By.xpath("//a[@href='Accordion/index.html' and @id='page-object-model']")).sendKeys( Keys.ENTER);

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
					Assert.assertTrue(driver.findElement(By.cssSelector("#main-header")).isDisplayed());
				}

							
							@Test (priority=2)
							public void runtests1() throws InterruptedException {
						    testAffects clicks = new testAffects(driver);
						    clicks.clickButton();
							}
							
							@AfterClass
							public void tierDown() {
							 driver.quit();
							}
							
							
			}
			