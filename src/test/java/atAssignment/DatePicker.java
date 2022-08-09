package atAssignment;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DatePicker {
	WebDriver driver=null;
	public DatePicker(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
	}
	
	public void selectDate() {
		String expectedDate="22-07-2078";
		String emonth=expectedDate.split("-")[1];
		String eyear=expectedDate.split("-")[2];
		String eday=expectedDate.split("-")[0];
		
		WebElement selectDateBtn= driver.findElement
		(By.xpath("//div[@id='datepicker']/span"));
		selectDateBtn.click();
		WebElement mid= driver.findElement
		(By.xpath("//div[@class='datepicker-days']/table/thead/tr[1]/th[2]"));
				
		
		int yearDiff = Integer.parseInt
				(eyear)- Calendar.getInstance().get(Calendar.YEAR);
		System.out.println(yearDiff);
		
		mid.click();

		WebElement next= driver.findElement
		(By.xpath("//div[@class='datepicker-months']/table/thead/tr[1]/th[3]"));
				
				
		WebElement prev= driver.findElement
		(By.xpath("//div[@class='datepicker-months']/table/thead/tr[1]/th[1]"));

		if(yearDiff!=0){

	        //if you have to move next year

	        if(yearDiff>0){

	            for(int i=0;i< yearDiff;i++){

	                //System.out.println("Year Diff->"+i);

	                next.click();


	            }

	        }

	        //if you have to move previous year

	        else if(yearDiff<0){

	            for(int i=0;i< (yearDiff*(-1));i++){

	                //System.out.println("Year Diff->"+i);

	                prev.click();


	            }

	        }

	    }
		
	    //Get all months from calendar to select correct one

	    List<WebElement> list_AllMonthToBook = driver.findElements
	    (By.xpath("//div[@class='datepicker-months']//tbody/tr/td/span"));
	    
	   list_AllMonthToBook.get(Integer.parseInt(emonth)-1).click();


	    //get all dates from calendar to select correct one

	    List<WebElement> list_AllDateToBook = driver.findElements
	    (By.xpath("//div[@class='datepicker-days']//tbody/tr/td"));
	    List<WebElement> currentMonthDays= new ArrayList<WebElement>();
	    
	   
	    for(WebElement d:list_AllDateToBook)	
	    {
	    	String className=d.getAttribute("class");
	    	if((className.equals("today day")) || (className.equals("day"))) {
	    		currentMonthDays.add(d);
	    	}
	    }
	//  for(WebElement d:currentMonthDays)	
	//  {
//	  	String className=d.getAttribute("class");
//	  	System.out.println(className);
//	  	}
	  

	  
	    currentMonthDays.get(Integer.parseInt(eday)-1).click();
	}

}
