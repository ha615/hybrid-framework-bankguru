package pageObject.facebook;

import org.openqa.selenium.WebDriver;

public class PageGeneratorManager {
	public static RegisterPageObject registerPage;
	
	public PageGeneratorManager() {
		
	}

	public static RegisterPageObject getRegisterPage(WebDriver driver) {
		if(registerPage == null)
			registerPage = new RegisterPageObject(driver);
		return registerPage;
	}
	
	
}
