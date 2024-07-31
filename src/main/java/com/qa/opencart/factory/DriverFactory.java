package com.qa.opencart.factory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {

	public WebDriver driver;
	public Properties prop;
	public OptionsManger optionsManger;
	public static String highlight;

	/**
	 * this method is initalizing the browser on the basis of browsername
	 * 
	 * @param browserName
	 * @return this returns the driver
	 */
	// public WebDriver initDriver(String browserName)
	public WebDriver initDriver(Properties prop) {
		optionsManger = new OptionsManger(prop);

		highlight=prop.getProperty("highlight");		
		String browserName = prop.getProperty("browser").trim();
		System.out.println("browsername is :" + browserName);
		if (browserName.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver(optionsManger.getChromeOptions());
		} 
		else if (browserName.trim().equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver(optionsManger.getFirefoxOptions());
		}
		else if (browserName.trim().equalsIgnoreCase("edge")) {
			driver = new EdgeDriver(optionsManger.getEdgeOptions());
		}
		else
		{
			System.out.println("Enter correct browser :" + browserName);
		}

		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		// driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		driver.get(prop.getProperty("url"));
		return driver;

	}

	/**
	 * This method is reading properties from properties file
	 * 
	 * @return
	 */
	public Properties initProp()

	{
		prop = new Properties();
		try {
			FileInputStream ip = new FileInputStream("./src/main/resources/Config/config.properties");
			prop.load(ip);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return prop;
	}

}
