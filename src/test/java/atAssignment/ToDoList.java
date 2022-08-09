package atAssignment;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class ToDoList {
	WebDriver driver=null;
	By element=By.cssSelector
		    ("input[placeholder='Add new todo']");
	By deleteBtn=By.xpath("//ul/li[3]/span/i");
	public ToDoList(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
	}
	public void addElement() {
		driver.findElement(element).sendKeys("make pizza");
		driver.findElement(element).sendKeys(Keys.ENTER);
	}
	public void removeElement() {
		driver.findElement(deleteBtn).click();
	}

}
