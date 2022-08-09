package testing;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class FileUploadPom {

WebDriver driver = null; 
	
	public FileUploadPom(WebDriver driver) {
		this.driver = driver;
	}
    public void testFileUpload(){
		driver.findElement(By.id("myFile")).sendKeys("/Users/riasengar/Documents");
		
		driver.findElement(By.id("submit-button")).click();
		
		driver.switchTo().alert().accept();
	}
}

