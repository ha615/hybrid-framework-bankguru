package com.nopcommerce.login;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObject.nopCommerce.HomePageObject;
import pageObject.nopCommerce.LoginPageObject;
import pageObject.nopCommerce.PageGeneratorManager;
import pageObject.nopCommerce.RegisterPageObject;



public class Level06_Register_Login_Page_Generator extends BaseTest {
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
		homePage = PageGeneratorManager.getHomePape(driver);

	}

	@Test
	public void Login_01_Register_To_System() {
		registerPage = homePage.clickToRegisterLink();
		sleepInSecond(3);
		registerPage.clickToGenderRadio();
		registerPage.enterFirstNameTextbox("zin");
		registerPage.enterLastNameTextbox("zin");
		registerPage.enterEmailTextbox(email);
		registerPage.enterPasswordTextbox(password);
		registerPage.enterConfirmPasswordTextbox(password);
		registerPage.clickToRegisterButton();
		Assert.assertTrue(registerPage.isVerifySucessMessageDisplayed());
		homePage = registerPage.clickToLogoutLink();
		sleepInSecond(3);
		Assert.assertTrue(homePage.verifyHomePageSliderDisplayed());
		
	}

	@Test
	public void Login_02_Login_To_System() {
		loginPage = homePage.clikToLoginLink();
		loginPage.enterEmailTextbox(email);
		loginPage.enterPassword(password);
		homePage = loginPage.clickToLoginButton();
		Assert.assertTrue(homePage.verifyHomePageSliderDisplayed());
	}

	@AfterClass
	public void quitBrowser() {
		driver.quit();
	}
}
