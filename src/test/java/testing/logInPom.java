package testing;

import java.util.ArrayList;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
//import org.testng.Assert;
import org.testng.annotations.Test;

public class logInPom {
WebDriver driver = null; 
	
	By UserName = By.xpath("//input[starts-with(@id,'text')]");
	By Password = By.xpath("//input[starts-with(@id,'password')]");
	By submit = By.xpath("//button[@type='submit' and  @id='login-button']");
	
	public logInPom(WebDriver driver) {
		this.driver = driver;
	}
	@Test 
	public void keys(ArrayList<String> text) throws InterruptedException {
		driver.findElement(UserName).sendKeys(text.get(0));
		driver.findElement(Password).sendKeys(text.get(1));
		
	}
	@Test 
	public void clickButton() throws InterruptedException {
		driver.findElement(submit).click();
		driver.switchTo().alert().accept();
	}

	
}

