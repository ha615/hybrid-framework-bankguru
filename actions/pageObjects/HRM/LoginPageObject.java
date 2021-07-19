package pageObjects.HRM;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.HRM.LoginPageUI;

public class LoginPageObject extends BasePage {
	WebDriver driver;

	public LoginPageObject(WebDriver driver) {
		super();
		this.driver = driver;
	}

	private void enterToUserNameTextbox(String userName) {
		waitForElementVisible(driver, LoginPageUI.USER_NAME);
		sendKeyToElement(driver, LoginPageUI.USER_NAME, userName);
	}
	
	private void enterToPasswordTextbox(String password) {
		waitForElementVisible(driver, LoginPageUI.PASSWORD);
		sendKeyToElement(driver, LoginPageUI.PASSWORD, password);
	}
	
	private void clickToLoginButton() {
		waitForElementClickable(driver, LoginPageUI.LOGIN_BUTTON);
		clickToElement(driver, LoginPageUI.LOGIN_BUTTON);
	}
	
	public DashboardPageObject loginToSystem(String userName, String password) {
		enterToUserNameTextbox(userName);
		enterToPasswordTextbox(password);
		clickToLoginButton();
		return PageGenerator.getDashboardPage(driver);
	}

}
