package testing;



import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class AutoCompletePom {

WebDriver driver = null; 
	
	By UserName = By.xpath("//input[starts-with(@id,'text')]");
	By Password = By.xpath("//input[starts-with(@id,'password')]");
	By submit = By.xpath("//button[@type='submit' and  @id='login-button']");
	
	public AutoCompletePom(WebDriver driver) {
		this.driver = driver;
	}

	
	@Test(priority = 2)
    public void testAutoComplete(){
		driver.findElement(By.id("myInput")).sendKeys("A");
		driver.findElement(By.id("myInput")).sendKeys(Keys.ARROW_DOWN , Keys.ARROW_DOWN);
		driver.findElement(By.id("myInput")).sendKeys(Keys.ENTER);
		driver.findElement(By.id("submit-button")).click();
		
		driver.findElement(By.id("myInput")).sendKeys("Ba");
		driver.findElement(By.id("myInput")).sendKeys(Keys.ARROW_DOWN , Keys.ARROW_DOWN , Keys.ARROW_DOWN);
		driver.findElement(By.id("myInput")).sendKeys(Keys.ENTER);
		driver.findElement(By.id("submit-button")).click();
	
	
	}
	
}

