package com.uiFramework.companyName.projectName.pageObject;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.Status;
import com.uiFramework.companyName.projectName.helper.assertion.VerificationHelper;
import com.uiFramework.companyName.projectName.helper.browserConfiguration.config.ObjectReader;
import com.uiFramework.companyName.projectName.helper.logger.LoggerHelper;
import com.uiFramework.companyName.projectName.helper.wait.WaitHelper;
import com.uiFramework.companyName.projectName.testBase.TestBase;

public class MyAccountPage {

	private WebDriver driver;
	private Logger log = LoggerHelper.getLogger(HomePage.class);

	WaitHelper waitHelper;

	@FindBy(xpath = "//p[@class='info-account']")
	public WebElement YourAccountPageMessage;

	@FindBy(xpath = "//span[contains(text(),'Order history and details')]")
	public WebElement OrderHistoryAndDetails;

	@FindBy(xpath = "//span[contains(text(),'My personal information')]")
	public WebElement MyPersonalInformation;

	@FindBy(xpath = "//span[contains(text(),'My wishlists')]")
	public WebElement wishLists;

	@FindBy(xpath = "//h1[@class='page-heading']")
	public WebElement myAccount;

	public MyAccountPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		waitHelper = new WaitHelper(driver);
		waitHelper.waitForElement(OrderHistoryAndDetails, ObjectReader.reader.getExplicitWait());
		TestBase.test.log(Status.INFO, "Myaccount page object created");
		new TestBase().getNavigationScreen(driver);
	}

	public void clickOnWishLists() {
		wishLists.click();
		log.info("Clicked on .." + wishLists.getText());
		TestBase.test.log(Status.INFO, "Clicked on .." + wishLists.getText());

	}

	public void clickOnOrderHistoryAndDetails() {
		OrderHistoryAndDetails.click();
		log.info("Clicked on .." + OrderHistoryAndDetails.getText());
		TestBase.test.log(Status.INFO, "Clicked on .." + OrderHistoryAndDetails.getText());
	}
	public boolean isYourAccountPageMessage()
	{
		return new VerificationHelper(driver).isDisplayed(YourAccountPageMessage);
	}

}
