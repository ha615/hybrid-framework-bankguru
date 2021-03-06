package pageObjects.HRM;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.HRBasePageUI;

public class DashboardPageObject extends BasePage {
	WebDriver driver;

	public DashboardPageObject(WebDriver driver) {
		super();
		this.driver = driver;
	}

	public EmployeeListPageObject openEmployeeListPage() {
		mouseHoverToMenu(driver, "PIM");
		waitForElementClickable(driver, HRBasePageUI.EMPLOYEE_LIST);
		clickToElement(driver, HRBasePageUI.EMPLOYEE_LIST);
		return PageGenerator.getEmployeeListPage(driver);
	}

}
