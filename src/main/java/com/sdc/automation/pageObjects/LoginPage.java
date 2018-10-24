package com.sdc.automation.pageObjects;


import java.io.IOException;
import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.testng.Assert;

/**
 * Created by imran on 13/08/15.
 */
public class LoginPage extends BasePage {

	private static Logger Log = Logger.getLogger(LoginPage.class.getName());


	public static void clickLogin() {

		getDriver().findElement(By.xpath("//input[@value='Sign In']")).click();
		// getDriver().findElement(By.xpath("//div[@class=controls]/div/input[@value='Sign In']")).click();

		// getDriver().findElement(By.className("credentials_input_submit")).click();

	}

	public static void enterPassword(String password) {

		getDriver().findElement(By.id("password")).sendKeys(password);
		//  getDriver().findElement(By.name("password")).sendKeys(password);
	}

	public static void enterUsername(String username) {

		getDriver().findElement(By.id("username")).sendKeys(username);


	}

	public static void navigate(String homePageUrl) {

		getDriver().get(homePageUrl);
		// getDriver().get("http://sdc-demo.labgsd.com");

	}

	public static void verifyHeader(String expectedHeader) {


		// String actualHeader = getDriver().findElement(By.xpath(".//div[@class='button']/")).getText();
		final String actualHeader = getDriver().findElement(By.xpath("//text[@id='Capacity Overview']")).getText();

		Assert.assertEquals(actualHeader,expectedHeader);

	}

	public LoginPage() throws IOException {

	}

}
