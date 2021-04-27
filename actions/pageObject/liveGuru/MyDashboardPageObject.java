package pageObject.liveGuru;

import org.openqa.selenium.WebDriver;

import commons.BasePage;

public class MyDashboardPageObject extends BasePage {
	WebDriver driver;

	public MyDashboardPageObject(WebDriver driver) {
		this.driver = driver;
	}
}
