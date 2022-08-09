package atAssignment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;


public class ActionCommand extends chromeDriverInitial{
	//WebDriver driver=null;
	
	  By source=By.cssSelector("div[id='draggable']");
	  By target=By.cssSelector("div[id='droppable']");
	  By dblClickBtn=By.cssSelector("div[id='double-click']");
	  By hover1=By.xpath("//div[@id='div-hover']/div[1]");
	  By hover2=By.xpath("//div[@id='div-hover']/div[2]");
	  By hover3=By.xpath("//div[@id='div-hover']/div[3]");
	  By hvr1Link1=By.xpath("//div[@id='div-hover']/div[1]/div/a");
	  By hvr2Link1=By.xpath("//div[@id='div-hover']/div[2]/div/a");
	  By hvr3Link1=By.xpath("//div[@id='div-hover']/div[3]/div/a[1]");
	  By hvr3Link2=By.xpath("//div[@id='div-hover']/div[3]/div/a[2]");
	  By clickHold=By.cssSelector("div[id='click-box']");
	  Actions action=new Actions(driver);
//	public ActionCommand(WebDriver driver) {
//		// TODO Auto-generated constructor stub
//		this.driver=driver;
//	}
	
	public void dragDrop(WebElement source,WebElement target) {
		action.dragAndDrop(source, target).perform();
	}
	public void doubleClick() {
		action.doubleClick(driver.findElement(dblClickBtn));
	}
	
	public void hover(By hvr) {
		action.moveToElement(driver.findElement(hvr)).perform();
	}
	
	public void clickHoverLink(By hvr) {
		action.click(driver.findElement(hvr)).perform();
	}
	
	public void holdClickHold() {
		 action.clickAndHold(driver.findElement
				  (clickHold)).perform();
	}
	
	public void handleAlert() {
		driver.switchTo().alert().accept();
	}
	
	

}
