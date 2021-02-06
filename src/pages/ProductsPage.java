package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductsPage {
	WebDriver driver;
	WebElement productsMenuLabel;
	WebElement burgerButton;
	WebElement sidebarOptionLogout;
	
	public ProductsPage(WebDriver driver) {
		//super();
		this.driver = driver;
	}

	public WebElement getProductsMenuLabel() {
		return driver.findElement(By.className("product_label"));
	}
	
	public WebElement getBurgerButton() {
		return driver.findElement(By.className("bm-burger-button"));
	}

	public WebElement getSidebarOptionLogout() {
		return driver.findElement(By.id("logout_sidebar_link"));
	}

	public String productsMenuLabelText() {
		return getProductsMenuLabel().getText();
	}
	
	public void clickBurgerButton() {
		getBurgerButton().click();
	}
	
	public void sidebarOptionLogoutClick() {
		getSidebarOptionLogout().click();
	}
	
}
