package commons;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import pageObject.admin.nopCommerce.ProductSearchPageObject;
import pageObject.user.nopCommerce.LoginPageObject;
import pageObject.user.nopCommerce.MyAccountPageObject;
import pageObject.user.nopCommerce.OrderPageObject;
import pageObject.user.nopCommerce.PageGeneratorManager;
import pageObject.user.nopCommerce.RegisterPageObject;
import pageObject.user.nopCommerce.SearchPageObject;
import pageUIs.admin.nopCommerce.DashboardPageUI;
import pageUIs.user.nopCommerce.HomePageUI;
import pageUIs.user.nopCommerce.MyAccountPageUI;
import pageUIs.user.nopCommerce.OrderPageUI;
import pageUIs.user.nopCommerce.SearchPageUI;

public class BasePage {

	public static BasePage getBasePage() {
		return new BasePage();
	}
 
	public void openPageUrl(WebDriver driver, String pageUrl) {
		driver.get(pageUrl);
	}

	public void getPageUrl(WebDriver driver, String pageUrl) {
		driver.get(pageUrl);
	}

	public String getTitle(WebDriver driver) {
		return driver.getTitle();
	}

	public String getCurrentURL(WebDriver driver) {
		return driver.getCurrentUrl();
	}

	public String getPageSource(WebDriver driver) {
		return driver.getPageSource();
	}

	public void backPage(WebDriver driver) {
		driver.navigate().back();
	}

	public void forwardPage(WebDriver driver) {
		driver.navigate().forward();
	}

	public void refreshCurrentPage(WebDriver driver) {
		driver.navigate().refresh();
	}

	public void acceptAlert(WebDriver driver) {
		alert = waitAlertPresence(driver);
		alert.accept();
	}

	public void cancelAlert(WebDriver driver) {
		alert = waitAlertPresence(driver);
		alert.dismiss();
	}

	public String getTextAlert(WebDriver driver) {
		alert = waitAlertPresence(driver);
		return alert.getText();
	}

	public void senkeyAlert(WebDriver driver, String value) {
		alert = waitAlertPresence(driver);
		alert.sendKeys(value);
	}

	public Alert waitAlertPresence(WebDriver driver) {
		explicitWait = new WebDriverWait(driver, timeouts);
		return explicitWait.until(ExpectedConditions.alertIsPresent());
	}

	public void switchWindowTabByID(WebDriver driver, String pWindowID) {
		Set<String> allWindowsID = driver.getWindowHandles();
		for (String windowID : allWindowsID) {
			if (!windowID.equals(pWindowID)) {
				driver.switchTo().window(windowID);
				break;
			}
		}
	}

	public void switchByWindowTitle(WebDriver driver, String expectedWindowTitle) {
		Set<String> allWidowsID = driver.getWindowHandles();
		for (String windowID : allWidowsID) {
			driver.switchTo().window(windowID);
			String actualWindowTitle = driver.getTitle();
			if (actualWindowTitle.equals(expectedWindowTitle)) {
				break;
			}
		}
	}

	public void closeAllWindowsWithoutParentWindow(WebDriver driver, String pWindowTitle) {
		Set<String> allWindowsID = driver.getWindowHandles();
		for (String windowID : allWindowsID) {
			driver.switchTo().window(windowID);
			String actualWindowTitle = driver.getTitle();
			if (!actualWindowTitle.equals(pWindowTitle)) {
				driver.close();
				sleepSecond(3);
			}
		}
	}

	private void sleepSecond(long time) {

		// TODO Auto-generated method stub
		try {
			Thread.sleep(time * 1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public By getByXpath(String locator) {
		return By.xpath(locator);
	}

	private String getDynamicLocator(String locator, String... params) {
		// TODO Auto-generated method stub
		return String.format(locator, (Object[])params);
	} 
	
	public WebElement getElement(WebDriver driver, String locator) {
		return driver.findElement(getByXpath(locator));
	}
	
	public WebElement getElement(WebDriver driver, String locator, String...params) {
		locator = getDynamicLocator(locator, params);
		return driver.findElement(getByXpath(locator));
	}
	
	public List<WebElement> getElements(WebDriver driver, String locator) {
		return driver.findElements(getByXpath(locator));
	}

	public void clickToElement(WebDriver driver, String locator) {
		getElement(driver, locator).click();
	}
	
	public void clickToElement(WebDriver driver, String locator, String...params) {
		locator = getDynamicLocator(locator,params);
		getElement(driver, locator).click();
	}

	public void sendKeyToElement(WebDriver driver, String locator, String value) {
		getElement(driver, locator).clear();
		getElement(driver, locator).sendKeys(value);
	}

	public void sendKeyToElement(WebDriver driver, String locator, String value, String...params) {
		locator = getDynamicLocator(locator, params);
		getElement(driver, locator).clear();
		getElement(driver, locator).sendKeys(value);
	}
	
	public int getElementsSize(WebDriver driver, String locator) {
		return getElements(driver, locator).size();
	}
	
	public int getElementsSize(WebDriver driver, String locator, String...params) {
		locator = getDynamicLocator(locator, params);
		return getElements(driver, locator).size();
	}
	public String getElementAttribute(WebDriver driver, String locator, String attributeName) {
		return getElement(driver, locator).getAttribute(attributeName);
	}
	public String getElementAttribute(WebDriver driver, String locator, String attributeName, String...params) {
		locator = getDynamicLocator(locator, params);
		return getElement(driver, locator).getAttribute(attributeName);
	}

	public String getElementText(WebDriver driver, String locator) {
		return getElement(driver, locator).getText();
	}
	
	public String getElementText(WebDriver driver, String locator, String...params) {
		locator = getDynamicLocator(locator, params);
		return getElement(driver, locator).getText();
	}

	public void clickToCheckboxOrRadio(WebDriver driver, String locator) {
		if (!isElementSelected(driver, locator)) {
			getElement(driver, locator).click();
		}
	}

	public void clickToUnCheckbox(WebDriver driver, String locator) {
		if (isElementSelected(driver, locator)) {
			getElement(driver, locator).click();
		}
	}

	public void selectDropdownByText(WebDriver driver, String locator, String itemText) {
		select = new Select(getElement(driver, locator));
		select.selectByVisibleText(itemText);
	}

	public String getSelectedItemDropdown(WebDriver driver, String locator) {
		select = new Select(getElement(driver, locator));
		return select.getFirstSelectedOption().getText();
	}

	public boolean isSelectedMultiple(WebDriver driver, String locator) {
		select = new Select(getElement(driver, locator));
		return select.isMultiple();
	}

	public boolean isElementDisplayed(WebDriver driver, String locator) {
		return getElement(driver, locator).isDisplayed();
	}
	
	public boolean isElementDisplayed(WebDriver driver, String locator, String...params) {
		locator = getDynamicLocator(locator, params);
		return getElement(driver, locator).isDisplayed();
	}

	public boolean isElementSelected(WebDriver driver, String locator, String...params) {
		locator = getDynamicLocator(locator, params);
		return getElement(driver, locator).isSelected();
	}
	
	public boolean isElementSelected(WebDriver driver, String locator) {
		return getElement(driver, locator).isSelected();
	}

	public boolean isElementEnable(WebDriver driver, String locator) {
		return getElement(driver, locator).isEnabled();
	}
	
	public boolean isElementEnable(WebDriver driver, String locator, String...params) {
		locator = getDynamicLocator(locator, params);
		return getElement(driver, locator).isEnabled();
	}

	public WebDriver switchToIframeByElement(WebDriver driver, String locator) {
		return driver.switchTo().frame(getElement(driver, locator));
	}

	public WebDriver switchToDefaultContent(WebDriver driver, String locator) {
		return driver.switchTo().defaultContent();
	}

	public void doubleClickToElement(WebDriver driver, String locator) {
		action = new Actions(driver);
		action.doubleClick(getElement(driver, locator)).perform();
	}

	public void hoverToElement(WebDriver driver, String locator) {
		action = new Actions(driver);
		action.moveToElement(getElement(driver, locator)).perform();
	}

	public void rightClickToElement(WebDriver driver, String locator) {
		action = new Actions(driver);
		action.contextClick(getElement(driver, locator)).perform();
	}

	public void dragAndDrop(WebDriver driver, String sourceLocator, String targetLocator) {
		action = new Actions(driver);
		action.dragAndDrop(getElement(driver, sourceLocator), getElement(driver, targetLocator)).perform();
	}

	public void pressKeyToElement(WebDriver driver, String locator, Keys key) {
		action = new Actions(driver);
		action.sendKeys(getElement(driver, locator), key).perform();
	}
	
	public void pressKeyToElement(WebDriver driver, String locator, Keys key, String...params) {
		action = new Actions(driver);
		action.sendKeys(getElement(driver, locator, params), key).perform();
	}

	public Object executeForBrowser(WebDriver driver, String javaScript) {
		jsExecutor = (JavascriptExecutor) driver;
		return jsExecutor.executeScript(javaScript);
	}

	public String getInnerText(WebDriver driver) {
		jsExecutor = (JavascriptExecutor) driver;
		return (String) jsExecutor.executeScript("return document.documentElement.innerText;");
	}

	public boolean areExpectedTextInInnerText(WebDriver driver, String textExpected) {
		jsExecutor = (JavascriptExecutor) driver;
		String textActual = (String) jsExecutor
				.executeScript("return document.documentElement.innerText.match('" + textExpected + "')[0]");
		return textActual.equals(textExpected);
	}

	public void scrollToBottomPage(WebDriver driver) {
		jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("window.scrollBy(0,document.body.scrollHeight)");
	}

	public void navigateToUrlByJS(WebDriver driver, String url) {
		jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("window.location = '" + url + "'");
	}

	public void highlightElement(WebDriver driver, String locator) {
		jsExecutor = (JavascriptExecutor) driver;
		WebElement element = getElement(driver, locator);
		String originalStyle = element.getAttribute("style");
		jsExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style",
				"border: 2px solid red; border-style: dashed;");
		sleepInSecond(1);
		jsExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style",
				originalStyle);
	}

	private void sleepInSecond(long time) {
		// TODO Auto-generated method stub
		try {
			Thread.sleep(time*1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void clickToElementByJS(WebDriver driver, String locator) {
		jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].click();", getElement(driver, locator));
	}

	public void scrollToElement(WebDriver driver, String locator) {
		jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].scrollIntoView(true);", getElement(driver, locator));
	}
	public void scrollToElement(WebDriver driver, String locator, String...params) {
		locator = getDynamicLocator(locator, params);
		jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].scrollIntoView(true);", getElement(driver, locator));
	}

	public void sendkeyToElementByJS(WebDriver driver, String locator, String value) {
		jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].setAttribute('value', '" + value + "')", getElement(driver, locator));
	}

	public void removeAttributeInDOM(WebDriver driver, String locator, String attributeRemove) {
		jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].removeAttribute('" + attributeRemove + "');",
				getElement(driver, locator));
	}

	public boolean areJQueryAndJSLoadedSuccess(WebDriver driver) {
		explicitWait = new WebDriverWait(driver, timeouts);
		jsExecutor = (JavascriptExecutor) driver;

		ExpectedCondition<Boolean> jQueryLoad = new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver driver) {
				try {
					return ((Long) jsExecutor.executeScript("return jQuery.active") == 0);
				} catch (Exception e) {
					return true;
				}
			}
		};

		ExpectedCondition<Boolean> jsLoad = new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver driver) {
				return jsExecutor.executeScript("return document.readyState").toString().equals("complete");
			}
		};

		return explicitWait.until(jQueryLoad) && explicitWait.until(jsLoad);
	}

	public String getElementValidationMessage(WebDriver driver, String locator) {
		jsExecutor = (JavascriptExecutor) driver;
		return (String) jsExecutor.executeScript("return arguments[0].validationMessage;", getElement(driver, locator));
	}

	public boolean isImageLoaded(WebDriver driver, String locator) {
		jsExecutor = (JavascriptExecutor) driver;
		boolean status = (boolean) jsExecutor.executeScript(
				"return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0",
				getElement(driver, locator));
		if (status) {
			return true;
		} else {
			return false;
		}
	}

	public void waitForElementVisible(WebDriver driver, String locator) {
		explicitWait = new WebDriverWait(driver, timeouts);
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(getByXpath(locator)));
	}
	
	public void waitForElementVisible(WebDriver driver, String locator, String...params) {
		locator = getDynamicLocator(locator, params);
		explicitWait = new WebDriverWait(driver, timeouts);
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(getByXpath(locator)));
	}
	
	public void waitAllElementVisible(WebDriver driver, String locator) {
		explicitWait = new WebDriverWait(driver, timeouts);
		explicitWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(getByXpath(locator)));
	}
	
	public void waitAllElementVisible(WebDriver driver, String locator, String...params) {
		locator = getDynamicLocator(locator, params);
		explicitWait = new WebDriverWait(driver, timeouts);
		explicitWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(getByXpath(locator)));
	}
	
	public void waitForElementClickable(WebDriver driver, String locator) {
		explicitWait = new WebDriverWait(driver, timeouts);
		explicitWait.until(ExpectedConditions.elementToBeClickable(getByXpath(locator)));
	}
	
	public void waitForElementClickable(WebDriver driver, String locator, String...params) {
		locator = getDynamicLocator(locator, params);
		explicitWait = new WebDriverWait(driver, timeouts);
		explicitWait.until(ExpectedConditions.elementToBeClickable(getByXpath(locator)));
	}
	
	public void waitElementInvisible(WebDriver driver, String locator) {
		explicitWait = new WebDriverWait(driver, timeouts);
		explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(getByXpath(locator)));
	}
	
	public void waitElementInvisible(WebDriver driver, String locator, String...params) {
		locator = getDynamicLocator(locator, params);
		explicitWait = new WebDriverWait(driver, timeouts);
		explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(getByXpath(locator)));
	}
	//USER
	//20 Page in footer -> 20 function
	public SearchPageObject openSearchPage(WebDriver driver, String...params) {
		waitForElementVisible(driver, UserBasePageUI.DYNAMIC_LOCATOR_FOOTER, params);
		clickToElement(driver, UserBasePageUI.DYNAMIC_LOCATOR_FOOTER, params);
		sleepInSecond(3);
		return PageGeneratorManager.getSearchPage(driver);
	}
	
	public MyAccountPageObject openMyAccountPage(WebDriver driver, String...params) {
		waitForElementVisible(driver, UserBasePageUI.DYNAMIC_LOCATOR_FOOTER, params);
		clickToElement(driver, UserBasePageUI.DYNAMIC_LOCATOR_FOOTER,params);
		sleepInSecond(3);
		return PageGeneratorManager.getMyAccountPage(driver);
	}
	
	public OrderPageObject openOrderPage(WebDriver driver) {
		waitForElementVisible(driver, UserBasePageUI.ORDER_LINK);
		clickToElement(driver, UserBasePageUI.ORDER_LINK);
		return PageGeneratorManager.getOrderPage(driver);
	}

	// 1 function cho 20 page
	//Case 1 : page < 10
	public BasePage getFooterPageByName(WebDriver driver, String pageName) {
		waitForElementClickable(driver, UserBasePageUI.DYNAMIC_LOCATOR_FOOTER,pageName);
		clickToElement(driver, UserBasePageUI.DYNAMIC_LOCATOR_FOOTER, pageName);
		switch (pageName) {
		case "Search":
			return PageGeneratorManager.getSearchPage(driver);
		case "My account":
			return PageGeneratorManager.getMyAccountPage(driver);
		case "Orders":
			return PageGeneratorManager.getOrderPage(driver);
		case "Shopping cart":
			return PageGeneratorManager.getShoppingCartPage(driver);
		default:
			return PageGeneratorManager.getHomePape(driver);
		}
	}
	//Case 2: multiple page
	public void openFooterPageByName(WebDriver driver, String pageName) {
		waitForElementClickable(driver, UserBasePageUI.DYNAMIC_LOCATOR_FOOTER,pageName);
		clickToElement(driver, UserBasePageUI.DYNAMIC_LOCATOR_FOOTER, pageName);
	}
	
	//ADMIN
	public void openSubMenuPageByName(WebDriver driver, String menuPageName, String subMenuPageName) {
		waitForElementClickable(driver, AdminBasePageUI.MENU_LINK_BY_NAME,menuPageName);
		clickToElement(driver, AdminBasePageUI.MENU_LINK_BY_NAME,menuPageName);
		
		waitForElementClickable(driver, AdminBasePageUI.SUB_MENU_LINK_BY_NAME, subMenuPageName);
		clickToElement(driver, AdminBasePageUI.SUB_MENU_LINK_BY_NAME, subMenuPageName);
	}

	public void uploadFileAtCardName(WebDriver driver, String cardName, String... fileNames) {
		scrollToElement(driver, AdminBasePageUI.UPLOAD_FILE_BY_CARD_NAME, cardName);
		String filePath = GlobalContants.UPLOAD_FOLDER_PATH;
		String fullFileName = "";
		for(String file : fileNames) {
			fullFileName = fullFileName + filePath + file +"\n";
		}
		fullFileName = fullFileName.trim();
		getElement(driver, AdminBasePageUI.UPLOAD_FILE_BY_CARD_NAME, cardName).sendKeys(fullFileName);;
	}
	private Alert alert;
	private WebDriverWait explicitWait;
	private long timeouts = 30;
	private Select select;
	private Actions action;
	private JavascriptExecutor jsExecutor;
}
