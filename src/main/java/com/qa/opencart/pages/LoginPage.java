package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.constants.AppConstant;
import com.qa.opencart.utils.ElementUtil;

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

	public String getLoginPageTitle() {
		// String title = driver.getTitle();
		// String title = eleUtil.waitForTitleContainsAndFetch(10, "Account Login");
		String title = eleUtil.waitForTitleContainsAndFetch(AppConstant.DEFAULT_MEDIUM_TIMEOUT, AppConstant.LOGIN_PAGE_TITLE_VALUE);
		return title;
	}

	public String getLoginUrl() {
		// String url = driver.getCurrentUrl();
		// String url = eleUtil.waitForURLContainsAndFetch(10, "route=account/login");
		String url = eleUtil.waitForURLContainsAndFetch(AppConstant.DEFAULT_MEDIUM_TIMEOUT, AppConstant.LOGIN_PAGE_URL_FRACTION_VALUE);
		return url;
	}

	public boolean isForgotpwdLinkExits() {
		// return driver.findElement(forgottenPwdlink).isDisplayed();
		//return eleUtil.waitForElementVisible(forgottenPwdlink, 10).isDisplayed();
		return eleUtil.waitForElementVisible(forgottenPwdlink, AppConstant.DEFAULT_MEDIUM_TIMEOUT).isDisplayed();

	}

	public boolean isregistetLinkExits() {
		// return driver.findElement(registerlink).isDisplayed();
		//return eleUtil.waitForElementVisible(registerlink, 10).isDisplayed();
		return eleUtil.waitForElementVisible(registerlink, AppConstant.DEFAULT_MEDIUM_TIMEOUT).isDisplayed();

	}

	public AccountsPage doLogin(String un, String pwd) {
		// driver.findElement(emailId).sendKeys(un);
		// driver.findElement(password).sendKeys(pwd);
		// driver.findElement(loginBtn).click();

		// ***---Replaced driver by elementUtil--- **//
		eleUtil.waitForElementVisible(emailId, AppConstant.DEFAULT_MEDIUM_TIMEOUT).sendKeys(un);
		eleUtil.doSendKeys(password, pwd);
		eleUtil.doClick(loginBtn);

		return new AccountsPage(driver);

	}

}
