package pageObjects.HRM;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.HRM.DashboardPageUI;
import pageUIs.HRM.EmployeeListPageUI;

public class EmployeeListPageObject extends BasePage {
	WebDriver driver;
	public EmployeeListPageObject(WebDriver driver) {
		this.driver  = driver;
	}
	
	public EmployeeDetailPageOject clickToAddButton() {
		waitForElementClickable(driver, EmployeeListPageUI.ADD_BUTTON);
		clickToElement(driver, EmployeeListPageUI.ADD_BUTTON);
		return new EmployeeDetailPageOject(driver);
	}


	public void enterEmployeeNameToTextboxAtEmployeeListForm(String fullName) {
		waitForElementVisible(driver, EmployeeListPageUI.EMPLOYEE_NAME_TEXTBOX);
		sendKeyToElement(driver, EmployeeListPageUI.EMPLOYEE_NAME_TEXTBOX, fullName);
	}

	public void clickToSearchButtonAtEmployeeListForm() {
		waitForElementClickable(driver, EmployeeListPageUI.SEARCH_BUTTON);
		clickToElement(driver, EmployeeListPageUI.SEARCH_BUTTON);
	}
}
