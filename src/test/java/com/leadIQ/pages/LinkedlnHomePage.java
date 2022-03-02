package com.leadIQ.pages;

import com.leadIQ.utilities.Driver;
import com.leadIQ.utilities.Utils;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LinkedlnHomePage extends BasePage{

	@FindBy(css = "input[placeholder='Search']")
	private WebElement searchBtn;

	@FindBy(xpath = "//span[text()='View full profile']")
	private WebElement viewFullProfileBtn;

	public void searchInLinkedln(String name){
		Utils.waitClickability(searchBtn,3);
		searchBtn.sendKeys(name, Keys.ENTER);
	}

	public void clickFullProfile(){
		Utils.waitForVisibility(viewFullProfileBtn,5);
		viewFullProfileBtn.click();
	}

}
