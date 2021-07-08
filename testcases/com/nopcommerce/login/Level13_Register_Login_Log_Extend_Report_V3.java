package com.nopcommerce.login;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObject.user.nopCommerce.HomePageObject;
import pageObject.user.nopCommerce.LoginPageObject;
import pageObject.user.nopCommerce.RegisterPageObject;

public class Level13_Register_Login_Log_Extend_Report_V3 extends BaseTest {
	WebDriver driver;
	String email, password;
	HomePageObject homePage;
	LoginPageObject loginPage;
	RegisterPageObject registerPage;
	
	@Parameters({"browser","url"})
	@BeforeClass
	public void initBrowser(String browserName, String appURL) {
		driver = getBrowserDriver(browserName, appURL);
		email = getRandomEmail();
		password = "123123";
	}

	@Test
	public void User_01_Register_To_System() {
		log.info( "User_01_Register - Step 01: Open Home Page");
		homePage = new HomePageObject(driver);
		
		log.info("User_01_Register - Step 02: Open Register Page");
		registerPage = homePage.clickToRegisterLink();
		sleepInSecond(3);
		
		log.info("User_01_Register - Step 03: Click To Gender Radio Button");
		registerPage.clickToGenderRadio();
		
		log.info("User_01_Register - Step 04: Enter Frist Name Textbox");
		registerPage.enterFirstNameTextbox("zin");
		
		log.info("User_01_Register - Step 05: Enter Last Name Textbox");
		registerPage.enterLastNameTextbox("zin");
		
		log.info("User_01_Register - Step 06: Enter Email textbox with value: " + email);
		registerPage.enterEmailTextbox(email);
		
		log.info("User_01_Register - Step 07: Enter Password textbox with value: " + password);
		registerPage.enterPasswordTextbox(password);
		
		log.info("User_01_Register - Step 08: Enter Confirm Password Textbox with value: " + password);
		registerPage.enterConfirmPasswordTextbox(password);
		
		log.info("User_01_Register - Step 09: Click To Register Button");
		registerPage.clickToRegisterButton();
		
		log.info("User_01_Register - Step 10: Verify User Created Success Message");
		verifyTrue(registerPage.isVerifySucessMessageDisplayed());
		
		log.info("User_01_Register - Step 11: click to Logout link");
		homePage = registerPage.clickToLogoutLink();
		sleepInSecond(3);
		
		log.info("User_01_Register - Step 12: Verify Home page is Displayed");
		verifyTrue(homePage.verifyHomePageSliderDisplayed());	
	}

	@Test
	public void User_02_Login_To_System() {
		log.info("User_02_Login_To_System");
		log.info("User_02_Login - Step 01: Click To Login link");
		loginPage = homePage.clikToLoginLink();
		
		log.info("User_02_Login - Step 02: Enter Email textbox with value: " + email);
		loginPage.enterEmailTextbox(email);
		
		log.info("User_02_Login - Step 03: Enter Password textbox with value: " + password);
		loginPage.enterPassword(password);
		
		log.info("User_02_Login - Step 04: click to Login button");
		homePage = loginPage.clickToLoginButton();
		
		log.info("User_02_Login - Step 05: Verify Home Page is displayed");
		verifyFalse(homePage.verifyHomePageSliderDisplayed());
	}

	@AfterClass
	public void quitBrowser() {
		driver.quit();
	}
}
