package atAssignment;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class HiddenElements extends chromeDriverInitial{
	WebElement btn1= driver.findElement
			(By.cssSelector("span[id='button1']"));
	WebElement btn2= driver.findElement
			(By.cssSelector("span[id='button2']"));
	WebElement btn3= driver.findElement
			(By.cssSelector("span[id='button3']"));
	
	By closeBtn1=By.xpath("//div[@id='myModalClick']/div/div/div[3]/button");
	By closeBtn2=By.xpath("//div[@id='myModalJSClick']/div/div/div[3]/button");
	By closeBtn3=By.xpath("//div[@id='myModalMoveClick']/div/div/div[3]/button");
	JavascriptExecutor js = (JavascriptExecutor)driver;

	
	public void clickBtn(WebElement btn) {
	
		js.executeScript("arguments[0].click();", btn);

	}
	
	public void clickCloseBtn(By btn) {
		driver.findElement(btn).click();
	}

}
