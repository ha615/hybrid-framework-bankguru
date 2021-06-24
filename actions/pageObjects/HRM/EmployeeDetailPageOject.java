package pageObjects.HRM;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.HRM.EmployeeDetailPageUI;
import pageUIs.HRM.HRMAbstractPageUI;

public class EmployeeDetailPageOject extends BasePage {
	WebDriver driver;

	public EmployeeDetailPageOject(WebDriver driver) {
		this.driver = driver;
	}
	
	public void enterFistNameTextbox(String firstName) {
		waitForElementVisible(driver, EmployeeDetailPageUI.FIRST_NAME_TEXTBOX_AT_ADD_EMPLOYEE_FORM);
		sendKeyToElement(driver, EmployeeDetailPageUI.FIRST_NAME_TEXTBOX_AT_ADD_EMPLOYEE_FORM, firstName);
	}

	public void enterLastNameTextbox(String lastName) {
		waitForElementVisible(driver, EmployeeDetailPageUI.LAST_NAME_TEXTBOX_AT_ADD_EMPLOYEE_FORM);
		sendKeyToElement(driver, EmployeeDetailPageUI.LAST_NAME_TEXTBOX_AT_ADD_EMPLOYEE_FORM, lastName);
	}

	public String getEmployeeIDInfoAtAdEmployeeForm() {
		waitForElementVisible(driver, EmployeeDetailPageUI.EMPLOYEE_ID_TEXTBOX_AT_ADD_EMPLOYEE_FORM);
		return getElementAttribute(driver, EmployeeDetailPageUI.EMPLOYEE_ID_TEXTBOX_AT_ADD_EMPLOYEE_FORM, "value");
	}
	public void inputPhotographFile() {
		// TODO Auto-generated method stub		
	}
	public void clickToSaveButton() {
		waitForElementClickable(driver, EmployeeDetailPageUI.SAVE_BUTTON_AT_ADD_EMPLOYEE_FORM);	
		clickToElement(driver, EmployeeDetailPageUI.SAVE_BUTTON_AT_ADD_EMPLOYEE_FORM);
	}

	public boolean isFullNameDisplayedAtHeader(String fullName) {
		waitForElementVisible(driver, EmployeeDetailPageUI.FULL_NAME_HEADER_TEXT_AT_PERSONAL_DETAIL_FORM,fullName);
		return isElementDisplayed(driver, EmployeeDetailPageUI.FULL_NAME_HEADER_TEXT_AT_PERSONAL_DETAIL_FORM, fullName);
	}

	public String getFistNameValueAtPersonalDetailForm() {
		waitForElementVisible(driver, EmployeeDetailPageUI.FIRST_NAME_TEXTBOX_AT_PERSONAL_DETAIL_FORM);
		return getElementAttribute(driver, EmployeeDetailPageUI.FIRST_NAME_TEXTBOX_AT_PERSONAL_DETAIL_FORM, "value");
	}

	public String getLastNameValueAtPersonalDetailForm() {
		waitForElementVisible(driver, EmployeeDetailPageUI.LAST_NAME_TEXTBOX_AT_PERSONAL_DETAIL_FORM);
		return getElementAttribute(driver, EmployeeDetailPageUI.LAST_NAME_TEXTBOX_AT_PERSONAL_DETAIL_FORM, "value");
	}

	public String getEmployeeIDValueAtPersonalDetailForm() {
		waitForElementVisible(driver, EmployeeDetailPageUI.EMPLOYEE_ID_TEXTBOX_AT_PERSONAL_DETAIL_FORM);
		return getElementAttribute(driver, EmployeeDetailPageUI.EMPLOYEE_ID_TEXTBOX_AT_PERSONAL_DETAIL_FORM, "value");
	}

	public void clickToFunctionButton(String sub, String child) {
		waitForElementClickable(driver, HRMAbstractPageUI.DYNAMIC_BUTTON_AT_PERSONAL_DETAIL, sub, child);
		clickToElement(driver, HRMAbstractPageUI.DYNAMIC_BUTTON_AT_PERSONAL_DETAIL, sub, child);
	}

	public void enterLicenseExpireDateTextbox(String date) {
		waitForElementVisible(driver, EmployeeDetailPageUI.LICENSE_EXPIRY_DATE_TEXTBOX);
		sendKeyToElement(driver, EmployeeDetailPageUI.LICENSE_EXPIRY_DATE_TEXTBOX, date);
	}

	public void chooseNationalityOnCombobox(String country) {
		waitForElementClickable(driver, EmployeeDetailPageUI.NATIONAL_COMBOBOX);
		selectDropdownByText(driver, EmployeeDetailPageUI.NATIONAL_COMBOBOX, country);
	}

	public String getLisenceExpireDateAtPersonalDetailForm() {
		waitForElementVisible(driver, EmployeeDetailPageUI.LICENSE_EXPIRY_DATE_TEXTBOX);
		return getElementAttribute(driver, EmployeeDetailPageUI.LICENSE_EXPIRY_DATE_TEXTBOX, "value");
	}

	public String getNationalAtPersonalDetailForm() {
		waitForElementVisible(driver, EmployeeDetailPageUI.NATIONAL_COMBOBOX);
		return getSelectedItemDropdown(driver, EmployeeDetailPageUI.NATIONAL_COMBOBOX);
	}



	public boolean isLicenseExpireDateDisplayedAtPersonalDetailForm(String licenseExpire) {
		waitForElementVisible(driver, EmployeeDetailPageUI.LICENSE_EXPIRY_DATE_TEXTBOX);
		return isElementDisplayed(driver, EmployeeDetailPageUI.LICENSE_EXPIRY_DATE_TEXTBOX, licenseExpire);
	}

	public boolean isNationalDisplayedAtPersonalDetail(String national) {
		waitForElementVisible(driver, EmployeeDetailPageUI.NATIONAL_COMBOBOX_GET_ATTRIBUTE);
		return isElementDisplayed(driver, EmployeeDetailPageUI.NATIONAL_COMBOBOX_GET_ATTRIBUTE, national);
	}
}
