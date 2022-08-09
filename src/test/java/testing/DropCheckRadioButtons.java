package testing;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class DropCheckRadioButtons {
	
WebDriver driver = null; 
	
	public DropCheckRadioButtons(WebDriver driver) {
		this.driver = driver;
	}
	
	@Test(priority = 3)
    public void dropDown() throws InterruptedException {
		WebElement ddown = driver.findElement(By.id("dropdowm-menu-1"));
		Select select = new Select(ddown);
		select.selectByValue("c#");
		WebElement ddown1 = driver.findElement(By.id("dropdowm-menu-2"));
		Select select1 = new Select(ddown1);
		select1.selectByValue("testng");
		WebElement ddown2 = driver.findElement(By.id("dropdowm-menu-3"));
		Select select2 = new Select(ddown2);
		select2.selectByValue("jquery");
	}
	
	@Test (priority = 4)
	public void Checkbox() throws InterruptedException {
		driver.findElement(By.xpath("//div[@id='checkboxes']/label/input[@value='option-1']")).click();
		driver.findElement(By.xpath("//div[@id='checkboxes']/label/input[@value='option-2']")).click();
		driver.findElement(By.xpath("//div[@id='checkboxes']/label/input[@value='option-3']")).click();
		driver.findElement(By.xpath("//div[@id='checkboxes']/label/input[@value='option-4']")).click();
		
	}
	
	@Test (priority = 5)
	public void SelectedAndDisabled() throws InterruptedException {
		driver.findElement(By.xpath("//input[@value='green']")).click();
		driver.findElement(By.xpath("//input[@value='lettuce']")).click();
		WebElement ddown4 = driver.findElement(By.id("fruit-selects"));
		Select select4 = new Select(ddown4);
		select4.selectByValue("pear");
	}
	
}


	
	

