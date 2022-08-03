package PomMain;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class ourProducts {
	WebDriver driver=null;
	By ourProdBtn=By.partialLinkText("Products");
	By specialOfferBtn=By.cssSelector("div[id='special-offers']");
	By closeBtn=By.xpath("//div[@id='myModal']/div/div/div[3]/button[2]");
	By proceedBtn=By.xpath("//div[@id='myModal']/div/div/div[3]/button[1]");
	By cameraBtn=By.cssSelector("div[id='cameras']");
	public ourProducts(WebDriver driver) {
		this.driver=driver;
	}
	public void clickButton() throws InterruptedException{
		driver.findElement(ourProdBtn).click();
		
		driver.findElement(specialOfferBtn).click();
		
		driver.findElement(proceedBtn).click();
		
		driver.findElement(cameraBtn).click();
		
		driver.findElement(closeBtn).click();
		
	}

}
