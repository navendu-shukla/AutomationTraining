package atAssignment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AutocompleteTextfield {
	WebDriver driver=null;
	By inputFoodItem=By.cssSelector("input[id='myInput']");
	By submitBtn=By.cssSelector("input[id='submit-button']");
	By listItem=By.xpath
			("//div[@id='myInputautocomplete-list']/div[2]");
	
	public AutocompleteTextfield(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
	}
	
	public void keys(String input) {
		driver.findElement(inputFoodItem).sendKeys(input);
	}
	
	public void selectItem() {
		driver.findElement(listItem).click();
	}
	
	public void clickSubmitBtn() {
		driver.findElement(submitBtn).click();
	}

}
