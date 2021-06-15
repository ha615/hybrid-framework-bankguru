package com.nopcommerce.login;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageFactory.nopCommerce.HomePageObject;
import pageFactory.nopCommerce.LoginPageObject;
import pageFactory.nopCommerce.RegisterPageObject;



public class Level13_Register_Login_Log_Report extends BaseTest {
	WebDriver driver;
	String email, password;
	HomePageObject homePage;
	LoginPageObject loginPage;
	RegisterPageObject registerPage;
	
	@Parameters({"browser","url"})
	@BeforeClass
	public void initBrowser(String browserName, String appURL) {
		log.info("Pre-Condition: Open browser: '" + browserName + "' and navigate to: '" + appURL + "'");
		driver = getBrowserDriver(browserName, appURL);
		email = getRandomEmail();
		password = "123123";
	}

	@Test
	public void User_01_Register_To_System() {
		log.info("User_01_Register - Step 01: Open Home Page");
		homePage = new HomePageObject(driver);
		log.info("User_01_Register - Step 02: Open Register Page");
		homePage.clickToRegisterLink();
		registerPage = new RegisterPageObject(driver);
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
		Assert.assertTrue(registerPage.verifySucessMessageDisplayed());
		log.info("User_01_Register - Step 11: click to Logout link");
		registerPage.clickToLogoutLink();
		sleepInSecond(3);
		log.info("User_01_Register - Step 12: Verify Home page is Displayed");
		homePage = new HomePageObject(driver);
		Assert.assertTrue(homePage.verifyHomePageSliderDisplayed());	
	}

	@Test
	public void User_02_Login_To_System() {
		log.info("User_02_Login - Step 01: Click To Login link");
		homePage.clikToLoginLink();
		loginPage = new LoginPageObject(driver);
		log.info("User_02_Login - Step 02: Enter Email textbox with value: " + email);
		loginPage.enterEmailTextbox(email);
		log.info("User_02_Login - Step 03: Enter Password textbox with value: " + password);
		loginPage.enterPassword(password);
		log.info("User_02_Login - Step 04: click to Login button");
		loginPage.clickToLoginButton();
		log.info("User_02_Login - Step 05: Verify Home Page is displayed");
		Assert.assertFalse(homePage.verifyHomePageSliderDisplayed());
	}

	@AfterClass
	public void quitBrowser() {
		log.info("Post Condition: Close browser");
		driver.quit();
	}
}
