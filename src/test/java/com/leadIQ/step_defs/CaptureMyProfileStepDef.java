package com.leadIQ.step_defs;

import com.leadIQ.pages.*;
import com.leadIQ.utilities.Driver;
import com.leadIQ.utilities.Utils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class CaptureMyProfileStepDef {

	private ExtensHomePage extensHomePage = new ExtensHomePage();
	private LinkedlnLoginPage linkedlnLoginPage = new LinkedlnLoginPage();
	private LinkedlnHomePage linkedlnHomePage = new LinkedlnHomePage();
	private LinkedlnFullProfilePage linkedlnFullProfilePage = new LinkedlnFullProfilePage();
	private ExtensFullProfilePage extensFullProfilePage = new ExtensFullProfilePage();

	String extensionWindowHandle;
	String name;
	
	@When("I click on See example button")
	public void i_Click_On_See_Example_Button() {
		extensHomePage.clickSeeExample();
		extensionWindowHandle = extensHomePage.getWindowHandle();
		System.out.println("extensionWindowHandle" + extensionWindowHandle);

	}

	@And("I login to Linkedln with valid credentials")
	public void i_Login_To_Linkedln_With_Valid_Credentials() {
		linkedlnLoginPage.loginLinkedln();
	}


	@And("I search for {string} to see the full profile")
	public void i_Search_For_To_see_the_full_Profile(String name) {
		this.name = name;
		linkedlnHomePage.searchInLinkedln(name);
		linkedlnHomePage.clickFullProfile();
	}


	@And("I switch to extension and capture the profile into current campaign")
	public void i_Switch_To_Extension_And_Capture_The_Profile_Into_Current_Campaign() {
//		extensFullProfilePage.refreshPage();
//		linkedlnFullProfilePage.refreshLinkedlnProfilePage();
		Utils.switchToWindow(1);
//		extensFullProfilePage.refreshPage();
		extensFullProfilePage.captureLead(name);
	}

	@Then("First name, Last name, company name and profile photo in the extension should be the same as those in Linkedln")
	public void first_Name_Last_Name_Company_Name_And_Profile_Photo_In_The_Extension_Should_Be_The_Same_As_Those_In_Linkedln() {
		System.out.println(linkedlnFullProfilePage.getProfileFromLinkedln());
		List<String> profileFromLinkedln = linkedlnFullProfilePage.getProfileFromLinkedln();

		Utils.switchToWindow(1);
		extensFullProfilePage.refreshPage();
		System.out.println(extensFullProfilePage.getProfileFromExtension());
		List<String> profileFromExtension = extensFullProfilePage.getProfileFromExtension();

		Assert.assertEquals(profileFromLinkedln, profileFromExtension);
	}


}
