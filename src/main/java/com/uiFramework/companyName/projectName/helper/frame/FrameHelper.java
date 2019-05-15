package com.uiFramework.companyName.projectName.helper.frame;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


import com.uiFramework.companyName.projectName.helper.logger.LoggerHelper;
import com.uiFramework.companyName.projectName.helper.wait.WaitHelper;

public class FrameHelper {

	private WebDriver driver;
	private Logger log = LoggerHelper.getLogger(FrameHelper.class);
	
	public FrameHelper(WebDriver driver)
	{
		this.driver=driver;
	}
	
	/**
	 * This method will switch to frame based on frame index
	 * @param driver
	 */
	
	public void switchToFrame(int index)
	{
		driver.switchTo().frame(index);
		log.info("Switched to :" + index + "frame");
	}
	
	/**
	 * This method will switch to frame based on frame name
	 * @param driver
	 */
	
	public void switchToFrame(String frameName)
	{
		driver.switchTo().frame(frameName);
		log.info("Switched to :" + frameName + "frame");
	}
	
	/**
	 * This method will switch to frame based on WebElement
	 * @param driver
	 */
	
	public void switchToFrame(WebElement element)
	{
		driver.switchTo().frame(element);
		log.info("Switched to :" + element.toString());
	}	
}
