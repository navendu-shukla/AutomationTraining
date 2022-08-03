package assignment;


import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.ui.Select;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class dropdown extends MainDriver{
	
	
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
		driver.findElement(By.id("dropdown-checkboxes-radiobuttons")).click();

		Set<String> handles = driver.getWindowHandles();
		for (String handle : handles) {
			System.out.println(handle);
			if(!handle.equals(parentHandle)) {
				driver.switchTo().window(handle);
			}
		}
	}
	
	@Test (priority = 1)
	public void verifyDropdownCheckboxesRadioHeaderIsDisplayed() {
		Assert.assertTrue(driver.findElement(By.cssSelector("#main-header")).isDisplayed());
	}
	
	@Test (priority = 2)
	public void verifyCopyrightIsDisplayed() {
		Assert.assertTrue(driver.findElement(By.cssSelector(".col-sm-12")).isDisplayed());
	}
	
	
	@Test(priority = 3)
    public void dropDown() throws InterruptedException {
		WebElement ddown = driver.findElement(By.id("dropdowm-menu-1"));
		Select select = new Select(ddown);
		select.selectByValue("c#");
		//Thread.sleep(2000);
		
		WebElement ddown1 = driver.findElement(By.id("dropdowm-menu-2"));
		Select select1 = new Select(ddown1);
		select1.selectByValue("testng");
		//Thread.sleep(2000);
		
		WebElement ddown2 = driver.findElement(By.id("dropdowm-menu-3"));
		Select select2 = new Select(ddown2);
		select2.selectByValue("jquery");
		//Thread.sleep(2000);
	
	}
	
	@Test (priority = 4)
	public void Checkbox() throws InterruptedException {
		driver.findElement(By.xpath("//div[@id='checkboxes']/label/input[@value='option-1']")).click();
		//Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@id='checkboxes']/label/input[@value='option-2']")).click();
		//Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@id='checkboxes']/label/input[@value='option-3']")).click();
		//Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@id='checkboxes']/label/input[@value='option-4']")).click();
		//Thread.sleep(2000);
	}
	
	@Test (priority = 5)
	public void SelectedAndDisabled() throws InterruptedException {
		driver.findElement(By.xpath("//input[@value='green']")).click();
		//Thread.sleep(2000);
		
		driver.findElement(By.xpath("//input[@value='lettuce']")).click();
		//Thread.sleep(2000);
		
		WebElement ddown4 = driver.findElement(By.id("fruit-selects"));
		Select select4 = new Select(ddown4);
		select4.selectByValue("pear");
		//Thread.sleep(2000);
	}
	
	
	
	@AfterClass
	public void tierDown() {
		driver.quit();
	}
	
}




