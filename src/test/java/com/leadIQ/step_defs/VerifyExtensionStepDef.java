package com.leadIQ.step_defs;

import com.leadIQ.pages.ChromeExtenDetailsPage;
import com.leadIQ.pages.ChromeExtensPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.List;

public class VerifyExtensionStepDef {

	private ChromeExtensPage chromeExtensPage = new ChromeExtensPage();
	private ChromeExtenDetailsPage chromeExtenDetailsPage = new ChromeExtenDetailsPage();

	@Given("I initiate the driver")
	public void i_initiate_the_driver() {
		chromeExtensPage.navigateToExtensionsPage();
	}

	@When("I check the extensions")
	public void i_check_the_extensions() {
		chromeExtensPage.checkExtensionDetails();
	}

	@Then("I see that LeadIQ extension is installed")
	public void i_see_that_LeadIQ_extension_is_installed() {
		chromeExtenDetailsPage.verifyExtensionName();
	}

	@When("I check the extensions in developer mode")
	public void i_check_the_extensions_in_developer_mode() {
		chromeExtensPage.openDevMode();
	}

	@Then("I see that LeadIQ extension is installed and ID is the below")
	public void i_see_that_LeadIQ_extension_is_installed_and_ID_is_the_below(List<String> id) {
		chromeExtensPage.verifyExtID(id);
	}

	@Then("version is {string}")
	public void version_is(String version) {
		chromeExtensPage.verifyExtVersion(version);
	}


}
