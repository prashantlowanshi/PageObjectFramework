package com.uiFramework.companyName.projectName.pageObject;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.Status;
import com.uiFramework.companyName.projectName.helper.browserConfiguration.config.ObjectReader;
import com.uiFramework.companyName.projectName.helper.javaScript.JavaScriptHelper;
import com.uiFramework.companyName.projectName.helper.logger.LoggerHelper;
import com.uiFramework.companyName.projectName.helper.select.DropDownHelper;
import com.uiFramework.companyName.projectName.helper.wait.WaitHelper;
import com.uiFramework.companyName.projectName.testBase.TestBase;

public class ProductCategoryPage {

	private WebDriver driver;
	private Logger log = LoggerHelper.getLogger(ProductCategoryPage.class);

	WaitHelper waitHelper;

	@FindBy(xpath = "//p[contains(text(),'Catalog')]")
	public WebElement catalogTextObj;

	@FindBy(xpath = "//*[@id='layer_cart']/div[1]/div[1]/h2")
	public WebElement productAddedSuccessfully;

	@FindBy(xpath = "//*[@id='center_column']/ul/li[1]/div/div[2]/div[2]/a[1]/span")
	public WebElement addToCart;

	@FindBy(xpath = "//span[contains(text(),'Proceed to checkout')]")
	public WebElement proceedToCheckOut;

	@FindBy(xpath = "//*[@id='center_column']/ul/li")
	List<WebElement> totalProducts;

	@FindBy(xpath = "//*[@id='selectProductSort']")
	public WebElement sortBy;

	@FindBy(xpath = "//*[@id='center_column']/ul/li/div/div[2]/div[1]/span[1]")
	List<WebElement> allPriceElements;

	public ProductCategoryPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		waitHelper = new WaitHelper(driver);
		waitHelper.waitForElement(catalogTextObj, ObjectReader.reader.getExplicitWait());
		TestBase.logExtentReport("ProductCategoryPage object created");
		new TestBase().getNavigationScreen(driver);
	}

	public void mouseOverOnProduct(int number) {
		String fPart = "//*[@id='center_column']/ul/li[";
		String sPart = "]/div/div[2]/h5/a";
		Actions action = new Actions(driver);
		log.info("Doing mouse hover on :" + number + "..product");
		action.moveToElement(driver.findElement(By.xpath(fPart + number + sPart))).build().perform();
	}

	public void clickOnAddToCart() {
		log.info("clicking on add to cart");
		addToCart.click();
	}

	public void clickOnProceedToCheckOut() {
		log.info("clicking on " + proceedToCheckOut.getText());
		proceedToCheckOut.click();
	}

	public void selectColour(String data) {
		new JavaScriptHelper(driver).scrollIntoView(driver
				.findElement(By.xpath("//a[contains(text(),'" + data + "')]/parent::*/preceding-sibling::input[1]")));
		driver.findElement(By.xpath("//a[contains(text(),'" + data + "')]/parent::*/preceding-sibling::input[1]"))
				.click();
		try {
			Thread.sleep(7000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void selectSmallSize() {
		log.info("selecting small size...");
		driver.findElement(By.xpath("//*[@id='layered_id_attribute_group_1']")).click();
	}

	public void selectMediumSize() {
		log.info("selecting Medium size...");
		try {
			boolean selected = driver.findElement(By.xpath("//*[@id='layered_id_attribute_group_2']")).isSelected();
			if (!selected) {
				driver.findElement(By.xpath("//*[@id='layered_id_attribute_group_2']")).click();
				log.info("checkbox is checked....");
			}
		} catch (Exception e) {
			log.info("Checkbox already checked");
		}
	}

	public void selectLSize() {
		log.info("selecting Large size...");
		try {
			boolean selected = driver.findElement(By.xpath("//*[@id='layered_id_attribute_group_3']")).isSelected();
			if (!selected) {
				driver.findElement(By.xpath("//*[@id='layered_id_attribute_group_3']")).click();
				log.info("checkbox is checked....");
			}
		} catch (Exception e) {
			log.info("Checkbox already checked");
		}
	}

	public void selectFirstProduct() {
		Actions obj = new Actions(driver);
		log.info("performing mouse hover on first product of page...");
		TestBase.logExtentReport("performing mouse hover on first product of page...");
		obj.moveToElement(totalProducts.get(0)).build().perform();
		log.info("clicking on add to basket...");
		addToCart.click();
	}

	public int getTotalProducts() {
		return totalProducts.size();
	}

	public List<WebElement> getAllProductsPrice() {
		return allPriceElements;
	}

	public void selectSortByFilter(String dateToSelect) {
		DropDownHelper dropdown = new DropDownHelper(driver);
		dropdown.selectUsingVisibleText(sortBy, dateToSelect);
	}

	public boolean verifyArrayHasAscendingData(ArrayList<Integer> array) {
		for (int i = 0; i < array.size()-1; i++) {
			// this condition will check all next price should be smaller than previous one.
			// next price can be greater and equal
			if (array.get(i) <= array.get(i + 1)) {
				log.info("obj.get(i).." + array.get(i));
				log.info("obj.get(i+1).." + array.get(i + 1));
			} else {
				log.info("price filter is not working");
				return false;
			}
		}
		return true;
	}

	public ArrayList<Integer> getPriceMassagedData(Iterator<WebElement> itr) {
		ArrayList<Integer> array = new ArrayList<Integer>();
		while (itr.hasNext()) {
			String p = itr.next().getText();
			if (p.contains("$")) {
				String actualData = p.substring(1);
				log.info(actualData);
				double p1 = Double.parseDouble(actualData);
				int productPrice = (int) (p1);
				array.add(productPrice);
			}
		}
		return array;
	}
}
