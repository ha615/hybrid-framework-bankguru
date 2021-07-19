package pageObjects.HRM;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.HRBasePageUI;

public class PersonalDetailPageObject extends BasePage{
	WebDriver driver;

	public PersonalDetailPageObject(WebDriver driver) {
		super();
		this.driver = driver;
	}

	public EmployeeListPageObject openEmployeeListPage() {
		waitForElementClickable(driver, HRBasePageUI.EMPLOYEE_LIST);
		clickToElement(driver, HRBasePageUI.EMPLOYEE_LIST);
		return PageGenerator.getEmployeeListPage(driver);
	}

}
