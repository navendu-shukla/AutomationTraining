package testing;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class youtube {
	public static void main (String args[]) {
	System.setProperty("webdriver.chrome.driver", "/Users/riasengar/eclipse-workspace/seleniumproject1/resource/chromedriver");  
    WebDriver driver=new ChromeDriver();  
      
	driver.manage().window().maximize();
	driver.get("https://www.youtube.com/c/ShivaConceptSolution");
	driver.findElement(By.name("video-stream html5-main-video"));
	driver.close();
}
}
