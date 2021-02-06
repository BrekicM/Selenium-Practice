package tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase{
	
	@BeforeMethod
	public void openPage() throws InterruptedException {
		driver.navigate().to("https://www.saucedemo.com/");
		Thread.sleep(2000);
	}
	
	@Test
	public void standardLogin() {
		mainPage.inputUsername(excelReader.getCellData("standard", 2, 1));
		mainPage.inputPassword(excelReader.getCellData("standard", 2, 2));
		mainPage.clickLoginButton();
	}
	
	@AfterMethod
	public void clearRefresh() {
		driver.manage().deleteAllCookies();
		driver.navigate().refresh();
	}
}
