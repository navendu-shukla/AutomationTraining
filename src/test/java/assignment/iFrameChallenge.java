package assignment;

import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.By;
//import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import testing.ContactUsIframe;
import testing.OurProductsIframe;
import testing.homeIframe;


public class iFrameChallenge extends MainDriver {
	
    @Test
	public void testWebUniversity() throws InterruptedException {
	    MainDriver.CreateInstance();
	    
	    homeIframe search = new homeIframe(driver);
	    OurProductsIframe offers = new OurProductsIframe(driver); 
	    ContactUsIframe info = new ContactUsIframe(driver);
	    
	    driver.manage().window().maximize();
		driver.get("http://www.webdriveruniversity.com/");
		String parentHandle = driver.getWindowHandle();
		System.out.println("parent window - " +parentHandle);
		driver.findElement(By.id("iframe")).sendKeys( Keys.ENTER);
		Set<String> handles = driver.getWindowHandles();
		for (String handle : handles) {
			System.out.println(handle);
			if(!handle.equals(parentHandle)) {
				driver.switchTo().window(handle);
				
				driver.switchTo().frame(driver.findElement(By.id("frame")));
				
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
				
				Thread.sleep(2000);
				driver.close();
				driver.switchTo().window(parentHandle);
				driver.close();


}
		}
	}
	}
