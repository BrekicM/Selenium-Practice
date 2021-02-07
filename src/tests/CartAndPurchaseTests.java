package tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CartAndPurchaseTests extends TestBase{
	
	@BeforeMethod
	public void openPage() throws InterruptedException {
		driver.navigate().to("https://www.saucedemo.com/");
		Thread.sleep(2000);
	}
	
	@Test
	public void addItemToCartAndCompletePurchase() {
		mainPage.logIn(excelReader.getCellData("standard", 2, 1), excelReader.getCellData("standard", 2, 2));
		mainPage.clickLoginButton();
		productsPage.addFouthProductToCart();
		productsPage.clickShoppingCartButton();
		cartPage.clickCheckoutButton();
		infoPage.inputFirstName("Pera");
		infoPage.inputLastName("Peric");
		infoPage.inputZipCode("21000");
		infoPage.clickContinueButton();
		checkoutPage.clickFinishButton();
		Assert.assertEquals(finishPage.completeOrderText(), "THANK YOU FOR YOUR ORDER");		
	}
	
	@Test
	public void addItemToCartRemoveItAndReturnToProducts() {
		mainPage.logIn(excelReader.getCellData("standard", 2, 1), excelReader.getCellData("standard", 2, 2));
		mainPage.clickLoginButton();
		productsPage.addFouthProductToCart();
		productsPage.clickShoppingCartButton();
		cartPage.clickRemoveButton();
		cartPage.clickContinueShoppingButton();
		Assert.assertEquals(productsPage.productsMenuLabelText(), "Products");
	}
	
	//@Test
	public void threeItemsToCart() throws InterruptedException {
		mainPage.inputUsername(excelReader.getCellData("standard", 2, 1));
		mainPage.inputPassword(excelReader.getCellData("standard", 2, 2));
		mainPage.clickLoginButton();
		Assert.assertEquals(productsPage.productsMenuLabelText(), "Products");
		Thread.sleep(3000);
		productsPage.addSeveralItemsToCart();
	}
	
	@AfterMethod
	public void clearRefresh() {
		driver.manage().deleteAllCookies();
		driver.navigate().refresh();
	}
}

