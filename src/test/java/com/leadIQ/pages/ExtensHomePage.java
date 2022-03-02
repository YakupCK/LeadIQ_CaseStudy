package com.leadIQ.pages;

import com.leadIQ.utilities.Driver;
import com.leadIQ.utilities.Utils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ExtensHomePage extends BasePage{

	@FindBy(css = "div.button-label")
	private WebElement seeExampleBtn;

	public void clickSeeExample(){
		Utils.waitClickability(seeExampleBtn,4);
		seeExampleBtn.click();
	}

	public String getWindowHandle(){
		return Driver.getDriver().getWindowHandle();
	}




}
