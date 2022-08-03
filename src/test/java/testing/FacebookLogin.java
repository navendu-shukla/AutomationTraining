package testing;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FacebookLogin {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 System.setProperty("webdriver.chrome.driver", "/Users/riasengar/eclipse-workspace/seleniumproject1/resource/chromedriver");  
		    WebDriver driver=new ChromeDriver();  
		      
		    // Launch website  
		    driver.navigate().to("https://www.google.co.in/url?sa=t&rct=j&q=&esrc=s&source=web&cd=&cad=rja&uact=8&ved=2ahUKEwj4yfTj1en4AhUOwzgGHaQfBFoQFnoECAsQAQ&url=https%3A%2F%2Fwww.facebook.com%2F&usg=AOvVaw2q27ov2cpCynr72DmuSqEz");  
		          
		    // Click on the search text box and send value  
		    driver.findElement(By.id("email")).sendKeys("sengarria4321@gmail.com");  
		    driver.findElement(By.id("pass")).sendKeys("#newlife123");      
		    // Click on the search button  
		    //driver.findElement(By.name("_42ft _4jy0 _6lth _4jy6 _4jy1 selected _51sy")).click();  
		    driver.findElement(By.id("pass")).sendKeys(Keys.ENTER); 
		   
		    driver.quit();
	}

}
