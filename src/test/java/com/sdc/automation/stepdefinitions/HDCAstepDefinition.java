/* Author - Saira Akram
 * Creation Date - May 2018
 * Last Modified Date - August 2018
 */

package com.sdc.automation.stepdefinitions;

import com.sdc.automation.backend.HDCAConnector;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;

public class HDCAstepDefinition {


	@And("the HDCA  NULL check begins")
	public void hasNullValues() throws Exception {

		HDCAConnector.checkNull();
	}

	@Given("^I am connected to HDCA: \"([^\"]*)\"$")
	public void iAmConnectedToHDCA(String HDCAconnectionURl) {
		HDCAConnector.setConnectionURl(HDCAconnectionURl);

	}
	@And("^I use the HDCA Authorisation: \"([^\"]*)\"$")
	public void iSpecifyHDCAauthorisation(String HDCAauthorisation) {

		HDCAConnector.setAuthorisation(HDCAauthorisation);
	}

	@And("I use the HDCA END_TIME: \"([^\"]*)\"$")
	public void iSpecifyHDCAendTime(String HDCAendTime) {

		HDCAConnector.setEndTime(HDCAendTime);
	}

	@And("the HDCA data is extracted at: \"([^\"]*)\"$")
	public void iSpecifyHDCAfilePath(String filePath) throws Exception {

		HDCAConnector.setFilePath(filePath);
	}

	@And("I use the HDCA Query: \"([^\"]*)\"$")
	public void iSpecifyHDCAquery(String HDCAquery) {

		HDCAConnector.setQuery(HDCAquery);
	}

	@And("I use the HDCA Resource: \"([^\"]*)\"$")
	public void iSpecifyHDCAresource(String HDCAresource) {

		HDCAConnector.setResource(HDCAresource);
	}
	@And("I use the HDCA START_TIME: \"([^\"]*)\"$")
	public void iSpecifyHDCAstartTime(String HDCAstartTime) {

		HDCAConnector.setStartTime(HDCAstartTime);
	}
	@And("the HDCA connection is established")
	public void theHDCAconnection() throws Exception {

		HDCAConnector.connect();

	}
}
