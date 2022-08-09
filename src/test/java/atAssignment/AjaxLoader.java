package atAssignment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AjaxLoader {
	WebDriver driver=null;
	By btn=By.cssSelector("span[id='button1']");
	By closeBtn=By.xpath("//div[@id='myModalClick']/div/div/div[3]/button");
	
	public AjaxLoader(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
	}
	
	public void clickBtn() {
		driver.findElement(btn).click();
		driver.findElement(closeBtn).click();
	}

}
