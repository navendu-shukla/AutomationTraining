package testing;

import java.time.Duration;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class ClicksPom {

WebDriver driver = null; 
	
	By webElementClick = By.xpath("//span[starts-with(@id,'button1')]");
	By JSClick = By.cssSelector("span#button2");
	By ActionClick = By.cssSelector("span#button3");
	
	public ClicksPom(WebDriver driver) {
		this.driver = driver;
	}
	@Test
	public void clickButton() throws InterruptedException {
		driver.findElement(webElementClick).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='myModalClick']/div/div/div[3]/button"))).click();
		
		driver.findElement(JSClick).click();
		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='myModalJSClick']/div/div/div[3]/button"))).click();
		
		
		driver.findElement(ActionClick).click();
		WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='myModalMoveClick']/div/div/div[3]/button"))).click();
	}
	
}

