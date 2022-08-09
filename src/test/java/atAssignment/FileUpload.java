package atAssignment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FileUpload {
	WebDriver driver=null;
	By submitBtn=By.cssSelector("input[id='submit-button']");
	By chooseFile=By.id("myFile");
	public FileUpload(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
	}
	public void enterFilepath() {
		driver.findElement(chooseFile).sendKeys("/Users/sahil.pathak/Downloads/flower.jpeg");
	}
	
	public void clickSubmitBtn() {
		driver.findElement(submitBtn).click();
	}
	public void handleAlert() {
		driver.switchTo().alert().accept();
	}

}
