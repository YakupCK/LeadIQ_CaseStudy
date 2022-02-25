package com.leadIQ.pages;

import com.leadIQ.utilities.ConfigReader;
import com.leadIQ.utilities.Utils;
import org.junit.Assert;

public class ChromeExtenDetailsPage extends BasePage{

	//css locator of extension name
	String extensionNameLocator = ".cr-title-text";

	//version of the extension
	String extensionVersionLocator = ".section-content";

	//return extension name as String
	public String getExtensionName(){
		return Utils.findShadowElement(extensionNameLocator).getText();
	}

	//return extension version as String
	public String getExtensionVersion(){
		return Utils.findShadowElement(extensionVersionLocator).getText();
	}

	//verify the extension name
	public void verifyExtensionName(){
		Assert.assertTrue(getExtensionName().contains(ConfigReader.getProperty("extensionName")));
	}

	//verify the extension version
	public void verifyExtensionVersion(){
		Assert.assertTrue(getExtensionVersion().equals(ConfigReader.getProperty("extensionVersion")));
	}

}
