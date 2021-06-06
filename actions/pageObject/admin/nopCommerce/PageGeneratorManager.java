package pageObject.admin.nopCommerce;

import org.openqa.selenium.WebDriver;

public class PageGeneratorManager {
	private static DashboardPageObject dashboardPage;
	private static LoginPageObject loginPage;
	private static ProductSearchPageObject productSearchPage;
	private static ProductDetailPageObject productDetailPage;
	
	public PageGeneratorManager() {
		// TODO Auto-generated constructor stub
	}
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
	public static ProductSearchPageObject getProductSearchPage(WebDriver driver) {
		if(productSearchPage == null)
			productSearchPage = new ProductSearchPageObject(driver);
		return productSearchPage;
	}
	public static ProductDetailPageObject getProductDetailPage(WebDriver driver) {
		if(productDetailPage == null)
			productDetailPage = new ProductDetailPageObject(driver);
		return productDetailPage;
	}
}
