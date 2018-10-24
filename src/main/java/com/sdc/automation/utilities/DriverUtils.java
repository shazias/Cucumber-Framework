package com.sdc.automation.utilities;

import java.io.File;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

/**
 * Created by imran on 28/01/17.
 */
public class DriverUtils {


	private static Logger Log = Logger.getLogger(DriverUtils.class.getName());


	public static WebDriver startDriver(String browser, String platform, Boolean remote, String remoteUrl) {

		WebDriver driver = null;

		try {
			switch (browser) {
			case ("firefox"):
				final DesiredCapabilities ffCap = DesiredCapabilities.firefox();

			switch (platform) {
			case ("windows"):
				ffCap.setPlatform(Platform.WINDOWS);
			break;
			case ("linux"):
				ffCap.setPlatform(Platform.LINUX);
			break; }
			if (!remote) {
				final File pathToBinary = new File("C:\\Program Files\\Mozilla Firefox\\firefox.exe");
				new FirefoxBinary(pathToBinary);
				final FirefoxProfile profile = new FirefoxProfile();
				profile.setPreference("network.automatic-ntlm-auth.trusted-uris", "uk-proxy");
				profile.setAcceptUntrustedCertificates(true);
				ffCap.setCapability(FirefoxDriver.PROFILE, profile);
				driver = new FirefoxDriver(ffCap);
			} else {
				return new RemoteWebDriver(new URL(remoteUrl), ffCap);

			}
			break;

			case ("chrome"):

				System.setProperty("webdriver.chrome.driver", "/path/to/chromedriver");

			final DesiredCapabilities chromeCap = DesiredCapabilities.chrome();

			switch (platform) {
			case ("windows"):
				chromeCap.setPlatform(Platform.WINDOWS);
			break;
			case ("linux"):
				chromeCap.setPlatform(Platform.LINUX);
			break; }

			if (!remote) {
				System.setProperty("webdriver.chrome.driver", "C:\\Users\\Sshaikh\\Desktop\\SDC\\sdc-ui-selenium\\functional-tests\\drivers\\chromedriver.exe");
				driver = new ChromeDriver();
			} else {
				return new RemoteWebDriver(new URL(remoteUrl), chromeCap);

			}




			case ("phantomjs"):

				final DesiredCapabilities phantomCap = DesiredCapabilities.phantomjs();

			switch (platform) {
			case ("windows"):
				phantomCap.setPlatform(Platform.WINDOWS);
			break;
			case ("linux"):
				phantomCap.setPlatform(Platform.LINUX);
			break; }

			return new RemoteWebDriver(new URL(remoteUrl), phantomCap);




			}

			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.manage().window().maximize();


		} catch (final Exception ex) {
			Log.info("Exception setting up driver: "+ ex);
		}

		return driver;

	}

}
