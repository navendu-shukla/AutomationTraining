package assignment;

//import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.testng.Assert;
//import org.testng.annotations.AfterSuite;
//import org.testng.annotations.BeforeSuite;

public class MainDriver {
public static WebDriver driver;

//@SuppressWarnings("deprecation")
//@BeforeSuite
public static void CreateInstance() {
	System.setProperty("webdriver.chrome.driver", "/Users/riasengar/eclipse-workspace/MyProject/src/test/resources/chromedriver");  
    driver=new ChromeDriver();
    
   //driver.manage().window().maximize();
   // driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
   
}

//@AfterSuite
//public void tearDown() {
	 
		//driver.quit();
	//}

}
