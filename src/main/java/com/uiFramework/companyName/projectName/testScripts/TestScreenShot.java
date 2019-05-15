package com.uiFramework.companyName.projectName.testScripts;

import org.testng.annotations.Test;

import com.uiFramework.companyName.projectName.testBase.TestBase;

public class TestScreenShot extends TestBase{

	@Test
	public void testScreen()
	{
		driver.get("https://www.google.com/");
		captureScreen("firstScreen", driver); 
	}
}
