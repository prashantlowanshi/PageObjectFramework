package com.uiFramework.companyName.projectName.pageObject;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.uiFramework.companyName.projectName.helper.logger.LoggerHelper;
import com.uiFramework.companyName.projectName.helper.wait.WaitHelper;

public class HomePage {

	private WebDriver driver;
	private Logger log = LoggerHelper.getLogger(HomePage.class);
	
	WaitHelper waitHelper;
	
	public HomePage(WebDriver driver)
	{
		this.driver = driver;
		//PageFactory.initElements(driver, this);
	}
}
