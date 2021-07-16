package pageObject.user.nopCommerce;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import io.qameta.allure.Step;
import pageUIs.user.nopCommerce.RegisterPageUI;

public class RegisterPageObject extends BasePage {

	private WebDriver driver;

	public RegisterPageObject(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}
	@Step("Click to gender radio")
	public void clickToGenderRadio() {
		// TODO Auto-generated method stub
		waitForElementClickable(driver, RegisterPageUI.GENDER_RADIO);
		clickToElement(driver, RegisterPageUI.GENDER_RADIO);
	}
	@Step("Enter to first name text box {0}")
	public void enterFirstNameTextbox(String firstName) {
		waitForElementVisible(driver, RegisterPageUI.FIRST_NAME_TEXTBOX);
		sendKeyToElement(driver, RegisterPageUI.FIRST_NAME_TEXTBOX, firstName);
	}
	@Step("Enter to last name text box {0}")
	public void enterLastNameTextbox(String lastName) {
		waitForElementVisible(driver, RegisterPageUI.LAST_NAME_TEXTBOX);
		sendKeyToElement(driver, RegisterPageUI.LAST_NAME_TEXTBOX, lastName);
	}
	@Step("Enter to email text box {0}")
	public void enterEmailTextbox(String email) {
		waitForElementVisible(driver, RegisterPageUI.EMAIL_TEXTBOX);
		sendKeyToElement(driver, RegisterPageUI.EMAIL_TEXTBOX, email);
	}
	@Step("Enter to password text box {0}")
	public void enterPasswordTextbox(String password) {
		waitForElementVisible(driver, RegisterPageUI.PASSWORD_TEXTBOX);
		sendKeyToElement(driver, RegisterPageUI.PASSWORD_TEXTBOX, password);
	}
	@Step("Enter to confirm password text box {0}")
	public void enterConfirmPasswordTextbox(String password) {
		waitForElementVisible(driver, RegisterPageUI.CONFIRM_PASSWORD_TEXTBOX);
		sendKeyToElement(driver, RegisterPageUI.CONFIRM_PASSWORD_TEXTBOX, password);

	}
	@Step("Click to register button")
	public void clickToRegisterButton() {
		waitForElementVisible(driver, RegisterPageUI.REGISTER_BUTTON);
		clickToElement(driver, RegisterPageUI.REGISTER_BUTTON);
	}
	@Step("Verify success mesage displayed")
	public boolean isVerifySucessMessageDisplayed() {
		waitForElementVisible(driver, RegisterPageUI.SUCESS_MESSAGE);
		return isElementDisplayed(driver, RegisterPageUI.SUCESS_MESSAGE);
	}
	@Step("Click to logout link")
	public HomePageObject clickToLogoutLink() {
		waitForElementClickable(driver, RegisterPageUI.LOGOUT_LINK);
		clickToElement(driver, RegisterPageUI.LOGOUT_LINK);
		return PageGeneratorManager.getHomePage(driver);
	}

}
