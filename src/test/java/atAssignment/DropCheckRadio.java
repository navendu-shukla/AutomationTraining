package atAssignment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class DropCheckRadio {
	WebDriver driver=null;
	
	
	public DropCheckRadio(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
	}
	public void dropDownAutomation() {
		 Select dropdown = new Select(driver.findElement(By.xpath
		    		("//select[@id='dropdowm-menu-1']")));  
		    dropdown.selectByVisibleText("Python");  
		    Select dropdown2 = new Select(driver.findElement(By.xpath
		    		("//select[@id='dropdowm-menu-2']")));  
		    dropdown2.selectByIndex(2);  

		    Select dropdown3 = new Select(driver.findElement(By.xpath
		    		("//select[@id='dropdowm-menu-3']")));  
		    dropdown3.selectByValue("javascript"); 
	}
	
	public void checkBoxAutomation() {
		driver.findElement(By.cssSelector
	    		("input[value=option-3]")).click();

	    
	    driver.findElement(By.cssSelector
	    		("input[value=option-1]")).click();
	    
	    driver.findElement(By.cssSelector
	    		("input[value=option-4]")).click();
	}
	
	public void radioButtonAutomation() {
		driver.findElement(By.cssSelector
	    		("input[value=green]")).click();
	    
	    int a=driver.findElements(By.cssSelector
	    		("input[name=color]")).size();
	    System.out.println(a);
	    for(int i=0;i<a;i++)
	    {
	    	driver.findElements(By.xpath
            		("//input[@name='color']")).get(i).click(); 
	    }
	    
	}
	
	public void disabledRadioButtonAutomation() {
		int a1=driver.findElements(By.cssSelector
	    		("input[name='vegetable']")).size();
	    System.out.println(a1);
	    for(int i=0;i<a1;i++)
	    {
	    	
	    	WebElement e=driver.findElements(By.xpath
            		("//input[@name='vegetable']")).get(i); 
	    	boolean selectState = e.isEnabled();
			
	    	//performing click operation only if element is enabled
	    	if(selectState == true) {
	    		e.click();

	    	}
	    }
	}
	
	public void disabledDropDownAutomation() {
		 Select sel = new Select(driver.findElement(By.xpath
		    		("//select[@id='fruit-selects']")));  
		    sel.selectByVisibleText("Apple");  
		     
		    sel.selectByIndex(2);  

		   
		    sel.selectByValue("grape"); 
	}
	    

}
