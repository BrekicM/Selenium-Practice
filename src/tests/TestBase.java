package tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import pages.MainPage;
import pages.ProductsPage;

public class TestBase {
	WebDriver driver;
	WebDriverWait wait;
	MainPage mainPage;
	ExcelReader excelReader;
	ProductsPage productsPage;
	
	@BeforeClass
	public void beforeClass() throws IOException {
		System.setProperty("webdriver.chrome.driver", "driver-lib\\chromedriver.exe");
		this.driver = new ChromeDriver();
		this.wait = new WebDriverWait(driver, 5);
		this.excelReader = new ExcelReader("data/logindata.xlsx");
		this.mainPage = new MainPage(driver);
		this.productsPage = new ProductsPage(driver);
		driver.manage().window().maximize();
	}
	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
