package assignment;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MainDriver {
public static WebDriver driver;
public static void CreateInstance() {
	System.setProperty("webdriver.chrome.driver", "/Users/riasengar/eclipse-workspace/MyProject/src/test/resources/chromedriver");  
    driver=new ChromeDriver();
}
}
