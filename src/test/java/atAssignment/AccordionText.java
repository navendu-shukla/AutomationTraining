package atAssignment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccordionText {
	WebDriver  driver=null;
	By btn1=By.cssSelector("button[id=manual-testing-accordion]");
	By btn2=By.cssSelector("button[id=cucumber-accordion]");
	By btn3=By.cssSelector("button[id=automation-accordion]");
	By btn4=By.cssSelector("button[id=click-accordion]");
	By loadingStatus=By.xpath("//p[@id='hidden-text']");
	
	public AccordionText(WebDriver driver) {
		this.driver=driver;
	}
	
	public void clickBtn(By btn) {
		driver.findElement(btn).click();
	}
	
	
}
