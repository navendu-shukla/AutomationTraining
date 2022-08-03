package assignment;

import org.testng.annotations.Test;
//import org.testng.annotations.Test;
import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
//import org.testng.annotations.Test;
import testing.home;
import testing.ourProducts;
import testing.contactUs_pom;

public class pom extends MainDriver{
	
	@Test
	public void testWebUniversity() throws InterruptedException {
	    MainDriver.CreateInstance();
	    
	    home search = new home(driver);
	    ourProducts offers = new ourProducts(driver); 
	    contactUs_pom info = new contactUs_pom(driver);
	    
	    driver.manage().window().maximize();
	    
		driver.get("http://www.webdriveruniversity.com/");
		
		String parentHandle = driver.getWindowHandle();
		
		System.out.println("parent window - " +parentHandle);
		
		driver.findElement(By.id("page-object-model")).sendKeys( Keys.ENTER);
		
		Set<String> handles = driver.getWindowHandles();
		
		for (String handle : handles) {
			System.out.println(handle);
			if(!handle.equals(parentHandle)) {
				driver.switchTo().window(handle);
				
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
				
		Thread.sleep(5000);
		driver.close();
		driver.switchTo().window(parentHandle);
        driver.close();
	    }
		}
		}
	}

