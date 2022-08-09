package atAssignment;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ScrollingAround extends chromeDriverInitial{

	JavascriptExecutor js =(JavascriptExecutor)driver ;
	Actions ac=new Actions(driver);
	WebElement zone1=driver.findElement(By.cssSelector("div[id=zone1]"));
	WebElement zone2=driver.findElement(By.cssSelector("div[id=zone2]"));
	WebElement zone3=driver.findElement(By.cssSelector("div[id=zone3]"));
	WebElement zone4=driver.findElement(By.cssSelector("div[id=zone4]"));
	public void scrollToElement(WebElement element) {
		ac.moveToElement(element).perform();
	}
	public void scrollDown() {
		js.executeScript("window.scrollBy(0,1500)","");	
	}
	public void scrollUp() {
		js.executeScript("window.scrollBy(0,-1500)","");	
	}
}
