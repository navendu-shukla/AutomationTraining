package assignment;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
//import org.openqa.selenium.Keys;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ContactUs extends MainDriver{
	
	@BeforeClass
	public void setup() {
		MainDriver.CreateInstance();

	    driver.manage().window().maximize();
		driver.get("http://www.webdriveruniversity.com/");
		String expectedTitle = "WebDriverUniversity.com";
		String actualTitle = driver.getTitle();
		Assert.assertEquals(actualTitle,expectedTitle);
		String parentHandle = driver.getWindowHandle();
		System.out.println("parent window - " +parentHandle);
		driver.findElement(By.id("contact-us")).click();

		Set<String> handles = driver.getWindowHandles();
		for (String handle : handles) {
			System.out.println(handle);
			if(!handle.equals(parentHandle)) {
				driver.switchTo().window(handle);
			}
		}
	}
	
	@Test (priority = 1)
	public void verifyContactUsHeaderIsDisplayed() {
		Assert.assertTrue(driver.findElement(By.cssSelector(".section_header")).isDisplayed());
	}
	
	@Test(priority = 2)
    public void testWebUniversity() throws InterruptedException {
	driver.findElement(By.xpath("//form[@id='contact_form']/input[@name='first_name']")).sendKeys("Ria");
	driver.findElement(By.xpath("//form[@id='contact_form']/input[@name='last_name']")).sendKeys("Sengar");
	driver.findElement(By.xpath("//form[@id='contact_form']/input[@name='email']")).sendKeys("sengarria4321@gmail.com");
	driver.findElement(By.xpath("//form[@id='contact_form']/textarea[@placeholder='Comments']")).sendKeys("Automation testing");
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[starts-with(@value,'SUBMIT')]"))).click();
	
	}
	
	
	@Test (priority = 3)
	public void verifyThankyouPageIsDisplayed() {
		Assert.assertTrue(driver.findElement(By.cssSelector("#contact_reply")).isDisplayed());
	}
	
	
	@AfterClass
	public void tierDown() {
		driver.quit();
	}
	
}
