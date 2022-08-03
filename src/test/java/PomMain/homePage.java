package PomMain;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class homePage {
	WebDriver driver=null;
	By nextBtn=By.cssSelector("a[data-slide='next']");
	By prevBtn=By.cssSelector("a[data-slide='prev']");
	By findMoreBtn=By.cssSelector("button[id=button-find-out-more]");
	By closeBtn=By.xpath("//div[@id='myModal']/div/div/div[3]/button[2]");
	public homePage(WebDriver driver) {
		this.driver=driver;
	}
	public void clickButton() throws InterruptedException
	{
		driver.findElement(nextBtn).click();
		
		driver.findElement(prevBtn).click();
		
		driver.findElement(nextBtn).click();
		
		driver.findElement(findMoreBtn).click();
		
		driver.findElement(closeBtn).click();
	}
}
