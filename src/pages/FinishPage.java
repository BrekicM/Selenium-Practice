package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FinishPage {
	WebDriver driver;
	WebElement completeOrderText;
	
	public FinishPage(WebDriver driver) {
		//super();
		this.driver = driver;
	}

	public WebElement getCompleteOrderText() {
		return driver.findElement(By.cssSelector("h2[class='complete-header']"));
	}
	
	public String completeOrderText() {
		return getCompleteOrderText().getText();
	}
}
