package testing;

import java.time.Duration;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class AlertsPom {

WebDriver driver = null; 
	
	public AlertsPom(WebDriver driver) {
		this.driver = driver;
	}
	@Test(priority = 2)
    public void JSAlert() throws InterruptedException {
		driver.findElement(By.id("button1")).click();
		//Thread.sleep(2000);
		driver.switchTo().alert().accept();
		//Thread.sleep(2000);
	}
	
	@Test(priority = 3)
    public void ModalAlert() throws InterruptedException {
		driver.findElement(By.id("button2")).click();
		//Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@id='myModal']/div/div/div[3]/button")).click();
		//Thread.sleep(2000);
		
	}
	
	@SuppressWarnings("deprecation")
	@Test(priority = 4)
    public void AjaxLoader() throws InterruptedException {
		driver.findElement(By.id("button3")).click();
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.findElement(By.id("button1")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@id='myModalClick']/div/div/div[3]/button")).click(); 
	
		driver.navigate().back();
		
		
	}
	

	@Test (priority = 5)
	public void JSConfirmBox() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@id='button4']"))).click();
		driver.switchTo().alert().dismiss();
	}
	
	
	
}
