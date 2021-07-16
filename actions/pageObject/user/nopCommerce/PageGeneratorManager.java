package pageObject.user.nopCommerce;

import org.openqa.selenium.WebDriver;

import pageObject.admin.nopCommerce.DashboardPageObject;

public class PageGeneratorManager {
//	private static HomePageObject homePage;
//	private static RegisterPageObject registerPage;
//	private static LoginPageObject loginPage;
//	private static SearchPageObject searchPage;
//	private static OrderPageObject orderPage;
//	private static MyAccountPageObject myAccountPage;
//	private static ShoppingCartObject shoppingCart;
//	private static DashboardPageObject dashboardPage;
	
	public static HomePageObject getHomePage(WebDriver driver) {
//		if(homePage == null) {
//			homePage = new HomePageObject(driver);
//		}
		return new HomePageObject(driver);
	}
	
	public static RegisterPageObject getRegisterPage(WebDriver driver) {
//		if(registerPage == null) {
//			registerPage = new RegisterPageObject(driver);
//		}
		return new RegisterPageObject(driver);
	}
	
	public static LoginPageObject getLoginPage(WebDriver driver) {
//		if(loginPage == null) {
//			loginPage = new LoginPageObject(driver);
//		}
		return new LoginPageObject(driver);
	}
	
	public static SearchPageObject getSearchPage(WebDriver driver) {
//		if(searchPage == null) {
//			searchPage = new SearchPageObject(driver);
//		}
		return new SearchPageObject(driver);
	}
	
	public static OrderPageObject getOrderPage(WebDriver driver) {
//		if(orderPage == null) {
//			orderPage = new OrderPageObject(driver);
//		}
		return new OrderPageObject(driver);
	}
	
	public static MyAccountPageObject getMyAccountPage(WebDriver driver) {
//		if(myAccountPage == null) {
//			myAccountPage = new MyAccountPageObject(driver);
//		}
		return new MyAccountPageObject(driver);
	}

	public static ShoppingCartObject getShoppingCartPage(WebDriver driver) {
//		if(shoppingCart == null) {
//			shoppingCart = new ShoppingCartObject(driver);
//		}
		return new ShoppingCartObject(driver);
	}

	public static DashboardPageObject getDashboardPage(WebDriver driver) {
//		if(dashboardPage == null)
//			dashboardPage = new DashboardPageObject(driver);
		return new DashboardPageObject(driver);
	}


	
}
