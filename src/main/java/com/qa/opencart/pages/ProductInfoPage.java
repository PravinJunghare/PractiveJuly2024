package com.qa.opencart.pages;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.constants.AppConstant;
import com.qa.opencart.utils.ElementUtil;

public class ProductInfoPage {
	
		private WebDriver driver;
		private ElementUtil eleUtil;

		private By productHeader = By.tagName("h1");
		private By ProductImages = By.cssSelector("ul.thumbnails img");
		private By productMetaDeta = By.xpath("(//div[@id='content']//ul[@class='list-unstyled'])[1]/li");
		private By productPriceDeta = By.xpath("(//div[@id='content']//ul[@class='list-unstyled'])[2]/li");
		private By quantity = By.id("input-quantity");
		private By addToCartBtn = By.id("button-cart");
		private By cartSuccessMsg = By.cssSelector("div.alert.alert-success");

		private Map<String, String> productInfoMap;

		public ProductInfoPage(WebDriver driver) {
			this.driver = driver;
			eleUtil = new ElementUtil(driver);
		}

		public String getProductHeaderValue() {
			String productHeaderValue = eleUtil.doElementGetText(productHeader);
			System.out.println("product header :" + productHeaderValue);
			return productHeaderValue;
		}
		
		public int getImageCount() {

			int imageCount = eleUtil.waitForElementsVisible(ProductImages, AppConstant.DEFAULT_MEDIUM_TIMEOUT).size();
			System.out.println("ProdcutImages :" + imageCount);
			return imageCount;
		}

	}

