package com.qa.opencart.base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.qa.opencart.factory.DriverFactory;
import com.qa.opencart.pages.AccountsPage;
import com.qa.opencart.pages.LoginPage;

public class BaseTest {

	DriverFactory df;
	WebDriver driver;
	protected LoginPage loginPage;
	protected AccountsPage accountsPage;
	@BeforeTest
	public void setUp() {
		df = new DriverFactory();// created driverfactory object
		driver = df.initDriver("chrome");// to call initDriver method to get driver
		loginPage = new LoginPage(driver);
	}

	@AfterTest
	public void teardown() {
		driver.quit();
	}

}
