package commons;

import java.util.List;
import java.util.Set;
import java.util.concurrent.locks.Condition;

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

public class BasePageFactory {

	public static BasePageFactory getBasePage() {
		return new BasePageFactory();
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

	public void refreshPage(WebDriver driver) {
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

	public WebElement getElement(WebDriver driver, String locator) {
		return driver.findElement(getByXpath(locator));
	}

	public List<WebElement> getElements(WebDriver driver, String locator) {
		return driver.findElements(getByXpath(locator));
	}

	public void clickToElement(WebDriver driver, WebElement element) {
		element.click();
	}

	public void sendKeyToElement(WebDriver driver, WebElement element, String value) {
		element.clear();
		element.sendKeys(value);
	}

	public int getElementsSize(WebDriver driver, List<WebElement> elements) {
		return elements.size();
	}

	public String getElementAttribute(WebDriver driver, WebElement element, String attributeName) {
		return element.getAttribute(attributeName);
	}

	public String getElementText(WebDriver driver, WebElement element) {
		return element.getText();
	}

	public void clickToCheckboxOrRadio(WebDriver driver, WebElement element) {
		if (!isElementSelected(driver, element)) {
			element.click();
		}
	}

	public void clickToUnCheckbox(WebDriver driver, WebElement element) {
		if (isElementSelected(driver, element)) {
			element.click();
		}
	}

	public void selectDropdownByText(WebDriver driver, WebElement element, String itemText) {
		select = new Select(element);
		select.selectByVisibleText(itemText);
	}

	public String getSelectedItemDropdown(WebDriver driver, WebElement element) {
		select = new Select(element);
		return select.getFirstSelectedOption().getText();
	}

	public boolean isSelectedMultiple(WebDriver driver, WebElement element) {
		select = new Select(element);
		return select.isMultiple();
	}

	public boolean isElementDisplayed(WebDriver driver, WebElement element) {
		return element.isDisplayed();
	}

	public boolean isElementSelected(WebDriver driver, WebElement element) {
		return element.isSelected();
	}

	public boolean isElementEnable(WebDriver driver, WebElement element) {
		return element.isEnabled();
	}

	public WebDriver switchToIframeByElement(WebDriver driver, WebElement element) {
		return driver.switchTo().frame(element);
	}

	public WebDriver switchToDefaultContent(WebDriver driver) {
		return driver.switchTo().defaultContent();
	}

	public void doubleClickToElement(WebDriver driver, WebElement element) {
		action = new Actions(driver);
		action.doubleClick(element).perform();
	}

	public void hoverToElement(WebDriver driver, WebElement element) {
		action = new Actions(driver);
		action.moveToElement(element).perform();
	}

	public void rightClickToElement(WebDriver driver, WebElement element) {
		action = new Actions(driver);
		action.contextClick(element).perform();
	}

	public void dragAndDrop(WebDriver driver, WebElement elementSource, WebElement elementTarget) {
		action = new Actions(driver);
		action.dragAndDrop(elementSource, elementTarget).perform();
	}

	public void pressKeyToElement(WebDriver driver, WebElement element, Keys key) {
		action = new Actions(driver);
		action.sendKeys(element, key).perform();
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
		String textActual = (String) jsExecutor.executeScript("return document.documentElement.innerText.match('" + textExpected + "')[0]");
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
		jsExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style", "border: 2px solid red; border-style: dashed;");
		sleepInSecond(1);
		jsExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style", originalStyle);
	}

	private void sleepInSecond(long time) {
		// TODO Auto-generated method stub
		try {
			Thread.sleep(time * 1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void clickToElementByJS(WebDriver driver, WebElement element) {
		jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].click();", element);
	}

	public void scrollToElement(WebDriver driver, WebElement element) {
		jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].scrollIntoView(true);", element);
	}

	public void sendkeyToElementByJS(WebDriver driver, WebElement element, String value) {
		jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].setAttribute('value', '" + value + "')", element);
	}

	public void removeAttributeInDOM(WebDriver driver, WebElement element, String attributeRemove) {
		jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].removeAttribute('" + attributeRemove + "');", element);
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

	public String getElementValidationMessage(WebDriver driver, WebElement element) {
		jsExecutor = (JavascriptExecutor) driver;
		return (String) jsExecutor.executeScript("return arguments[0].validationMessage;", element);
	}

	public boolean isImageLoaded(WebDriver driver, String locator) {
		jsExecutor = (JavascriptExecutor) driver;
		boolean status = (boolean) jsExecutor.executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0", getElement(driver, locator));
		if (status) {
			return true;
		} else {
			return false;
		}
	}

	public void waitForElementVisible(WebDriver driver, WebElement element) {
		explicitWait = new WebDriverWait(driver, timeouts);
		explicitWait.until(ExpectedConditions.visibilityOf(element));
	}

	public void waitAllElementVisible(WebDriver driver, List<WebElement> elements) {
		explicitWait = new WebDriverWait(driver, timeouts);
		explicitWait.until(ExpectedConditions.visibilityOfAllElements(elements));
	}

	public void waitForElementClickable(WebDriver driver, WebElement element) {
		explicitWait = new WebDriverWait(driver, timeouts);
		explicitWait.until(ExpectedConditions.elementToBeClickable(element));
	}

	public void waitElementInvisible(WebDriver driver, WebElement element) {
		explicitWait = new WebDriverWait(driver, timeouts);
		explicitWait.until(ExpectedConditions.invisibilityOf(element));
	}

	private Alert alert;
	private WebDriverWait explicitWait;
	private long timeouts = 30;
	private Select select;
	private Actions action;
	private JavascriptExecutor jsExecutor;
}
