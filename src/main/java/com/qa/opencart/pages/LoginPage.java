package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.constants.AppConstant;
import com.qa.opencart.utils.ElementUtil;

import io.qameta.allure.Step;

public class LoginPage {
	private WebDriver driver;
	private ElementUtil eleUtil;

	// 1. Private By locators
	private By emailId = By.id("input-email");
	private By password = By.id("input-password");
	private By loginBtn = By.xpath("//input[@value='Login']");
	private By forgottenPwdlink = By.id("input-email");
	private By registerlink = By.linkText("Register");

	// 2. Page Constructor
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);
	}

	// 3.Page Actions/Methods
	@Step("Getting LoginPage Title......")
	public String getLoginPageTitle() {
		// String title = driver.getTitle();
		// String title = eleUtil.waitForTitleContainsAndFetch(10, "Account Login");
		String title = eleUtil.waitForTitleContainsAndFetch(AppConstant.DEFAULT_MEDIUM_TIMEOUT, AppConstant.LOGIN_PAGE_TITLE_VALUE);
		return title;
	}
	@Step("Getting LoginPage Url......")

	public String getLoginUrl() {
		// String url = driver.getCurrentUrl();
		// String url = eleUtil.waitForURLContainsAndFetch(10, "route=account/login");
		String url = eleUtil.waitForURLContainsAndFetch(AppConstant.DEFAULT_MEDIUM_TIMEOUT, AppConstant.LOGIN_PAGE_URL_FRACTION_VALUE);
		return url;
	}
	@Step("Getting LoginPage ForgotPassword link......")
	public boolean isForgotpwdLinkExits() {
		// return driver.findElement(forgottenPwdlink).isDisplayed();
		//return eleUtil.waitForElementVisible(forgottenPwdlink, 10).isDisplayed();
		return eleUtil.waitForElementVisible(forgottenPwdlink, AppConstant.DEFAULT_MEDIUM_TIMEOUT).isDisplayed();

	}
	@Step("Getting LoginPage Regiter link......")
	public boolean isregistetLinkExits() {
		// return driver.findElement(registerlink).isDisplayed();
		//return eleUtil.waitForElementVisible(registerlink, 10).isDisplayed();
		return eleUtil.waitForElementVisible(registerlink, AppConstant.DEFAULT_MEDIUM_TIMEOUT).isDisplayed();

	}
	@Step("Login to the Application using username: {0}  and password: {1}")
	public AccountsPage doLogin(String un, String pwd) {
		// driver.findElement(emailId).sendKeys(un);
		// driver.findElement(password).sendKeys(pwd);
		// driver.findElement(loginBtn).click();

		// ***---Replaced driver by elementUtil--- **//
		System.out.println("App Credentials are " +un+ ":" +pwd);
		
		eleUtil.waitForElementVisible(emailId, AppConstant.DEFAULT_MEDIUM_TIMEOUT).sendKeys(un);
		eleUtil.doSendKeys(password, pwd);
		eleUtil.doClick(loginBtn);

		return new AccountsPage(driver);

	}
	
	@Step("Navigating to Registration Page.")
	public RegistrationPage navigateToRegisterPage()
	{
		eleUtil.doClick(registerlink);
		return new RegistrationPage(driver);
	}

}
