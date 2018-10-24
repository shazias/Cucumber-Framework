package com.sdc.automation.runner;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.sdc.automation.stepdefinitions.BaseSteps;

/**
 * Created by imran on 28/01/17.
 */
public class TestNG {

	@Parameters({"remoteUrl", "useGrid"})
	@BeforeSuite
	public void configureSuite(@Optional("none") String remoteUrl, @Optional("none") String useGrid) {

		BaseSteps.remoteUrl = remoteUrl;
		BaseSteps.executeRemotelyFromTestNG = useGrid;
	}


	@Parameters({"platform", "browser", "browserVersion"})
	@Test
	public void configureTest(@Optional("none") String platform, @Optional("none") String browser, @Optional("none") String browserVersion) {

		BaseSteps.platform = platform;
		BaseSteps.browser = browser;
		BaseSteps.browserVersion = browserVersion;

	}
}
