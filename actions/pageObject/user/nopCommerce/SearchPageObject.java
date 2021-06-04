package pageObject.user.nopCommerce;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.BasePageUI;
import pageUIs.user.nopCommerce.SearchPageUI;

public class SearchPageObject extends BasePage{

	WebDriver driver;
	public SearchPageObject(WebDriver driver) {
		this.driver = driver;
	}
	public boolean isSearchPageDisplayed() {
		// TODO Auto-generated method stub
		return isElementDisplayed(driver, BasePageUI.DYNAMIC_LOCATOR_FOOTER,"Search");
	}



}
