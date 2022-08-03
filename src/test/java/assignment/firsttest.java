package assignment;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

//import io.github.bonigarcia.wdm.WebDriverManager;

public class firsttest {
	@Test(priority=1)
	public void TestGoogle() throws InterruptedException {
		//WebDriverManager.chromedriver().setup();
		//WebDriver driver = new ChromeDriver();
		System.setProperty("webdriver.chrome.driver", "/Users/riasengar/eclipse-workspace/seleniumproject1/resource/chromedriver");  
	    WebDriver driver=new ChromeDriver();  
	      
		driver.manage().window().maximize();
		driver.get("https://www.google.co.in/");
		driver.findElement(By.name("q")).sendKeys("HYR Tutorials", Keys.ENTER);
		System.out.println(driver.getTitle());
		Thread.sleep(5000);
		driver.quit();
	}
	
	@Test(priority=2)
	public void TestFacebook() throws InterruptedException {
		//WebDriverManager.chromedriver().setup();
		//WebDriver driver = new ChromeDriver();
		System.setProperty("webdriver.chrome.driver", "/Users/riasengar/eclipse-workspace/seleniumproject1/resource/chromedriver");  
	    WebDriver driver=new ChromeDriver();  
	      
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/");
		driver.findElement(By.name("email")).sendKeys("sengarria4321@gmail.com", Keys.ENTER);
		System.out.println(driver.getTitle());
		Thread.sleep(5000);
		driver.quit();
	}

}
