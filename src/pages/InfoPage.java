package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class InfoPage {
	WebDriver driver;
	WebElement firstNameField;
	WebElement lastNameField;
	WebElement zipCodeField;
	WebElement continueButton;
	
	public InfoPage(WebDriver driver) {
		//super();
		this.driver = driver;
	}

	public WebElement getFirstNameField() {
		return driver.findElement(By.id("first-name"));
	}

	public WebElement getLastNameField() {
		return driver.findElement(By.id("last-name"));
	}

	public WebElement getZipCodeField() {
		return driver.findElement(By.id("postal-code"));
	}

	public WebElement getContinueButton() {
		return driver.findElement(By.cssSelector("input[value='CONTINUE']"));
	}
	
	public void inputFirstName(String name) {
		getFirstNameField().sendKeys(name);
	}
	
	public void inputLastName(String lastName) {
		getLastNameField().sendKeys(lastName);
	}
	
	public void inputZipCode(String zipCode) {
		getZipCodeField().sendKeys(zipCode);
	}
	
	public void clickContinueButton() {
		getContinueButton().click();
	}
	
}
