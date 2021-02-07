package tests;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
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
	public void standardUserLoginAndLogout() throws InterruptedException {
		mainPage.inputUsername(excelReader.getCellData("standard", 2, 1));
		mainPage.inputPassword(excelReader.getCellData("standard", 2, 2));
		mainPage.clickLoginButton();
		Assert.assertEquals(productsPage.productsMenuLabelText(), "Products");
		productsPage.clickBurgerButton();
		wait.until(ExpectedConditions.elementToBeClickable(productsPage.getSidebarOptionLogout()));
		productsPage.sidebarOptionLogoutClick();
		Assert.assertEquals(true, mainPage.getLoginButton().isDisplayed());
	}
	
	@Test
	public void lockedOutUserLogin() {
		mainPage.inputUsername(excelReader.getCellData("lockedOut", 2, 1));
		mainPage.inputPassword(excelReader.getCellData("lockedOut", 2, 2));
		mainPage.clickLoginButton();
		wait.until(ExpectedConditions.visibilityOf(mainPage.getUserLockedOutLabel()));
		Assert.assertEquals(true, mainPage.getUserLockedOutLabel().isDisplayed());
	}
	
	@Test
	public void problemUserLoginAndLogout() throws InterruptedException {
		mainPage.inputUsername(excelReader.getCellData("problem", 2, 1));
		mainPage.inputPassword(excelReader.getCellData("problem", 2, 2));
		mainPage.clickLoginButton();
		Assert.assertEquals(productsPage.productsMenuLabelText(), "Products");
		productsPage.clickBurgerButton();
		wait.until(ExpectedConditions.elementToBeClickable(productsPage.getSidebarOptionLogout()));
		productsPage.sidebarOptionLogoutClick();
		Assert.assertEquals(true, mainPage.getLoginButton().isDisplayed());
	}
	
	@Test
	public void performanceGlitchUserLoginAndLogout() throws InterruptedException {
		mainPage.inputUsername(excelReader.getCellData("performanceGlitch", 2, 1));
		mainPage.inputPassword(excelReader.getCellData("performanceGlitch", 2, 2));
		mainPage.clickLoginButton();
		Assert.assertEquals(productsPage.productsMenuLabelText(), "Products");
		productsPage.clickBurgerButton();
		wait.until(ExpectedConditions.elementToBeClickable(productsPage.getSidebarOptionLogout()));
		productsPage.sidebarOptionLogoutClick();
		Assert.assertEquals(true, mainPage.getLoginButton().isDisplayed());
	}
	
	@AfterMethod
	public void clearRefresh() {
		driver.manage().deleteAllCookies();
		driver.navigate().refresh();
	}
}
