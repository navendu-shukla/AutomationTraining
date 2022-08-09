package testing;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class TodoListPom {

WebDriver driver = null; 
	
	By PlusIcon = By.xpath("//i[starts-with(@id,'plus-icon')]");
	By NewTask = By.xpath("//input[starts-with(@placeholder,'Add new todo')]");
	By Strike = By.xpath("//ul/li[1]");
	By Delete = By.xpath("//ul/li[3]/span/i");
	
	public TodoListPom(WebDriver driver) {
		this.driver = driver;
	}
	
	@Test (priority=2)
	public void keys(ArrayList<String> text) throws InterruptedException {
		driver.findElement(NewTask).sendKeys(text.get(0));
	}
	@Test (priority=1)
	public void clickButton() throws InterruptedException {
		driver.findElement(PlusIcon).click();
	}
	
	@Test (priority=3)
	public void clickButton2() throws InterruptedException {
		driver.findElement(Strike).click();
		driver.findElement(Delete).click();
	}

	
}

