package com.uiFramework.companyName.projectName.helper.assertion;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.uiFramework.companyName.projectName.helper.logger.LoggerHelper;
import com.uiFramework.companyName.projectName.testBase.TestBase;

public class VerificationHelper {

	private WebDriver driver;
	private Logger log = LoggerHelper.getLogger(VerificationHelper.class);

	public VerificationHelper(WebDriver driver) {
		this.driver = driver;
	}

	public boolean isDisplayed(WebElement element) {
		try {
			element.isDisplayed();
			log.info("element is displayed " + element.getText());
			TestBase.logExtentReport("element is displayed " + element.getText());
			return true;
		} catch (Exception e) {
			log.error("element is not displayed " + e.getCause());
			TestBase.logExtentReport("element is not displayed " + e.getMessage());
			return false;
		}
	}

	public boolean isNotDisplayed(WebElement element) {
		try {
			element.isDisplayed();
			log.info("element is displayed " + element.getText());
			TestBase.logExtentReport("element is displayed " + element.getText());
			return false;
		} catch (Exception e) {
			log.error("element is not displayed " + e.getCause());
			TestBase.logExtentReport("element is not displayed " + e.getCause());
			return true;
		}
	}

	public String getText(WebElement element) {
		if (null == element) {
			log.info("WebElement is null");
			return null;
		}
		boolean status = isDisplayed(element);
		if (status) {
			log.info("element text is " + element.getText());
			return element.getText();
		} else {
			return null;
		}
	}
	
	public String getTitle()
	{
		log.info("page Title is "+ driver.getTitle());
		return driver.getTitle();
	}

}
