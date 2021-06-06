package pageObject.user.nopCommerce;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.UserBasePageUI;

public class MyAccountPageObject extends BasePage{
	WebDriver driver;
	public MyAccountPageObject(WebDriver driver) {
		this.driver = driver;
	}
	public boolean isMyAccountPageDisplayed() {
		// TODO Auto-generated method stub
		return isElementDisplayed(driver, UserBasePageUI.DYNAMIC_LOCATOR_FOOTER,"My account");
	}
	

}


