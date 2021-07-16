package com.nopcommerce.common;

import java.util.Set;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import commons.BaseTest;
import pageObject.user.nopCommerce.HomePageObject;
import pageObject.user.nopCommerce.LoginPageObject;
import pageObject.user.nopCommerce.RegisterPageObject;

public class Common_01_Login extends BaseTest {
	WebDriver driver;
	String email, password;
	HomePageObject homePage;
	LoginPageObject loginPage;
	RegisterPageObject registerPage;
	public static Set<Cookie> loginCookiePage;
	
	@Parameters({"browser","url"})
	@BeforeTest
	public void beforeTest(String browserName, String appURL) {
		driver = getBrowserDriver(browserName, appURL);
		email = getRandomEmail();
		password = "123123";
		log.info( "Common_01 - Step 01: Open Home Page");
		homePage = new HomePageObject(driver);
		
		log.info("Common_01 - Step 02: Open Register Page");
		registerPage = homePage.clickToRegisterLink();
		sleepInSecond(3);
		
		log.info("Common_01 - Step 03: Click To Gender Radio Button");
		registerPage.clickToGenderRadio();
		
		log.info("Common_01 - Step 04: Enter Frist Name Textbox");
		registerPage.enterFirstNameTextbox("zin");
		
		log.info("Common_01 - Step 05: Enter Last Name Textbox");
		registerPage.enterLastNameTextbox("zin");
		
		log.info("Common_01 - Step 06: Enter Email textbox with value: " + email);
		registerPage.enterEmailTextbox(email);
		
		log.info("Common_01 - Step 07: Enter Password textbox with value: " + password);
		registerPage.enterPasswordTextbox(password);
		
		log.info("Common_01 - Step 08: Enter Confirm Password Textbox with value: " + password);
		registerPage.enterConfirmPasswordTextbox(password);
		
		log.info("Common_01 - Step 09: Click To Register Button");
		registerPage.clickToRegisterButton();
		
		log.info("Common_01 - Step 10: Verify User Created Success Message");
		verifyTrue(registerPage.isVerifySucessMessageDisplayed());
		
		log.info("Common_01 - Step 11: click to Logout link");
		homePage = registerPage.clickToLogoutLink();
		sleepInSecond(3);
		
		log.info("Common_01 - Step 12: Verify Home page is Displayed");
		verifyTrue(homePage.verifyHomePageSliderDisplayed());	

		log.info("Common_01_To_System");
		log.info("Common_01 - Step 13: Click To Login link");
		loginPage = homePage.clikToLoginLink();
		
		log.info("Common_01 - Step 14: Enter Email textbox with value: " + email);
		loginPage.enterEmailTextbox(email);
		
		log.info("Common_01 - Step 15: Enter Password textbox with value: " + password);
		loginPage.enterPassword(password);
		
		log.info("Common_01 - Step 16: click to Login button");
		homePage = loginPage.clickToLoginButton();
		
		log.info("Common_01 - Step 17: Verify Home Page is displayed");
		verifyFalse(homePage.verifyHomePageSliderDisplayed());
		
		log.info("Common_01 - Step 18: Get all login page cookies");
		loginCookiePage = homePage.getAllCookies(driver);
		System.out.println("COOKIE: " + loginCookiePage);
		
		log.info("Post-condition: Close browser");
		cleanBrowserAndDriver();
	}

}
