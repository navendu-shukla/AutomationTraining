package testing;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class Actions1Pom {

WebDriver driver = null; 

	public Actions1Pom(WebDriver driver) {
		this.driver = driver;
	}
	
	@Test(priority = 2)
    public void DragAndDrop() throws InterruptedException {
		WebElement drag = driver.findElement(By.id("draggable"));
		WebElement drop = driver.findElement(By.id("droppable"));
		Actions action = new Actions(driver);
		action.dragAndDrop(drag, drop).perform();
	}
	
	@Test (priority = 3)
	public void DoubleClick() {
		WebElement clickable = driver.findElement(By.id("double-click"));
	        new Actions(driver)
            .doubleClick(clickable)
            .perform();
	}
	
	@Test (priority = 4)
	public void FirstHover() throws InterruptedException {
		WebElement element = driver.findElement(By.xpath("//div[@id='div-hover' ]/div/button[@class='dropbtn']"));
		Actions hover1 = new Actions(driver);
		  hover1.moveToElement(element).perform();
          
        WebElement link1 = driver.findElement(By.xpath("//div[@id='div-hover']/div/div/a[1]"));
         Actions link1click = new Actions(driver);
          link1click.click(link1).perform();
      
          driver.switchTo().alert().accept();
	}
	
	@Test (priority = 5)
	public void SecondHover() throws InterruptedException {
		 WebElement element1 = driver.findElement(By.xpath("//div[@id='div-hover' ]/div[@class='dropdown']/button[1]"));
			Actions hover2 = new Actions(driver);
		  hover2.moveToElement(element1).perform();
		    
	            
	      WebElement link2 = driver.findElement(By.xpath("//div[@class='dropdown']/div[@class='dropdown-content' and @style='left:0;']/a"));
	      Actions link2click = new Actions(driver);
	      link2click.click(link2).perform();
	      
	      driver.switchTo().alert().accept();
	}
	
	@Test (priority = 6)
	public void ThirdHover() throws InterruptedException {
		 WebElement element2 = driver.findElement(By.xpath("//div[@class='dropdown' and @style='float:right;']/button"));
			Actions hover3 = new Actions(driver);
		    hover3.moveToElement(element2).perform();
	       
		            
         WebElement link3 = driver.findElement(By.xpath("//div[@id='div-hover']/div/div/a[2]"));
		     Actions link3click = new Actions(driver);
		     link3click.click(link3).perform();
		     
		      driver.switchTo().alert().accept();
	}
	
	@Test (priority = 7)
	public void ClickAndHold() throws InterruptedException {
		WebElement clickandhold = driver.findElement(By.id("click-box"));
		Actions clickandhold1 = new Actions(driver);
	    clickandhold1.clickAndHold(clickandhold).perform();
	}
	

	
}
