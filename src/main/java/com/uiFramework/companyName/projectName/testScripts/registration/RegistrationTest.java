package com.uiFramework.companyName.projectName.testScripts.registration;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import com.uiFramework.companyName.projectName.helper.assertion.AssertionHelper;
import com.uiFramework.companyName.projectName.helper.browserConfiguration.config.ObjectReader;
import com.uiFramework.companyName.projectName.helper.logger.LoggerHelper;
import com.uiFramework.companyName.projectName.pageObject.LoginPage;
import com.uiFramework.companyName.projectName.pageObject.MyAccountPage;
import com.uiFramework.companyName.projectName.pageObject.RegistrationPage;
import com.uiFramework.companyName.projectName.testBase.TestBase;

public class RegistrationTest extends TestBase {
	private final Logger log = LoggerHelper.getLogger(RegistrationTest.class);
	LoginPage loginPage;
	RegistrationPage register;
	MyAccountPage myAccountPage;

	@Test
	public void testLoginToApplication() throws InterruptedException {
		getApplicationUrl(ObjectReader.reader.getUrl());
		loginPage = new LoginPage(driver);
		loginPage.clickOnSignInLink();
		loginPage.enterRegistrationEmail();
		loginPage.clickOnCreateAnAccount();
		
		//enter registration date
		register = new RegistrationPage(driver);
		register.setMrRadioButton();
		register.setFirstName("firtName");
		register.setLastName("lastName");
		register.setPassword("password");
		register.setAddress("address");
		register.setDay("5");
		register.setMonth("June");
		register.setYear("2017");
		
		Thread.sleep(5000);
		
		register.setYourAddressFirstName("yourAddressFirstName");
		
		Thread.sleep(5000);
		
		register.setYourAddresslastName("yourAddresslastName");
		register.setYourAddressCompany("yourAddressCompany");
		register.setYourAddressCity("yourAddressCity");
		register.setYourAddressState("Alaska");
		register.setYourAddressPostCode("99501");
		register.setmobilePhone("9999999999");
		register.setAddressAlias("addressAlias");
		register.clickRegistration();
		
		myAccountPage = new MyAccountPage(driver);
		boolean status = myAccountPage.isYourAccountPageMessage();
		AssertionHelper.updateTestStatus(status);
	}
}
