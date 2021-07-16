package pageObject.user.nopCommerce;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import io.qameta.allure.Step;
import pageUIs.user.nopCommerce.LoginPageUI;

public class LoginPageObject extends BasePage{
	private WebDriver driver;
	public LoginPageObject(WebDriver driver) {
		this.driver = driver;
	}
	@Step("Enter to email text box {0}")
	public void enterEmailTextbox(String value) {
		waitForElementVisible(driver, LoginPageUI.EMAIL_TEXTBOX);
		sendKeyToElement(driver, LoginPageUI.EMAIL_TEXTBOX, value);
	}
	@Step("Enter to password text box {0}")
	public void enterPassword(String value) {
		waitForElementVisible(driver, LoginPageUI.PASSWORD_TEXTBOX);
		sendKeyToElement(driver, LoginPageUI.PASSWORD_TEXTBOX, value);
	}
	@Step("Click to login button")
	public HomePageObject clickToLoginButton() {
		waitForElementVisible(driver, LoginPageUI.LOGIN_BUTTON);
		clickToElement(driver, LoginPageUI.LOGIN_BUTTON);
		if(driver.toString().contains("chrome")||driver.toString().contains("edge_chromium")) {
			sleepSecond(3);
		}
		return PageGeneratorManager.getHomePage(driver);
	}
	
	@Step("Click to homepage link")
	public HomePageObject openHomePage() {
		waitForElementVisible(driver, LoginPageUI.HOME_PAGE_LINK);
		clickToElement(driver, LoginPageUI.HOME_PAGE_LINK);
		if(driver.toString().contains("chrome")||driver.toString().contains("edge_chromium")) {
			sleepSecond(3);
		}
		return PageGeneratorManager.getHomePage(driver);
	}

	
}
