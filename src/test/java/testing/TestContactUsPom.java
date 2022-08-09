package testing;

import java.util.ArrayList;

import org.openqa.selenium.By;
//import org.openqa.selenium.Keys;
//import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
//import org.testng.Assert;
import org.testng.annotations.Test;

@Test 
public class TestContactUsPom {

WebDriver driver = null; 
	
    //By openPage = By.xpath("//ul[@class='nav navbar-nav']//li[3]/a");
    
	By firstName = By.xpath("//form[@id='contact_form']/input[@name='first_name']");
	By lastName = By.xpath("//form[@id='contact_form']/input[@name='last_name']");
	By email = By.xpath("//form[@id='contact_form']/input[@name='email']");
	By comments = By.xpath("//form[@id='contact_form']/textarea[@placeholder='Comments']");
	By submit = By.xpath("//input[starts-with(@value,'SUBMIT')]");
	
	public TestContactUsPom(WebDriver driver) {
		this.driver = driver;
	}
	@Test 
	public void keys(ArrayList<String> text) throws InterruptedException {
		driver.findElement(firstName).sendKeys(text.get(0));
		driver.findElement(lastName).sendKeys(text.get(1));
		driver.findElement(email).sendKeys(text.get(2));
		driver.findElement(comments).sendKeys(text.get(3));
	}
	//public void openContactUsPage() throws InterruptedException {
		//driver.findElement(openPage).sendKeys(Keys.ENTER);
	
	//}
	@Test 
	public void clickButton() throws InterruptedException {
		driver.findElement(submit).click();
	}

	
}

