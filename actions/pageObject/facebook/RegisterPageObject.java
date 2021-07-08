package pageObject.facebook;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.facebook.RegisterPageUI;

public class RegisterPageObject extends BasePage {
	WebDriver driver;

	public RegisterPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public boolean isEmailTextboxDisplayed() {
		waitForElementVisible(driver, RegisterPageUI.EMAIL_TEXTBOX);
		return isElementDisplayed(driver, RegisterPageUI.EMAIL_TEXTBOX);
	}

	public boolean isConfirmEmailTextboxUnDisplayed() {
		return isElementUndisplayed(driver, RegisterPageUI.CONFIRM_EMAIL_TEXTBOX);
	}

	public void enterEmailTextbox(String email) {
		sendKeyToElement(driver, RegisterPageUI.EMAIL_TEXTBOX, email);
		
	}

	public boolean isLoginButtonDisplayed() {
		// TODO Auto-generated method stub
		return isElementDisplayed(driver, RegisterPageUI.LOGIN_BUTTON);
	}

	public boolean isLoginButtonUnDisplayed() {
		// TODO Auto-generated method stub
		//waitForElementInvisible(driver, RegisterPageUI.LOGIN_BUTTON);
		return isElementUndisplayed(driver, RegisterPageUI.LOGIN_BUTTON);
	}

	public boolean isEmailTextboxUnisplayed() {
		return isElementUndisplayed(driver, RegisterPageUI.EMAIL_TEXTBOX);
	}

	public boolean isConfirmEmailTextboxDisplayed() {
		// TODO Auto-generated method stub
		return isElementDisplayed(driver, RegisterPageUI.CONFIRM_EMAIL_TEXTBOX);
	}


}
