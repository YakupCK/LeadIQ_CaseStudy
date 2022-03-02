package com.leadIQ.pages;

import com.leadIQ.utilities.ConfigReader;
import com.leadIQ.utilities.Driver;
import com.leadIQ.utilities.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LinkedlnLoginPage extends BasePage {

	@FindBy(xpath = "//button[text()=' Sign in ']")
	private WebElement signInLinkedlnBtn;

	@FindBy(css = "input[autocomplete='username']")
	private WebElement usernameInput;

	@FindBy(css = "input[autocomplete='current-password']")
	private WebElement passwordInput;

	@FindBy(css = "button.sign-in-form__submit-button")
	private WebElement signInBtn;

	@FindBy(xpath = "//button[text()='Sign in']")
	private WebElement signInBtn2;

	@FindBy(css = "a[aria-label='Sign in']")
	private WebElement signInLinkedlnBtn2;


	@FindBy(css = "input#username")
	private WebElement usernameInput2;

	@FindBy(css = "input#password")
	private WebElement passwordInput2;

	@FindBy(css = "//a[contains(text(),'Sign in')]")
	private WebElement signInLinkedlnBtn3;

	public void skipSecurityCheck() {
		signInLinkedlnBtn2.click();
		Utils.waitClickability(usernameInput, 3);
		usernameInput2.sendKeys(ConfigReader.getProperty("linkedlnUsername"));
		passwordInput2.sendKeys(ConfigReader.getProperty("linkedlnPassword"));
		signInBtn2.click();
	}

	public void loginWithoutSecurityCheck() {
		Utils.waitClickability(signInLinkedlnBtn, 3);
		signInLinkedlnBtn.click();
		Utils.waitClickability(usernameInput, 3);
		usernameInput.sendKeys(ConfigReader.getProperty("linkedlnUsername"));
		passwordInput.sendKeys(ConfigReader.getProperty("linkedlnPassword"));
		signInBtn.click();
	}

	public void login3() {
		Utils.waitClickability(signInLinkedlnBtn3, 3);
		signInLinkedlnBtn3.click();
		Utils.waitClickability(usernameInput, 3);
		usernameInput2.sendKeys(ConfigReader.getProperty("linkedlnUsername"));
		passwordInput2.sendKeys(ConfigReader.getProperty("linkedlnPassword"));
		signInBtn2.click();
	}


	public void loginLinkedln() {
		Utils.switchToWindow(2);
		try {
			loginWithoutSecurityCheck();
		} catch (Exception e) {
			skipSecurityCheck();
		}
	}
}




