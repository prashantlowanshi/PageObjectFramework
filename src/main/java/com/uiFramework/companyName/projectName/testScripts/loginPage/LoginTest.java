package com.uiFramework.companyName.projectName.testScripts.loginPage;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import com.uiFramework.companyName.projectName.helper.assertion.AssertionHelper;
import com.uiFramework.companyName.projectName.helper.browserConfiguration.config.ObjectReader;
import com.uiFramework.companyName.projectName.helper.logger.LoggerHelper;
import com.uiFramework.companyName.projectName.pageObject.LoginPage;
import com.uiFramework.companyName.projectName.testBase.TestBase;


public class LoginTest extends TestBase {
	private final Logger log = LoggerHelper.getLogger(LoginTest.class);

	@Test(description = "Login test with valid credentials")
	public void testLoginToApplication() {
		System.out.println();
		getApplicationUrl(ObjectReader.reader.getUrl());
		//Browser instance of testbase will be created here 
		LoginPage loginPage = new LoginPage(driver);
		loginPage.loginToApplication(ObjectReader.reader.getUserName(), ObjectReader.reader.getPassword());
		boolean status = loginPage.verifySuccessLoginMsg();
		AssertionHelper.updateTestStatus(status);
	}
}
