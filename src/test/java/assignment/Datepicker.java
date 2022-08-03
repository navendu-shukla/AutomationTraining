package assignment;

import org.testng.annotations.Test;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
//import org.testng.annotations.Test;

public class Datepicker extends MainDriver{
	
    @Test
	public void testWebUniversity() throws InterruptedException {
	    MainDriver.CreateInstance();
	    
	    driver.manage().window().maximize();
		driver.get("http://www.webdriveruniversity.com/");
		String parentHandle = driver.getWindowHandle();
		System.out.println("parent window - " +parentHandle);
		driver.findElement(By.id("datepicker")).sendKeys( Keys.ENTER);
		Set<String> handles = driver.getWindowHandles();
		for (String handle : handles) {
			System.out.println(handle);
			if(!handle.equals(parentHandle)) {
				driver.switchTo().window(handle);
				
				String month = "October 2022";
				String date = "15";
				
				driver.findElement(By.id("datepicker")).click();
			    Thread.sleep(2000);  
			    
			    while(true) {
			    String text = driver.findElement(By.xpath("/html/body/div[2]/div[1]/table/thead/tr[1]/th[2]")).getText();
			    if(text.equals(month))
			    {
			    	break;
			    }
			    else {
			    	driver.findElement(By.xpath("/html/body/div[2]/div[1]/table/thead/tr[1]/th[3]")).click();
			    	Thread.sleep(2000);
			    }
			    
			    }
			    Thread.sleep(2000);
			    driver.findElement(By.xpath("/html/body/div[2]/div[1]/table/tbody/tr/td[contains(text(),"+date+")]")).click();
			    
			    Thread.sleep(2000);
	        	driver.close();
				driver.switchTo().window(parentHandle);
				driver.close();


}
		}
	}
}
