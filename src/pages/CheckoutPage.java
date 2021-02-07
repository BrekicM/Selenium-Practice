package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckoutPage {
	WebDriver driver;
	WebElement finishButton;
	
	public CheckoutPage(WebDriver driver) {
		//super();
		this.driver = driver;
	}

	public WebElement getFinishButton() {
		return driver.findElement(By.cssSelector("a[class='btn_action cart_button']"));
	}
	
	public void clickFinishButton() {
		getFinishButton().click();
	}
}
