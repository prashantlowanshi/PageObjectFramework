package com.uiFramework.companyName.projectName.pageObject;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.uiFramework.companyName.projectName.helper.browserConfiguration.config.ObjectReader;
import com.uiFramework.companyName.projectName.helper.logger.LoggerHelper;
import com.uiFramework.companyName.projectName.helper.wait.WaitHelper;
import com.uiFramework.companyName.projectName.testBase.TestBase;

public class NavigationMenu {

	private WebDriver driver;
	private Logger log = LoggerHelper.getLogger(NavigationMenu.class);
	WaitHelper waitHelper;

	// *[@id='block_top_menu']/ul/li[2]/a
	// css equivalent - [id='block_top_menu']>ul>li:nth-child(2)>a

	@FindBy(xpath = "//*[@id='block_top_menu']/ul/li[1]/a")
	public WebElement womenMenu;

	@FindBy(xpath = "//*[@id='block_top_menu']/ul/li[2]/a")
	public WebElement dressMenu;

	@FindBy(xpath = "//*[@id='block_top_menu']/ul/li[3]/a")
	public WebElement tshirtMenu;

	public NavigationMenu(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		waitHelper = new WaitHelper(driver);
		waitHelper.waitForElement(womenMenu, ObjectReader.reader.getExplicitWait());
		TestBase.logExtentReport("NavigationMenu object created");
		new TestBase().getNavigationScreen(driver);
	}

	public void mouseOver(String data) {
		log.info("doing mouse over on :" + data);
		TestBase.logExtentReport("doing mouse over on :" + data);
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//*[contains(text(),'" + data + "')]"))).build().perform();
	}

	public ProductCategoryPage clickOnItem(String data) {
		log.info("clicking on : " + data);
		TestBase.logExtentReport("clicking on : " + data);
		driver.findElement(By.xpath("//*[contains(text(),'" + data + "')]")).click();
		return new ProductCategoryPage(driver);
	}
	
	public ProductCategoryPage clickOnMenu(WebElement element)
	{
		log.info("clicking on : " + element.getText());
		TestBase.logExtentReport("clicking on : " + element.getText());
		element.click();
		return new ProductCategoryPage(driver);
	}
	

}
