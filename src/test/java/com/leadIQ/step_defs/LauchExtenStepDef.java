package com.leadIQ.step_defs;

import com.leadIQ.pages.ChromeExtensPage;
import com.leadIQ.pages.ExtensLoginPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.sikuli.script.FindFailed;

public class LauchExtenStepDef {


	private ChromeExtensPage chromeExtensPage = new ChromeExtensPage();
	private ExtensLoginPage extensLoginPage = new ExtensLoginPage();

	@When("I launch the leadIQ extension")
	public void i_launch_the_leadIQ_extension() throws FindFailed {
		chromeExtensPage.launchExtension();
	}

	@Then("the extension should be launched")
	public void the_extension_should_be_launched() {
		extensLoginPage.verifyExtenLaunched();
	}

	@When("I login with valid credentials")
	public void I_login_with_valid_credentials() {
		extensLoginPage.login();
	}

	@Then("Create New is displayed in the campaign dropdown")
	public void Create_New_is_displayed_in_the_campaign_dropdown() {
		extensLoginPage.verifySelectCampaignOrCreateNewDisplayed();
	}

}
