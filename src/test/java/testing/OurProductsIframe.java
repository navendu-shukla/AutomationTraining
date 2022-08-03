package testing;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class OurProductsIframe {
WebDriver driver = null; 
	
	By openPage = By.xpath("//div[@class='col-md-12']//a[@href='products.html']");
	
	By specialOffers = By.xpath("//div[@id='container-special-offers']");
	
	By Close = By.xpath("//div[@class='modal-footer']/button[2]");
    
	By camera = By.xpath("//div[@id='cameras']");
	
	By Proceed = By.xpath("//div[@class='modal-footer']/button[1]");
	
	public OurProductsIframe(WebDriver driver) {
		this.driver = driver;
	}
	
	public void clickButton() throws InterruptedException {
		driver.findElement(openPage).sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		driver.findElement(specialOffers).click();
		Thread.sleep(2000);
		driver.findElement(Close).click();
		Thread.sleep(2000);
		driver.findElement(camera).click();
		Thread.sleep(2000);
		driver.findElement(Proceed).click();
	}
}

