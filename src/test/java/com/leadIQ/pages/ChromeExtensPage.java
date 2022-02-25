package com.leadIQ.pages;

import com.leadIQ.utilities.ConfigReader;
import com.leadIQ.utilities.Driver;
import com.leadIQ.utilities.Utils;
import org.junit.Assert;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

import java.util.List;
import java.util.Set;

public class ChromeExtensPage extends BasePage {

	private String detailsBtnLocator = "#detailsButton";

	private String devModeBtn = "cr-toggle#devMode";

	private String extensionID = "div#extension-id";

	private String version = "span#version";

	public String getExtVersion() {
		return Utils.findShadowElement(version).getText();
	}

	public String getExtID(){
		String id = Utils.findShadowElement(extensionID).getText();
		return id = id.replace("ID: ", "");
	}

	public void openDevMode(){
		Utils.findShadowElement(devModeBtn).click();
	}

	public void navigateToExtensionsPage(){
		Driver.getDriver().get(ConfigReader.getProperty("chromeExtensionURL"));
	}

	public void checkExtensionDetails(){
		Utils.findShadowElement(detailsBtnLocator).click();
	}

	public void verifyExtID(List<String> idList){
		Assert.assertTrue(getExtID().equals(idList.get(0)));
	}

	public void verifyExtVersion(String version){
		Assert.assertTrue(getExtVersion().contains(version));
	}

	public void launchExtension() throws FindFailed {
		Screen screen = new Screen();
		Pattern extensionIcon = new Pattern(System.getProperty("user.dir") + "\\src\\test\\resources\\sikuli_images\\extensions_icon.png");
		screen.click(extensionIcon);

		Pattern leadIQIcon = new Pattern(System.getProperty("user.dir") + "\\src\\test\\resources\\sikuli_images\\leadiq_extension_icon.png");
		screen.click(leadIQIcon);

		Utils.switchToWindow(1);

	}

}
