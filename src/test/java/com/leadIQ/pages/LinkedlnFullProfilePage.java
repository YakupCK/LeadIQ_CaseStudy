package com.leadIQ.pages;

import com.leadIQ.utilities.Driver;
import com.leadIQ.utilities.Utils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class LinkedlnFullProfilePage extends BasePage {

	@FindBy(tagName = "h1")
	private WebElement fullName;

	@FindBy(css = "div[aria-label='Current company']")
	private WebElement currentCompany;

	@FindBy(css = "div.pv-top-card--photo.text-align-left img")
	private WebElement profilePhoto;


	public String getFullName() {
		if (fullName.getText().contains(".")) {
			return fullName.getText().replaceAll("\\.","");
		}else{
			return fullName.getText();
		}
	}

	public String getCurrentCompany(){
		return currentCompany.getText();
	}

	public String getprofilePhotoSRC(){
		return profilePhoto.getAttribute("src");
	}

	public List<String> getProfileFromLinkedln(){
		List<String> fullProfile = new ArrayList<>();
		fullProfile.add(getFullName());
		fullProfile.add(getCurrentCompany());
		fullProfile.add(getprofilePhotoSRC());
		return fullProfile;
	}

	public void refreshLinkedlnProfilePage(){
		Utils.waitForVisibility(profilePhoto,6);
		Driver.getDriver().navigate().refresh();
	}


}
