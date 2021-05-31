package pageFactory.nopCommerce;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commons.BasePageFactory;

public class LoginPageObject extends BasePageFactory {
	WebDriver driver;
	/*
	 * public static final String EMAIL_TEXTBOX = "//input[@id='Email']"; 
	 * public static final String PASSWORD_TEXTBOX = "//input[@id='Password']"; public
	 * static final String LOGIN_BUTTON = "//button[text()='Log in']";
	 */
	@FindBy(id = "Email")
	WebElement emailTextbox;

	@FindBy(id = "Password")
	WebElement passwordTextbox;

	@FindBy(xpath = "//button[text()='Log in']")
	WebElement loginButton;

	public LoginPageObject(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void enterEmailTextbox(String value) {
		sendKeyToElement(driver, emailTextbox, value);
	}

	public void enterPassword(String value) {
		sendKeyToElement(driver, passwordTextbox, value);
	}

	public void clickToLoginButton() {
		clickToElement(driver, loginButton);
	}

}
