package com.leadIQ.pages;

import com.leadIQ.utilities.Utils;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.ArrayList;
import java.util.List;

public class ExtensFullProfilePage extends BasePage{

//	(//img[@class='service-icon'])[2]

	@FindBy(css = "div.checkmark")
	private WebElement checkmark;

	@FindBy(css = "div.name.iq-bold")
	private WebElement fullName;

	@FindBy(css = "div.iq-button.action-button.primary")
	private WebElement captureBtn;

	@FindBy(css = "img.icon.refresh-icon")
	private WebElement refreshBtn;

	@FindBy(css = "div.company-name")
	private WebElement currentCompany;

	@FindBy(css = "div.profile-photo-container.profile-pic img")
	private WebElement profilePhoto;

	public void captureLead(String name){
		Utils.waitForText(fullName,name);
		Utils.waitForVisibility(captureBtn,8);
		captureBtn.click();
		Utils.waitForVisibility(checkmark,8);
		Assert.assertTrue(checkmark.isDisplayed());
	}

	public void refreshPage() {
		Utils.waitClickability(refreshBtn, 3);
		refreshBtn.click();
	}

	public String getFullName() {
		Utils.waitForVisibility(fullName, 10);
		return fullName.getText();
	}

	public String getCurrentCompany() {
		String company = currentCompany.getText();
		String[] companySplit = company.split(" ");
		return companySplit[0];
	}

	public String getprofilePhotoSRC() {
		return profilePhoto.getAttribute("src");
	}

	public List<String> getProfileFromExtension() {

		List<String> fullProfile = new ArrayList<>();
		fullProfile.add(getFullName());
		fullProfile.add(getCurrentCompany());
		fullProfile.add(getprofilePhotoSRC());
		return fullProfile;
	}



}
