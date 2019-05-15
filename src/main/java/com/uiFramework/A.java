package com.uiFramework;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.uiFramework.companyName.projectName.testBase.TestBase;

public class A extends TestBase {
	@Test
	public void testLoginA() {
      Assert.assertTrue(true);
      System.out.println(System.getProperty("environment"));
      System.out.println(System.getProperty("testSuite"));
	}
}
