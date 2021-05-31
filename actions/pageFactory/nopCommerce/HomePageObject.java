package pageFactory.nopCommerce;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commons.BasePageFactory;

public class HomePageObject extends BasePageFactory {

	WebDriver driver;
	/*
	 	public static final String HOME_PAGE_SLIDER = "//div[@id='nivo-slider']";
	public static final String REGISTER_LINK = "//a[text()='Register']";
	public static final String LOGIN_LINK = "//a[text()='Log in']";
	 * */
	//UI
	@FindBy(id="nivo-slider")
	WebElement homePageSlider;
	
	@FindBy(className="ico-register")
	WebElement registerLink;
	
	@FindBy(className = "ico-login")
	WebElement loginLink;
	
	//Action
	public HomePageObject(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public boolean verifyHomePageSliderDisplayed() {
		return isElementDisplayed(driver, homePageSlider);
	}

	public void clickToRegisterLink() {
		clickToElement(driver, registerLink);
	}

	public void clikToLoginLink() {
		clickToElement(driver, loginLink);
	}



}
