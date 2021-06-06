package pageObject.admin.nopCommerce;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.admin.nopCommerce.DashboardPageUI;

public class DashboardPageObject extends BasePage {

	WebDriver driver;
	ProductSearchPageObject productSearchPage;
	public DashboardPageObject(WebDriver driver) {
		this.driver = driver;
	}


}
