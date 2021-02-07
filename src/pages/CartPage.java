package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CartPage {
	WebDriver driver;
	WebElement checkoutButton;
	WebElement removeButton;
	WebElement continueShoppingButton;
	
	public CartPage(WebDriver driver) {
		//super();
		this.driver = driver;
	}

	public WebElement getCheckoutButton() {
		return driver.findElement(By.cssSelector("a[class='btn_action checkout_button']"));
	}
	
	
	public WebElement getRemoveButton() {
		return driver.findElement(By.cssSelector("button[class='btn_secondary cart_button']"));
	}

	public WebElement getContinueShoppingButton() {
		return driver.findElement(By.cssSelector("a[class='btn_secondary']"));
	}

	public void clickCheckoutButton() {
		getCheckoutButton().click();
	}	
	
	public void clickRemoveButton() {
		getRemoveButton().click();
	}
	
	public void clickContinueShoppingButton() {
		getContinueShoppingButton().click();
	}
}
