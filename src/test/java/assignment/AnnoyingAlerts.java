package assignment;

import java.time.Duration;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AnnoyingAlerts extends MainDriver{
	
	@SuppressWarnings("deprecation")
	@BeforeClass
	public void setup() {
		MainDriver.CreateInstance();

	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("http://www.webdriveruniversity.com/");
		String expectedTitle = "WebDriverUniversity.com";
		String actualTitle = driver.getTitle();
		Assert.assertEquals(actualTitle,expectedTitle);
		String parentHandle = driver.getWindowHandle();
		System.out.println("parent window - " +parentHandle);
		driver.findElement(By.id("popup-alerts")).click();

		Set<String> handles = driver.getWindowHandles();
		for (String handle : handles) {
			System.out.println(handle);
			if(!handle.equals(parentHandle)) {
				driver.switchTo().window(handle);
			}
		}
	}
	
	@Test (priority = 1)
	public void verifyHeaderIsDisplayed() {
		Assert.assertTrue(driver.findElement(By.cssSelector("#main-header")).isDisplayed());
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
	
	
	@Test (priority = 6)
	public void verifyCopyrightIsDisplayed() {
		Assert.assertTrue(driver.findElement(By.cssSelector(".col-lg-12")).isDisplayed());
	}
	
	
	@AfterClass
	public void tierDown() {
		driver.quit();
	}
	
}

