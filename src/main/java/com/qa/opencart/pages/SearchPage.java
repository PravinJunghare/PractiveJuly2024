package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.constants.AppConstant;
import com.qa.opencart.utils.ElementUtil;

public class SearchPage {
	
	private WebDriver driver;
	private ElementUtil eleUtil;
	private By searchproductResult = By.cssSelector("div#content div .product-layout");
	
	public SearchPage(WebDriver driver)
	{
		this.driver=driver;
		eleUtil = new ElementUtil(driver);
	}

	
	public int getSearchProductCount()
	{
		int produtCount= eleUtil.waitForElementsVisible(searchproductResult, AppConstant.DEFAULT_MEDIUM_TIMEOUT).size();
		System.out.println("Product Count:"+produtCount);
		return produtCount;
	}
	
	
	
	public ProductInfoPage selectProduct(String productName)
	{
		By prodLocator=By.linkText(productName);// dynamic locator
		eleUtil.waitForElementVisible(prodLocator,AppConstant.DEFAULT_MEDIUM_TIMEOUT).click();
		return new ProductInfoPage(driver);
	}
	
	
}
