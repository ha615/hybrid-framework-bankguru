package pageObject.admin.nopCommerce;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.admin.nopCommerce.LoginPageUI;

public class LoginPageObject extends BasePage {

	WebDriver driver;
	
	public LoginPageObject(WebDriver driver) {
		this.driver = driver;
	}
	public DashboardPageObject clickToLoginButton(WebDriver driver) {
		waitForElementClickable(driver, LoginPageUI.LOGIN_BUTTON);
		clickToElement(driver, LoginPageUI.LOGIN_BUTTON);
		return PageGeneratorManager.getDashBoardPage(driver);
	}
	public void enterToEmailTextbox(String email) {
		waitForElementVisible(driver, LoginPageUI.EMAIL_TEXTBOX);
		getElement(driver, LoginPageUI.EMAIL_TEXTBOX).clear();
		sendKeyToElement(driver, LoginPageUI.EMAIL_TEXTBOX, email);
	}
	public void enterToPasswordTextbox(String password) {
		waitForElementVisible(driver, LoginPageUI.PASSWORD_TEXTBOX);
		getElement(driver, LoginPageUI.PASSWORD_TEXTBOX).clear();
		sendKeyToElement(driver, LoginPageUI.PASSWORD_TEXTBOX, password);
		
	}
}
