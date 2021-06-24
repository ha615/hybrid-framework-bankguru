package pageObjects.HRM;

import org.openqa.selenium.WebDriver;

public class PageGeneratorManager {

	private PageGeneratorManager() {
		
	}
	
	public static LoginPageObject getLoginPage(WebDriver driver) {
		return new LoginPageObject(driver);
	}
	
	public static DashboardPageObject getDashboarPage(WebDriver driver) {
		return new DashboardPageObject(driver);
	}
	
	public static EmployeeDetailPageOject getEmployeeDetailPage(WebDriver driver) {
		return new EmployeeDetailPageOject(driver);
	}
	
	public static UserDetailPageObject getUserDetailPage(WebDriver driver) {
		return new UserDetailPageObject(driver);
	}
	public static EmployeeListPageObject getEmployeeListPage(WebDriver driver) {
		return new EmployeeListPageObject(driver);
	}
	
}
