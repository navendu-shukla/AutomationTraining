package atAssignment;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ButtonClick extends chromeDriverInitial{
	//WebDriver driver=null;
	By btn1=By.xpath("//span[@id='button1']");
	By btn2=By.xpath("//span[@id='button2']");
	By btn3=By.xpath("//span[@id='button3']");
	By closeBtn1=By.xpath("//div[@id='myModalClick']/div/div/div[3]/button");
	By closeBtn2=By.xpath("//div[@id='myModalJSClick']/div/div/div[3]/button");
	By closeBtn3=By.xpath("//div[@id='myModalMoveClick']/div/div/div[3]/button");
	Actions act=new Actions(driver);
	JavascriptExecutor js = (JavascriptExecutor)driver;

//	public ButtonClick(WebDriver driver) {
//		// TODO Auto-generated constructor stub
//		this.driver=driver;
//	}
	public void clickBtn1() {
		driver.findElement(btn1).click();
	}
	public void clickBtn2() {
		WebElement element = driver.findElement(btn2);
			    
			    js.executeScript("arguments[0].click();", element);
	}
	public void clickBtn3() {
		
		    
		    act.click(driver.findElement(btn3)).perform(); 
	}
	public void clickCloseBtn1() {
		driver.findElement(closeBtn1).click();;
	}
	public void clickCloseBtn2() {
		driver.findElement(closeBtn2).click();
	}
	public void clickCloseBtn3() {
		
	    
	   driver.findElement(closeBtn3).click();
}
	
	

}
