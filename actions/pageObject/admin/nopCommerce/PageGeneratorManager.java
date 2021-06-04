package pageObject.admin.nopCommerce;

import org.openqa.selenium.WebDriver;

public class PageGeneratorManager {
	private static DashboardPageObject dashboardPage;
	private static LoginPageObject loginPage;
	public static DashboardPageObject getDashBoardPage(WebDriver driver) {
		if(dashboardPage == null)
			dashboardPage = new DashboardPageObject(driver);
		return dashboardPage;
	}
	public static LoginPageObject getLoginPage(WebDriver driver) {
		if(loginPage == null)
			loginPage = new LoginPageObject(driver);
		return loginPage;
	}
}
