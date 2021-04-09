package commons;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class BasePage {
	
	public void getPageUrl(WebDriver driver, String pageUrl) {
		driver.get(pageUrl);
	}
	
	public String getTitle(WebDriver driver){
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
		for(String windowID : allWindowsID) {
			if(!windowID.equals(pWindowID)) {
				driver.switchTo().window(windowID);
				break;
			}
		}
	}
	
	public void switchByWindowTitle(WebDriver driver, String expectedWindowTitle) {
		Set<String> allWidowsID = driver.getWindowHandles();
		for(String windowID : allWidowsID) {
			driver.switchTo().window(windowID);
			String actualWindowTitle = driver.getTitle();
			if(actualWindowTitle.equals(expectedWindowTitle)) {
				break;
			}
		}
	}
	
	public void closeAllWindowsWithoutParentWindow(WebDriver driver, String pWindowTitle) {
		Set<String> allWindowsID = driver.getWindowHandles();
		for(String windowID : allWindowsID) {
			driver.switchTo().window(windowID);
			String actualWindowTitle = driver.getTitle();
			if(!actualWindowTitle.equals(pWindowTitle)) {
				driver.close();
				sleepSecond(3);
			}
		}
	}

	private void sleepSecond(long time) {

		// TODO Auto-generated method stub
		try {
			Thread.sleep(time*1000);
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
	public void clickToElement(WebDriver driver, String locator) {
		getElement(driver, locator).click();
	}
	
	public void sendKeyToElement(WebDriver driver, String locator, String value) {
		getElement(driver, locator).clear();
		getElement(driver, locator).sendKeys(value);
	}
	
	public int getElementsSize(WebDriver driver, String locator) {
		return getElements(driver, locator).size();
	}
	
	public void clickToCheckboxOrRadio(WebDriver driver, String locator) {
		if(!getElement(driver, locator).isSelected()) {
			getElement(driver, locator).click();
		}
	}
	
	public void clickToUnCheckbox(WebDriver driver, String locator) {
		if(getElement(driver, locator).isSelected()) {
			getElement(driver, locator).click();
		}
	}
	
	public void selectItemInDropdown(WebDriver driver, String locator, String value) {
		select = new Select(getElement(driver, locator));
		select.selectByVisibleText(value);
	}
	
	public void getSelectItemInDropdown(WebDriver driver, String locator) {
		select = new Select(getElement(driver, locator));
		select.selectByVisibleText(value);
	}

	private Alert alert;
	private WebDriverWait explicitWait;
	private long timeouts = 30;
	private Select select;
	
}
