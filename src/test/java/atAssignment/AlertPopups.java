package atAssignment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AlertPopups {
	WebDriver driver=null;
	By btn1=By.cssSelector("span[id='button1']");
	By btn2=By.cssSelector("span[id='button2']");
	By btn3=By.cssSelector("span[id='button3']");
	By btn4=By.cssSelector("span[id='button4']");
	By btnAjax=By.cssSelector("span[id='button1']");
	By closeBtnBtn2=By.xpath("//div[@id='myModal']/div/div/div[3]/button");
	By closeBtnAjax=By.xpath("//div[@id='myModalClick']/div/div/div[3]/button");
	
	public AlertPopups(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
		
	}
	
	public void alertAccept() {
		driver.switchTo().alert().accept();
	}
	
	public void alertDismiss() {
		driver.switchTo().alert().dismiss();
	}
	public void clickBtn(By btn) {
		driver.findElement(btn).click();
	}
	
	public void clickCloseBtn(By closeBtn) {
		driver.findElement(closeBtn).click();
	}

}
