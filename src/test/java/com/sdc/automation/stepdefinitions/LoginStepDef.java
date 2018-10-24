package com.sdc.automation.stepdefinitions;

import com.sdc.automation.pageObjects.LoginPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

/**
 * Created by imran on 29/01/17.
 */
public class LoginStepDef {

	@Given("^I click Login$")public void clickLogin()  {

		LoginPage.clickLogin();
	}

	@Given("^I enter the password \"([^\"]*)\"$")
	public void enterPassword(String password) { LoginPage.enterPassword(password); }


	@Given("^I enter the username \"([^\"]*)\"$")
	public void enterUsername(String username) {
		LoginPage.enterUsername(username);
	}

	@Given("^I am on the SDC home page: \"([^\"]*)\"$")
	public void iAmOnThePipelineDemoPage(String homePageUrl) {
		LoginPage.navigate(homePageUrl);

	}

	@Then("^the SDC home page should have title: \"([^\"]*)\"$")
	public void thePageHeaderShouldBe(String header) {
		LoginPage.verifyHeader(header);
	}
}
