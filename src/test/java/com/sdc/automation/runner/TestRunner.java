package com.sdc.automation.runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;

/**
 * Created by imran on 12/08/15.
 */


@RunWith(Cucumber.class)
@CucumberOptions(
		features = {"target/test-classes/features/"},
		glue={"com.sdc.automation.stepdefinitions"},
		plugin = {
				"pretty",
				"html:target/cucumber-report/",
				"json:target/cucumber-report/cuc-json-report.json",
		"junit:target/junit-report/cucumber-junit-report.xml"}
		)
public class TestRunner extends AbstractTestNGCucumberTests {


}