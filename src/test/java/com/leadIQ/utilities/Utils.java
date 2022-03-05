package com.leadIQ.utilities;

import io.github.sukgu.Shadow;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.Set;

public class Utils {

	public static WebElement findShadowElement(String cssLocator){
		WebElement shadowElement = null;
		try {
			Shadow shadow = new Shadow(Driver.getDriver());
			shadowElement = shadow.findElement(cssLocator);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return shadowElement;
	}


	//wait for an element to be clickable (with web element)
	public static void waitClickability(WebElement element, int timeOut){
		try {
			WebDriverWait wait = new WebDriverWait(Driver.getDriver(), timeOut);
			wait.until(ExpectedConditions.elementToBeClickable(element));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	//wait for an element to be clickable (with By locator)
	public static void waitClickability(By locator, int timeOut){
		try {
			WebDriverWait wait = new WebDriverWait(Driver.getDriver(),timeOut);
			wait.until(ExpectedConditions.elementToBeClickable(Driver.getDriver().findElement(locator)));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	//wait till URL contains a specific text
	public static void waitForURLContains(String urlPart, int timeOut) {
		try {
			WebDriverWait wait = new WebDriverWait(Driver.getDriver(), timeOut);
			wait.until(ExpectedConditions.urlContains(urlPart));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	//wait for visibility of a web element
	public static void waitForVisibility(WebElement element, int timeOut) {
		try {
			WebDriverWait wait = new WebDriverWait(Driver.getDriver(), timeOut);
			wait.until(ExpectedConditions.visibilityOf(element));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	//wait till a new window gets opened
	public static void waitForNewWindow(){
		try {
			WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 4);
			wait.until(ExpectedConditions.numberOfWindowsToBe(2));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	//switch to another window by passing index number
	public static void switchToWindow(int index){
		try {
			waitForNewWindow();
			Set<String> windowHandles = Driver.getDriver().getWindowHandles();
			ArrayList<String> allTabs = new ArrayList<>(windowHandles);
			Driver.getDriver().switchTo().window(allTabs.get(index));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	//wait for a web element till has a specific text
	public static void waitForText(WebElement element, String text){
		try {
			WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 8);
			wait.until(ExpectedConditions.textToBePresentInElement(element,text));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	//open a new tab using JSexecutor
	public static void openNewTab(){
		((JavascriptExecutor) Driver.getDriver()).executeScript("window.open();");
	}

	//Thread.sleep()
	public static void staticWait(int time){
		try {
			Thread.sleep(time);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	//switch to tab with title
	public static void switchTabWithTitle(String title){
		Set<String> windowHandles = Driver.getDriver().getWindowHandles();
		for (String handle : windowHandles) {
			Driver.getDriver().switchTo().window(handle);
			staticWait(1);
			if (Driver.getDriver().getTitle().equals(title)) {
				switchToWindow(1);
				break;
			}
		}
	}




}
