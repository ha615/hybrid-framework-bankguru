package pageObjects.HRM;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import commons.BasePage;
import commons.HRBasePageUI;
import pageUIs.HRM.AddEmployeePageUI;
import pageUIs.HRM.EmployeeListPagePageUI;

public class EmployeeListPageObject extends BasePage{
	WebDriver driver;

	public EmployeeListPageObject(WebDriver driver) {
		super();
		this.driver = driver;
	}

	public AddEmployeePageObject clickToAddButton() {
		waitForElementClickable(driver, EmployeeListPagePageUI.ADD_EMPLOYEE_BUTTON);
		clickToElement(driver, EmployeeListPagePageUI.ADD_EMPLOYEE_BUTTON);
		return PageGenerator.getAddEmployeePage(driver);
	}

	public void enterToEmployeeNameTextbox(String eName) {
		waitForElementVisible(driver, AddEmployeePageUI.EMPLOYEE_NAME_TEXTBOX);
		sendKeyToElement(driver, AddEmployeePageUI.EMPLOYEE_NAME_TEXTBOX, eName);
	}

	public void clickToSearchButton() {
		waitForElementClickable(driver, AddEmployeePageUI.SEARCH_BUTTON);
		clickToElement(driver, AddEmployeePageUI.SEARCH_BUTTON);
	}

	public boolean isEmployeeInformationDisplayedAtTable(String employeeID) {
		Assert.assertTrue(HRBasePageUI.DYNAMIC_EMPLOYEE_LIST_TABLE.contains(employeeID));
	}

}
