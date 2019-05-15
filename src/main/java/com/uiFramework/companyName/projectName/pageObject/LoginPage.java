package com.uiFramework.companyName.projectName.pageObject;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.Status;
import com.uiFramework.companyName.projectName.helper.assertion.VerificationHelper;
import com.uiFramework.companyName.projectName.helper.browserConfiguration.config.ObjectReader;
import com.uiFramework.companyName.projectName.helper.javaScript.JavaScriptHelper;
import com.uiFramework.companyName.projectName.helper.logger.LoggerHelper;
import com.uiFramework.companyName.projectName.helper.wait.WaitHelper;
import com.uiFramework.companyName.projectName.testBase.TestBase;

// http://automationpractice.com/index.php?controller=authentication&back=my-account
// Email - Prashant@mailinator.com
// Password - Prashant123
// Time - 12:54

public class LoginPage {

	private WebDriver driver;
	private Logger log = LoggerHelper.getLogger(LoginPage.class);

	WaitHelper waitHelper;

	@FindBy(xpath = "//a[@title='Log in to your customer account']")
	WebElement signin;

	@FindBy(xpath = "//input[@name='email']")
	WebElement emailAddress;

	@FindBy(xpath = "//input[@id='passwd']")
	WebElement password;

	@FindBy(xpath = "//p[@class='submit']//span[1]")
	WebElement SubmitLogin;

	@FindBy(xpath = "//*[@id='center_column']/p")
	WebElement successMsgObject;

	@FindBy(xpath = "//input[@name='email_create']")
	WebElement registrationEmailAddress;

	@FindBy(xpath = "//div[@class='submit']//span[1]")
	WebElement createAnAccount;

	@FindBy(xpath = "//h1[@class='page-heading']")
	WebElement authenticate;

	@FindBy(xpath = "//h3[contains(text(),'Create an account')]")
	WebElement createAnAccountMessage;

	@FindBy(xpath = "//*[@title='Log me out']")
	WebElement logout;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		waitHelper = new WaitHelper(driver);
		waitHelper.waitForElement(signin, ObjectReader.reader.getExplicitWait());
		new TestBase().getNavigationScreen(driver);
		TestBase.logExtentReport("Login page object created");
	}

	public void clickOnSignInLink() {
		log.info("Clicked on sign in link ...");
		TestBase.logExtentReport("Clicked on sign in link ...");
		signin.click();
	}

	public void enterEmailAddress(String emailAddress) {
		log.info("Entering email address...." + emailAddress);
	    TestBase.logExtentReport("Entering email address...." + emailAddress);
		this.emailAddress.sendKeys(emailAddress);
	}

	public void enterPassword(String password) {
		log.info("Entering password...." + emailAddress);
		TestBase.logExtentReport("Entering password...." + password);
		this.password.sendKeys(password);
	}

	public HomePage clickOnSubmitButton() {
		log.info("Clicking on submit button");
		new JavaScriptHelper(driver).scrollDownVertically();
		SubmitLogin.click();
		return new HomePage(driver);
	}

	public boolean verifySuccessLoginMsg() {
		log.info("................User is logged in..............");
		TestBase.logExtentReport("................User is logged in..............");		
		return new VerificationHelper(driver).isDisplayed(successMsgObject);		
	}

	public void enterRegistrationEmail() {
		String email = System.currentTimeMillis() + "@gmail.com";
		log.info("Entering registration email...." + email);
		registrationEmailAddress.sendKeys(email);
	}

	public RegistrationPage clickOnCreateAnAccount() {
		createAnAccount.click();
		return new RegistrationPage(driver);
	}

	public void loginToApplication(String emailAddress, String password) {
		clickOnSignInLink();
		enterEmailAddress(emailAddress);
		enterPassword(password);
		clickOnSubmitButton();
	}
	
	/*public void logExtentReport(String s1)
	{
		TestBase.test.log(Status.INFO, s1);
	}*/
	
	public void logout()
	{
		logout.click();
		waitHelper.waitForElement(signin, ObjectReader.reader.getExplicitWait());
	}
	
}
