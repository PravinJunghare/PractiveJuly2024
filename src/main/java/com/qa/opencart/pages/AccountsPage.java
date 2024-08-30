package com.qa.opencart.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencart.utils.ElementUtil;

public class AccountsPage {

	// 1 Private Webdriver
	private WebDriver driver;
	private ElementUtil eleUtil;

	// 2 Constructor
	public AccountsPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);
	}

	// 3 Private BY loctaors

	private By logoutLink = By.linkText("Logout");
	private By accHeader = By.xpath("//div[@id='content']//h2");
	private By search = By.name("search");
	private By searchIcon = By.cssSelector("#search button");

	// 4 Page actions
	public String getAccPageTitle() {
		// String title = driver.getTitle();
		String title = eleUtil.waitForTitleIsAndFetch(10, "My Account");
		// String title =
		// eleUtil.waitForTitleIsAndFetch(AppConstant.DEFAULT_MEDIUM_TIMEOUT,
		// AppConstant.ACCOUNTS_PAGE_TITLE_VALUE);
		System.out.println("Accountpage title is :" + title);
		return title;
	}

	public String getAccPageUrl() {
		// String url = driver.getCurrentUrl();
		String url = eleUtil.waitForURLContainsAndFetch(10, "route=account/account");
		// String url =
		// eleUtil.waitForURLContainsAndFetch(AppConstant.DEFAULT_MEDIUM_TIMEOUT,
		// AppConstant.ACCOUNTS_PAGE_URL_FRACTION_VALUE);
		System.out.println("AccountPage url is :" + url);
		return url;
	}

	public boolean isLogoutLinkExist() {
		// return driver.findElement(logoutLink).isDisplayed();
		return eleUtil.waitForElementVisible(logoutLink, 10).isDisplayed();
		// return eleUtil.waitForElementVisible(logoutLink,
		// AppConstant.DEFAULT_MEDIUM_TIMEOUT).isDisplayed();
	}

	public boolean isSearchExist() {
		// return driver.findElement(search).isDisplayed();
		return eleUtil.waitForElementVisible(search, 10).isDisplayed();
		// return eleUtil.waitForElementVisible(search,
		// AppConstant.DEFAULT_MEDIUM_TIMEOUT).isDisplayed();
	}

	public List<String> getAccountPageHeadersList() {

		// List<WebElement> accHeaderslist = driver.findElements(accHeader);
		List<WebElement> accHeaderslist = eleUtil.waitForElementsVisible(accHeader, 10);
		// List<WebElement> accHeaderslist =
		// eleUtil.waitForElementsVisible(accHeader,AppConstant.DEFAULT_MEDIUM_TIMEOUT);
		List<String> accHeaderValList = new ArrayList<String>();

		for (WebElement e : accHeaderslist) {
			String text = e.getText();
			accHeaderValList.add(text);
		}
		return accHeaderValList;
	}
	
	public SearchPage  performSearch(String searchKey)
	
	{
		
		if(isSearchExist())
			
		{
			eleUtil.doSendKeys(search, searchKey);
			eleUtil.doClick(searchIcon);
			return new SearchPage(driver);
		}
		else
		{
			System.out.println("Search Field is not exist on page...");
		}
		return null;
		
	}

}