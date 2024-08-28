package com.qa.opencart.factory;

import java.util.Properties;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;

public class OptionsManger {
	private Properties prop;
	private ChromeOptions co;
	private FirefoxOptions fo;
	private EdgeOptions eo;

	public OptionsManger(Properties prop) {
		this.prop = prop;
	}

	public ChromeOptions getChromeOptions() {

		co = new ChromeOptions();
		/*
		 * this will check the value in form of string then gives restult in form of
		 * boolean
		 */
		co.addArguments("--remote-allow-origins=*");
		if (Boolean.parseBoolean(prop.getProperty("headless").trim()))
		{
			System.out.println("=======Running chrome headless=====");
			co.addArguments("--headless");
		}
		if (Boolean.parseBoolean(prop.getProperty("incognito").trim()))
			co.addArguments("incognito");
		return co;
	}

	public FirefoxOptions getFirefoxOptions() {

		fo = new FirefoxOptions();
		/*
		 * this will check the value in form of string then gives restult in form of
		 * boolean
		 */
		if (Boolean.parseBoolean(prop.getProperty("headless").trim()))
			fo.addArguments("--headless");
		if (Boolean.parseBoolean(prop.getProperty("incognito").trim()))
			fo.addArguments("incognito");
		return fo;
	}

	public EdgeOptions getEdgeOptions() {

		eo = new EdgeOptions();
		/*
		 * this will check the value in form of string then gives restult in form of
		 * boolean
		 */
		if (Boolean.parseBoolean(prop.getProperty("headless").trim()))
			eo.addArguments("--headless");
		if (Boolean.parseBoolean(prop.getProperty("incognito").trim()))
			eo.addArguments("incognito");
		return eo;
	}
}