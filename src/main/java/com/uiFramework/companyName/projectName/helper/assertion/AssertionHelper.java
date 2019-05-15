package com.uiFramework.companyName.projectName.helper.assertion;

import org.apache.log4j.Logger;
import org.testng.Assert;

import com.uiFramework.companyName.projectName.helper.logger.LoggerHelper;

public class AssertionHelper {

	private static Logger log = LoggerHelper.getLogger(AssertionHelper.class);

	public static void verifyText(String s1, String s2) {
		log.info("Veryfing test: " + s1 + " with " + s2);
		Assert.assertEquals(s1, s2);
	}

	public static void makeTrue() {
		log.info("make script Pass ....");
		Assert.assertTrue(true);
	}

	public static void makeTrue(String message) {
		log.info("make script Pass ...." + message);
		Assert.assertTrue(true);
	}

	public static void makeFalse() {
		log.info("make script Fail ....");
		Assert.assertTrue(false);
	}

	public static void makeFalse(String message) {
		log.info("make script Fail ...." + message);
		Assert.assertTrue(false);
	}

	public static void verifyTrue(boolean status) {
		Assert.assertTrue(status);
	}

	public static void verifyFalse(boolean status) {
		Assert.assertFalse(status);
	}

	public static void verifyNull(String s1) {
		log.info("Verify objet is null....");
		Assert.assertNull(s1);
	}

	public static void verifyNotNull(String s1) {
		log.info("Verify objet is not null....");
		Assert.assertNull(s1);
	}

	public static void fail() {
       Assert.assertTrue(false);
	}

	public static void pass() {
		Assert.assertTrue(true);
	}

	public static void updateTestStatus(boolean status) {
		if(status)
		{
			pass();
		}
		else
		{
			fail();
		}

	}

}
