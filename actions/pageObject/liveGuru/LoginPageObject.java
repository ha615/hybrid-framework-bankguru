package pageObject.liveGuru;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.liveGuru.LoginPageUI;

public class LoginPageObject extends BasePage {
	WebDriver driver;

	public LoginPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void enterEmailAddressTextbox(String mailAddress) {
		waitForElementVisible(driver, LoginPageUI.EMAIL_ADDRESS_TEXTBOX);
		sendKeyToElement(driver, LoginPageUI.EMAIL_ADDRESS_TEXTBOX, mailAddress);
	}

	public void enterPasswordTextbox(String password) {
		waitForElementVisible(driver, LoginPageUI.PASSWORD_TEXTBOX);
		sendKeyToElement(driver, LoginPageUI.PASSWORD_TEXTBOX, password);
	}

	public void clickToLoginButton() {
		waitForElementClickable(driver, LoginPageUI.LOGIN_BUTTON);
		clickToElement(driver, LoginPageUI.LOGIN_BUTTON);
		
	}
	public void loginToSystem(String mailAddress, String password) {
		enterEmailAddressTextbox(mailAddress);;
		enterPasswordTextbox(password);
		clickToLoginButton();
		
	}
	public String getMessageWarningEmptyEmailAndPassword() {
		waitForElementVisible(driver, LoginPageUI.MESSAGE_WARNING_1);
		return getElementText(driver, LoginPageUI.MESSAGE_WARNING_1);
	}

	public String getMessageWarningInValidEmail() {
		waitForElementVisible(driver, LoginPageUI.MESSAGE_WARNING_2);
		return getElementText(driver, LoginPageUI.MESSAGE_WARNING_2);
	}

	public String getMessageWarningInValidPassword() {
		waitForElementVisible(driver, LoginPageUI.MESSAGE_WARNING_3);
		return getElementText(driver, LoginPageUI.MESSAGE_WARNING_3);
	}

	public String getMessageWarningInCorrectEmail() {
		waitForElementVisible(driver, LoginPageUI.MESSAGE_WARNING_4);
		return getElementText(driver, LoginPageUI.MESSAGE_WARNING_4);
	}

	public String getMessageWarningInCorrectPassword() {
		waitForElementVisible(driver, LoginPageUI.MESSAGE_WARNING_5);
		return getElementText(driver, LoginPageUI.MESSAGE_WARNING_5);
	}

	public boolean isMyDashboarDisplayed() {
		waitForElementVisible(driver, LoginPageUI.MY_DASHBOARD_TEXT);
		return isElementDisplayed(driver, LoginPageUI.MY_DASHBOARD_TEXT);
	}


}
