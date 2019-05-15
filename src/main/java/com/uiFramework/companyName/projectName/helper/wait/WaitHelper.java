package com.uiFramework.companyName.projectName.helper.wait;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.uiFramework.companyName.projectName.helper.logger.LoggerHelper;
import com.uiFramework.companyName.projectName.testBase.TestBase;

public class WaitHelper{
	private WebDriver driver;
	private Logger log = LoggerHelper.getLogger(WaitHelper.class);

	public WaitHelper(WebDriver driver) {
		this.driver = driver;
	}

	/**
	 * This is implicit wait method
	 * 
	 * @param timeout
	 * @param unit
	 */

	public void setImplicitWait(long timeout, TimeUnit unit) {
		log.info("Implicit wait has been set to: " + timeout);
		driver.manage().timeouts().implicitlyWait(timeout, unit);
	}

	/**
	 * This will help us get WebDriverwait object
	 * 
	 * @param timeOutInSeconds
	 * @param pollingEveryInMiliSec
	 * @return
	 */

	private WebDriverWait getWait(int timeOutInSeconds, int pollingEveryInMiliSec) {
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		wait.pollingEvery(Duration.ofMillis(pollingEveryInMiliSec));
		wait.ignoring(NoSuchElementException.class);
		wait.ignoring(ElementNotVisibleException.class);
		wait.ignoring(StaleElementReferenceException.class);
		wait.ignoring(NoSuchFrameException.class);
		return wait;
	}

	/**
	 * This method will make sure element is visible
	 * 
	 * @param timeOutInSeconds
	 * @param pollingEveryInMiliSec
	 * @return
	 */

	public void WaitForElementVisibleWithPollingTime(WebElement element, int timeOutInSeconds,
			int pollingEveryInMiliSec) {
		log.info("Waiting for : " + element.toString() + "for :" + timeOutInSeconds + "Seconds");
		WebDriverWait wait = getWait(timeOutInSeconds, pollingEveryInMiliSec);
		wait.until(ExpectedConditions.visibilityOf(element));
		TestBase.logExtentReport("Element is visible now");
	}

	/**
	 * This method will make sure element is elementToBeClickable
	 * 
	 * @param timeOutInSeconds
	 * @param pollingEveryInMiliSec
	 * @return
	 */

	public void WaitForElementClickable(WebElement element, int timeOutInSeconds) {
		log.info("Waiting for : " + element.toString() + "for :" + timeOutInSeconds + "Seconds");
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		wait.until(ExpectedConditions.elementToBeClickable(element));
		log.info("Element is clickable now");
	}

	/**
	 * This method will make sure invisibilityOf element
	 * 
	 * @param timeOutInSeconds
	 * @param pollingEveryInMiliSec
	 * @return
	 */
	public boolean WaitForElementNotPresent(WebElement element, long timeOutInSeconds) {
		log.info("Waiting for : " + element.toString() + "for :" + timeOutInSeconds + "Seconds");
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		boolean status = wait.until(ExpectedConditions.invisibilityOf(element));
		log.info("Element is invisible now");
		return status;
	}

	/**
	 * This method will wait for frameToBeAvailableAndSwitchToIt
	 * 
	 * @param timeOutInSeconds
	 * @param pollingEveryInMiliSec
	 * @return
	 */
	public void WaitForFrameToBeAvailableAndSwitchToIt(WebElement element, int timeOutInSeconds) {
		log.info("Waiting for : " + element.toString() + "for :" + timeOutInSeconds + "Seconds");
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(element));
		log.info("frame is available and switched ");
	}

	/**
	 * This method will give us fluent wait object
	 * 
	 * @param timeOutInSeconds
	 * @param pollingEveryInMiliSec
	 * @return
	 */
	private Wait<WebDriver> getfluentWait(int timeOutInSeconds, int pollingEveryInMiliSec) {
		Wait<WebDriver> fWait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(timeOutInSeconds))
				.pollingEvery(Duration.ofMillis(pollingEveryInMiliSec)).ignoring(NoSuchElementException.class);
		return fWait;
	}

	public WebElement waitForElement(WebElement element, int timeOutInSeconds, int pollingEveryInMiliSec) {
		Wait<WebDriver> fwait = getfluentWait(timeOutInSeconds, pollingEveryInMiliSec);
		fwait.until(ExpectedConditions.visibilityOf(element));
		return element;
	}

	public void pageLoadTime(long timeout, TimeUnit unit) {
		log.info("Waiting for page to load for : " + unit + "seconds");
		driver.manage().timeouts().pageLoadTimeout(timeout, unit);
		log.info("Page is loaded");
	}

	public void waitForElement(WebElement element, int timeOutInSeconds) {
		log.info("waiting for :" + element.toString() + " for" + timeOutInSeconds + " seconds");
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		wait.until(ExpectedConditions.visibilityOf(element));
		log.info("element is visible now");
	}

}