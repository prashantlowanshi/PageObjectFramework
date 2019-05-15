package com.uiFramework.companyName.projectName.helper.javaScript;

import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.uiFramework.companyName.projectName.helper.logger.LoggerHelper;

public class JavaScriptHelper {

	private WebDriver driver;
	private Logger log = LoggerHelper.getLogger(JavaScriptHelper.class);

	public JavaScriptHelper(WebDriver driver) {
		this.driver = driver;
		log.info("JavaScript Helper has been initialized");
	}
    /**
     * This method will execute java script 
     * @param script
     * @return
     */
	public Object executeScript(String script) {
		JavascriptExecutor exe = (JavascriptExecutor) driver;
		return exe.executeScript(script);
	}
	
	/**
	 * This method will execute java script with multiple arguments
	 * @param script
	 * @param args
	 * @return
	 */
	
	public Object executeScript(String script, Object...args) {
		JavascriptExecutor exe = (JavascriptExecutor) driver;
		return exe.executeScript(script, args);
	}
	
	/**
	 * This method will execute till element
	 * @param element
	 */
	
	public void scrollToElement(WebElement element)
	{
		log.info("scroll to WebElement");
		executeScript("window.scrollTo(arguments[0], arguments[1])", element.getLocation().x,element.getLocation().y);
	}
	
	/**
	 * This method will execute till element and click
	 * @param element
	 */
	public void scrollToElementAndClick(WebElement element)
	{
		scrollToElement(element);
		element.click();
		log.info("element is clicked" + element.toString());
	}
	
	/**
	 * This method will scroll till element view
	 * @param element
	 */
	public void scrollIntoView(WebElement element)
	{
		log.info("scroll till web element");
		executeScript("arguments[0].scrollIntoView()", element);
	}
	
	
	/**
	 * This method will scroll till element view and click
	 * @param element
	 */
	public void scrollIntoViewAndClick(WebElement element)
	{
		scrollIntoView(element);
		element.click();
	    log.info("element is clicked: " + element.toString());
	}
	
	
	/**
	 * This method will scroll down vertically
	 * @param element
	 */
	public void scrollDownVertically()
	{
		log.info("Scrolling down veritically");
		executeScript("window.scrollTo(0, document.body.scrollHeight)");
	}
	
	
	/**
	 * This method will scroll up vertically
	 * @param element
	 */
	public void scrollUpVertically()
	{
		log.info("Scrolling up vertically");
		executeScript("window.scrollTo(0, -document.body.scrollHeight)");
	}
	
	/**
	 * This method will scroll till element view
	 * @param element
	 */
	public void scrollDownByPixel(int pixel)
	{
		executeScript("window.scrollBY(0,"+pixel+")");
	}
	
	/**
	 * This method will scroll till given pixel (e.g = 1500)
	 * @param element
	 */
	public void scrollUpByPixel(int pixel)
	{
		executeScript("window.scrollBY(0,-"+pixel+")");
	}
	
	/**
	 * This method will zoom screen by 100
	 * @param element
	 */
	public void zoomInBy100Percentage()
	{
		executeScript("document.body.style.zoom='100%'");
	}
	
	/**
	 * This method will zoom screen by 60
	 * @param element
	 */
	public void zoomInBy40Percentage()
	{
		executeScript("document.body.style.zoom='40%'");
	}
	
	
	/**
	 * This method will click on element
	 * @param element
	 */
	public void clickElement(WebElement element)
	{
		executeScript("arguments[0].click();",  element);
	}
}
