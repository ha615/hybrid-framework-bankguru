package pageObjects.HRM;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.HRM.DashboardPageUI;
import pageUIs.HRM.HRMAbstractPageUI;

public class DashboardPageObject extends BasePage {
	WebDriver driver;

	public DashboardPageObject(WebDriver driver) {
		this.driver = driver;
	}



}
