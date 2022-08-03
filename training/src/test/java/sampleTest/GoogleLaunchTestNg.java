package sampleTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class GoogleLaunchTestNg {
	
//	System.setProperty("webdriver.chrome.driver", "/Users/navendushukla/eclipse-workspace/training/src/test/resources/chromedriverMac");
    WebDriver driver;
    
    @BeforeClass
    public void setup() {
    	System.setProperty("webdriver.chrome.driver", "/Users/navendushukla/eclipse-workspace/training/src/test/resources/chromedriverMac");
        driver=new ChromeDriver();  
        driver.manage().window().maximize();
    }
	
	
	@Test (priority = 1)
	public void googleLaunch() throws InterruptedException {
		
//        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//        driver.manage().timeouts().pageLoadTimeout(null);
        

         driver.get("http://www.google.com");
         driver.findElement(By.name("q")).sendKeys("javatpoint tutorials");  

         // Click on the search button  
//         driver.findElement(By.name("btnK")).click();
         driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
//         Thread.sleep(10000);
         
         driver.findElement(By.xpath("//h3[text()='Javatpoint: Tutorials List']")).click();
         
         Thread.sleep(10000);
         driver.findElement(By.cssSelector("img[data-src*='redis']")).isDisplayed();
         driver.findElement(By.cssSelector("img[data-src*='redis']")).click();
         
//         Assert.assertTrue(!driver.getTitle().equals("ahsdgasdasdv"));
         
//         JavascriptExecutor js = new JavascriptExecutor(driver)
         
//         driver.quit();


	}
	
	@Test (priority = 2)
	public void fbLaunch() {
//		System.setProperty("webdriver.chrome.driver", "/Users/navendushukla/eclipse-workspace/training/src/test/resources/chromedriverMac");
//        driver=new ChromeDriver();  
//        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//        driver.manage().timeouts().pageLoadTimeout(null);
        

         driver.get("https://www.facebook.com");
//         driver.findElement(By.name("q")).sendKeys("javatpoint tutorials");  
//
//         // Click on the search button  
////         driver.findElement(By.name("btnK")).click();
//         driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
////         Thread.sleep(10000);
//         
//         driver.findElement(By.xpath("//h3[text()='Javatpoint: Tutorials List']")).click();
//         
//         Assert.assertTrue(driver.getTitle().equals("ahsdgasdasdv"));
         
//         JavascriptExecutor js = new JavascriptExecutor(driver)
         
//         driver.quit();


	}
	
	@AfterClass
	public void cleanup() {
		driver.quit();
	}

}
