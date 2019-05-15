package com.uiFramework.companyName.projectName.testScripts.productDetailsPage;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.uiFramework.companyName.projectName.helper.assertion.AssertionHelper;
import com.uiFramework.companyName.projectName.helper.browserConfiguration.config.ObjectReader;
import com.uiFramework.companyName.projectName.helper.logger.LoggerHelper;
import com.uiFramework.companyName.projectName.pageObject.NavigationMenu;
import com.uiFramework.companyName.projectName.pageObject.ProductCategoryPage;
import com.uiFramework.companyName.projectName.testBase.TestBase;

public class VerifyLowestFirstPriceFilter extends TestBase {
	private final Logger log = LoggerHelper.getLogger(VerifyLowestFirstPriceFilter.class);

	@Test
	public void verifyLowestFirstPriceListInProduct_detailsPage() throws InterruptedException {

		getApplicationUrl(ObjectReader.reader.getUrl());

		NavigationMenu navigationMenu = new NavigationMenu(driver);
		ProductCategoryPage pcategoryPage = navigationMenu.clickOnMenu(navigationMenu.womenMenu);
		// select price filter
		pcategoryPage.selectSortByFilter("Price: Lowest first");

		// wait for sometime to make sure price is sorted
		Thread.sleep(8000);
		List<WebElement> price = pcategoryPage.getAllProductsPrice();
		ArrayList<Integer> array = new ArrayList<Integer>();

		Iterator<WebElement> itr = price.iterator();

		ArrayList<Integer> data = pcategoryPage.getPriceMassagedData(itr);
		boolean status = pcategoryPage.verifyArrayHasAscendingData(data);
		AssertionHelper.updateTestStatus(status);
	}
}
