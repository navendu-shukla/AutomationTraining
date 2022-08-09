package testing;



import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.testng.annotations.Test;

public class HiddenElementsPom {

WebDriver driver = null; 
	
	
	public HiddenElementsPom(WebDriver driver) {
		this.driver = driver;
	}
	
	@Test(priority = 2)
    public void NotDisplayed() throws InterruptedException {
		//Not Displayed Element
		WebElement element = driver.findElement(By.cssSelector("span[id='button1']"));
		JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].click();", element);
        
        driver.findElement(By.xpath("//div[@id='myModalClick']/div/div/div[3]/button")).click();
     
	}
	
	@Test (priority = 3)
	public void HiddenElement() {
		//Visibility Hidden Element
        WebElement element1 = driver.findElement(By.cssSelector("span[id='button2']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", element1);
       
        driver.findElement(By.xpath("//div[@id='myModalJSClick']/div/div/div[3]/button")).click();
        
	}
	
	@Test (priority = 4)
	public void ZeroOpacity() throws InterruptedException {
		 //Zero Opacity Element
        WebElement element2 = driver.findElement(By.cssSelector("span[id='button3']"));
        JavascriptExecutor js2 = (JavascriptExecutor) driver;
        js2.executeScript("arguments[0].click();", element2);

        driver.findElement(By.xpath("//div[@id='myModalMoveClick']/div/div/div[3]/button")).click();

	}
	
}
