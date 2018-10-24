package com.sdc.automation.stepdefinitions;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Properties;
import java.util.logging.Logger;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.sdc.automation.pageObjects.BasePage;
import com.sdc.automation.utilities.ConfigUtils;
import com.sdc.automation.utilities.DriverUtils;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

/**
 * Created by imran on 28/01/17.
 */
public class BaseSteps {

	public static String remoteUrl;
	public static String platform;
	public static String browser;
	public static String browserVersion;
	public static String executeRemotelyFromTestNG = null;
	static Properties config;
	private static Logger Log = Logger.getLogger(BaseSteps.class.getName());

	@After
	public void afterScenario(Scenario scenario) throws IOException {

		if (scenario.isFailed()) {

			try {
				final byte[] screenshot = ((TakesScreenshot) BasePage.getDriver()).getScreenshotAs(OutputType.BYTES);
				scenario.embed(screenshot, "img/png");
			} catch (final Exception ex) {
				Log.info("Exception taking screenshot: " + ex);
			}
		}

		Log.info(scenario.getName().toUpperCase() + "scenario ended with status: " + scenario.getStatus().toUpperCase());
		Log.info("**************************************************");

		BasePage.quitDriver();
	}

	@Before
	public void beforeScenario(Scenario scenario) throws IOException {

		Log.info(scenario.getName().toUpperCase() + " scenario started");

		// WebDriver driver = null;
		Boolean executeRemotely;

		DOMConfigurator.configure("log4j.xml");

		ConfigUtils.loadConfig();

		if ("true".equals(ConfigUtils.getConfigValue("ui"))) {

			//Determine whether to execute locally or remotely
			if (executeRemotelyFromTestNG == null || executeRemotelyFromTestNG.equals("none")) {
				executeRemotely = ConfigUtils.getConfigValue("execute.remotely").toLowerCase().equals("true"); //use config val
			} else {
				executeRemotely = Boolean.valueOf(executeRemotelyFromTestNG.toLowerCase()); //use param
			}

			if (!executeRemotely) {
				browser = ConfigUtils.getConfigValue("browser.name");
				platform = System.getProperty("os.name");
				remoteUrl = "LOCAL";
			}

			final String msg = "Browser: '" + browser.toUpperCase() + "'. Remote: '" + executeRemotely + "'. Platform: '"
					+ platform.toUpperCase() + "'. URL: '" + remoteUrl + "'. Date: '"
					+ new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new java.util.Date()) + "'\n";

			Log.info(msg);

			BasePage.setDriver(DriverUtils.startDriver(browser, platform, executeRemotely, remoteUrl));
		}


	}



}
//public void startUp() throws MalformedURLException {
//   DOMConfigurator.configure("log4j.xml");
//   Log.startScenario("Valid Submission");
//System.setProperty("webdriver.chrome.driver", "/home/imran/TestDevProjects/chromedriver");
//driver = new FirefoxDriver();
//driver = new ChromeDriver();

// DesiredCapabilities capabilities = DesiredCapabilities.phantomjs();
//driver = new PhantomJSDriver(capabilities);
//capabilities.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY, "/drivers/phantomjs");
//capabilities.setCapability("phantomjs.binary.path", "/drivers/phantomjs");



//  URL hubUrl = new URL("http://192.168.0.5:4444/wd/hub");
//  DesiredCapabilities capabilities = new DesiredCapabilities();
// capabilities.setBrowserName("chrome");
//  capabilities.setPlatform(Platform.LINUX);
// driver = new RemoteWebDriver(hubUrl, capabilities);



//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);






