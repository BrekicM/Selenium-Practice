package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MainPage {
	WebDriver driver;
	WebElement usernameField;
	WebElement passwordField;
	WebElement loginButton;
	WebElement userLockedOutLabel;
	
	public MainPage(WebDriver driver) {
		//super();
		this.driver = driver;
	}

	public WebElement getUsernameField() {
		return driver.findElement(By.id("user-name"));
	}

	public WebElement getPasswordField() {
		return driver.findElement(By.id("password"));
	}

	public WebElement getLoginButton() {
		return driver.findElement(By.id("login-button"));
	}
	
	public WebElement getUserLockedOutLabel() {
		return driver.findElement(By.cssSelector("h3[data-test='error']"));
	}

	public void inputUsername(String username) {
		getUsernameField().clear();
		getUsernameField().sendKeys(username);
	}
	
	public void inputPassword(String password) {
		getPasswordField().clear();
		getPasswordField().sendKeys(password);
	}
	
	public void clickLoginButton() {
		getLoginButton().click();
	}
	
}
