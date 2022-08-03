package assignment;

import java.util.Set;
import testing.testAffects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;




public class accordion extends MainDriver {
	@Test
	public void testWebUniversity() throws InterruptedException {
	    MainDriver.CreateInstance();
	    
	    testAffects clicks = new testAffects(driver);
	
	    driver.manage().window().maximize();
	    
		driver.get("http://www.webdriveruniversity.com/");
		
		String parentHandle = driver.getWindowHandle();
		
		System.out.println("parent window - " +parentHandle);
		
		driver.findElement(By.xpath("//a[@href='Accordion/index.html' and @id='page-object-model']")).sendKeys( Keys.ENTER);
		
		Set<String> handles = driver.getWindowHandles();
		
		for (String handle : handles) {
			System.out.println(handle);
			if(!handle.equals(parentHandle)) {
				driver.switchTo().window(handle);
				
				clicks.clickButton();
				
				
				driver.close();
				driver.switchTo().window(parentHandle);
		        driver.close();
				
				
			}
		}
}
}