package pageFactory.nopCommerce;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commons.BasePageFactory;

public class RegisterPageObject extends BasePageFactory {

	WebDriver driver;
	/*
	 public static final String GENDER_RADIO = "//input[@id='gender-male']";
	public static final String FIRST_NAME_TEXTBOX = "//input[@id='FirstName']";
	public static final String LAST_NAME_TEXTBOX = "//input[@id='LastName']";
	public static final String EMAIL_TEXTBOX = "//input[@id='Email']";
	public static final String PASSWORD_TEXTBOX = "//input[@id='Password']";
	public static final String CONFIRM_PASSWORD_TEXTBOX = "//input[@id='ConfirmPassword']";
	public static final String REGISTER_BUTTON = "//button[@id='register-button']";
	public static final String SUCESS_MESSAGE = "//div[text()='Your registration completed']";
	public static final String LOGOUT_LINK = "//a[text()='Log out']";
	 * */
	
	@FindBy(id="gender-male")
	WebElement genderRadio;
	
	@FindBy(id="FirstName")
	WebElement firstNameTextbox;
	
	@FindBy(id="LastName")
	WebElement lastNameTextbox;
	
	@FindBy(id="Email")
	WebElement emailTextbox;
	
	@FindBy(id="Password")
	WebElement passwordTextbox;
	
	@FindBy(id="ConfirmPassword")
	WebElement confirmPasswordTextbox;

	@FindBy(id="register-button")
	WebElement registerButton;
	
	@FindBy(xpath ="//div[text()='Your registration completed']")
	WebElement successMessage;
	
	@FindBy(xpath ="//a[text()='Log out']")
	WebElement logoutLink;
	
	public RegisterPageObject(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void clickToGenderRadio() {
		clickToCheckboxOrRadio(driver, genderRadio);
	}

	public void enterFirstNameTextbox(String firstName) {
		sendKeyToElement(driver, firstNameTextbox, firstName);
	}

	public void enterLastNameTextbox(String lastName) {
		sendKeyToElement(driver, lastNameTextbox, lastName);
	}

	public void enterEmailTextbox(String email) {
		sendKeyToElement(driver, emailTextbox, email);
	}

	public void enterPasswordTextbox(String password) {
		sendKeyToElement(driver, passwordTextbox, password);
	}

	public void enterConfirmPasswordTextbox(String password) {
		sendKeyToElement(driver, confirmPasswordTextbox, password);

	}

	public void clickToRegisterButton() {
		clickToElement(driver, registerButton);
	}

	public boolean verifySucessMessageDisplayed() {
		return isElementDisplayed(driver, successMessage);

	}

	public void clickToLogoutLink() {
		clickToElement(driver, logoutLink);
	}

}
