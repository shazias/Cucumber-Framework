package com.sdc.automation.pageObjects;

import java.util.logging.Logger;

import org.openqa.selenium.WebDriver;

/**
 * Created by imran on 28/01/17.
 */
public class BasePage {

	private static Logger Log = Logger.getLogger(BasePage.class.getName());

	private static ThreadLocal<WebDriver> threadDriver = new ThreadLocal<>();

	public static WebDriver getDriver() {
		return threadDriver.get();
	}


	public static void quitDriver() {

		if (getDriver() != null) {
			getDriver().quit();
		}

	}


	public static void setDriver (WebDriver driver) {
		threadDriver.set(driver);
	}

	public void navigateTo (String url) throws InterruptedException {
		Log.info ("Navigating to '" + url + "'");
		getDriver().navigate().to(url);


	}

}