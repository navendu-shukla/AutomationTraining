package atAssignment;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class chromeDriverInitial {
	public static WebDriver driver;
  
//@SuppressWarnings("deprecation")
//public chromeDriverInitial() {
//	  System.setProperty
//	  ("webdriver.chrome.driver",
//			  "/Users/sahil.pathak/eclipse-workspace/atAssignment/src/main/resources/drivers/chromedriver");
//	  
//	  
//	     driver=new ChromeDriver();  
//	     driver.manage().window().maximize();
//	     driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//	     
//  }
@SuppressWarnings("deprecation")
@BeforeSuite
public void driverInitial() {
	System.setProperty
	  ("webdriver.chrome.driver",
			  "/Users/sahil.pathak/eclipse-workspace/atAssignment/src/main/resources/drivers/chromedriver");
	  
	  
	     driver=new ChromeDriver();  

	     driver.manage().window().maximize();
	     driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
}

@AfterSuite
public void tearDown() {

		driver.quit();
	
}

}
