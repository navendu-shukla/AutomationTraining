package testing;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class AjaxPom {

WebDriver driver = null; 
	
	By Button = By.id("button1");
	By Close = By.xpath("//button[@class='btn btn-default']");
	public AjaxPom(WebDriver driver) {
		this.driver = driver;
	}
	@Test 
	public void clickButton() throws InterruptedException {
		driver.findElement(Button).click();
	    driver.findElement(Close).click();
	}}
