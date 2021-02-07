package pages;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductsPage {
	WebDriver driver;
	WebElement productsMenuLabel;
	WebElement burgerButton;
	WebElement sidebarOptionLogout;
	WebElement fourthProduct;
	WebElement shoppingCartButton;
	
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
	
	public WebElement getFourthProduct() {
		return driver.findElement(By.xpath("//div[4]//div[3]//button[1]"));
	}
	
	public WebElement getShoppingCartButton() {
		return driver.findElement(By.id("shopping_cart_container"));
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
	
	public void addFouthProductToCart() {
		getFourthProduct().click();
	}
	
	public void clickShoppingCartButton() {
		getShoppingCartButton().click();
	}
	
	public void addSeveralItemsToCart() throws InterruptedException {
		int j = 0;
		String[] itemsNeeded = {"Sauce Labs Bike Light", "Sauce Labs Fleece Jacket", "Sauce Labs Onesie"};
		List<WebElement> products = driver.findElements(By.xpath("//div[@class='inventory_item_label']/a"));
		List addToCartList = Arrays.asList(itemsNeeded);	// converted array to list
		for (int i = 0; i < products.size(); i++) {
			String productName = products.get(i).getText();
			if(addToCartList.contains(productName)) {
				//j++;
				driver.findElements(By.xpath("//button[@class='btn_primary btn_inventory']")).get(i).click();
				Thread.sleep(1000);
				/*if (j == 3) {
					break;
				} */
			}
			
		}
	}
}
