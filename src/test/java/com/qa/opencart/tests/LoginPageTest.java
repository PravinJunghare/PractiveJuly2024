
package com.qa.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.constants.AppConstant;

import io.qameta.allure.Epic;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;


@Epic("EPIC -100: Design Login for OpenCart Application ")
@Story("User Story US-01: Design Features for Login Page")
@Severity(SeverityLevel.TRIVIAL)
public class LoginPageTest extends BaseTest {

	@Test(priority = 1)
	public void loginPageTitleTest() {
		String actTitle = loginPage.getLoginPageTitle();
		// Assert.assertEquals(actTitle, "Account Login");
		Assert.assertEquals(actTitle, AppConstant.LOGIN_PAGE_TITLE_VALUE);

	}

	@Test(priority = 2)
	public void loginPageUrlTest() {
		String actUrl = loginPage.getLoginUrl();
		// Assert.assertTrue(actUrl.contains("route=account/login"));
		Assert.assertTrue(actUrl.contains(AppConstant.LOGIN_PAGE_URL_FRACTION_VALUE));
	}

	@Test(priority = 3)
	public void forgotpassLinkExistTest() {
		Assert.assertTrue(loginPage.isForgotpwdLinkExits());
	}

	@Test(priority = 4)
	public void loginTest() {
		// loginPage.doLogin("pravinjunghare01@yahoo.com", "Test@1234");
		// accountsPage = loginPage.doLogin("hixiken531@leacore.com", "Test@1234");

		// ***added Properties file and removed the hardcoded username and password***//
		accountsPage = loginPage.doLogin(prop.getProperty("username").trim(), prop.getProperty("password").trim());

		Assert.assertTrue(accountsPage.isLogoutLinkExist());
	}

}
