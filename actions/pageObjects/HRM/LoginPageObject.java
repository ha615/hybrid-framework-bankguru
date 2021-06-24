package pageObjects.HRM;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.HRM.LoginPageUI;

public class LoginPageObject extends BasePage {
	WebDriver driver;

	public LoginPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void enterToUsernameTextbox(String userName) {
		waitForElementVisible(driver, LoginPageUI.USER_NAME);
		sendKeyToElement(driver, LoginPageUI.USER_NAME, userName);
	}

	public void enterToPasswordTextbox(String password) {
		waitForElementVisible(driver, LoginPageUI.PASS_WORD);
		sendKeyToElement(driver, LoginPageUI.PASS_WORD, password);		
	}

	public DashboardPageObject clickToLoginButton() {
		waitForElementClickable(driver, LoginPageUI.LOGIN_BUTTON);
		clickToElement(driver, LoginPageUI.LOGIN_BUTTON);
		return PageGeneratorManager.getDashboarPage(driver);
	}
}
