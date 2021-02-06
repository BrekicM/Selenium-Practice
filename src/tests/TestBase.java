package tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import pages.MainPage;

public class TestBase {
	WebDriver driver;
	MainPage mainPage;
	ExcelReader excelReader;
	
	@BeforeClass
	public void beforeClass() throws IOException {
		System.setProperty("webdriver.chrome.driver", "driver-lib\\chromedriver.exe");
		this.driver = new ChromeDriver();
		this.mainPage = new MainPage(driver);
		this.excelReader = new ExcelReader("data/logindata.xlsx");
		driver.manage().window().maximize();
	}
	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
