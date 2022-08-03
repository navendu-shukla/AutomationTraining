package assignment;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

public class Ajax extends MainDriver{
	@SuppressWarnings("deprecation")
	@Test
	public void testWebUniversity() throws InterruptedException {
	    MainDriver.CreateInstance();
	    
	    driver.manage().window().maximize();
		driver.get("http://www.webdriveruniversity.com/");
		String parentHandle = driver.getWindowHandle();
		System.out.println("parent window - " +parentHandle);
		driver.findElement(By.id("ajax-loader")).sendKeys( Keys.ENTER);
		Set<String> handles = driver.getWindowHandles();
		for (String handle : handles) {
			System.out.println(handle);
			if(!handle.equals(parentHandle)) {
				driver.switchTo().window(handle);
				
				driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
				
				driver.findElement(By.id("button1")).click();
				Thread.sleep(2000);
				driver.findElement(By.xpath("//div[@id='myModalClick']/div/div/div[3]/button")).click();
                
				driver.close();
				driver.switchTo().window(parentHandle);
				driver.close();

}
		}
	}
}
