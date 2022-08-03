package testing;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;

public class testAffects {
	WebDriver driver =  null;
	
	By manual = By.xpath("//button[@id='manual-testing-accordion']");
	//swipe left
	By bdd = By.xpath("//button[@id='cucumber-accordion']");
	//find more button
	By automationTesting = By.xpath("//button[@id='automation-accordion']");
	//close the alert box
	By secondswait = By.xpath("//button[@id='click-accordion']");
	
	public testAffects(WebDriver driver) {
		this.driver = driver;
	}
	

	public void clickButton() throws InterruptedException {
	
		driver.findElement(manual).click();
		Thread.sleep(2000);
		driver.findElement(bdd).click();
		Thread.sleep(2000);
		driver.findElement(automationTesting).click();
		Thread.sleep(2000);
		
		
		driver.findElement(secondswait).click();
		Thread.sleep(5000);
	}

}
