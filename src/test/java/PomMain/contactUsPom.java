package PomMain;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class contactUsPom{
	WebDriver driver=null;
	By contactBtn=By.partialLinkText("Contact");
	By firstName=By.xpath("//input[@name='first_name']");
	By lastName=By.xpath("//form[@id='contact_form']/input[2]");
	By email=By.xpath("//form[@id='contact_form']/input[3]");
	By comments=By.cssSelector("textarea[name='message']");
	By submitBtn=By.xpath
			("//input[@class='contact_button' and @value='SUBMIT']");
	
	By resetBtn=By.cssSelector("input[type='reset']");
	
	public contactUsPom(WebDriver driver) {
		this.driver=driver;
	}
	
	public void keys() throws InterruptedException {
		
		driver.findElement(firstName).sendKeys("sahil");
		
		driver.findElement(lastName).sendKeys("pathak");
		
		driver.findElement(email).sendKeys("sahilpathak@gmail.com");
		
		driver.findElement(comments).sendKeys
		("hello this is contact us form");
	}
	public void clickContactButton() throws InterruptedException {
			
			driver.findElement(contactBtn).click();
		}
	public void clickSubmitButton() throws InterruptedException {
		
		driver.findElement(submitBtn).click();
	}
	public void clickResetButton() throws InterruptedException {
		
		driver.findElement(resetBtn).click();
	}
}
