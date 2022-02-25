package com.leadIQ.pages;

import com.leadIQ.utilities.ConfigReader;
import com.leadIQ.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class ExtensLoginPage extends BasePage {

//	div[class='ds-button get-started primary normal']

	@FindBy(css = "span[class=' el-dropdown-selfdefine   ']  ")
	private WebElement seeCampaignBtn;

	@FindBy(css = "input[placeholder='Select a campaign']")
	private WebElement selectaCampaignBtn;

	@FindBy(css = "input[type='email']")
	private WebElement emailInputBox;

	@FindBy(css = "input[type='password']")
	private WebElement passwordInputBox;

	@FindBy(xpath = "(//iframe)[5]")
	private WebElement iframeLogin;

	@FindBy(css = "div[class='iq-button hover-button btn login-button strong']")
	private WebElement loginBtn;

	@FindBy(css = "meta[name='leadiq-chrome-extension']")
	private WebElement extenMeta;

	public void verifyExtenLaunched(){
		Assert.assertTrue(Driver.getDriver().getTitle().equals("LeadIQ"));
		Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains("extension/leadiq-app.html#/init"));
		Assert.assertTrue(extenMeta.getAttribute("content").equals("installed"));
	}

	public void login(){
		Driver.getDriver().switchTo().frame(iframeLogin);
		emailInputBox.sendKeys(ConfigReader.getProperty("username"));
		passwordInputBox.sendKeys(ConfigReader.getProperty("password"));
		loginBtn.click();
		Driver.getDriver().switchTo().defaultContent();
	}

	public void verifySelectCampaignDisplayed(){
		Assert.assertTrue(selectaCampaignBtn.isDisplayed());
	}


}
