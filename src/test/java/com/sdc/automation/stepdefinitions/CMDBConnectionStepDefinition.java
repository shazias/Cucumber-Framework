/* Author - Saira Akram
 * Creation Date - June 2018
 * Last Modified Date - August 2018
 */

package com.sdc.automation.stepdefinitions;

import com.sdc.automation.backend.CMDBConnector;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CMDBConnectionStepDefinition {
	@Then("the CMDB file is extracted and NULL check begins")
	public void CmdbDataCheckNull() throws Exception {
		try {
			CMDBConnector.CmdbDataCheckNull();
		} catch (final Exception e) {
			throw e;
		}
	}

	@Given("^I use the CMDB URL: \"([^\"]*)\"$")
	public void iAmConnectedToCmdb(String databaseURl) {
		CMDBConnector.setDatabaseURl(databaseURl);

	}

	@And("I use the CMDB password: \"([^\"]*)\"$")
	public void iSpecifyPassword(String password) {

		CMDBConnector.setPassword(password);
	}

	@And("^I use the CMDB userid: \"([^\"]*)\"$")
	public void iSpecifyuserId(String userId) {

		CMDBConnector.setUserId(userId);
	}

	@When("I insert CMDB query: \"([^\"]*)\"$")
	public void iUseExtractQuery(String extractquery) {

		CMDBConnector.setExtractQuery(extractquery);
	}

	@And("I use CMDB query: \"([^\"]*)\"$")
	public void iUseQuery(String query) {

		CMDBConnector.setQuery(query);
	}

	@And("^the CMDB table data is extracted at: \"([^\"]*)\"$")
	public void theCMDBDataExtracted(String CMDBfileLocation) throws Exception {
		try {
			CMDBConnector.extractData(CMDBfileLocation);
		} catch (final Exception e) {
			throw e;
		}
	}

	@Then("the CMDB connection is established")
	public void theConnectionIsEstablished() throws Exception {

		try {
			CMDBConnector.validateConnection();
		} catch (final Exception e) {
			throw e;
		}
	}
}
