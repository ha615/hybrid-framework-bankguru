package pageObject.jQuery;

import org.openqa.selenium.WebDriver;

public class PageGeneratorManager {
	private static HomePageObject homePage;
	
	private PageGeneratorManager() {
		
	}
	
	public static HomePageObject getHomePape(WebDriver driver) {
		if(homePage == null) {
			homePage = new HomePageObject(driver);
		}
		return homePage;
	}

	
}
