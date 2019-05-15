package com.uiFramework.companyName.projectName.pageObject;

import java.util.Iterator;
import java.util.List;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.uiFramework.companyName.projectName.helper.browserConfiguration.config.ObjectReader;
import com.uiFramework.companyName.projectName.helper.logger.LoggerHelper;
import com.uiFramework.companyName.projectName.helper.wait.WaitHelper;
import com.uiFramework.companyName.projectName.testBase.TestBase;

public class RegistrationPage {

	private WebDriver driver;
	private Logger log = LoggerHelper.getLogger(HomePage.class);

	WaitHelper waitHelper;

	@FindBy(xpath = "//*[@id='id_gender1']")
	public WebElement mrRadioButton;

	@FindBy(xpath = "//*[@id='id_gender2']")
	public WebElement mrsRadioButton;

	@FindBy(xpath = "//*[@id='customer_firstname']")
	public WebElement firstName;

	@FindBy(xpath = "//*[@id='customer_lastname']")
	public WebElement lastName;

	@FindBy(xpath = "//*[@id='email']")
	public WebElement emailAddress;

	@FindBy(xpath = "//*[@id='passwd']")
	public WebElement password;

	@FindBy(xpath = "//*[@id='days']")
	public WebElement days;

	@FindBy(xpath = "//*[@id='months']")
	public WebElement months;

	@FindBy(xpath = "//*[@id='years']")
	public WebElement years;

	@FindBy(xpath = "//*[@id='firstname']")
	public WebElement yourAddressFirstName;

	@FindBy(xpath = "//*[@id='lastname']")
	public WebElement yourAddresslastName;

	@FindBy(xpath = "//*[@id='company']")
	public WebElement yourCompanyAddress;

	@FindBy(xpath = "//*[@id='address1']")
	public WebElement address;

	@FindBy(xpath = "//*[@id='address2']")
	public WebElement address2;

	@FindBy(xpath = "//*[@id='city']")
	public WebElement yourAddressCity;

	@FindBy(xpath = "//*[@id='id_state']")
	public WebElement yourAddressState;

	@FindBy(xpath = "//*[@id='postcode']")
	public WebElement yourAddressPostCode;

	@FindBy(xpath = "//*[@id='id_country']")
	public WebElement additionalInformation;

	@FindBy(xpath = "//*[@id='phone']")
	public WebElement homePhone;

	@FindBy(xpath = "//*[@id='phone_mobile']")
	public WebElement mobilePhone;

	@FindBy(xpath = "//*[@id='alias']")
	public WebElement addressAlias;

	@FindBy(xpath = "//*[@id='submitAccount']")
	public WebElement registration;

	public RegistrationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		waitHelper = new WaitHelper(driver);
		waitHelper.waitForElement(mrRadioButton, ObjectReader.reader.getExplicitWait());
		TestBase.logExtentReport("RegistrationPage object created");
		new TestBase().getNavigationScreen(driver);
	}

	public void setMrRadioButton() {
		log.info("selecting mr checkbox....");
		TestBase.logExtentReport("selecting mr checkbox....");
		this.mrRadioButton.click();
	}

	public void setMrsRadioButton() {
		log.info("selecting mrs checkbox....");
		TestBase.logExtentReport("selecting mrs checkbox....");
		this.mrsRadioButton.click();
	}

	public void setFirstName(String firstName) {
		log.info("entering firstname " + firstName);
		TestBase.logExtentReport("entering firstname" + firstName);
		this.firstName.sendKeys(firstName);
	}

	public void setLastName(String lastName) {
		log.info("entering lastname " + lastName);
		TestBase.logExtentReport("entering lastname" + lastName);
		this.lastName.sendKeys(lastName);
	}

	public void setEmailAddress(String emailAddress) {
		log.info("entering email address.." + emailAddress);
		TestBase.logExtentReport("entering email address.." + emailAddress);
		this.emailAddress.sendKeys(emailAddress);
	}

	public void setPassword(String password) {
		log.info("entering password.." + password);
		TestBase.logExtentReport("entering password.." + password);
		this.password.sendKeys(password);
	}

	public void setDay(String day) {
		List<WebElement> days = driver.findElements(By.xpath("//*[@id='days']/option"));
		Iterator<WebElement> itr = days.iterator();
		while (itr.hasNext()) {
			WebElement c = itr.next();
			String text = c.getText().trim().toString();
			if (text.equals(day)) {
				System.out.println(day);
				c.click();
				break;
			}
		}
	}

	public void setMonth(String month) {
		List<WebElement> months = driver.findElements(By.xpath("//*[@id='months']/option"));
		Iterator<WebElement> itr = months.iterator();
		while (itr.hasNext()) {
			WebElement click = itr.next();
			String text = click.getText().trim();
			if (text.equals(month)) {
				click.click();
				break;
			}
		}

	}

	public void setYear(String year) {
		List<WebElement> years = driver.findElements(By.xpath("//*[@id='years']/option"));
		Iterator<WebElement> itr = years.iterator();
		while (itr.hasNext()) {
			WebElement click = itr.next();
			String text = click.getText().trim();
			if (text.equals(year)) {
				click.click();
				break;
			}
		}

	}

	public void setYourAddressFirstName(String yourAddressFirstName) {
		log.info("Set your address firstname" + yourAddressFirstName);
		TestBase.logExtentReport("entering email address.." + yourAddressFirstName);
		this.yourAddressFirstName.sendKeys(yourAddressFirstName);
	}

	public void setYourAddresslastName(String yourAddresslastName) {
		log.info("Set your address lastname" + yourAddresslastName);
		TestBase.logExtentReport("entering your address lastname.." + yourAddresslastName);
		this.yourAddresslastName.sendKeys(yourAddresslastName);
	}

	public void setYourAddressCompany(String yourCompanyAddress) {
		log.info("Set your company address " + yourCompanyAddress);
		TestBase.logExtentReport("Set your company address " + yourCompanyAddress);
		this.yourCompanyAddress.sendKeys(yourCompanyAddress);
	}

	public void setAddress(String address) {
		log.info("Enetring address" + address);
		TestBase.logExtentReport("Enetring address" + address);
		this.address.sendKeys(address);
	}

	public void setAddress2(String address2) {
		log.info("Enetring address 2" + address2);
		TestBase.logExtentReport("Enetring address 2" + address2);
		this.address2.sendKeys(address2);
	}

	public void setYourAddressCity(String yourAddressCity) {
		log.info("Enetring address city" + yourAddressCity);
		TestBase.logExtentReport("Enetring  address city" + yourAddressCity);
		this.yourAddressCity.sendKeys(yourAddressCity);
	}

	public void setYourAddressState(String yourAddressState) {
		log.info("Entering address state " + yourAddressState);
		TestBase.logExtentReport("Entering address state " + yourAddressState);
		this.yourAddressState.sendKeys(yourAddressState);
	}

	public void setYourAddressPostCode(String yourAddressPostCode) {
		log.info("Entering address postal code " + yourAddressPostCode);
		TestBase.logExtentReport("Entering address postal code " + yourAddressPostCode);
		this.yourAddressPostCode.sendKeys(yourAddressPostCode);
	}

	public void setAdditionalInformation(String additionalInformation) {
		log.info("Entering additional info " + additionalInformation);
		TestBase.logExtentReport("Entering additional info " + additionalInformation);
		this.additionalInformation.sendKeys(additionalInformation);
	}

	public void setHomePhone(String homePhone) {
		log.info("Entering homePhone " + homePhone);
		TestBase.logExtentReport("Entering homePhone " + homePhone);
		this.homePhone.sendKeys(homePhone);
	}

	public void setmobilePhone(String mobilePhone) {
		log.info("Entering mobilePhone " + mobilePhone);
		TestBase.logExtentReport("Entering mobilePhone " + mobilePhone);
		this.mobilePhone.sendKeys(mobilePhone);
	}

	public void setAddressAlias(String addressAlias) {
		log.info("Entering addressAlias " + addressAlias);
		TestBase.logExtentReport("Entering addressAlias " + addressAlias);
		this.addressAlias.sendKeys(addressAlias);
	}

	public void clickRegistration() {
		log.info("clicked on registration.." + registration);
		this.registration.click();
	}
}
