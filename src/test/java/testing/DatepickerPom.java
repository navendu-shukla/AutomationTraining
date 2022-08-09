package testing;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DatepickerPom {
WebDriver driver = null; 
	
	public DatepickerPom(WebDriver driver) {
		this.driver = driver;
	
	}
	
	public void clickButton() throws InterruptedException {
		String month = "October 2022";
		String date = "15";
		driver.findElement(By.id("datepicker")).click();
	    while(true) {
	    String text = driver.findElement(By.xpath("/html/body/div[2]/div[1]/table/thead/tr[1]/th[2]")).getText();
	    if(text.equals(month))
	    {
	    	break;
	    }
	    else {
	    	driver.findElement(By.xpath("/html/body/div[2]/div[1]/table/thead/tr[1]/th[3]")).click();	
	    }
	    }
	    driver.findElement(By.xpath("/html/body/div[2]/div[1]/table/tbody/tr/td[contains(text(),"+date+")]")).click();   
	}
	
}

