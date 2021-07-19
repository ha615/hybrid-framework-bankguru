package pageObjects.HRM;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.HRM.AddEmployeePageUI;

public class AddEmployeePageObject extends BasePage{
	WebDriver driver;

	public AddEmployeePageObject(WebDriver driver) {
		super();
		this.driver = driver;
	}

	public void enterToFirstNameTextbox(String fName) {
		waitForElementVisible(driver, AddEmployeePageUI.FIRST_NAME_TEXTBOX);
		sendKeyToElement(driver, AddEmployeePageUI.FIRST_NAME_TEXTBOX, fName);
	}

	public void enterToLastNameTextbox(String lName) {
		waitForElementVisible(driver, AddEmployeePageUI.LAST_NAME_TEXTBOX);
		sendKeyToElement(driver, AddEmployeePageUI.LAST_NAME_TEXTBOX, lName);		
	}

	public String getEmployeeID() {
		waitForElementVisible(driver, AddEmployeePageUI.EMPLOYEE_ID_TEXTBOX);
		return getElementAttribute(driver, AddEmployeePageUI.EMPLOYEE_ID_TEXTBOX, "employeeId");
	}

	public void clickToCreateLoginDetailCheckbox() {
		waitForElementVisible(driver, AddEmployeePageUI.DETAIL_LOGIN_CHECKBOX);
		clickToCheckboxOrRadio(driver, AddEmployeePageUI.DETAIL_LOGIN_CHECKBOX);
	}

	public void enterToUserNameTextbox(String userName) {
		waitForElementVisible(driver, AddEmployeePageUI.USER_NAME_TEXTBOX);
		sendKeyToElement(driver, AddEmployeePageUI.USER_NAME_TEXTBOX, userName);
		
	}

	public void enterToPasswordTextbox(String password) {
		waitForElementVisible(driver, AddEmployeePageUI.PASSWORD_TEXTBOX);
		sendKeyToElement(driver, AddEmployeePageUI.PASSWORD_TEXTBOX, password);
		
	}

	public void enterToConfirmPasswordTextbox(String password) {
		waitForElementVisible(driver, AddEmployeePageUI.CONFIRM_PASSWORD_TEXTBOX);
		sendKeyToElement(driver, AddEmployeePageUI.CONFIRM_PASSWORD_TEXTBOX, password);	
	}

	public void selectValueInStatusDropdwn(String statusValue) {
		waitForElementVisible(driver, AddEmployeePageUI.STATUS_DROPDOWN);
		selectDropdownByText(driver, AddEmployeePageUI.STATUS_DROPDOWN, statusValue);
	}

	public PersonalDetailPageObject clickToSaveButton() {
		waitForElementClickable(driver, AddEmployeePageUI.SAVE_BUTTON);
		clickToElement(driver, AddEmployeePageUI.SAVE_BUTTON);
		return PageGenerator.getPersonalDetailPage(driver);
	}

}
