/* Author - Saira Akram
 * Creation Date - May 2018
 * Last Modified Date - August 2018
 */

package com.sdc.automation.stepdefinitions;

import com.sdc.automation.backend.HiveConnection;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class HiveConnectionStepDefinition {
	@Then("the file is extracted and NULL check begins")
	public void HiveDataCheckNull() throws Exception {
		try {
			HiveConnection.HiveDataCheckNull();
		} catch (final Exception e) {
			throw e;
		}
	}

	@Given("^I am connected to Hive: \"([^\"]*)\"$")
	public void iAmConnectedToHive(String databaseURl) {
		HiveConnection.setDatabaseURl(databaseURl);


	}

	@And("I use the Hive password: \"([^\"]*)\"$")
	public void iSpecifyPassword(String password) {

		HiveConnection.setPassword(password);
	}

	@And("^I use the Hive userid: \"([^\"]*)\"$")
	public void iSpecifyuserId(String userId) {

		HiveConnection.setUserId(userId);
	}

	@When("I insert HIVE query: \"([^\"]*)\"$")
	public void iUseExtractHiveQuery(String extractHiveQuery) {

		HiveConnection.setHiveExtractQuery(extractHiveQuery);
	}
	@And("I use Hive query: \"([^\"]*)\"$")
	public void iUseQuery(String query) {

		HiveConnection.setQuery(query);
	}

	@And("the Hive connection is established")
	public void theConnectionIsEstablished() throws Exception {
		try {
			HiveConnection.ConnectHive();
		}
		catch (final Exception e)
		{
			throw e;
		}
	}
	@Then("^The Hive Data is dumped in MariaDbTable:\"([^\"]*)\"$")
	public void theHiveDatadumpedtoMariaDataBase(String tableName) throws Exception {

		HiveConnection.HiveDataDumpedtoMariaTable(tableName);

	}
	@Then("^The variation in last two days is less than percent :(\\d+)$")
	public void theHiveDataExtracted(int variationTreshold) throws Exception {

		HiveConnection.HiveVariationForLastTwoDays(variationTreshold);

	}
	@Then("^the HIVE table data is extracted at: \"([^\"]*)\"$")
	public void theHiveDataExtracted(String HiveFilelocation) throws Exception {
		try {
			HiveConnection.HiveExtractData(HiveFilelocation);
		} catch (final Exception e) {
			throw e;
		}
	}
	@Then("^The variation in last two days is less than number :(\\d+)$")
	public void theHiveDeviceNumbers(int numberVariationTreshold) throws Exception {

		HiveConnection.HiveNumberVariation(numberVariationTreshold);

	}

	@Then("^connection to Maria Database is established:\"([^\"]*)\"$")
	public void theMAriaDBConnectionisEstablished(String mariaDbUrl) throws Exception {

		HiveConnection.maridDBConnectionEstablished(mariaDbUrl);

	}

}
