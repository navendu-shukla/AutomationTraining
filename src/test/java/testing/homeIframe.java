package testing;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class homeIframe {
	
	WebDriver driver = null; 
    //swipe right
	By scroll = By.xpath("//span[starts-with(@class,'glyphicon glyphicon-chevron-right')]");
	//swipe left
	By leftscroll = By.xpath("//span[starts-with(@class,'glyphicon glyphicon-chevron-left')]");
	//find more button
	By findMore = By.xpath("//button[starts-with(@id,'button-find-out-more')]");
	//close the alert box
	By Close = By.xpath("//div[@class='modal-footer']/button[2]");
	
	public homeIframe(WebDriver driver) {
		this.driver = driver;
	}
	
	public void clickButton() throws InterruptedException {
		driver.findElement(scroll).click();
		Thread.sleep(2000);
		driver.findElement(leftscroll).click();
		Thread.sleep(2000);
		driver.findElement(findMore).click();
		Thread.sleep(2000);
		driver.findElement(Close).click();
	}
}



