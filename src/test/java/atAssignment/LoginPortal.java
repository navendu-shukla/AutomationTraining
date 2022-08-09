package atAssignment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPortal {
	WebDriver driver=null;
	By username=By.cssSelector("input[placeholder='Username']"); 
	By password=By.cssSelector("input[placeholder='Password']");
	By loginBtn=By.cssSelector
    		("button[id='login-button']");
	
	public LoginPortal(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
		
	}
	public void keys() {
		driver.findElement(username).sendKeys("webdriver");
		driver.findElement(password).sendKeys("webdriver123");
	}
	public void clickLoginBtn() {
		driver.findElement(loginBtn).click();
	}
	public void handleAlert() {
		driver.switchTo().alert().accept();
	}

}
