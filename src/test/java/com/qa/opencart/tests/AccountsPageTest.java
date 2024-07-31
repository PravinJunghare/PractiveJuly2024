package com.qa.opencart.tests;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.constants.AppConstant;

public class AccountsPageTest extends BaseTest {
	// precodition is that user should be login for AccountsPage

	@BeforeClass

	public void accPageSetup() {
		// accountsPage = loginPage.doLogin("hixiken531@leacore.com", "12345");
		accountsPage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));

	}

	@Test
	public void accountsPageTitleTest() {
		String actTitle = accountsPage.getAccPageTitle();
		// Assert.assertEquals(actTitle, "My Account");
		Assert.assertEquals(actTitle, AppConstant.ACCOUNTS_PAGE_TITLE_VALUE);
	}

	@Test
	public void accountsPageUrlTest() {
		String actUrl = accountsPage.getAccPageUrl();
		// Assert.assertTrue(actUrl.contains(""));
		Assert.assertTrue(actUrl.contains(AppConstant.ACCOUNTS_PAGE_URL_FRACTION_VALUE));
	}

	@Test
	public void isLogoutLinkExistTest() {
		Assert.assertTrue(accountsPage.isLogoutLinkExist());
	}

	@Test
	public void accountHeaderTest() {
		List<String> actualAccHeaderList = accountsPage.getAccountPageHeadersList();
		System.out.println(actualAccHeaderList);
		// Assert.assertEquals(actualAccHeaderList.size(), 4);
		Assert.assertEquals(actualAccHeaderList.size(), AppConstant.ACCOUNTS_PAGE_HEADERCOUNT);
	}

	@Test
	public void accountHeaderValueTest() {
		List<String> actualAccHeaderList = accountsPage.getAccountPageHeadersList();
		System.out.println("Actual AccPage header list" + actualAccHeaderList);
		System.out.println("Expected AccPage header list " + AppConstant.EXPECTED_ACCOUNTPAGE_HEADERS_LIST);
		Assert.assertEquals(actualAccHeaderList, AppConstant.EXPECTED_ACCOUNTPAGE_HEADERS_LIST);

	}

}