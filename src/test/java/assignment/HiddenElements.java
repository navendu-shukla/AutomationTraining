package assignment;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class HiddenElements extends MainDriver{
	@Test
	public void testWebUniversity() throws InterruptedException {
	    MainDriver.CreateInstance();
	    
	    driver.manage().window().maximize();
		driver.get("http://www.webdriveruniversity.com/");
		String parentHandle = driver.getWindowHandle();
		System.out.println("parent window - " +parentHandle);
		driver.findElement(By.id("hidden-elements")).sendKeys( Keys.ENTER);
		Set<String> handles = driver.getWindowHandles();
		for (String handle : handles) {
			System.out.println(handle);
			if(!handle.equals(parentHandle)) {
				driver.switchTo().window(handle);
				
				//Not Displayed Element
				WebElement element = driver.findElement(By.cssSelector("span[id='button1']"));
				JavascriptExecutor jse = (JavascriptExecutor) driver;
	            jse.executeScript("arguments[0].click();", element);
	            Thread.sleep(2000);
	            driver.findElement(By.xpath("//div[@id='myModalClick']/div/div/div[3]/button")).click();
	            Thread.sleep(2000);
	            
	            //Visibility Hidden Element
	            WebElement element1 = driver.findElement(By.cssSelector("span[id='button2']"));
	            JavascriptExecutor js = (JavascriptExecutor) driver;
	            js.executeScript("arguments[0].click();", element1);
	            Thread.sleep(2000);
	            driver.findElement(By.xpath("//div[@id='myModalJSClick']/div/div/div[3]/button")).click();
	            Thread.sleep(2000);
	            
	            //Zero Opacity Element
	            WebElement element2 = driver.findElement(By.cssSelector("span[id='button3']"));
	            JavascriptExecutor js2 = (JavascriptExecutor) driver;
	            js2.executeScript("arguments[0].click();", element2);
	            Thread.sleep(2000);
	            driver.findElement(By.xpath("//div[@id='myModalMoveClick']/div/div/div[3]/button")).click();
	            Thread.sleep(2000);
	            
	        	driver.close();
				driver.switchTo().window(parentHandle);
				driver.close();

}
		}
	}
}
