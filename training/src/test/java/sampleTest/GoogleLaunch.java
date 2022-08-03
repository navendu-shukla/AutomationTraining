package sampleTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleLaunch {
	
	public static void main(String[] args) throws InterruptedException {
        // TODO Auto-generated method stub
        System.setProperty("webdriver.chrome.driver", "/Users/navendushukla/eclipse-workspace/training/src/test/resources/chromedriverMac");
        WebDriver driver=new ChromeDriver();  
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//        driver.manage().timeouts().pageLoadTimeout(null);
        

         driver.navigate().to("http://www.google.com");
         driver.findElement(By.name("q")).sendKeys("javatpoint tutorials");  

         // Click on the search button  
//         driver.findElement(By.name("btnK")).click();
         driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
//         Thread.sleep(10000);
         
         driver.findElement(By.xpath("//h3[text()='Javatpoint: Tutorials List']")).click();
         
//         JavascriptExecutor js = new JavascriptExecutor(driver)
         
         driver.quit();

    }

}
