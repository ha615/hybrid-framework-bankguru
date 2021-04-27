package pageObject.bankGuru;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.bankGuru.RegisterPageUI;

public class RegisterPageObject extends BasePage{

	private WebDriver driver;

	public RegisterPageObject(WebDriver driver) {
		this.driver = driver;
	}
	public void enterEmailAddressTextbox(String emailAddress) {
		// TODO Auto-generated method stub
		waitForElementVisible(driver,RegisterPageUI.EMAIL_TEXTBOX);
		sendKeyToElement(driver,RegisterPageUI.EMAIL_TEXTBOX, emailAddress);
		
	}

	public void clickToSubmitButton() {
		// TODO Auto-generated method stub
		waitForElementClickable(driver, RegisterPageUI.SUBMIT_BUTTON);
		clickToElement(driver, RegisterPageUI.SUBMIT_BUTTON);
	}

	public String getInfoUserName() {
		waitForElementVisible(driver, RegisterPageUI.USER_ID_GETTEXT);
		return getElementText(driver, RegisterPageUI.USER_ID_GETTEXT);
	}

	public String getInfoPassword() {
		waitForElementVisible(driver, RegisterPageUI.PASSWORD_GETTEXT);
		return getElementText(driver, RegisterPageUI.PASSWORD_GETTEXT);
	}

}
