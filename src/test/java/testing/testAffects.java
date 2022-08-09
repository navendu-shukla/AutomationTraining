package testing;

import java.time.Duration;

//import java.time.Duration;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
@Test
public class testAffects {
	WebDriver driver =  null;
	
	By manual = By.xpath("//button[@id='manual-testing-accordion']");
	//swipe left
	By bdd = By.xpath("//button[@id='cucumber-accordion']");
	//find more button
	By automationTesting = By.xpath("//button[@id='automation-accordion']");
	//close the alert box
	//By secondswait = By.xpath("//button[@id='click-accordion']");
	
	public testAffects(WebDriver driver) {
		this.driver = driver;
	}
	
    @Test
	public void clickButton() throws InterruptedException {
	
		driver.findElement(manual).click();
		
		driver.findElement(bdd).click();
		
		driver.findElement(automationTesting).click();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='click-accordion']"))).click();
		
		//driver.findElement(secondswait).click();
		
	}

}
