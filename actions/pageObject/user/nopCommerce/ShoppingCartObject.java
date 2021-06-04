package pageObject.user.nopCommerce;

import org.openqa.selenium.WebDriver;

import commons.BasePage;

public class ShoppingCartObject extends BasePage {
	WebDriver driver;
	public ShoppingCartObject(WebDriver driver) {
		this.driver = driver;
	}
}
