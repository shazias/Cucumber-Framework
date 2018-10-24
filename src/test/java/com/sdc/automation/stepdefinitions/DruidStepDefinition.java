/* Author - Saira Akram
 * Creation Date - May 2018
 * Last Modified Date - August 2018
 */

package com.sdc.automation.stepdefinitions;

import com.sdc.automation.backend.DruidConnection;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class DruidStepDefinition {
	@And("the Druid file is extracted and NULL check begins")
	public void DruidDataCheckNull() throws Exception {
		try {
			DruidConnection.DruidDataCheckNull();
		} catch (final Exception e) {
			throw e;
		}
	}

	@Given("^I am connected to: \"([^\"]*)\"$")
	public void iAmConnectedToDruid(String connectionURl) {
		DruidConnection.setDruidUrl(connectionURl);

	}
	@Given("I save data to Location: \"([^\"]*)\"$")
	public void iSpecifyDataDumpLocation(String csvLocation) {

		DruidConnection.setFileLocation(csvLocation);
	}
	@Given("^I use the Jason query: \"([^\"]*)\"$")
	public void iSpecifyJsonQuery(String jsonPath) {

		DruidConnection.setJsonPath(jsonPath);
	}
	@Then("^The Druid Data is dumped in MariaDbTable:\"([^\"]*)\"$")
	public void theDruidDatadumpedtoMariaDataBase(String tableName) throws Exception {

		DruidConnection.DruidDataDumpedtoMariaTable(tableName);

	}
	@Then("^The variation in Druid for last two days is less than percent :(\\d+)$")
	public void theDruidDataExtracted(int variationTreshold) throws Exception {

		DruidConnection.DruidVariationForLastTwoDays(variationTreshold);

	}
	@Then("^The variation in Druid for last two days is less than number :(\\d+)$")
	public void theDruidDeviceNumbers(int druidNumberVariation) throws Exception {

		DruidConnection.DruidNumberVariation(druidNumberVariation);

	}
	@Then("^Druid connection to Maria Database is established:\"([^\"]*)\"$")
	public void theMAriaDBConnectionisEstablished(String mariaDbUrl) throws Exception {

		DruidConnection.maridDBConnectionEstablished(mariaDbUrl);

	}

	@Then("the result should be pulled")
	public void thePageHeaderShouldBe() {
		try {
			DruidConnection.dumpData();
		} catch (final Exception e) {
			e.printStackTrace();
		}
	}
}
