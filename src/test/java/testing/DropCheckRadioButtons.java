package testing;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Select;

public class DropCheckRadioButtons {
	
WebDriver driver =  null;
	
	By ddown = By.xpath("//select[@class='dropdown-menu-lists' and @id='dropdowm-menu-1']");
	Select select = new Select((WebElement) ddown);
	//swipe left
	//By bdd = By.xpath("//button[@id='cucumber-accordion']");
	//find more button
	//By automationTesting = By.xpath("//button[@id='automation-accordion']");
	//close the alert box
	//By secondswait = By.xpath("//button[@id='click-accordion']");
	
	public DropCheckRadioButtons(WebDriver driver) {
		this.driver = driver;
	}
	
    
	public void clickButton() throws InterruptedException {
	
		
		//driver.findElement(ddown).select.click();
		//Select select = new Select((WebElement) ddown);
		
		Thread.sleep(2000);
		//driver.findElement(bdd).click();
		//Thread.sleep(2000);
		//driver.findElement(automationTesting).click();
		//Thread.sleep(2000);
		
		//driver.findElement(secondswait).click();
		
	}

}

	
	

