package pageObject.bankGuru;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.bankGuru.LoginPageUI;

public class LoginPageObject extends BasePage {

	private WebDriver driver;

	public LoginPageObject(WebDriver driver) {
		this.driver = driver;
	}
	
	public void clickHereLink() {
		// TODO Auto-generated method stub
		waitForElementClickable(driver, LoginPageUI.HERE_LINK);
		clickToElement(driver, LoginPageUI.HERE_LINK);
	}

	public void enterUserIDTextbox(String userID) {
		// TODO Auto-generated method stub
		waitForElementVisible(driver, LoginPageUI.USER_ID_TEXTBOX);
		sendKeyToElement(driver, LoginPageUI.USER_ID_TEXTBOX, userID);
	}

	public void enterPasswordTextbox(String password) {
		waitForElementVisible(driver, LoginPageUI.PASSWORD_TEXTBOX);
		sendKeyToElement(driver, LoginPageUI.PASSWORD_TEXTBOX, password);
	}

	public void clickToLoginButton() {
		// TODO Auto-generated method stub
		waitForElementClickable(driver, LoginPageUI.LOGIN_BUTTON);
		clickToElement(driver, LoginPageUI.LOGIN_BUTTON);
	}

	public boolean isWellcomeMessageDisplayed() {
		waitForElementVisible(driver, LoginPageUI.WELLCOME_MESSAGE);
		return isElementDisplayed(driver, LoginPageUI.WELLCOME_MESSAGE);
	}

	public void clickToLogoutLink() {
		waitForElementClickable(driver, LoginPageUI.LOGOUT_LINK);
		clickToElement(driver, LoginPageUI.LOGOUT_LINK);
	}

	public String getLogoutMessageDisplayed() {
		waitAlertPresence(driver);
		Alert alert = driver.switchTo().alert();
		return alert.getText();
	}

}
