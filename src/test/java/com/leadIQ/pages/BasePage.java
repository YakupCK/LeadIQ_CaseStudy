package com.leadIQ.pages;

import com.leadIQ.step_defs.Hooks;
import com.leadIQ.utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {


	public BasePage() {
		PageFactory.initElements(Driver.getDriver(), this);
	}

}
