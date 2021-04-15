package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commons.BasePage;

public class LoginPageObject extends BasePage{
	public String USER_ID_TEXTBOX = getByXpath("//input[@name='uid']") ;
	public WebElement PASSWORD_TEXTBOX;
	public WebElement LOGIN_BUTTON;
	public WebElement RESET_BUTTON;
	
	
	
}
